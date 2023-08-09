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

public class ProductListAction implements Action {
	// 전역변수
	private String kind;

	public ProductListAction(String kind) {
		// switch에서의 null point 에러를 막기 위해
		if(kind == null) {
			this.kind = "";
		} else {
			this.kind = kind;
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kind = request.getParameter("kind");
		System.out.println(kind);
		String url = "/productList.jsp";
		ProductDAO productDAO = ProductDAO.getInstance();
		List<ProductVO> productList = productDAO.selectAllProducts(kind);
	
		// 아이템 종류 설정
		String kindName;
		switch (kind) {
		case "1":
			kindName = "단백질 쉐이크";
			break;
		case "2":
			kindName = "단백질바/스낵";
			break;
		case "3":
			kindName = "소도구";
			break;
		case "4":
			kindName = "여성의류";
			break;
		case "5":
			kindName = "남성의류";
			break;
		default:
			kindName = "에러";
			break;
		}
		request.setAttribute("kindName", kindName);
		request.setAttribute("productList", productList);
		request.setAttribute("kind", kind);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
