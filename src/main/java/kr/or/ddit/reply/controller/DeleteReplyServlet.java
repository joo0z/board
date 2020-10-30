package kr.or.ddit.reply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceI;

@WebServlet("/deleteReply")
public class DeleteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(DeleteReplyServlet.class);
	private ReplyServiceI replyService;
	
	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int reply_no = Integer.parseInt(request.getParameter("reply_no"));
		int post_no = Integer.parseInt(request.getParameter("post_no")); 
		logger.debug("reply_no,post_no : {},{}", reply_no, post_no);
		
		ReplyVo replyVo = new ReplyVo();
		replyVo.setReply_no(reply_no);
		
		int cnt = replyService.deleteReply(reply_no);
		logger.debug("cnt : {}", cnt );
		
		if (cnt == 1 ) {
			response.sendRedirect(request.getContextPath() + "/postContent?post_no="+post_no);
		}else {
			doGet(request, response);
		}
	}

}
