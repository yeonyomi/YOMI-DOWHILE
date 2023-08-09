package com.dw.controller.action5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.controller.action.Action;
import com.dw.dao.CartDAO;

public class CartDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String[] names = request.getParameterValues("names[]");
	        CartDAO cDao = CartDAO.getInstance();
	        if (names != null) {
	            for (String name : names) {
	                cDao.deleteCart(name);
	            }
	        }
	        new CartListAction().execute(request, response);
	    }
}
	