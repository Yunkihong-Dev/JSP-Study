package com.app.reply.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.app.Action;
import com.app.Result;
import com.app.reply.dao.ReplyDAO;

public class ListOkController implements Action {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int page = Integer.parseInt(req.getParameter("page"));
		ReplyDAO replyDAO = new ReplyDAO();
		JSONArray jsonArray = new JSONArray();
		PrintWriter out = resp.getWriter();
		
		HashMap<String, Object> replyListMap = new HashMap<String, Object>();
		replyListMap.put("boardId", Long.valueOf(req.getParameter("boardId")));
		replyListMap.put("offset", (page - 1) * 10);
		replyListMap.put("rowCount", 10);
		
		replyDAO.selectByBoardId(replyListMap)
				.stream()
				.map(reply -> new JSONObject(reply)).forEach(jsonArray::put);
		
		out.print(jsonArray.toString());
		out.close();
		
		return null;
	}
}
