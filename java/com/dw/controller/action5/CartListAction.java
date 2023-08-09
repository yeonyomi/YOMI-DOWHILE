package com.dw.controller.action5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.controller.action.Action;
import com.dw.dao.CartDAO;
import com.dw.dto.CartVO;

public class CartListAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      String url = "/cart/cartmain.jsp";
      HttpSession session = request.getSession();
      String id = (String) session.getAttribute("id");
      CartDAO cDao = CartDAO.getInstance();
      List<CartVO> cartList = cDao.userCart(id);
      request.setAttribute("clist", cartList);
      if (id == null) {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('로그인이 필요한 항목입니다.');");
            out.println("location.href='javascript:history.back()';");
            out.println("</script>");
        } else {
           RequestDispatcher rd = request.getRequestDispatcher(url);
          rd.forward(request, response);
        }
      

      

      
      
   }
}


