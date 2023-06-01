package com.app.reply.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.app.mybatis.config.MyBatisConfig;
import com.app.reply.domain.ReplyDTO;

public class ReplyDAO {
	public SqlSession sqlSession;
	
	public ReplyDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	댓글 추가
	public void insert() {}
	
//	댓글 목록
	public List<ReplyDTO> selectByBoardId(HashMap<String, Object> replyListMap) {
		return sqlSession.selectList("reply.selectByBoardId", replyListMap);
	}
	
//	댓글 수정
	public void update() {}
//	댓글 삭제
	public void delete() {}
}







