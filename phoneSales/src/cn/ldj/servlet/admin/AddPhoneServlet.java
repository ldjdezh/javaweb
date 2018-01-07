package cn.ldj.servlet.admin;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class AddPhoneServlet extends HttpServlet {
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
		request.setCharacterEncoding("utf-8");

		/*
		 * 上传步骤 1.创建DiskFileItemFactory 2.通过DiskFileItemFactory创建ServletFileUpload解析器
		 * 3.通过解析器解析request 4.遍历FileItem集合完成文件保存
		 */

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setHeaderEncoding("utf-8");

		try {
			List<FileItem> fileItemList = sfu.parseRequest(request);

			String version = fileItemList.get(0).getString("utf-8");
			String name = fileItemList.get(1).getString("utf-8");
			String made = fileItemList.get(2).getString("utf-8");
			String price = fileItemList.get(3).getString("utf-8");
			String mess = fileItemList.get(4).getString("utf-8");

			FileItem f = fileItemList.get(5);

			String root = this.getServletContext().getRealPath("/WEB-INF/img");
			String filename = f.getName();

			File file = new File(root, filename);
			f.write(file);

			String url = "jdbc:mysql://localhost:3306/mobileshop?useSSL=true";
			String username = "root";
			String password = "123456";

			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "INSERT INTO mobileclassify(name) VALUES(?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, made);
			pstmt.executeUpdate();
			
			String sql2 = "INSERT INTO mobileform VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1, version);
			pstmt2.setString(2, name);
			pstmt2.setString(3, made);
			pstmt2.setString(4, price);
			pstmt2.setString(5, mess);
			pstmt2.setString(6, file.getAbsolutePath());
			pstmt2.executeUpdate();
			
			request.setAttribute("mess", "添加成功");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mess", "添加失败");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		}
	}

}
