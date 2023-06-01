package com.app.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.app.Action;
import com.app.Result;
import com.app.member.dao.MemberDAO;

public class CheckEmailOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html;charset=utf-8");
		String memberEmail = req.getParameter("memberEmail");
		MemberDAO memberDAO = new MemberDAO();
		boolean check = memberDAO.selectEmail(memberEmail) == null;
		JSONObject result = new JSONObject();
		
		try {
			result.put("check", check);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		PrintWriter out = resp.getWriter();
		out.print(result.toString());
		out.close();
		
		return null;
	}

}
