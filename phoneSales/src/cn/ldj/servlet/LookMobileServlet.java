package cn.ldj.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ldj.domain.MobileClassify;

public class LookMobileServlet extends HttpServlet {
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/mobileshop?useSSL=true";
		String username = "root";
		String password = "123456";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "SELECT * FROM mobileclassify";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			List<MobileClassify> list = new ArrayList<MobileClassify>();
			
			while(rs.next()) {
				MobileClassify mc = new MobileClassify();
				int mid = rs.getInt("mid");
				String name = rs.getString("name");
				mc.setMid(mid); 
				mc.setName(name); 
				list.add(mc);
			}
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("lookMobile.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
