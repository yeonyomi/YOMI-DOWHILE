package com.dw.controller.action5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.controller.action.Action;
import com.dw.dao.CartDAO;
import com.dw.dto.CartVO;

public class CartUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		CartVO cvo = new CartVO();
		
		cvo.setName(request.getParameter("name"));
		
		cvo.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		
		cvo.setPrice(Integer.parseInt(request.getParameter("price")));
		
		CartDAO cDao = CartDAO.getInstance();
		
		cDao.updateCart(cvo);
		
		new CartListAction().execute(request, response);
		
	}

}
