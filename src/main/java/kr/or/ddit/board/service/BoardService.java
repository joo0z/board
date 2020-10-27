package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoI;
import kr.or.ddit.board.model.BoardVo;

public class BoardService implements BoardServiceI{
	
	private BoardDaoI boardDao;

	public BoardService() {
		boardDao = new BoardDao();
	}
	@Override
	public List<BoardVo> getAllBoard() {
		return boardDao.getAllBoard();
	}

	@Override
	public int createBoard(String board_title) {
		return boardDao.createBoard(board_title);
	}
	@Override
	public int updateBoard(BoardVo boardVo) {
		return boardDao.updateBoard(boardVo);
	}
	@Override
	public BoardVo getBoard(int board_no) {
		return boardDao.getBoard(board_no);
	}

}
