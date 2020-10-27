package kr.or.ddit.users.dao;

import kr.or.ddit.users.model.UserVo;

public interface UserDaoI {
	
	UserVo getUser(String user_id);

}
