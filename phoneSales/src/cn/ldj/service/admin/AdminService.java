package cn.ldj.service.admin;

import java.util.List;

import cn.ldj.domain.Manager;
import cn.ldj.domain.MobileClassify;
import cn.ldj.domain.MobileForm;
import cn.ldj.domain.PageMobile;
import cn.ldj.domain.PageOrder;

public interface AdminService {
	void addMade(String made) throws Exception;
	
	void deleteMade(int mid) throws Exception;
	
	List<MobileClassify> getAllMobileClassify() throws Exception;
	
	Manager getManager(String name) throws Exception;
		
	void addPhone(MobileForm mf) throws Exception;
	
	void updatePhone(MobileForm mf) throws Exception;
	
	void deletePhone(MobileForm mf) throws Exception;
	
	PageMobile findPhoneList(int pageNum) throws Exception;
	
	MobileForm getMobileForm(String version) throws Exception;
	
	PageOrder getList(int pageNum) throws Exception;
}
