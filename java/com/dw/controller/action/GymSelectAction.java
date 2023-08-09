package com.dw.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.dao.PlaceDAO;
import com.dw.dto.PlaceVO;

public class GymSelectAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/dowhile/place.jsp";
		PlaceDAO pDao = PlaceDAO.getInstance();
		
		String gym = request.getParameter("gym");
		System.out.println("액션에있는 짐 값 ->"+gym);
		List<PlaceVO> plist = PlaceDAO.getInstance().allGym(gym);
		request.setAttribute("plist", plist);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
