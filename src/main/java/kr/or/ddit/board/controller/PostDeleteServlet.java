package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.PostService;
import kr.or.ddit.board.service.PostServiceI;

@WebServlet("/postDelete")
public class PostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostDeleteServlet.class);
    private PostServiceI postService;
    
    @Override
    public void init() throws ServletException {
    	postService = new PostService();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		PostVo postVo = postService.getPost(post_no);
		request.setAttribute("postVo", postVo);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		int cnt = postService.deletePost(post_no);
		logger.debug("cnt : {}", cnt);
		
		// 경로
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		logger.debug("board_no : {}", board_no);
		
		if (cnt == 1) {
			response.sendRedirect(request.getContextPath() + "/postList?board_no="+board_no);
		}else {
			doGet(request, response);
		}
	}
	

}
