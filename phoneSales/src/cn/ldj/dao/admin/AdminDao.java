package cn.ldj.dao.admin;

import java.util.List;

import cn.ldj.domain.Manager;
import cn.ldj.domain.MobileClassify;
import cn.ldj.domain.MobileForm;
import cn.ldj.domain.OrderForm;

public interface AdminDao {
	void addMade(String made) throws Exception;

	List<MobileClassify> getAllMobileClassify() throws Exception;

	Manager getManager(String name) throws Exception;

	void addPhone(MobileForm mf) throws Exception;

	void updatePhone(MobileForm mf) throws Exception;

	void deletePhone(MobileForm mf) throws Exception;

	List<MobileForm> findPhoneList(int begin, int end) throws Exception;

	MobileForm getMobileForm(String version) throws Exception;

	MobileClassify getMobileClassify(int mid) throws Exception;

	int getTotal() throws Exception;

	void deleteMade(int mid) throws Exception;

	int getTotalByOrder() throws Exception;

	List<OrderForm> getOrderFormList(int begin, int end) throws Exception;
}
