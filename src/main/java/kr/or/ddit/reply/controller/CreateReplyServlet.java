package kr.or.ddit.reply.controller;

import java.io.IOException;
import java.util.Date;

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

@WebServlet("/createReply")
public class CreateReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CreateReplyServlet.class);
	
	private ReplyServiceI replyService;
       
	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/post/postContent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String reply_content = request.getParameter("reply_content");  
		String reply_status = request.getParameter("reply_status");      
		String user_id = request.getParameter("user_id");          
		int post_no = Integer.parseInt(request.getParameter("post_no"));          
		
		logger.debug("parameter : {},{},{},{}", reply_content,reply_status,user_id,post_no);
		
		ReplyVo replyVo = new ReplyVo();
		replyVo.setReply_content(reply_content);
		replyVo.setReply_status(reply_status);
		replyVo.setUser_id(user_id);
		replyVo.setPost_no(post_no);
		int cnt = replyService.createReply(replyVo);
		logger.debug("cnt :{}", cnt);
		
		if (cnt == 1 ) {
			response.sendRedirect(request.getContextPath() + "/postContent?post_no="+post_no);
		}else {
			doGet(request, response);
		}
		
	}

}
