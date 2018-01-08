package cn.ldj.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ldj.domain.Manager;
import cn.ldj.service.admin.AdminService;
import cn.ldj.service.admin.impl.AdminServiceImpl;

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminService adminService = new AdminServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username == null || "".equals(username.trim())) {
			request.setAttribute("uInfo", "登录名不能为空");
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response); 
			return;
		}
		
		if(password == null || "".equals(password.trim())) {
			request.setAttribute("pInfo", "密码不能为空");
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response); 
			return;
		}
		
		try {
			Manager manager = adminService.getManager(username);
			
			if(manager == null) {
				throw new Exception("登录失败");
			}
			
			if(!manager.getPassword().equals(password)) {
				throw new Exception("登录失败");
			}
			
			request.getSession().setAttribute("manager", manager);
			response.sendRedirect("manager.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mess", "登录失败");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		}
		
		
	}

}
