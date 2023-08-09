package com.dw.controller.action5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.controller.action.Action;
import com.dw.dao.CartDAO;
import com.dw.dto.CartVO;

public class CartViewAction implements Action {

@Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String url= "cart/cartView.jsp";
	String pseq=request.getParameter("pseq");

	CartDAO cDao=CartDAO.getInstance();
	CartVO cVo =cDao.selectAllCartBypseq(pseq);
	request.setAttribute("cart", cVo);
	
RequestDispatcher dispatcher= request.getRequestDispatcher(url);
dispatcher.forward(request, response);
}

}
