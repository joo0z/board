package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.FileVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.FileService;
import kr.or.ddit.board.service.FileServiceI;
import kr.or.ddit.board.service.PostService;
import kr.or.ddit.board.service.PostServiceI;
import kr.or.ddit.fileupload.FileUploadUtil;

@WebServlet("/createPost")
@MultipartConfig
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CreatePostServlet.class);
	
	private PostServiceI postService;
	private FileServiceI fileService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostService();
		fileService = new FileService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/post/createPost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String post_title = request.getParameter("post_title");  
		String post_content = request.getParameter("post_content");
		String post_status = request.getParameter("post_status"); 
		String user_id = request.getParameter("user_id");     
		int board_no = Integer.parseInt(request.getParameter("board_no"));   
		logger.debug("parameter : {}, {}, {}, {}, {}", post_title,post_content,post_status,user_id,board_no  );
		
		PostVo postVo = new PostVo();
		postVo.setPost_title(post_title);
		postVo.setPost_content(post_content);
		postVo.setPost_status(post_status);
		postVo.setUser_id(user_id);
		postVo.setBoard_no(board_no);
		
		int cnt = postService.createPost(postVo);
		logger.debug("cnt : {}", cnt);
		for (int i = 1; i < 6; i++) {
			Part profile = request.getPart("realfilename" + i);
			logger.debug("file : {}", profile.getHeader("Content-Disposition"));
			String realfilename = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
			String file_realnm = UUID.randomUUID().toString();
			String filePath = "";
			String extension = FileUploadUtil.getExtension(realfilename);
			
			if (profile.getSize() > 0) {
				filePath = "D:\\profile\\" + file_realnm + "." + extension;
				profile.write(filePath);
				int post_no = postVo.getPost_no();      
				FileVo fileVo = new FileVo();
				fileVo.setFile_name(filePath);
				fileVo.setFile_realnm(file_realnm);
				fileVo.setPost_no(post_no);
				
				int cnt2 = fileService.createFile(fileVo);
				logger.debug("cnt : {}", cnt2);
			}
			
		}
		if (cnt == 1) {
			// 서버쪽 상태가 바뀌는 경우 sendRedirect요청 forword X
			// contextPath 입력해줘야 한다.
			response.sendRedirect(request.getContextPath() + "/postList?board_no="+board_no);
		}else {
			// 회원등록 실패
			doGet(request, response);
		}
		
	}

}