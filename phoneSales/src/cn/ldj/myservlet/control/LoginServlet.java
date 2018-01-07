package cn.ldj.myservlet.control;

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
import javax.servlet.http.HttpSession;

import cn.ldj.mybean.data.User;

public class LoginServlet extends HttpServlet {
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
		
		String url = "jdbc:mysql://localhost:3306/mobileshop?useSSL=true";
		String username = "root";
		String pwd = "123456";
		
		try {
			Connection con = DriverManager.getConnection(url, username, pwd);
			String sql = "SELECT * FROM user WHERE logname = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, logname);
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				request.setAttribute("lognameInfo", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response); 
				return;
			}
			
			String rPassword = rs.getString("password");
			
			if(rPassword == null || !rPassword.equals(password.trim())) {
				request.setAttribute("lognameInfo", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response); 
				return;
			}
			
			String rPhone = rs.getString("phone");
			String rAddress = rs.getString("address");
			String rRealname = rs.getString("realname");
			int uid = rs.getInt("uid");
			
			User user = new User();
			
			user.setUid(uid);
			user.setLogname(logname); 
			user.setPassword(rPassword);
			user.setPhone(rPhone);
			user.setAddress(rAddress);
			user.setRealname(rRealname);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			request.setAttribute("mess", "登录成功");
			request.getRequestDispatcher("mess.jsp").forward(request, response); 
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("mess", "登录失败");
			request.getRequestDispatcher("mess.jsp").forward(request, response); 
		}
	}

}
