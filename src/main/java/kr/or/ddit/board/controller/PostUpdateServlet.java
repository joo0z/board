package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

@WebServlet("/postUpdate")
@MultipartConfig
public class PostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostUpdateServlet.class);
	private PostServiceI postService;
	private FileServiceI fileService;
    private FileVo fileVo;   
	
	@Override
	public void init() throws ServletException {
		postService = new PostService();
		fileService = new FileService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.debug("doGet");
		request.setCharacterEncoding("utf-8");
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		logger.debug("post_no :{}", post_no);
		
		String post_title = request.getParameter("post_title");
		String post_content= request.getParameter("post_content");
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		logger.debug("parameter :{},{},{}",post_title , post_content, board_no);
		
		List<FileVo> fileList = fileService.getAllFile(post_no);
		request.setAttribute("fileList", fileList);
		logger.debug("fileList : {}", fileList);
		
		request.getRequestDispatcher("/post/updatePost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doPost");
		request.setCharacterEncoding("utf-8");
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		logger.debug("post_no :{}", post_no);
		
		String post_title = request.getParameter("post_title");
		String post_content= request.getParameter("post_content");
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		logger.debug("post_title,post_content,board_no :{},{},{}",post_title , post_content, board_no);
		
		PostVo postVo = new PostVo();   
		postVo.setPost_title(post_title);
		postVo.setPost_content(post_content);
		postVo.setPost_no(post_no);
		postVo.setBoard_no(board_no);
		logger.debug("===========");
		
		int cnt = postService.updatePost(postVo);
		logger.debug("cnt : {}", cnt);
		
		// input요소를 가져오는 List
		List<Part> partList = new ArrayList(request.getParts());
		int fileCount = 0;
		logger.debug("partSize : {}",partList.size());
		for(Part part : partList) {
			// realfilename이 없을 때 까지 count
			if(part.getName().indexOf("realfilename")!= -1) {
				fileCount++;
			}
		}
		
		for (int i = 1; i < fileCount+1; i++) {
			Part profile = request.getPart("realfilename" + i);
			logger.debug("profile-num : {}",profile.getName());
			logger.debug("file : {}", profile.getHeader("Content-Disposition"));
			String realfilename = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
			String file_realnm = UUID.randomUUID().toString();
			String filePath = "";
			String extension = FileUploadUtil.getExtension(realfilename);
			
			if (profile.getSize() > 0) {
				filePath = "D:\\profile\\" + file_realnm + "." + extension;
				profile.write(filePath);
				post_no = postVo.getPost_no();      
				FileVo fileVo = new FileVo();
				fileVo.setFile_name(filePath);
				fileVo.setFile_realnm(realfilename);
				fileVo.setPost_no(post_no);
				
				int cnt2 = fileService.createFile(fileVo);
				logger.debug("cnt : {}", cnt2);
			}
		}
		
		String[] file_nos = request.getParameterValues("del_nos");
		logger.debug("file_nos : {}", Arrays.toString(file_nos));
		for (int i = 0; i < file_nos.length; i++) {
			int file_no = Integer.parseInt(file_nos[i]);
			int delCnt = fileService.deleteFile(file_no);
			logger.debug("delCnt : {}", delCnt);
		}
		
		
		if (cnt == 1 ) {
			response.sendRedirect(request.getContextPath() + "/postList?board_no="+board_no);
		}else {
			doGet(request, response);
		}
	}

}
