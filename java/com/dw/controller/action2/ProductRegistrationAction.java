package com.dw.controller.action2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.controller.action.Action;
import com.dw.dao.ProductDAO;
import com.dw.dto.ProductVO;

public class ProductRegistrationAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/product/productRegistration.jsp";

		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");

		if (id == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다');");
			out.println("</script>");
		} else {
			

			ProductVO product = new ProductVO();

			product.setName(request.getParameter("name"));
			product.setKind(request.getParameter("kind"));
			product.setCost(Integer.parseInt(request.getParameter("cost")));
			product.setPrice(Integer.parseInt(request.getParameter("price")));
			product.setContent(request.getParameter("content"));
			product.setImagePath(request.getParameter("image_path"));
			product.setThumbImagePath(request.getParameter("thumb_image_path"));
			product.setUseYn(request.getParameter("use_yn"));
			product.setBestYn(request.getParameter("best_yn"));
			product.setUpdateBy(request.getParameter("update_by"));
			product.setCreateBy((String) session.getAttribute("id"));

			ProductDAO pDao = ProductDAO.getInstance();

			pDao.insertProduct(product);

			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}
}
