package milliongravity.modules.system.dao;

import milliongravity.common.persistence.CrudDao;
import milliongravity.common.persistence.annotation.MyBatisDao;
import milliongravity.modules.system.entity.User;

@MyBatisDao
public interface UserDao extends CrudDao<User>{
}