package com.dw.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.MembersDAO;

public class DeleteMypageUser implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/dowhile/main.jsp";
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		
		MembersDAO mDao = MembersDAO.getInstance();
		mDao.deleteMember(id);
		
		session.invalidate();
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
