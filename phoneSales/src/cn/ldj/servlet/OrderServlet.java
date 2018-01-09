package cn.ldj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ldj.domain.PageOrder;
import cn.ldj.domain.ShopCar;
import cn.ldj.domain.User;
import cn.ldj.service.OrderService;
import cn.ldj.service.impl.OrderServiceImpl;
import cn.ldj.utils.BaseServlet;

public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderServiceImpl();

	public void addOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		@SuppressWarnings("unchecked")
		List<ShopCar> carList = (List<ShopCar>) session.getAttribute("carList");

		try {
			orderService.addOrder(carList, user);
			carList.clear();
			request.getRequestDispatcher("OrderServlet?method=getList").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strPage = request.getParameter("page");
		int pageNum = 1;
		
		if(strPage != null) {
			pageNum = Integer.parseInt(strPage.trim());
		}
		
		try {
			PageOrder po = orderService.getList(pageNum);
			request.setAttribute("po", po);
			request.getRequestDispatcher("lookOrderForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
