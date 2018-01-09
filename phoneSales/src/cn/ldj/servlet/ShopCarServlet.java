package cn.ldj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ldj.domain.MobileForm;
import cn.ldj.domain.ShopCar;
import cn.ldj.service.MobileService;
import cn.ldj.service.impl.MobileServiceImpl;
import cn.ldj.utils.BaseServlet;

public class ShopCarServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private MobileService mobileService = new MobileServiceImpl();

	public void addShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String version = request.getParameter("version");

		@SuppressWarnings("unchecked")
		List<ShopCar> carList = (List<ShopCar>) request.getSession().getAttribute("carList");

		ShopCar shopCar = new ShopCar();

		try {
			MobileForm mf = mobileService.getMobileForm(version);
			shopCar.setMf(mf);
			shopCar.setNum(1);
			shopCar.setPrice(mf.getMobile_price());

			carList.add(shopCar);
			
			request.getRequestDispatcher("lookShoppingCar.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
