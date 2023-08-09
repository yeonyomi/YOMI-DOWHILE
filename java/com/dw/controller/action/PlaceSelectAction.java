package com.dw.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.dao.PlaceDAO;
import com.dw.dto.PlaceVO;

public class PlaceSelectAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/dowhile/place.jsp";
		PlaceDAO pDao = PlaceDAO.getInstance();
		
		String gu = request.getParameter("place");
		List<PlaceVO> plist = PlaceDAO.getInstance().allGu(gu);
		request.setAttribute("plist", plist);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
