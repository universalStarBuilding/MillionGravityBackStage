/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package milliongravity.modules.system.web;


import milliongravity.common.persistence.AuthenticationResult;
import milliongravity.common.persistence.annotation.TokenCheck;
import milliongravity.common.security.JwtUtil;
import milliongravity.common.session.VirtualSession;
import milliongravity.common.session.VirtualSessionManager;
import milliongravity.common.utils.StringUtils;
import milliongravity.common.web.BaseController;
import milliongravity.modules.system.entity.User;
import milliongravity.modules.system.service.UserService;
import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *登录 Controller
 *Controller
 * @author Junz
 * @version 2015-05-19
 */
@Component
@Path("/")
public class loginController extends BaseController{
    @Autowired
    private UserService userService;
    @GET
    @Produces(MediaType.TEXT_HTML)
    public  Viewable  welcome2System()
    {
        return new Viewable("/WEB-INF/views/base/sysIndex", null);
    }
    @POST
    @Path("doLogin")
    @Produces(MediaType.APPLICATION_JSON)
    public  AuthenticationResult  doLogin( @BeanParam  User user)
    {
        AuthenticationResult result = new AuthenticationResult();
        user=userService.get(user);
        if(user==null)
        {
            //异常处理机制，记录异常
            return null;
        }
        //判断用户在已经登录且session未失效时，重复登录时的处理
        if(StringUtils.isNotBlank(user.getToken()))
        {
            VirtualSession virtualSession=
                    VirtualSessionManager.getInstance().getSession(user.getToken(),false);
            if(virtualSession==null)
            {

            }
        }else
        {
            //验证登录等相关操作，暂时省略，等认证以及权限机制搞定再去处理
            //.........
            //登录成功，生成token，生成用户虚拟session
            String token = JwtUtil.generateToken(String.valueOf(user.getId()));
            VirtualSessionManager.getInstance().getSession(token, true).addAttribute("user", user);
            System.out.println(VirtualSessionManager.getInstance().getSession(token,false));
            logger.debug("login token="+token);
            result.setToken(token);
        }
        return result;
    }

    @POST
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    @TokenCheck
    public  String  test( String test)
    {
        return test;
    }

    @POST
    @Path("test22")
    @Produces(MediaType.APPLICATION_JSON)
    @TokenCheck
    public  String  test22( String test)
    {
        return test;
    }


}
