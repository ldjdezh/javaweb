package cn.ldj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ldj.domain.User;

public class GetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		User user = (User) request.getSession().getAttribute("user");
		
		if(user == null) {
			request.setAttribute("mess", "请先登录");
			response.addHeader("refresh", "3;URL=login.jsp");
			return;
		}
		
		response.sendRedirect("modifyInfo.jsp");
	}


}
