package com.dw.controller.action4;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.controller.action.Action;
import com.dw.dao.workoutDAO;
import com.dw.dto.workoutVO;

public class WorkoutListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Scheduler/workoutList.jsp";
		workoutDAO wDao = workoutDAO.getInstance();
		
		List<workoutVO> workoutList = wDao.selectallWorkout();
		request.setAttribute("list", workoutList);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}
	

}
