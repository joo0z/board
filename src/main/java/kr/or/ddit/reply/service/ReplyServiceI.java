package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;

public interface ReplyServiceI {
	
	/**
	 * 게시글에 등록된 모든 댓글의 목록을 출력하는 메서드
	 * @param post_no
	 * @return
	 */
	List<ReplyVo> getAllReply(int post_no);
	
	/**
	 * 댓글 등록을 위한 메서드
	 * @param replyVo
	 * @return
	 */
	int createReply(ReplyVo replyVo);
	
	/**
	 * 댓글 삭제를 위한 메서드
	 * @param reply_no
	 * @return
	 */
	int deleteReply(int reply_no);
}
