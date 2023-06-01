package com.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.board.dao.BoardDAO;
import com.app.file.dao.FileDAO;

public class DetailOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		BoardDAO boardDAO = new BoardDAO();
		FileDAO fileDAO = new FileDAO();
		Result result = new Result();
		Long boardId = Long.valueOf(req.getParameter("boardId"));
		boardDAO.updateReadCount(boardId);
		
		req.setAttribute("board", boardDAO.select(boardId));
		req.setAttribute("files", fileDAO.selectByBoardId(boardId));
		
		result.setPath("templates/board/detail.jsp");
		return result;
	}
}
