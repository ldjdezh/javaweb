package cn.ldj.myservlet.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String logname = request.getParameter("logname");
		String password = request.getParameter("password");
		String again_password = request.getParameter("again_password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String realname = request.getParameter("realname");

		if(logname == null || "".equals(logname.trim())) {
			request.setAttribute("lognameinfo", "用户名不能为空");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		if(password == null || "".equals(password.trim())) {
			request.setAttribute("passwordinfo", "密码不能为空");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		
	}

}
