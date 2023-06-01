package com.app.member.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.app.member.domain.MemberVO;
import com.app.mybatis.config.MyBatisConfig;

public class MemberDAO {
	public SqlSession sqlSession;
	
	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	회원가입
	public void insert(MemberVO memberVO) {
		sqlSession.insert("member.insert", memberVO);
	}
	
//	아이디 중복검사
	public String selectIdentification(String memberIdentification) {
		return sqlSession.selectOne("member.selectIdentification", memberIdentification);
	}
	
//	이메일 중복검사
	public String selectEmail(String memberEmail) {
		return sqlSession.selectOne("member.selectEmail", memberEmail);
	}
	
//	로그인
	public Long login(String memberIdentification, String memberPassword) {
		HashMap<String, String> loginMap = new HashMap<String, String>();
		loginMap.put("memberIdentification", memberIdentification);
		loginMap.put("memberPassword", memberPassword);
		
		return sqlSession.selectOne("member.login", loginMap);
	}
}






















