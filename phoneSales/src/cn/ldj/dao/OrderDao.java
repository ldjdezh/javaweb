package cn.ldj.dao;

import java.util.List;

import cn.ldj.domain.OrderForm;

public interface OrderDao {
	void addOrder(OrderForm orderForm) throws Exception;

	int getTotal() throws Exception;

	List<OrderForm> getOrderFormList(int begin, int end) throws Exception;
}
