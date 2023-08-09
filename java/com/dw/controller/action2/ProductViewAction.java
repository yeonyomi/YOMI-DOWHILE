package com.dw.controller.action2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.controller.action.Action;
import com.dw.dao.ProductDAO;
import com.dw.dto.ProductVO;

public class ProductViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/product/productView.jsp";
		
		int seq  =Integer.parseInt(request.getParameter("seq"));
		ProductDAO pDao = ProductDAO.getInstance();
		
		ProductVO product = pDao.getProduct(seq);
		request.setAttribute("product", product);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
