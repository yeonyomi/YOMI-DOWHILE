package com.dw.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.PhysicalDAO;
import com.dw.dto.PhysicalVO;

public class MyPageAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/dowhile/mypage.jsp";
      
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        
    
        System.out.println("마이페이지"+id);
        PhysicalDAO phDao = PhysicalDAO.getInstance();
        
        PhysicalVO physical = phDao.getUserSpec(id);
        System.out.println(physical);
        request.setAttribute("physical", physical);
      
      RequestDispatcher rd = request.getRequestDispatcher(url);
      rd.forward(request, response);
      
   }

}