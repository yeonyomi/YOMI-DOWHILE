package com.dw.controller.action5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.controller.action.Action;
import com.dw.dao.CartDAO;
import com.dw.dto.CartVO;

public class CartBasketAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      String id = (String) session.getAttribute("id");
      
       int pseq = Integer.parseInt(request.getParameter("pseq"));
       String imagePath = request.getParameter("imagePath");
       String name = request.getParameter("name");
       int quantity = Integer.parseInt(request.getParameter("quantity"));
       int price = Integer.parseInt(request.getParameter("price"));
       
       CartVO cart = new CartVO();
       cart.setId(id);
       cart.setpSeq(pseq);
       cart.setImagePath(imagePath);
       cart.setName(name);
       cart.setQuantity(quantity);
       cart.setPrice(price);
       
       CartDAO cartDAO = CartDAO.getInstance();
       cartDAO.insertCart(cart);
       if (id == null) {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('로그인이 필요한 항목입니다.');");
            out.println("location.href='javascript:history.back()';");
            out.println("</script>");
        } else {
        	response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("location.href='javascript:history.back()';");
            out.println("</script>");
        }
       


   }

}