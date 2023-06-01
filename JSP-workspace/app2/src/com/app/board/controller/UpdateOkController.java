package com.app.board.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.board.dao.BoardDAO;
import com.app.board.domain.BoardVO;
import com.app.file.dao.FileDAO;
import com.app.file.domain.FileVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		BoardVO boardVO = new BoardVO();
		FileVO fileVO = new FileVO();
		BoardDAO boardDAO = new BoardDAO();
		FileDAO fileDAO = new FileDAO();
		Result result = new Result();
		Path path = null;
		
		String root = req.getServletContext().getRealPath("/") + "upload/";
		int fileSize = 1024 * 1024 * 20;

		MultipartRequest multipartRequest = new MultipartRequest(req, root, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		Long boardId = Long.valueOf(multipartRequest.getParameter("boardId"));
		boardVO.setBoardId(boardId);
		boardVO.setBoardTitle(multipartRequest.getParameter("boardTitle"));
		boardVO.setBoardContent(multipartRequest.getParameter("boardContent"));
		
		boardDAO.update(boardVO);
		
		fileDAO.selectByBoardId(boardId).stream()
		.map(FileVO::getFileSystemName)
		.forEach(fileName -> {
			File file = new File(root, fileName);
			if(file.exists()) {
				file.delete();
			}
		});
		
		fileDAO.delete(boardVO.getBoardId());
		fileVO.setBoardId(boardVO.getBoardId());
		
		Enumeration<String> inputTypeFileNames = multipartRequest.getFileNames();
		
		while(inputTypeFileNames.hasMoreElements()) {
			String inputTypeFileName = inputTypeFileNames.nextElement();
			String fileSystemName = multipartRequest.getFilesystemName(inputTypeFileName);
			if(fileSystemName == null) {continue;}
			fileVO.setFileSystemName(fileSystemName);
			fileVO.setFileOriginalName(multipartRequest.getOriginalFileName(inputTypeFileName));
			path = Path.of(root + fileSystemName);
			fileVO.setFileSize(Files.size(path));
			
			fileDAO.insert(fileVO);
		}
		
		
		result.setPath(req.getContextPath() + "/detailOk.board?boardId=" + boardId);
		result.setRedirect(true);
		
		return result;
	}

}
