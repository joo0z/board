package kr.or.ddit.reply.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReplyServiceTest {
	
	ReplyServiceI replyService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void replyTest() {
		/*** Given ***/
		replyService = new ReplyService();
		int reply_no = 10;
		
		/*** When ***/
		int cnt = replyService.deleteReply(reply_no);

		/*** Then ***/
		assertEquals(1, cnt);
	}

}
