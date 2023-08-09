package com.dw.controller.action2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.controller.action.Action;
import com.dw.dao.ProductDAO;

public class ProductDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		ProductDAO pDao = ProductDAO.getInstance();
		
		pDao.deleteProduct(seq);
		
		new ManageProductAction().execute(request, response);
		
		
	}

}
