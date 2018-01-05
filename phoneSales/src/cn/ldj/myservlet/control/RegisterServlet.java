package cn.ldj.myservlet.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
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

		String url = "jdbc:mysql://localhost:3306/mobileshop?useSSL=true";
		String user = "root";
		String pwd = "123456";

		try {
			Connection con = DriverManager.getConnection(url, user, pwd);
			String sql = "INSERT INTO user(logname,password,phone,address,realname) VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, logname);
			pstmt.setString(2, password); 
			pstmt.setString(3, phone);
			pstmt.setString(4,address);
			pstmt.setString(5, realname);
			
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("mess", "注册信息有问题");
			request.getRequestDispatcher("mess.jsp").forward(request, response); 
			return;
		}
		
		request.setAttribute("mess", "注册成功");
		request.getRequestDispatcher("mess.jsp").forward(request, response); 
	}

}
