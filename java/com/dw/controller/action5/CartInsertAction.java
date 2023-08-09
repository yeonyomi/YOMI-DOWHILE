package com.dw.controller.action5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.controller.action.Action;
import com.dw.dao.CartDAO;
import com.dw.dto.CartVO;
import com.dw.dto.MembersVO;


public class CartInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "DowhileServlet?command=cart_list";
		
		HttpSession session = request.getSession();
		 MembersVO id = (MembersVO) session.getAttribute("id");
		
		 
		 if (id == null) {
		      url = "DowhileServlet?command=login_form";
		    } else {
		      CartVO cartVO = new CartVO();
		      
		      cartVO.setId(id.getId());
		      cartVO.setpSeq(Integer.parseInt(request.getParameter("pSeq")));
		      cartVO.setQuantity(Integer.parseInt(request
		          .getParameter("quantity")));

		      CartDAO cartDAO = CartDAO.getInstance();
		      cartDAO.insertCart(cartVO);
		    }
		    response.sendRedirect(url);
		  }
		}
