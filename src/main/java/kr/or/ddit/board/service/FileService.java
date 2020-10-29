package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.FileDao;
import kr.or.ddit.board.dao.FileDaoI;
import kr.or.ddit.board.dao.PostDao;
import kr.or.ddit.board.dao.PostDaoI;
import kr.or.ddit.board.model.FileVo;

public class FileService implements FileServiceI{

	private FileDaoI fileDao;

	public FileService() {
		fileDao = new FileDao();
	}

	@Override
	public int createFile(FileVo fileVo) {
		return fileDao.createFile(fileVo);
	}

	@Override
	public List<FileVo> getAllFile(int post_no) {
		return fileDao.getAllFile(post_no);
	}

	@Override
	public FileVo getFile(int file_no) {
		return fileDao.getFile(file_no);
	}

	@Override
	public int deleteFile(int file_no) {
		return fileDao.deleteFile(file_no);
	}
	

}
