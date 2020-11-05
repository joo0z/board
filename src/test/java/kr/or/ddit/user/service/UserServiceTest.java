package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.ddit.users.model.UserVo;
import kr.or.ddit.users.service.UserService;
import kr.or.ddit.users.service.UserServiceI;

public class UserServiceTest {
	
	UserServiceI userService;

	@Before
	public void setup() {
		userService = new UserService();
		String user_id = "brown";
		userService.getUser(user_id);
	}
	
	@Test
	public void getUserTest() {
		/*** Given ***/
		userService = new UserService();
		String user_id = "brown";
		UserVo userVo = new UserVo();

		/*** When ***/
		userVo = userService.getUser(user_id);
		
		/*** Then ***/
		assertEquals("brown", userVo.getUser_id());
	}

}
