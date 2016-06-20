package milliongravity.common.Filter;

import com.google.gson.Gson;
import milliongravity.common.security.JwtUtil;
import milliongravity.common.session.VirtualSession;
import milliongravity.common.session.VirtualSessionManager;
import milliongravity.modules.system.entity.User;
import milliongravity.modules.system.service.UserService;
import org.glassfish.jersey.server.ContainerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.IOException;


@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationRequestFilter implements ContainerRequestFilter
{
	private static final Logger logger = LoggerFactory.getLogger(AuthorizationRequestFilter.class);

	@Inject
	javax.inject.Provider<UriInfo> uriInfo;

	@Autowired
	UserService userService;

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException
	{
		//得到访问的方法 例如GET,POST
		String method = requestContext.getMethod().toLowerCase();
		//得到访问路径
		String path = ((ContainerRequest) requestContext).getPath(true).toLowerCase();

		//get application.wadl和application.wadl/xsd0.xsd不需要验证，post验证过滤,注册过滤。
		if (("get".equals(method) && ("application.wadl".equals(path) || "application.wadl/xsd0.xsd".equals(path)))
				|| ("post".equals(method) &&( "authentication".equals(path)||"regist".equals(path)))||("get".equals(method) && "user".equals(path)))
		{
			// pass through the filter.
			//requestContext.setSecurityContext(new SecurityContextAuthorizer(uriInfo,new AuthorPricinple("pass"), new String[]{"pass"}));
			return;
		}

		//获取头信息中的token
		String authorizationHeader = ((ContainerRequest) requestContext).getHeaderString("auth_token");
		String authHeader=requestContext.getHeaderString("Authorization");
		//remove "Bearer "
		String tokenText=null;
		//从hearder中获取token
		if (authHeader!=null)
			tokenText=authHeader.substring(7);

		//如果token为空抛出
		if (authorizationHeader == null)
		{

			throw new WebApplicationException(Response.Status.UNAUTHORIZED);//抛出未认证的错误
		}
		//把Bear Token换成Token
		String strToken=JwtUtil.extractJwtTokenFromAuthorizationHeader(authorizationHeader);
		if (JwtUtil.isValid(strToken))
		{
			String userId=JwtUtil.getUserId(strToken);//反解出Name
			String[] roles=JwtUtil.getRoles(strToken);//反解出角色
			int version=JwtUtil.getVersion(strToken);//得到版本
			if(userId !=null&&roles.length!=0&&version!=-1)
			{
				VirtualSession session= VirtualSessionManager.getInstance().getSession(tokenText, false);
				if (session!=null && session.getAttribute("user")!=null)
				{
					final User user=(User)session.getAttribute("user");
					if(String.valueOf(user.getId()).equals(userId))
					{
						requestContext.setSecurityContext(new SecurityContextAuthorizer(uriInfo,user, new String[]{"user"}));
						return;
					}
					else{
						logger.info("User not found " + userId);
					}
				}
				else {
					throw new WebApplicationException("Authentication failed");
				}


			}
			else {
				logger.info("name, roles or version missing from token");
			}
		}
		else {
			logger.info("token is invalid");

		}
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

}