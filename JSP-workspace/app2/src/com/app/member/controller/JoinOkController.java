package com.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.member.dao.MemberDAO;
import com.app.member.domain.MemberVO;

public class JoinOkController implements Action{
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		Result result = new Result();
		
		memberVO.setMemberIdentification(req.getParameter("memberIdentification"));
		memberVO.setMemberPassword(req.getParameter("memberPassword"));
		memberVO.setMemberName(req.getParameter("memberName"));
		memberVO.setMemberBirth(req.getParameter("memberBirth"));
		memberVO.setMemberPhone(req.getParameter("memberPhone"));
		memberVO.setMemberEmail(req.getParameter("memberEmail"));
		
		memberDAO.insert(memberVO);
		
		result.setRedirect(true);
		result.setPath(req.getContextPath() + "/login.member");
		
		return result;
	}
}

















