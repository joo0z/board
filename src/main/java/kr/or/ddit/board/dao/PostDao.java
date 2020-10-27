package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.db.MybatisUtil;

public class PostDao implements PostDaoI{

	@Override
	public List<PostVo> getAllPost(int board_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<PostVo> list = sqlSession.selectList("post.getAllPost",board_no);
		sqlSession.close();
		return list;
	}

	@Override
	public int selectPostTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("post.selectPostTotalCnt");
	}

	@Override
	public List<PostVo> selectPostPageList(SqlSession sqlSession, PageVo pageVo) {
		return sqlSession.selectList("post.selectPostPageList", pageVo);
	}

	@Override
	public PostVo getPost(int post_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		PostVo postVo = sqlSession.selectOne("post.getPost", post_no);
		sqlSession.close();
		return postVo;
	}
	
}
