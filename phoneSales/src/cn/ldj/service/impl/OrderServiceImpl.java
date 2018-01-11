package cn.ldj.service.impl;

import java.util.List;

import cn.ldj.dao.OrderDao;
import cn.ldj.dao.impl.OrderDaoImpl;
import cn.ldj.domain.OrderForm;
import cn.ldj.domain.PageOrder;
import cn.ldj.domain.ShopCar;
import cn.ldj.domain.User;
import cn.ldj.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = new OrderDaoImpl();

	@Override
	public void addOrder(List<ShopCar> carList, User user) throws Exception {

		for (ShopCar shopCar : carList) {
			OrderForm of = new OrderForm();

			of.setMobileForm(shopCar.getMf());
			of.setUser(user);
			of.setNum(1);
			of.setSum(shopCar.getPrice());
			of.setMess("正在交易");
			of.setStatus(1);

			orderDao.addOrder(of);
		}
	}

	@Override
	public PageOrder getList(int pageNum) throws Exception {
		PageOrder po = new PageOrder();

		po.setCurrentPage(pageNum); // 设置当前第几页
		po.setPageSize(5); // 设置每页在大小
		int total = orderDao.getTotal();
		po.setTotal(total); // 设置共有多少条记录
		int num = total % 5 == 0 ? (total / 5) : (total / 5 + 1);
		po.setPageNum(num); // 设置共有多少页
		int pre = pageNum - 1; // 设置前一页的页码

		if (pre <= 0) {
			pre = 1;
		}

		int next = pageNum + 1; // 设置后一页的页码

		if (next > num) {
			next = num;
		}
		po.setPre(pre);
		po.setNext(next);

		int begin = (pageNum - 1) * 5;

		List<OrderForm> list = orderDao.getOrderFormList(begin, 5);
		po.setList(list);

		return po;
	}

}
