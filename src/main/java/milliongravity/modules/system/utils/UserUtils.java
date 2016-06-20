/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package milliongravity.modules.system.utils;


import milliongravity.common.session.VirtualSessionManager;
import milliongravity.modules.system.entity.User;

import java.security.Principal;

/**
 * 用户工具类
 * @author ThinkGem
 * @version 2013-12-05
 */
public class UserUtils {
	/**
	 * 获取当前用户
	 *  @author junz
	 * @param token 用户令牌
	 * @return 取不到返回 new User()
	 */
	public static Principal getUser(String token){
		Principal principal = getPrincipal(token);

		return principal;
	}

	/**
	 * 获取当前登录者对象
	 * @author junz
	 * @param  token String
	 * @return 取不到返回null
	 */
	public static Principal getPrincipal(String token){

		return (Principal) VirtualSessionManager.getInstance().getSession(token,false).getAttribute("User");
	}
}
