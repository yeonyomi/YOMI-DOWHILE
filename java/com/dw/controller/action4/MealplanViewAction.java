package com.dw.controller.action4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.controller.action.Action;
import com.dw.dao.PhysicalDAO;
import com.dw.dao.mealplanDAO;
import com.dw.dao.workoutDAO;
import com.dw.dto.mealplanVO;
import com.dw.dto.workoutVO;

public class MealplanViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Scheduler/workoutList.jsp";
		String selectdate = request.getParameter("selectdate");
		System.out.println(selectdate);
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		if(id==null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		mealplanDAO mDao = mealplanDAO.getInstance();
		mealplanVO mvo = mDao.getMeal(selectdate);
		workoutDAO wDao = workoutDAO.getInstance();
		workoutVO wVo = wDao.getWorkout(selectdate);
		request.setAttribute("workout2", wVo);
		request.setAttribute("mealplan", mvo);
        PhysicalDAO pDao = PhysicalDAO.getInstance();
        pDao.getWeightData(request);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}
	

}
