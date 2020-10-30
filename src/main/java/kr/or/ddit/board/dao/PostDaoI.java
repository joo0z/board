package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;

public interface PostDaoI {
	
	/**
	 * 모든 게시글의 목록을 출력하는 메서드
	 * @param board_no
	 * @return
	 */
	List<PostVo> getAllPost(int board_no);
	
	/**
	 * 게시글의 갯수
	 * @param sqlSession
	 * @return
	 */
	int selectPostTotalCnt(SqlSession sqlSession, int board_no);

	/**
	 * 한 페이지당 반환할 게시글 List를 출렷하는 메서드
	 * @param sqlSession
	 * @param pageVo
	 * @return
	 */
	List<PostVo> selectPostPageList(SqlSession sqlSession, PageVo pageVo);
	
	/**
	 * 선택한 하나의 게시글의 정보를 가져오는 메서드
	 * @param post_no
	 * @return
	 */
	PostVo getPost(int post_no);
	
	/**
	 * 하나의 게시물을 등록하는 메서드
	 * @param postVo
	 * @return 성공 : 1, 실패 : 0
	 */
	int createPost(PostVo postVo);
	
	/**
	 * 하나의 게시물을 삭제하는 메서드
	 * @param postVo
	 * @return 성공 : 1, 실패 : 0
	 */
	int deletePost(int post_no);
	
	/**
	 * 게시글 수정을 위한 메서드
	 * @param post_no
	 * @return
	 */
	int updatePost(PostVo postVo);
	
	/**
	 * 답글 등록을 위한 메서드
	 * @param postVo
	 * @return
	 */
	int createAnswer(PostVo postVo);
}
