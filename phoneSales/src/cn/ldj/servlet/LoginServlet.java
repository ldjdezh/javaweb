package cn.ldj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ldj.domain.User;
import cn.ldj.service.UserService;
import cn.ldj.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logname = request.getParameter("logname");
		String password = request.getParameter("password");
		
		if(logname == null || "".equals(logname.trim())) {
			request.setAttribute("lognameInfo", "登录名不能为空");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		if(password == null || "".equals(password.trim())) {
			request.setAttribute("passwordInfo", "密码不能为空");
			request.getRequestDispatcher("login.jsp").forward(request, response); 
			return;
		}
		
		try {
			User user = userService.getUser(logname);
			
			if(user == null) {
				request.setAttribute("lognameInfo", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			if(!password.trim().equals(user.getPassword())) {
				request.setAttribute("lognameInfo", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			request.setAttribute("mess", "登录成功");
			request.getRequestDispatcher("mess.jsp").forward(request, response); 
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mess", "登录失败");
			request.getRequestDispatcher("mess.jsp").forward(request, response); 
		}
	}

}
