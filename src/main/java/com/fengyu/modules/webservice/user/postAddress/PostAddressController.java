package com.fengyu.modules.webservice.user.postAddress;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.exception.MapperSupport.Constant.WebExceptionType;
import com.fengyu.common.exception.MapperSupport.WebActionException;
import com.fengyu.modules.model.PostAddress;
import com.fengyu.modules.service.user.PostAddressService;
import com.fengyu.system.entity.ResultAPI;
import com.fengyu.system.entity.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by admin on 2016/6/22.
 */
@Component
@Path("/user/postAddress")
public class PostAddressController {

    protected Logger logger = LoggerFactory.getLogger(PostAddressController.class);
    @Autowired
    private PostAddressService postAddressService;

    /**
     * 获取收获地址
     * @param id
     * @return
     */
    @GET
    @Path("get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getPostAddress(@PathParam("id")Integer id){
        PostAddress postAddress=postAddressService.getPostAddress(id);
        if (postAddress==null){
            throw new WebActionException(WebExceptionType.POSTACCESSNOTFUND,postAddress);
        }
        return JSON.toJSONString(postAddress);
    }

    /**
     * 添加收货地址
     * @param postAddress
     * @return
     */
    @POST
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String insertPostAddress(PostAddress postAddress){
        Integer rows=postAddressService.insert(postAddress);
        if (rows==0){
            throw new WebActionException(WebExceptionType.INSERTPOSTACCESS,postAddress);
        }
        return JSON.toJSONString(rows);
    }

    /**
     * 修改收获地址
     * @param postAddress
     * @return
     */
    @POST
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String updatePostAddress( PostAddress postAddress){
        Integer rows=postAddressService.updatePostAddress(postAddress);
        if (rows == 0) {
            throw new WebActionException(WebExceptionType.UPDATEPOSTACCESS,postAddress);
        }
        return JSON.toJSONString(rows);
    }

    /**
     * 删除收获地址
     * @param id
     * @return
     */
    @GET
    @Path("delete/{id}")
    public String deletePostAddress(@PathParam("id")Integer id){
        Integer rows=postAddressService.deletePostAddress(id);
        if (rows==0){
            throw new WebActionException(WebExceptionType.DELETEPOSTACCESS,id);
        }
        return JSON.toJSONString(rows);
    }

    /**
     * 分页查询收获地址
     * @param postAddress
     * @return
     */
    @POST
    @Path("pageList")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String pageList(PostAddress postAddress){
        SearchResult searchResult=postAddressService.getListPostAddress(postAddress);
        if (searchResult==null){
            throw new WebActionException(WebExceptionType.POSTACCESSNOTFUND,postAddress);
        }
       return JSON.toJSONString(searchResult);
    }
}
