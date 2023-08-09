package com.dw.controller.action4;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.controller.action.Action;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.dw.dao.mealplanDAO;
import com.dw.dto.mealplanVO;

public class MealplanWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext context = request.getServletContext();
		HttpSession session = request.getSession();
		String path = context.getRealPath("images");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType);
		
		String selectdate = multi.getParameter("selectdate");
		String breakfast = multi.getParameter("breakfast");
		String breakfastimage = multi.getFilesystemName("breakfastimage");
		String breakfastmemo = multi.getParameter("breakfastmemo");
		String lunch = multi.getParameter("lunch");
		String lunchimage = multi.getFilesystemName("lunchimage");
		String lunchmemo = multi.getParameter("lunchmemo");
		String dinner = multi.getParameter("dinner");
		String dinnerimage = multi.getFilesystemName("dinnerimage");
		String dinnermemo = multi.getParameter("dinnermemo");
		
		mealplanVO mvo = new mealplanVO();
		mvo.setSelectdate(selectdate);
		mvo.setBreakfast(breakfast);
		mvo.setBreakfastimage(breakfastimage);
		mvo.setBreakfastmemo(breakfastmemo);
		mvo.setLunch(lunch);
		mvo.setLunchimage(lunchimage);
		mvo.setLunchmemo(lunchmemo);
		mvo.setDinner(dinner);
		mvo.setDinnerimage(dinnerimage);
		mvo.setDinnermemo(dinnermemo);
		
		mealplanDAO mDao = mealplanDAO.getInstance();
		mDao.insertMeal(mvo);
		new WorkoutListAction().execute(request, response);
	}

}
