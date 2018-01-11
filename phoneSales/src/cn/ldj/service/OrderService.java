package cn.ldj.service;

import java.util.List;

import cn.ldj.domain.PageOrder;
import cn.ldj.domain.ShopCar;
import cn.ldj.domain.User;

public interface OrderService {

	void addOrder(List<ShopCar> carList, User user) throws Exception;

	PageOrder getList(int pageNum,int uid) throws Exception;
}
