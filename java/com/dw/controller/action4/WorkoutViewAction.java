package com.dw.controller.action4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.controller.action.Action;
import com.dw.dao.workoutDAO;
import com.dw.dto.workoutVO;

public class WorkoutViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Scheduler/workoutList.jsp";
		HttpSession session = request.getSession();
        String selectdate = (String) session.getAttribute("selectdate");
		System.out.println(selectdate);
		workoutDAO wDao = workoutDAO.getInstance();
		workoutVO wVo = wDao.getWorkout(selectdate);
		request.setAttribute("workout2", wVo);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}	

}
