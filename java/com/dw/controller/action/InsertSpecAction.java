package com.dw.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.PhysicalDAO;

public class InsertSpecAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      HttpSession session = request.getSession();
      String id = (String) session.getAttribute("id");
      System.out.println(id);
      //입력된 값 가져오기
            String physicaldate = request.getParameter("physicaldate");
            System.out.println(physicaldate);
            String weight = request.getParameter("weight");
            String height = request.getParameter("height");
            String fat = request.getParameter("fat");
            String muscle = request.getParameter("muscle");
            
            
            // DAO 호출하여 데이터 저장
            PhysicalDAO phDao = PhysicalDAO.getInstance();
            phDao.UserSpec(id, physicaldate, weight, height, fat, muscle);
            
            new MyPageAction().execute(request, response);
      
   }

}