package com.dw.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.dao.MembersDAO;

public class IdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/dowhile/join.jsp";
		
		String id = request.getParameter("id");
		if (id == null || id.trim().isEmpty()) {
		    request.setAttribute("message", "아이디를 입력해주세요.");
		} else {
		    MembersDAO mDao = MembersDAO.getInstance();
		    boolean idCheck = mDao.idCheck(id);
		    System.out.println(id);
		    
		    if (idCheck) {
		        request.setAttribute("message", "중복된 아이디입니다.");
		    } else {
		        request.setAttribute("message", "사용 가능한 아이디입니다.");
		        request.setAttribute("id", id);
		    }
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}