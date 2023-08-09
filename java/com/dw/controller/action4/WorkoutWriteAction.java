package com.dw.controller.action4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.controller.action.Action;
import com.dw.dao.workoutDAO;
import com.dw.dto.workoutVO;

public class WorkoutWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		workoutVO wvo = new workoutVO();
		wvo.setSelectdate(request.getParameter("selectdate"));
		wvo.setExercise(request.getParameter("exercise"));
		wvo.setTime(request.getParameter("time"));
		wvo.setPart(request.getParameter("part"));
		wvo.setContent1(request.getParameter("content1"));
		wvo.setContent2(request.getParameter("content2"));
		wvo.setContent3(request.getParameter("content3"));
		wvo.setContent4(request.getParameter("content4"));
		wvo.setContent5(request.getParameter("content5"));
		
		workoutDAO wDao = workoutDAO.getInstance();
		wDao.insertWorkout(wvo);
		
		new WorkoutListAction().execute(request, response);
	}

}
