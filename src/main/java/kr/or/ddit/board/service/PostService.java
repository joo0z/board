package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.dao.PostDao;
import kr.or.ddit.board.dao.PostDaoI;
import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.db.MybatisUtil;

public class PostService implements PostServiceI{

	private PostDaoI postDao;
	public PostService() {
		postDao = new PostDao();
	}
	
	@Override
	public List<PostVo> getAllPost(int board_no) {
		return postDao.getAllPost(board_no);
	}
	
	@Override
	public Map<String, Object> selectPostPageList(PageVo pageVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("postList", postDao.selectPostPageList(sqlSession, pageVo));
		
		int cnt = postDao.selectPostTotalCnt(sqlSession,pageVo.getBoard_no());
		int pages = (int)Math.ceil((double)cnt/pageVo.getPageSize());
		map.put("pages", pages);
		
		sqlSession.close();
		return map;
	}
	
	@Override
	public int selectPostTotalCnt(int board_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		return postDao.selectPostTotalCnt(sqlSession, board_no);
	}
	
	@Override
	public PostVo getPost(int post_no) {
		return postDao.getPost(post_no);
	}
	
	@Override
	public int createPost(PostVo postVo) {
		return postDao.createPost(postVo);
	}

	@Override
	public int deletePost(int post_no) {
		return postDao.deletePost(post_no);
	}

	@Override
	public int updatePost(PostVo postVo) {
		return postDao.updatePost(postVo);
	}

}
