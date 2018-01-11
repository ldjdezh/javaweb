package cn.ldj.dao;

import java.util.List;

import cn.ldj.domain.OrderForm;

public interface OrderDao {
	void addOrder(OrderForm orderForm) throws Exception;

	int getTotal(int uid) throws Exception;

	List<OrderForm> getOrderFormListByUid(int uid,int begin, int end) throws Exception;
}
