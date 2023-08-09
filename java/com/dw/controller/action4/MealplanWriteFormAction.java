package com.dw.controller.action4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.controller.action.Action;

public class MealplanWriteFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Scheduler/mealplanWrite.jsp";
		String selectdate = request.getParameter("selectdate");
		request.setAttribute("selectdate", selectdate);
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
}
