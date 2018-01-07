package cn.ldj.servlet.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ldj.domain.Manager;

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

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
		
		String url = "jdbc:mysql://localhost:3306/mobileshop?useSSL=true";
		String uname = "root";
		String pwd = "123456";
		
		try {
			Connection con = DriverManager.getConnection(url, uname, pwd);
			
			String sql = "SELECT * FROM manager WHERE name = ?";
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setString(1, username);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				request.setAttribute("uInfo", "用户名或密码错误");
				request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
				return;
			}
			
			String rPassword = rs.getString("password");
			
			if(!rPassword.equals(password)) {
				request.setAttribute("uInfo", "用户名或密码错误");
				request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
				return;
			}
			
			Manager manager = new Manager();
			
			manager.setName(username); 
			manager.setPassword(rPassword);
			
			request.getSession().setAttribute("manager", manager);
			response.sendRedirect("manager.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("mess", "登录失败");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		}
		
		
	}

}
