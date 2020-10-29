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
	public int selectPostTotalCnt(SqlSession sqlSession, int board_no) {
		return sqlSession.selectOne("post.selectPostTotalCnt", board_no);
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

	@Override
	public int createPost(PostVo postVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = sqlSession.insert("post.createPost", postVo);
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
	public int deletePost(int post_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.delete("post.deletePost", post_no);
		
		if (cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}

	@Override
	public int updatePost(PostVo postVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.delete("post.updatePost", postVo);
		
		if (cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}
	
}
