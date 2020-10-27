package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.db.MybatisUtil;

public class BoardDao implements BoardDaoI{

	@Override
	public List<BoardVo> getAllBoard() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<BoardVo> list = sqlSession.selectList("board.getAllBoard");
		sqlSession.close();
		return list;
	}

	@Override
	public int createBoard(String board_title) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = sqlSession.insert("board.createBoard", board_title);
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
	public int updateBoard(BoardVo boardVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.update("board.updateBoard", boardVo);
		
		if (cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}

	@Override
	public BoardVo getBoard(int board_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BoardVo boardVo = sqlSession.selectOne("board.getBoard", board_no);
		sqlSession.close();
		return boardVo;
	}

	

}
