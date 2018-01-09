package cn.ldj.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ldj.domain.ShopCar;
import cn.ldj.domain.User;
import cn.ldj.service.UserService;
import cn.ldj.service.impl.UserServiceImpl;
import cn.ldj.utils.BaseServlet;

public class UserServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();

	/**
	 * 获得用户信息，
	 * 
	 * 下一步修改
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {
			request.setAttribute("mess", "请先登录");
			response.addHeader("refresh", "3;URL=login.jsp");
			return;
		}

		response.sendRedirect("modifyInfo.jsp");
	}

	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modifyPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		String againPassword = request.getParameter("againPassword");

		if (password == null || "".equals(password.trim())) {
			request.setAttribute("tip1", "原密码不能为空");
			request.getRequestDispatcher("modifyPassword.jsp").forward(request, response);
			return;
		}

		if (newPassword == null || "".equals(newPassword.trim())) {
			request.setAttribute("tip2", "新密码不能为空");
			request.getRequestDispatcher("modifyPassword.jsp").forward(request, response);
			return;
		}

		if (againPassword == null || "".equals(againPassword.trim())) {
			request.setAttribute("tip3", "密码不能为空");
			request.getRequestDispatcher("modifyPassword.jsp").forward(request, response);
			return;
		}

		if (!newPassword.trim().equals(againPassword.trim())) {
			request.setAttribute("tip2", "两次密码不同");
			request.getRequestDispatcher("modifyPassword.jsp").forward(request, response);
			return;
		}

		User user = (User) request.getSession().getAttribute("user");
		if (!user.getPassword().equals(password)) {
			request.setAttribute("tip1", "原密码不正确");
			request.getRequestDispatcher("modifyPassword.jsp").forward(request, response);
			return;
		}

		user.setPassword(newPassword);

		try {
			userService.updateUser(user);

			request.getSession().setAttribute("user", user);
			request.setAttribute("mess", "修改密码成功");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mess", "修改密码失败");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		}
	}

	/**
	 * 修改用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modifyInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String realname = request.getParameter("realname");

		User user = (User) request.getSession().getAttribute("user");
		user.setPhone(phone);
		user.setAddress(address);
		user.setRealname(realname);

		try {
			userService.updateUser(user);
			request.getSession().setAttribute("user", user);
			request.setAttribute("mess", "修改成功");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mess", "修改失败");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		}
	}

	/**
	 * 退出
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	/**
	 * 注册
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String logname = request.getParameter("logname");
		String password = request.getParameter("password");
		String againPassword = request.getParameter("againPassword");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String realname = request.getParameter("realname");

		if (logname == null || "".equals(logname.trim())) {
			request.setAttribute("lognameinfo", "用户名不能为空");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		if (password == null || "".equals(password.trim())) {
			request.setAttribute("passwordinfo", "密码不能为空");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		if (!password.equals(againPassword)) {
			request.setAttribute("passwordinfo", "两次密码不同");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		try {
			User user = new User();
			user.setLogname(logname);
			user.setPassword(password);
			user.setPhone(phone);
			user.setAddress(address);
			user.setRealname(realname);

			userService.register(user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mess", "注册信息有问题");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
			return;
		}

		request.setAttribute("mess", "注册成功");
		request.getRequestDispatcher("mess.jsp").forward(request, response);
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logname = request.getParameter("logname");
		String password = request.getParameter("password");

		if (logname == null || "".equals(logname.trim())) {
			request.setAttribute("lognameInfo", "登录名不能为空");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		if (password == null || "".equals(password.trim())) {
			request.setAttribute("passwordInfo", "密码不能为空");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		try {
			User user = userService.getUser(logname);

			if (user == null) {
				request.setAttribute("lognameInfo", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}

			if (!password.trim().equals(user.getPassword())) {
				request.setAttribute("lognameInfo", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}

			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			List<ShopCar> carList = new ArrayList<ShopCar>();
			
			session.setAttribute("carList", carList);
			
			request.setAttribute("mess", "登录成功");
			request.getRequestDispatcher("mess.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mess", "登录失败");
			request.getRequestDispatcher("mess.jsp").forward(request, response);
		}
	}
}
