package kr.or.ddit.users.service;

import kr.or.ddit.users.dao.UserDao;
import kr.or.ddit.users.dao.UserDaoI;
import kr.or.ddit.users.model.UserVo;

public class UserService implements UserServiceI{

	private UserDaoI userDao;
	
	public UserService() {
		userDao = new UserDao();
	}
	public UserVo getUser(String user_id) {
		return userDao.getUser(user_id);
	}

}
