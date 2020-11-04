package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.board.service.PostService;
import kr.or.ddit.board.service.PostServiceI;

@WebServlet("/postList")
public class PostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostListServlet.class);
	private PostServiceI postService;
	private BoardServiceI boardService;
	@Override
	public void init() throws ServletException {
		postService = new PostService();
		boardService = new BoardService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		request.setAttribute("board_no", board_no);
		logger.debug("board_no : {}", board_no);
//		List<PostVo> postList = postService.getAllPost(board_no);
		
		BoardVo boardVo = new BoardVo();
		boardVo = boardService.getBoard(board_no);
		logger.debug("boardVo : {}", boardVo);
		request.setAttribute("board_title", boardVo.getBoard_title());
		
		List<BoardVo> boardList = boardService.getAllBoard();
		request.setAttribute("boardList", boardList);
		
		//page
		String page_str = request.getParameter("page");
		int page = page_str == null ? 1 : Integer.parseInt(page_str);
		request.setAttribute("page", page);
		
		// pageSize
		String pageSize_str = request.getParameter("pageSize");
		int pageSize = pageSize_str == null ? 10 : Integer.parseInt(pageSize_str);
		request.setAttribute("pageSize", pageSize);
		
		PageVo pageVo = new PageVo(page, pageSize, board_no);
		Map<String, Object> map = postService.selectPostPageList(pageVo);
		request.setAttribute("postList", map.get("postList"));
//		request.setAttribute("postList", postList);
		request.setAttribute("pages", map.get("pages"));

		request.getRequestDispatcher("/post/post.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath() + "/createBoard");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
