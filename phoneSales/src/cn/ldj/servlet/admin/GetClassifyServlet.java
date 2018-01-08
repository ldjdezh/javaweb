package cn.ldj.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ldj.domain.MobileClassify;
import cn.ldj.service.admin.AdminService;
import cn.ldj.service.admin.impl.AdminServiceImpl;

public class GetClassifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminService adminService = new AdminServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String str = request.getParameter("method");
			List<MobileClassify> list = adminService.getAllMobileClassify();
			request.setAttribute("list", list);

			if (str.equals("addPhone")) {
				request.getRequestDispatcher("addPhone.jsp").forward(request, response);
			}

			if (str.equals("addMade")) {
				request.getRequestDispatcher("addMade.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
