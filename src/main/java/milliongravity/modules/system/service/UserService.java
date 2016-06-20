package milliongravity.modules.system.service;


import milliongravity.common.service.BaseService;
import milliongravity.modules.system.dao.UserDao;
import milliongravity.modules.system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统管理，后台用户管理
 * @author Junz
 * @version 2016-5-19
 */
@Service(value="userService")
@Transactional
public class UserService extends BaseService
{
	@Autowired
    UserDao userDao;
    public User get(User user)
    {
        user=userDao.get(user);
        return user;
    }
}
