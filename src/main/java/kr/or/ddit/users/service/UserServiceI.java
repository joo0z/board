package kr.or.ddit.users.service;

import kr.or.ddit.users.model.UserVo;

public interface UserServiceI {
	
	UserVo getUser(String user_id);
}
