/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package milliongravity.modules.system.web;


import milliongravity.common.web.BaseController;
import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 后台管理用户Controller
 * @author Junz
 * @version 2015-05-19
 */
@Component
@Path("/page1111")
public class JumpPageController extends BaseController{

    @GET
    @Path("{pageUrl}")
    @Produces(MediaType.TEXT_HTML)
    public  Viewable login(@PathParam("pageUrl") String pageUrl)
    {
        System.out.println(pageUrl);
        return new Viewable("/WEB-INF/views/"+pageUrl, null);
    }
}
