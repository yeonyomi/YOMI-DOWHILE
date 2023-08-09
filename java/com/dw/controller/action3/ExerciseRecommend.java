package com.dw.controller.action3;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.controller.action.Action;
import com.dw.dao.RecommendDAO;
import com.dw.dto.RecommendVO;

public class ExerciseRecommend implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/training/training.jsp";
		
		String part = request.getParameter("part");
		System.out.println(part);
		RecommendDAO rDao = RecommendDAO.getInstance();
		List<RecommendVO> rlist = rDao.ramdomExercise(part);
	System.out.println(rlist);
		
		request.setAttribute("rlist", rlist);
	
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}
