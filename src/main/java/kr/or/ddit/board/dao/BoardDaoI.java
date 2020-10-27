package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;


public interface BoardDaoI {
	
	/**
	 * 전체 board를 조회하는 메서드
	 * @return
	 */
	List<BoardVo> getAllBoard();

	/**
	 * 하나의 board정보를 가져오는 메서드
	 * @param board_no
	 * @return
	 */
	BoardVo getBoard(int board_no);
	
	/**
	 * board 등록 메서드
	 * @param board_title
	 * @return
	 */
	int createBoard(String board_title);
	
	/**
	 * board 수정 메서드
	 * @param boardVo
	 * @return
	 */
	int updateBoard(BoardVo boardVo);
}