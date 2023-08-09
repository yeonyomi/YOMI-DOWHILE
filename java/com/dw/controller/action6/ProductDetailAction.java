package com.dw.controller.action6;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.controller.action.Action;
import com.dw.dao.ProductDAO;
import com.dw.dto.ProductVO;

public class ProductDetailAction implements Action {
	private String seq;

	public ProductDetailAction(String seq) {
		this.seq = seq;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/productContent.jsp";
		
		
		int seq  =Integer.parseInt(request.getParameter("seq"));
		ProductDAO productDAO = ProductDAO.getInstance();
		ProductVO productVO = productDAO.selectProduct(seq);
		System.out.println(productVO);
		request.setAttribute("product", productVO);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
