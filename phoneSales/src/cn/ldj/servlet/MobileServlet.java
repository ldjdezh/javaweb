package cn.ldj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ldj.domain.MobileClassify;
import cn.ldj.domain.MobileForm;
import cn.ldj.domain.PageMobile;
import cn.ldj.service.MobileService;
import cn.ldj.service.impl.MobileServiceImpl;
import cn.ldj.utils.BaseServlet;

public class MobileServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private MobileService mobileService = new MobileServiceImpl();

	/**
	 * 获得分类列表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getClassifyList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<MobileClassify> list = mobileService.getMobileClassify();

			request.setAttribute("list", list);
			request.getRequestDispatcher("lookMobile.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据分类，获得分页对象
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getListByClassify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strPage = request.getParameter("page");
		int pageNum = 1;

		String strClazz = request.getParameter("class");

		int clazz = Integer.parseInt(strClazz.trim());

		if (strPage != null) {
			pageNum = Integer.parseInt(strPage.trim());
		}

		if (clazz == 0) {
			try {
				PageMobile pm = mobileService.getMobileFormList(pageNum);
				request.setAttribute("pm", pm);
				request.setAttribute("class", strClazz);
				request.getRequestDispatcher("byPageShow.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				PageMobile pm = mobileService.getMobileFormListByClassify(clazz, pageNum);
				request.setAttribute("pm", pm);
				request.setAttribute("class", strClazz);
				request.getRequestDispatcher("byPageShow.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 根据手机版本号获得分页对象
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getListByVersion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String version = request.getParameter("version");
		String strPage = request.getParameter("page");
		int pageNum = 1;

		if (strPage != null) {
			pageNum = Integer.parseInt(strPage.trim());
		}

		try {
			PageMobile pm = mobileService.getMobileFormListByVersion(version, pageNum);
			request.setAttribute("pm", pm);
			request.setAttribute("version", version);
			request.getRequestDispatcher("byPageShow.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据手机名称获得分页对象
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getListByName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String strPage = request.getParameter("page");
		int pageNum = 1;

		if (strPage != null) {
			pageNum = Integer.parseInt(strPage.trim());
		}

		try {
			PageMobile pm = mobileService.getMobileFormListByName(name, pageNum);
			request.setAttribute("pm", pm);
			request.setAttribute("name", name);
			request.getRequestDispatcher("byPageShow.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据手机价格获得分页对象
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getListByPrice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strLow = request.getParameter("low");
		String strHigh = request.getParameter("high");

		int low = Integer.parseInt(strLow);
		int high = Integer.parseInt(strHigh);

		String strPage = request.getParameter("page");
		int pageNum = 1;

		if (strPage != null) {
			pageNum = Integer.parseInt(strPage.trim());
		}

		try {
			PageMobile pm = mobileService.getMobileFormListByPrice(low, high, pageNum);
			request.setAttribute("pm", pm);
			request.setAttribute("low", strLow);
			request.setAttribute("high", strHigh);
			request.getRequestDispatcher("byPageShow.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strClazz = request.getParameter("class");
		String version = request.getParameter("version");
		String name = request.getParameter("name");
		String strLow = request.getParameter("low");
		String strHigh = request.getParameter("high");
		String page = request.getParameter("page");

		if (strClazz != null && !"".equals(strClazz.trim())) {
			request.getRequestDispatcher("MobileServlet?method=getListByClassify&page=" + page + "&class=" + strClazz)
					.forward(request, response);
		} else if (version != null && !"".equals(version.trim())) {
			request.getRequestDispatcher("MobileServlet?method=getListByVersion&page=" + page + "&version=" + version)
					.forward(request, response);
		} else if (name != null && !"".equals(name.trim())) {
			request.getRequestDispatcher("MobileServlet?method=getListByName&page=" + page + "&name=" + name)
					.forward(request, response);
		} else {
			request.getRequestDispatcher(
					"MobileServlet?method=getListByPrice&page=" + page + "&low=" + strLow + "&high=" + strHigh)
					.forward(request, response);
		}
	}
	
	public void showDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String version = request.getParameter("version");
		
		try {
			MobileForm mf = mobileService.getMobileForm(version);
			
			request.setAttribute("mf", mf); 
			request.getRequestDispatcher("showDetail.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
