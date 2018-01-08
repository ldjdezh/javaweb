package cn.ldj.servlet.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.ldj.domain.MobileClassify;
import cn.ldj.domain.MobileForm;
import cn.ldj.service.admin.AdminService;
import cn.ldj.service.admin.impl.AdminServiceImpl;

public class AddPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminService adminService = new AdminServiceImpl();

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
			String mid = fileItemList.get(2).getString("utf-8");
			String price = fileItemList.get(3).getString("utf-8");
			String mess = fileItemList.get(4).getString("utf-8");

			FileItem f = fileItemList.get(5);

			String root = this.getServletContext().getRealPath("/pic");
			String filename = f.getName();

			File file = new File(root, filename);
			f.write(file);

			MobileForm mf = new MobileForm();
			mf.setMobile_version(version);
			mf.setMobile_name(name);
			mf.setMobile_price(Double.valueOf(price));
			mf.setMobile_mess(mess);
			mf.setMobile_pic("/pic/"+filename);
			MobileClassify mc = new MobileClassify();
			mc.setMid(Integer.valueOf(mid));
			mf.setMobile_classify(mc);
			
			adminService.addPhone(mf);
			
			request.setAttribute("mess", "添加成功");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mess", "添加失败");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		}
	}

}
