package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.users.dao.UserDao;
import kr.or.ddit.users.dao.UserDaoI;
import kr.or.ddit.users.model.UserVo;

public class UserDaoTest {
	
	UserDaoI userDao;
	
	@Before
	public void setup() {
		userDao = new UserDao();
		String user_id = "brown";
		userDao.getUser(user_id);
	}

	@Test
	public void getUserTest() {
		/*** Given ***/
		userDao = new UserDao();
		String user_id = "brown";
		
		/*** When ***/
		UserVo userVo = userDao.getUser(user_id);
		
		/*** Then ***/
		assertEquals("brown", userVo.getUser_id());
		
	}

}
