package com.dw.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.MembersDAO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String lev = request.getParameter("lev");
        
        MembersDAO mDAO = MembersDAO.getInstance();
        int result = mDAO.userCheck(id, pass, lev);
	    
        if (result == 1) {
            // 로그인 성공시 처리할 코드 작성
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            // 로그인 후 메인 페이지로 이동
            new MainAction().execute(request, response);
        } else if (result == 2) {
            // 관리자 로그인 성공시 처리할 코드 작성
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            // 관리자 페이지로 이동
            RequestDispatcher rd = request.getRequestDispatcher("dowhile/admin.jsp");
            rd.forward(request, response);
        } else if (result == 0) {
            // 비밀번호 불일치 처리
            String message = "비밀번호가 일치하지 않습니다.";
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("dowhile/login.jsp");
            rd.forward(request, response);
        } else if (result == -1) {
            // 해당 id가 존재하지 않는 경우 처리
            String message = "찾을 수 없는 아이디입니다.";
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("dowhile/login.jsp");
            rd.forward(request, response);
        }
	}
}
