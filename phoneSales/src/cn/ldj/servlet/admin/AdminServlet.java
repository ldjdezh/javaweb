package cn.ldj.servlet.admin;

import cn.ldj.domain.Manager;
import cn.ldj.domain.MobileClassify;
import cn.ldj.domain.MobileForm;
import cn.ldj.domain.PageMobile;
import cn.ldj.service.admin.AdminService;
import cn.ldj.service.admin.impl.AdminServiceImpl;
import cn.ldj.utils.BaseServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private AdminService adminService = new AdminServiceImpl();

	public void addMade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String clazz = request.getParameter("class");
		
		try {
			adminService.addMade(clazz);
			request.setAttribute("mess", "添加成功");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username == null || "".equals(username.trim())) {
			request.setAttribute("uInfo", "登录名不能为空");
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response); 
			return;
		}
		
		if(password == null || "".equals(password.trim())) {
			request.setAttribute("pInfo", "密码不能为空");
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response); 
			return;
		}
		
		try {
			Manager manager = adminService.getManager(username);
			
			if(manager == null) {
				throw new Exception("登录失败");
			}
			
			if(!manager.getPassword().equals(password)) {
				throw new Exception("登录失败");
			}
			
			request.getSession().setAttribute("manager", manager);
			response.sendRedirect("manager.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mess", "登录失败");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		}
		
		
	}
	
	public void deleteMade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clazz = request.getParameter("class");
		int mid = Integer.parseInt(clazz);

		try {
			adminService.deleteMade(mid);
			request.setAttribute("mess", "删除成功");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
	public void getClassify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String str = request.getParameter("type");
			List<MobileClassify> list = adminService.getAllMobileClassify();
			request.setAttribute("list", list);

			if (str.equals("addPhone")) {
				request.getRequestDispatcher("addPhone.jsp").forward(request, response);
			}

			if (str.equals("addMade")) {
				request.getRequestDispatcher("addMade.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getPhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String version = (String) request.getParameter("version");
		String type = (String) request.getParameter("type");
		
		try {
			MobileForm mf = adminService.getMobileForm(version);
			
			request.setAttribute("mf", mf);
			
			if("u".equals(type.trim())) {
				request.setAttribute("cList", adminService.getAllMobileClassify());
				request.getRequestDispatcher("modifyPhone.jsp").forward(request, response);
			}else if("d".equals(type.trim())) {
				request.getRequestDispatcher("deletePhone.jsp").forward(request, response);
			}else if("c".equals(type.trim())) {
				request.getRequestDispatcher("showDetail.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
