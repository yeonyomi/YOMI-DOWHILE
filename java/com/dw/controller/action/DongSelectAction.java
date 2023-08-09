package com.dw.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.dao.PlaceDAO;
import com.dw.dto.PlaceVO;

public class DongSelectAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/dowhile/place.jsp";
		PlaceDAO pDao = PlaceDAO.getInstance();
		
		String dong = request.getParameter("dong");
		System.out.println("액션에있는 동 값 ->"+dong);
		List<PlaceVO> plist = PlaceDAO.getInstance().allDong(dong);
		request.setAttribute("plist", plist);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
