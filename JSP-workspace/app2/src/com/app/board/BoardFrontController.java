package com.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Result;
import com.app.board.controller.DeleteOkController;
import com.app.board.controller.DetailOkController;
import com.app.board.controller.ListOkController;
import com.app.board.controller.UpdateController;
import com.app.board.controller.UpdateOkController;
import com.app.board.controller.WriteOkController;

public class BoardFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String target = req.getRequestURI().replace(req.getContextPath() + "/", "").split("\\.")[0];
		Result result = null;
		
		if(target.equals("listOk")) {
			result = new ListOkController().execute(req, resp);
			
		} else if(target.equals("write")) {
			result = new Result();
			result.setPath("templates/board/write.jsp");
			
		} else if(target.equals("writeOk")) {
			result = new WriteOkController().execute(req, resp);
			
		} else if(target.equals("detailOk")) {
			result = new DetailOkController().execute(req, resp);
			
		} else if(target.equals("update")) {
			result = new UpdateController().execute(req, resp);
			
		} else if(target.equals("updateOk")) {
			result = new UpdateOkController().execute(req, resp);
			
		} else if(target.equals("deleteOk")) {
			result = new DeleteOkController().execute(req, resp);
			
		}
		
		if(result != null) {
			if(result.isRedirect()) {
				resp.sendRedirect(result.getPath());
			}else {
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
