package com.dw.controller.action5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.controller.action.Action;
import com.dw.dao.CartDAO;

public class CartDeleteAllAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
         String id = (String) session.getAttribute("id");
         
         // 장바구니에 있는 모든 상품을 삭제하는 DAO 메서드 호출
         CartDAO cartDao = CartDAO.getInstance();
         cartDao.deleteAllCartItems(id);
         
         // 장바구니 페이지로 다시 이동
         new CartListAction().execute(request, response);

		
	}

}
