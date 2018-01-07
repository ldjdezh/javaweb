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


public class ModifyInfoServlet extends HttpServlet {
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
		request.setCharacterEncoding("utf-8");
		
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String realname = request.getParameter("realname");
		
		User user = (User) request.getSession().getAttribute("user");
	
		int uid = user.getUid();
		
		String url = "jdbc:mysql://localhost:3306/mobileshop?useSSL=true";
		String username = "root";
		String password = "123456";
		
		Connection con;
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE user SET phone=?,address=?,realname=? WHERE uid=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, phone);
			pstmt.setString(2, address);
			pstmt.setString(3, realname);
			pstmt.setInt(4, uid);
			
			pstmt.executeUpdate();
			
			request.setAttribute("mess", "修改成功");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
			pstmt.close();
			con.close();
			user.setPhone(phone); 
			user.setAddress(address); 
			user.setRealname(realname);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("mess", "修改失败");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		}
	}

}
