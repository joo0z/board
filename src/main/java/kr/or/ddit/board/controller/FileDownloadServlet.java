package kr.or.ddit.board.controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.FileVo;
import kr.or.ddit.board.service.FileService;
import kr.or.ddit.board.service.FileServiceI;

@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileServiceI fileService;
	private static final Logger logger = LoggerFactory.getLogger(FileDownloadServlet.class);
	
	@Override
	public void init() throws ServletException {
		fileService = new FileService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int file_no = Integer.parseInt(request.getParameter("file_no"));
		logger.debug("file_no : {}", file_no);
		
		
		FileVo fileVo = fileService.getFile(file_no);
		// response context-type 설정
	    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileVo.getFile_realnm() + "\"");
	    response.setContentType("application/octet-stream");
		
		FileInputStream fis = new FileInputStream(fileVo.getFile_name());
		ServletOutputStream sos = response.getOutputStream();
		
		// 이미지는 text가 아니고 바이너리 파일로 보내야한다.
		byte[] buffer = new byte[512];
		
		while ( fis.read(buffer) != -1) {
			sos.write(buffer);
		}
		
		fis.close();
		// 응답이 가지 않은게 있으면 보내고 닫아라
		sos.flush();
		sos.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
