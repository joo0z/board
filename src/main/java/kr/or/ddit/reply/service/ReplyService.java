package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.dao.ReplyDaoI;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyService implements ReplyServiceI{
	
	private ReplyDaoI replyDao;
	public ReplyService() {
		replyDao = new ReplyDao();
	}
	
	@Override
	public List<ReplyVo> getAllReply(int post_no) {
		return replyDao.getAllReply(post_no);
	}

	@Override
	public int createReply(ReplyVo replyVo) {
		return replyDao.createReply(replyVo);
	}

	@Override
	public int deleteReply(int reply_no) {
		return replyDao.deleteReply(reply_no);
	}

}
