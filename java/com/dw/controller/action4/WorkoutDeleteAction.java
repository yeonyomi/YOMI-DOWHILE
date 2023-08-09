package com.dw.controller.action4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.controller.action.Action;
import com.dw.dao.workoutDAO;

public class WorkoutDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectdate = request.getParameter("selectdate");
		workoutDAO wDao = workoutDAO.getInstance();
		wDao.deleteWorkout(selectdate);
		
		new WorkoutListAction().execute(request, response);
		
	}
	
}
