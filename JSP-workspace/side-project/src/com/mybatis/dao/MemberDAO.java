//package com.mybatis.dao;
//
//import java.util.HashMap;
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//
//import com.mybatis.config.MyBatisConfig;
//import com.mybatis.vo.MemberVO;
//
//public class MemberDAO {
//	public SqlSession sqlSession;
//	
//	public MemberDAO() {
//		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
//	}
//	
////	회원 가입
//	public void insert(MemberVO memberVO) {
//		sqlSession.insert("member.insert", memberVO);
//	}
//	
////	로그인
//	public Long login(String memberName, int memberAge) {
//		HashMap<String, Object> loginMap = new HashMap<String, Object>();
//		loginMap.put("memberName", memberName);
//		loginMap.put("memberAge", memberAge);
//		
//		return sqlSession.selectOne("member.login", loginMap);
//	}
//	
////	전체 조회
//	public List<MemberVO> selectAll() {
//		return sqlSession.selectList("member.selectAll");
//	}
//	
////	이름 중복검사
//	public boolean getCountOfMemberName(String memberName) {
//		return (Integer)sqlSession.selectOne("member.getCountOfMemberName", memberName) == 0;
//	}
//	
////	마이페이지
//	public MemberVO select(Long memberId) {
//		return sqlSession.selectOne("member.select", memberId);
//	}
//	
////	회원탈퇴
//	public void delete(Long memberId) {
//		sqlSession.delete("member.delete", memberId);
//	}
//	
////	정보수정 : 여러분
//	public void update(MemberVO memberVO) {
//		sqlSession.update("member.update", memberVO);
//	}
//	
//	
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
