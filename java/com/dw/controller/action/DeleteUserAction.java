package com.dw.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.dao.MembersDAO;


public class DeleteUserAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
	
		MembersDAO mDao = MembersDAO.getInstance();
		mDao.deleteMember(id);
		
		new ManageUserAction().execute(request, response);
	}

}