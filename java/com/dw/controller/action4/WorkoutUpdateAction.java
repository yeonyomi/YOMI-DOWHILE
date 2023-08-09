package com.dw.controller.action4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.controller.action.Action;
import com.dw.dao.workoutDAO;
import com.dw.dto.workoutVO;

public class WorkoutUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		workoutVO wvo = new workoutVO();
		wvo.setSelectdate(request.getParameter("selectdate"));
		wvo.setContent1(request.getParameter("update1"));
		wvo.setContent2(request.getParameter("update2"));
		wvo.setContent3(request.getParameter("update3"));
		wvo.setContent4(request.getParameter("update4"));
		wvo.setContent5(request.getParameter("update5"));
		System.out.println(request.getParameter("selectdate"));
		System.out.println(request.getParameter("update1"));
		System.out.println(request.getParameter("update2"));
		System.out.println(request.getParameter("update3"));
		System.out.println(request.getParameter("update4"));
		System.out.println(request.getParameter("update5"));
		workoutDAO wDao = workoutDAO.getInstance();
		wDao.updateWorkout(wvo);
		new WorkoutListAction().execute(request, response);
		
		
		
		
	}
	

}
