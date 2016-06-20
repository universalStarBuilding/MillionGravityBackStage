package milliongravity.common.Filter;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationRequestFilter implements ContainerRequestFilter
{
	private static final Logger logger = LoggerFactory.getLogger(AuthorizationRequestFilter.class);
	private final List<String>tokenCkList;
	@Inject
	javax.inject.Provider<UriInfo> uriInfo;

	@Autowired
	UserService userService;

	public AuthorizationRequestFilter(List<String> tokenCkList)
	{
		this.tokenCkList = tokenCkList;
	}

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException
	{
		//得到访问的方法 例如GET,POST
		String method = requestContext.getMethod().toLowerCase();
		//得到访问路径
		String path = "/"+((ContainerRequest) requestContext).getPath(true).toLowerCase();

		boolean skipCheck=true;
		for(String url:tokenCkList)
		{
			if(path.equals(url.toLowerCase()))
			{
				skipCheck=false;
			}
		}
		if(skipCheck)
			return;
		//获取头信息中的token
		String tokenText=requestContext.getHeaderString("Authorization");


		//如果token为空抛出
		if (tokenText == null)
		{
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);//抛出未认证的错误
		}
		//把Bear Token换成Token
		String strToken=JwtUtil.extractJwtTokenFromAuthorizationHeader(tokenText);
		if (JwtUtil.isValid(strToken))
		{
			VirtualSession session= VirtualSessionManager.getInstance().getSession(tokenText, false);
			if(session==null)
			{
				throw new WebApplicationException("Authentication failed");
			}
			/*String userId=JwtUtil.getUserId(strToken);//反解出Name
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
			}*/
		}
		else {
			logger.info("token is invalid");

		}
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

}