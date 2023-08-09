package com.dw.controller.action2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.controller.action.Action;
import com.dw.dao.ProductDAO;
import com.dw.dto.ProductVO;

public class ManageProductAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/product/manageProduct.jsp";

		String kind = request.getParameter("kind"); // 선택한 상품 종류
		
		ProductDAO pDao = ProductDAO.getInstance();
		List<ProductVO> plist = pDao.allProduct(kind); // 선택한 종류에 해당하는 상품 리스트 조회
		
		System.out.println(plist);
		request.setAttribute("plist", plist);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
