package kr.or.ddit.users.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.users.model.UserVo;
import kr.or.ddit.users.service.UserService;
import kr.or.ddit.users.service.UserServiceI;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	private UserServiceI userService;
	
	@Override
	public void init() throws ServletException {
		// service객체 초기화(생성)
		userService = new UserService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("userLoginServlet doGet");
		request.getRequestDispatcher("/userLogin.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pass = request.getParameter("user_pass");
		
		logger.debug("userId : {}, password : {} ", user_id, user_pass);
		
		UserVo userVo = userService.getUser(user_id);
		BoardServiceI boardService = new BoardService();
		List<BoardVo> boardList = boardService.getAllBoard();
		
		// 등록된 회원이 없는 경우
		// 비밀번호가 틀린경우
		if (userVo == null || !userVo.getUser_pass().equals(user_pass)) {
			request.getRequestDispatcher("/userLogin.jsp").forward(request, response);
		}
		// 비밀번호가 일치하는경우 (메인페이지)
		else if(userVo.getUser_pass().equals(user_pass)) {
			request.getSession().setAttribute("S_MEMBER", userVo);
			request.getSession().setAttribute("boardList", boardList);
			request.getRequestDispatcher("/userMain.jsp").forward(request, response);
		}
		
		// 쿠키정보
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			logger.debug("name : {}, value :{}", cookie.getName(), cookie.getValue());
			cookie.getName();
			cookie.getValue();
		}
		
		Cookie cookie = new Cookie("SERVERCOOKIE", "COOKIEVALUE");
		cookie.setMaxAge(60*60*24);  // 초단위
		
		response.addCookie(cookie);
	}

}
