package cn.ldj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ldj.domain.User;
import cn.ldj.service.UserService;
import cn.ldj.service.impl.UserServiceImpl;

public class ModifyPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		String againPassword = request.getParameter("againPassword");
		
		if(password == null || "".equals(password.trim())) {
			request.setAttribute("tip1", "原密码不能为空");
			request.getRequestDispatcher("modifyPassword.jsp").forward(request, response);
			return;
		}
		
		if(newPassword == null || "".equals(newPassword.trim())) {
			request.setAttribute("tip2", "新密码不能为空");
			request.getRequestDispatcher("modifyPassword.jsp").forward(request, response);
			return;
		}
		
		if(againPassword == null || "".equals(againPassword.trim())) {
			request.setAttribute("tip3", "密码不能为空");
			request.getRequestDispatcher("modifyPassword.jsp").forward(request, response);
			return;
		}
		
		if(!newPassword.trim().equals(againPassword.trim())) {
			request.setAttribute("tip2", "两次密码不同");
			request.getRequestDispatcher("modifyPassword.jsp").forward(request, response);
			return;
		}
		
		User user = (User) request.getSession().getAttribute("user");
		if(!user.getPassword().equals(password)) {
			request.setAttribute("tip1", "原密码不正确");
			request.getRequestDispatcher("modifyPassword.jsp").forward(request, response);
			return;
		}
		
		user.setPassword(newPassword);
		
		try {
			userService.updateUser(user); 
			
			request.getSession().setAttribute("user", user);
			request.setAttribute("mess", "修改密码成功");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mess", "修改密码失败");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		}
		
		
	}

}
