package kr.or.ddit.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyDao implements ReplyDaoI{

	@Override
	public List<ReplyVo> getAllReply(int post_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<ReplyVo> list = sqlSession.selectList("post.getAllReply",post_no);
		sqlSession.close();
		return list;
	}

	@Override
	public int createReply(ReplyVo replyVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = sqlSession.insert("post.createReply", replyVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return cnt;
	}

	@Override
	public int deleteReply(int reply_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = sqlSession.insert("post.deleteReply", reply_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return cnt;
	}

}
