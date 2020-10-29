package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.FileVo;
import kr.or.ddit.db.MybatisUtil;

public class FileDao implements FileDaoI{

	@Override
	public int createFile(FileVo fileVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = sqlSession.insert("post.createFile", fileVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return cnt;
	}

	@Override
	public List<FileVo> getAllFile(int post_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<FileVo> list = sqlSession.selectList("post.getAllFile", post_no);
		sqlSession.close();
		return list;
	}

	@Override
	public FileVo getFile(int file_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		FileVo fileVo = sqlSession.selectOne("post.getFile", file_no);
		sqlSession.close();
		return fileVo;
	}

}
