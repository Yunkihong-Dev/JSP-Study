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

public class CheckIdOkController implements Action{
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		MemberDAO memberDAO = new MemberDAO();
		String memberIdentification = memberDAO.selectIdentification(req.getParameter("memberIdentification"));
		boolean check = memberIdentification == null;
		
		JSONObject result = new JSONObject();
		try {
			result.put("check", check);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.print(result.toString());
		out.close();
		return null;
	}
}






















