package com.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.Action;
import com.app.Result;
import com.app.member.dao.MemberDAO;

public class LoginOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		MemberDAO memberDAO = new MemberDAO();
		String memberIdentification = req.getParameter("memberIdentification");
		String memberPassword = req.getParameter("memberPassword");
		Long memberId = 0L;
		HttpSession session = req.getSession();
		Result result = new Result();
		boolean autoLogin = Boolean.valueOf(req.getParameter("auto-login"));
		result.setRedirect(true);
		
		if(memberIdentification == null) {
			if(req.getHeader("Cookie") != null){
				Cookie[] cookies = req.getCookies();
				
				for(Cookie cookie: cookies){
					if(cookie.getName().equals("memberIdentification")) {
						memberIdentification = cookie.getValue();
					}
					if(cookie.getName().equals("memberPassword")) {
						memberPassword = cookie.getValue();
					}
					if(cookie.getName().equals("autoLogin")) {
						autoLogin = Boolean.valueOf(cookie.getValue());
					}
				}
			}
		}
		
		memberId = memberDAO.login(memberIdentification, memberPassword);
		
		if(memberId == null) {
//			로그인 실패
			result.setPath(req.getContextPath() + "/login.member?login=false");
		}else {
//			로그인 성공
			session.setAttribute("memberId", memberId);
			result.setPath(req.getContextPath() + "/listOk.board");
			if(autoLogin) {
				Cookie memberIdentificationInCookie = new Cookie("memberIdentification", memberIdentification);
				Cookie memberPasswordInCookie = new Cookie("memberPassword", memberPassword);
				Cookie autoLoginInCookie = new Cookie("autoLogin", String.valueOf(autoLogin));
				resp.addCookie(memberIdentificationInCookie);
				resp.addCookie(memberPasswordInCookie);
				resp.addCookie(autoLoginInCookie);
				
			}else {
				if(req.getHeader("Cookie") != null){
					Cookie[] cookies = req.getCookies();
					for(Cookie cookie: cookies){
						if(cookie.getName().equals("autoLogin")) {
							cookie.setMaxAge(0); //초단위
							resp.addCookie(cookie);
						}
					}
				}
			}
		}
		return result;
	}

}






















