package milliongravity.common.utils;

import milliongravity.common.config.CommonDictionaryConfig;
import milliongravity.modules.system.dao.LogAccessDao;
import milliongravity.modules.system.entity.LogAccess;
import milliongravity.modules.system.entity.User;
import milliongravity.modules.system.utils.UserUtils;

import javax.ws.rs.container.ContainerRequestContext;
/**
 * 日志工具类
 * @author junz
 * @version 2016-06-10
 */
public class LogUtils {

	//private static LogAccessDao logAccessDao = SpringContextHolder.getBean(LogAccessDao.class);


	
	/**
	 * 保存日志
	 */
	public static void saveLog(ContainerRequestContext requestContext, Exception ex,String title,int timeCost){
		 String authHeader=requestContext.getHeaderString("Authorization");
    	String tokenText=null;
    	if (authHeader!=null)
    		tokenText=authHeader.substring(7);
		User user=null;
		if(tokenText!=null)
			user = (User) UserUtils.getUser(tokenText);
		LogAccess log = new LogAccess();
		log.setCreateBy(user==null?"visitor":String.valueOf(user.getId()));
		log.setCreateDate(DateUtils.getDateTime());
		log.setTitle(title);
		log.setType(ex == null ? CommonDictionaryConfig.getConfig("logAccess.TYPE_ACCESS"):
				CommonDictionaryConfig.getConfig("logAccess.TYPE_EXCEPTION"));
		log.setRemoteAddr(StringUtils.getRemoteAddr(requestContext));
		log.setUserAgent(requestContext.getHeaderString("user-agent"));
		log.setRequestUri(requestContext.getUriInfo().getRequestUri().toString());
		log.setParams("");
		log.setMethod(requestContext.getMethod());
		log.setException(ex==null?"":ex.getMessage());
		log.setTimeCost(timeCost);
		// 异步保存日志
		new SaveLogThread(log,null, ex).start();
	}

	/**
	 * 保存日志线程
	 */
	public static class SaveLogThread extends Thread{
		
		private LogAccess log;
		private Object handler;
		private Exception ex;
		
		public SaveLogThread(LogAccess log, Object handler, Exception ex){
			super(SaveLogThread.class.getSimpleName());
			this.log = log;
			this.handler = handler;
			this.ex = ex;
		}
		
		@Override
		public void run() {
			// 获取日志标题
			if (StringUtils.isBlank(log.getTitle())){

				log.setTitle(log.getRequestUri());
			}
			// 如果有异常，设置异常信息
			log.setException(Exceptions.getStackTraceAsString(ex));
			// 如果无标题并无异常日志，则不保存信息
			if (StringUtils.isBlank(log.getTitle()) && StringUtils.isBlank(log.getException())){
				return;
			}
			// 保存日志信息
			//log.preInsert();
			LogAccessDao logDao = SpringContextHolder.getBean(LogAccessDao.class);
			logDao.insert(log);
		}
	}

	/**
	 * 获取菜单名称路径（如：系统设置-机构用户-用户管理-编辑）
	 */
	/*public static String getMenuNamePath(String requestUri, String permission){
		String href = StringUtils.substringAfter(requestUri, Global.getAdminPath());
		@SuppressWarnings("unchecked")
		Map<String, String> menuMap = (Map<String, String>)CacheUtils.get(CACHE_MENU_NAME_PATH_MAP);
		if (menuMap == null){
			menuMap = Maps.newHashMap();
			List<Menu> menuList = menuDao.findAllList(new Menu());
			for (Menu menu : menuList){
				// 获取菜单名称路径（如：系统设置-机构用户-用户管理-编辑）
				String namePath = "";
				if (menu.getParentIds() != null){
					List<String> namePathList = Lists.newArrayList();
					for (String id : StringUtils.split(menu.getParentIds(), ",")){
						if (Menu.getRootId().equals(id)){
							continue; // 过滤跟节点
						}
						for (Menu m : menuList){
							if (m.getId().equals(id)){
								namePathList.add(m.getName());
								break;
							}
						}
					}
					namePathList.add(menu.getName());
					namePath = StringUtils.join(namePathList, "-");
				}
				// 设置菜单名称路径
				if (StringUtils.isNotBlank(menu.getHref())){
					menuMap.put(menu.getHref(), namePath);
				}else if (StringUtils.isNotBlank(menu.getPermission())){
					for (String p : StringUtils.split(menu.getPermission())){
						menuMap.put(p, namePath);
					}
				}
				
			}
			CacheUtils.put(CACHE_MENU_NAME_PATH_MAP, menuMap);
		}
		String menuNamePath = menuMap.get(href);
		if (menuNamePath == null){
			for (String p : StringUtils.split(permission)){
				menuNamePath = menuMap.get(p);
				if (StringUtils.isNotBlank(menuNamePath)){
					break;
				}
			}
			if (menuNamePath == null){
				return "";
			}
		}
		return menuNamePath;
	}*/

	
}
