package cn.ldj.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/mobile?useSSL=true";
		String username = "root";
		String password = "123456";

		Connection con = DriverManager.getConnection(url, username, password);// 实例化
		
		return con;
	}
}
