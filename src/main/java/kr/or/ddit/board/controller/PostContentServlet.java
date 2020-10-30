package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.FileVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.FileService;
import kr.or.ddit.board.service.FileServiceI;
import kr.or.ddit.board.service.PostService;
import kr.or.ddit.board.service.PostServiceI;
import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceI;

@WebServlet("/postContent")
public class PostContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostContentServlet.class);
	private PostServiceI postService;
	private FileServiceI fileService;
	private ReplyServiceI replyService;

	@Override
	public void init() throws ServletException {
		postService = new PostService();
		fileService = new FileService();
		replyService = new ReplyService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		PostVo postVo = postService.getPost(post_no);
		request.setAttribute("postVo", postVo);
		
		List<FileVo> fileList = fileService.getAllFile(post_no);
		logger.debug("fileList : {}", fileList);
		request.setAttribute("fileList", fileList);
		
		List<ReplyVo> replyList = replyService.getAllReply(post_no);
		logger.debug("replyList : {}", replyList);
		request.setAttribute("replyList", replyList);
		
		request.getRequestDispatcher("/post/postContent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
