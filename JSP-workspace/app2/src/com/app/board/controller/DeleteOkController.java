package com.app.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.board.dao.BoardDAO;
import com.app.file.dao.FileDAO;
import com.app.file.domain.FileVO;

public class DeleteOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		BoardDAO boardDAO = new BoardDAO();
		FileDAO fileDAO = new FileDAO();
		Result result = new Result();
		Long boardId = Long.valueOf(req.getParameter("boardId"));
		String root = req.getServletContext().getRealPath("/") + "upload";
		
		fileDAO.selectByBoardId(boardId).stream()
		.map(FileVO::getFileSystemName)
		.forEach(fileName -> {
			File file = new File(root, fileName);
			if(file.exists()) {
				file.delete();
			}
		});
		
		fileDAO.delete(boardId);
		boardDAO.delete(boardId);
		
		result.setPath(req.getContextPath() + "/listOk.board");
		result.setRedirect(true);
		
		return result;
	}

}
