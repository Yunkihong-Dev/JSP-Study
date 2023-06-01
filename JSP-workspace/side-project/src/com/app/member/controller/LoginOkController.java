package com.app.member.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;

public class LoginOkController implements Action {

	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		MemberDAO memberDAO = new MemberDAO();
		Result result = new Result();
		
		String name = req.getParameter("memberName");
		int age = Integer.parseInt(req.getParameter("memberAge"));
		
		Long memberId = memberDAO.login(name, age);
		
		if(memberId != null) {
//			로그인 성공
			result.setRedirect(true);
//			서블릿에서 쿼리스트링에 문자열값을 보낼 때에는 URLEncoder를 사용하여 보낸다.
			result.setPath(req.getContextPath() + "/main?name=" + URLEncoder.encode(name, "UTF-8"));
			
		}else {
//			로그인 실패
			result.setPath("join.member");
			
		}
		
		return result;
	}
}
