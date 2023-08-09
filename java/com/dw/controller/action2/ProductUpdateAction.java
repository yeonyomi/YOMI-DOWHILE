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

public class ProductUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/product/productUpdate.jsp";

		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");

		if (id == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다');");
			out.println("</script>");
		} else {
			ProductVO pvo = new ProductVO();

			pvo.setSeq(Integer.parseInt(request.getParameter("seq")));
			pvo.setName(request.getParameter("name"));
			pvo.setKind(request.getParameter("kind"));
			pvo.setCost(Integer.parseInt(request.getParameter("cost")));
			pvo.setPrice(Integer.parseInt(request.getParameter("price")));
			pvo.setContent(request.getParameter("content"));
			pvo.setContentImagePath(request.getParameter("content_image_path"));
			pvo.setImagePath(request.getParameter("image_path"));
			pvo.setThumbImagePath(request.getParameter("thumb_image_path"));
			pvo.setUseYn(request.getParameter("use_yn"));
			pvo.setBestYn(request.getParameter("best_yn"));
			pvo.setUpdateBy((String) session.getAttribute("id"));

			ProductDAO pDao = ProductDAO.getInstance();

			pDao.updateProduct(pvo);

			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}

}
