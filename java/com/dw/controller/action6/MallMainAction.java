package com.dw.controller.action6;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.controller.action.Action;
import com.dw.dao.ProductDAO;
import com.dw.dto.ProductVO;

public class MallMainAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="mall.jsp";
		ProductDAO productDAO = ProductDAO.getInstance();

		List<ProductVO> productList = productDAO.selectBestProducts();
		request.setAttribute("productList", productList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
