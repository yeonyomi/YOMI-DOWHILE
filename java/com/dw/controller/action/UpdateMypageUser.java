package com.dw.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.dao.MembersDAO;
import com.dw.dto.MembersVO;

public class UpdateMypageUser implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/dowhile/mypage.jsp";
		

		MembersVO mvo = new MembersVO();
		

		mvo.setId(request.getParameter("id"));
		mvo.setPass(request.getParameter("pass"));
		mvo.setName(request.getParameter("name"));
		mvo.setAddress(request.getParameter("address"));
		mvo.setPhone(request.getParameter("phone"));

		MembersDAO mDao = MembersDAO.getInstance();

		mDao.updateMember(mvo);
		System.out.println(mvo);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
