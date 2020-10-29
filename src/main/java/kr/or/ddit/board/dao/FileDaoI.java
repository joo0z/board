package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.FileVo;

public interface FileDaoI {
	
	/**
	 * 파일 업로드를 위한 메서드
	 * @param fileVo
	 * @return
	 */
	int createFile(FileVo fileVo);
	
	/**
	 * 게시글에 있는 파일을 모두 반환하는 메서드
	 * @param file_no
	 * @return
	 */
	List<FileVo> getAllFile(int post_no);
	
	/**
	 * 파일 1개의 정보를 가져오는 메서드
	 * @param file_no
	 * @return
	 */
	FileVo getFile(int file_no);
	
	/**
	 * 파일을 삭제하는 메서드
	 * @param file_no
	 * @return
	 */
	int deleteFile(int file_no);
}
