/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package milliongravity.modules.system.web;


import milliongravity.common.web.BaseController;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 后台管理用户Controller
 * @author Junz
 * @version 2015-05-19
 */
@Component
@Path("/sysUser")
public class SysUserController  extends BaseController{

    @GET
    @Path("login")
    @Produces(MediaType.TEXT_PLAIN)
    public  String login()
    {
        return "ssdfsfsdf";
    }
}
