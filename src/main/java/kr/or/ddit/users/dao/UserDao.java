package kr.or.ddit.users.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.users.model.UserVo;

public class UserDao implements UserDaoI{

	public UserVo getUser(String user_id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		UserVo userVo = sqlSession.selectOne("user.getUser", user_id);
		
		sqlSession.close();
		
		return userVo;
	}
	

}
