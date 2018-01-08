package cn.ldj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ldj.domain.MobileClassify;
import cn.ldj.service.MobileService;
import cn.ldj.service.impl.MobileServiceImpl;

public class LookMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MobileService mobileService = new MobileServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<MobileClassify> list = mobileService.getMobileClassify();

			request.setAttribute("list", list);
			request.getRequestDispatcher("lookMobile.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
