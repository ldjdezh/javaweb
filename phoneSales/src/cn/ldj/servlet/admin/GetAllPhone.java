package cn.ldj.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ldj.domain.PageMobile;
import cn.ldj.service.admin.AdminService;
import cn.ldj.service.admin.impl.AdminServiceImpl;

public class GetAllPhone extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminService adminService = new AdminServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		int pageNum = 1;
		
		if(page != null) {
			pageNum = Integer.parseInt(page);
		}
		
		try {
			PageMobile pm = adminService.findPhoneList(pageNum);
			
			request.setAttribute("pm", pm);
			request.getRequestDispatcher("lookPhone.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
