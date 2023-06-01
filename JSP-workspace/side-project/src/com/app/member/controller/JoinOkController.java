//package com.app.member.controller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.app.Action;
//import com.app.Result;
//import com.mybatis.dao.MemberDAO;
//import com.mybatis.vo.MemberVO;
//
//public class JoinOkController implements Action {
//	@Override
//	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		
//		String name = req.getParameter("memberName");
//		int age = Integer.parseInt(req.getParameter("memberAge"));
//		MemberDAO memberDAO = new MemberDAO();
//		Result result = new Result();
//		
//		MemberVO memberVO = new MemberVO();
//		memberVO.setMemberName(name);
//		memberVO.setMemberAge(age);
//		
//		memberDAO.insert(memberVO);
//		result.setRedirect(true);
//		result.setPath("login.member");
//		
//		return result;
//	}
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
