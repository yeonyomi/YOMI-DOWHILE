package com.dw.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.MembersDAO;
import com.dw.dto.MembersVO;

public class UserChangeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/dowhile/userChange.jsp";
		HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
		System.out.println("유저 체인지"+id);
		MembersDAO mDao = MembersDAO.getInstance();

		MembersVO member = mDao.getMember(id);

		request.setAttribute("member", member);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
