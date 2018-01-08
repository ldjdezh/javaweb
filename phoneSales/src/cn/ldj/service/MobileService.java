package cn.ldj.service;

import java.util.List;

import cn.ldj.domain.MobileClassify;
import cn.ldj.domain.MobileForm;
import cn.ldj.domain.PageMobile;

public interface MobileService {
	List<MobileClassify> getMobileClassify() throws Exception;

	MobileForm getMobileForm(String version) throws Exception;

	PageMobile getMobileFormList(int pageNum) throws Exception;

	PageMobile getMobileFormListByClassify(int mid, int pageNum) throws Exception;

	PageMobile getMobileFormListByVersion(String version, int pageNum) throws Exception;

	PageMobile getMobileFormListByName(String name, int pageNum) throws Exception;

	PageMobile getMobileFormListByPrice(int low, int high, int pageNum) throws Exception;
}
