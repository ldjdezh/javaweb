package cn.ldj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ldj.domain.User;
import cn.ldj.service.UserService;
import cn.ldj.service.impl.UserServiceImpl;

public class ModifyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String realname = request.getParameter("realname");

		User user = (User) request.getSession().getAttribute("user");
		user.setPhone(phone);
		user.setAddress(address);
		user.setRealname(realname);

		try {
			userService.updateUser(user);
			request.getSession().setAttribute("user", user);
			request.setAttribute("mess", "修改成功");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mess", "修改失败");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		}
	}

}
