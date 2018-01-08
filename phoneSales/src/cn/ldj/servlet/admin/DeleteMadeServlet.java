package cn.ldj.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ldj.service.admin.AdminService;
import cn.ldj.service.admin.impl.AdminServiceImpl;

public class DeleteMadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminService adminService = new AdminServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String clazz = request.getParameter("class");
		int mid = Integer.parseInt(clazz);

		try {
			adminService.deleteMade(mid);
			request.setAttribute("mess", "删除成功");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
