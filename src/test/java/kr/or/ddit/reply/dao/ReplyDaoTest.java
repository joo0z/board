package kr.or.ddit.reply.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.ddit.reply.model.ReplyVo;

public class ReplyDaoTest {

	ReplyDaoI replyDao;
	
	@Before
	public void setUp() throws Exception {
		replyDao = new ReplyDao();
		int post_no = 79;
		replyDao.getAllReply(post_no);
	}
	
	@Test
	public void test() {
		/*** Given ***/
		int post_no = 79;
		int reply_no = 10;
		
		/*** When ***/
		replyDao.deleteReply(reply_no);
		replyDao.getAllReply(post_no);

		/*** Then ***/
		assertEquals(1, replyDao.deleteReply(reply_no));
		assertEquals(1, replyDao.getAllReply(post_no).size());
	}

}
