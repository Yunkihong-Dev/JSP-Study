package com.app.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.app.Action;
import com.app.Result;
import com.app.board.dao.BoardDAO;
import com.app.board.domain.BoardDTO;
import com.app.board.domain.Criteria;
import com.app.board.domain.Search;

public class ListOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		BoardDAO boardDAO = new BoardDAO();
		Result result = new Result();
		JSONArray jsonArray = new JSONArray();
		String temp = req.getParameter("page");
		int page = temp == null ? 1 : Integer.parseInt(temp);
		String sort = req.getParameter("sort");
		String type = req.getParameter("type");
		String keyword = req.getParameter("keyword");
		
		sort = sort == null ? "recent" : sort; 
		
		Search search = new Search(type, keyword);
		Criteria criteria = new Criteria(page, boardDAO.getTotal(search), sort);
		HashMap<String, Object> pagable = new HashMap<String, Object>();
		pagable.put("types", search.getTypes());
		pagable.put("keyword", search.getKeyword());
		pagable.put("offset", criteria.getOffset());
		pagable.put("rowCount", criteria.getRowCount());
		pagable.put("sort", sort);
		
		boardDAO.selectAll(pagable).stream().map(board -> new JSONObject(board)).forEach(jsonArray::put);
		req.setAttribute("boards", jsonArray.toString());
		req.setAttribute("total", boardDAO.getTotal(search));
		req.setAttribute("page", page);
		req.setAttribute("startPage", criteria.getStartPage());
		req.setAttribute("endPage", criteria.getEndPage());
		req.setAttribute("prev", criteria.isPrev());
		req.setAttribute("next", criteria.isNext());
		req.setAttribute("sort", sort);
		req.setAttribute("type", type);
		req.setAttribute("keyword", keyword);
		
		result.setPath("templates/board/list.jsp");
		return result;
	}
}









