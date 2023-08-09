package com.dw.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.dao.MembersDAO;
import com.dw.dto.MembersVO;



public class JoinAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersVO member =new MembersVO();
		
		member.setId(request.getParameter("id"));
		member.setPass(request.getParameter("pass"));
		member.setName(request.getParameter("name"));
		member.setAddress(request.getParameter("address"));
		member.setPhone(request.getParameter("phone"));
		
		MembersDAO mDao = MembersDAO.getInstance();
		mDao.insertMember(member);
		
		new MainAction().execute(request, response);
		
	}

}
