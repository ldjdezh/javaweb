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

import cn.ldj.mybean.data.User;

public class ModifyPasswordServlet extends HttpServlet {
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
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		String againPassword = request.getParameter("againPassword");
		
		User user = (User) request.getSession().getAttribute("user");
		int uid = user.getUid();
		
		String url = "jdbc:mysql://localhost:3306/mobileshop?useSSL=true";
		String username = "root";
		String pwd = "123456";
		
		try {
			Connection con = DriverManager.getConnection(url, username, pwd);
			
			String sql = "UPDATE user SET password = ? WHERE uid = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setInt(2, uid);
			pstmt.executeUpdate();
			
			request.setAttribute("mess", "修改密码成功");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("mess", "修改密码失败");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		}
		
		
	}

}
