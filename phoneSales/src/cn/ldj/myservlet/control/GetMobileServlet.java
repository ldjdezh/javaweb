package cn.ldj.myservlet.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ldj.mybean.data.PageMobile;

public class GetMobileServlet extends HttpServlet {
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
		String clazz = request.getParameter("class");
		int clz = Integer.parseInt(clazz);

		String url = "jdbc:mysql://localhost:3306/mobileshop?useSSL=true";
		String user = "root";
		String pwd = "123456";

		try {
			Connection con = DriverManager.getConnection(url, user, pwd);
			PageMobile page = new PageMobile();
			int total = getCount(con);
			
			page.setNum(5);
			page.setTotal(total);
			page.setPre(1);
			page.setNext(2); 
			page.setCurrentPage(1);
			
			int pageNum = (int) Math.ceil(total/5);
			page.setPageNum(pageNum); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int getCount(Connection con) throws SQLException {
		String sql = "SELECT count(*) FROM mobileform";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		int count = 0;
		
		if(rs.next()) {
			count = rs.getInt(1);
		}
		
		return count;
	}
}
