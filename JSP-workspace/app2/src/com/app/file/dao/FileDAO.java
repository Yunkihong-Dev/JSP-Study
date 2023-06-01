package com.app.file.dao;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.app.file.domain.FileVO;
import com.app.mybatis.config.MyBatisConfig;

public class FileDAO {
public SqlSession sqlSession;
	
	public FileDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	파일 추가
	public void insert(FileVO fileVO) {
		sqlSession.insert("file.insert", fileVO);
	}
	
//	파일 삭제
	public void delete(Long boardId) {
		sqlSession.delete("file.delete", boardId);
	}
	
//	파일 조회
	public List<FileVO> selectByBoardId(Long boardId){
		return sqlSession.selectList("file.selectByBoardId", boardId);
	}
}



















