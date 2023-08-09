package com.dw.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.dao.MembersDAO;
import com.dw.dto.MembersVO;


public class ManageUserAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/dowhile/manageUser.jsp";
		MembersDAO mDao = MembersDAO.getInstance();
		
		List<MembersVO> memberList = mDao.allUser();
		request.setAttribute("mlist", memberList);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}
