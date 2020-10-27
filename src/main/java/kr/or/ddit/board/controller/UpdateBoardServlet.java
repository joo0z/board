package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(UpdateBoardServlet.class);
    private BoardServiceI boardService;
    private BoardVo boardVo;
    
    @Override
    public void init() throws ServletException {
    	boardService = new BoardService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doGet");
		request.getRequestDispatcher("/board/board.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doPost");
		request.setCharacterEncoding("utf-8");
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String board_title = request.getParameter("board_title");
		String board_status = request.getParameter("board_status");
		
		logger.debug("board_no:{},board_title{},board_status :{}", board_no, board_title, board_status);

		boardVo = new BoardVo();
		boardVo.setBoard_title(board_title);
		boardVo.setBoard_status(board_status);
		boardVo.setBoard_no(board_no);
		
		int cnt = boardService.updateBoard(boardVo);
		
		logger.debug("cnt : {}", cnt);
		
		response.sendRedirect(request.getContextPath() + "/createBoard");
//		response.sendRedirect(request.getContextPath() + "/board/board.jsp");
	}

}
