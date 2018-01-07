package cn.ldj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ldj.domain.User;
import cn.ldj.service.UserService;
import cn.ldj.service.impl.UserServiceImpl;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String logname = request.getParameter("logname");
		String password = request.getParameter("password");
		String againPassword = request.getParameter("againPassword");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String realname = request.getParameter("realname");

		if (logname == null || "".equals(logname.trim())) {
			request.setAttribute("lognameinfo", "用户名不能为空");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		if (password == null || "".equals(password.trim())) {
			request.setAttribute("passwordinfo", "密码不能为空");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		if (!password.equals(againPassword)) {
			request.setAttribute("passwordinfo", "两次密码不同");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}


		try {
			User user = new User();
			user.setLogname(logname); 
			user.setPassword(password); 
			user.setPhone(phone); 
			user.setAddress(address); 
			user.setRealname(realname);
			
			userService.register(user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mess", "注册信息有问题");
			request.getRequestDispatcher("mess.jsp").forward(request, response); 
			return;
		}
		
		request.setAttribute("mess", "注册成功");
		request.getRequestDispatcher("mess.jsp").forward(request, response); 
	}

}
