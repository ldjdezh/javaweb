package cn.ldj.service;

import java.util.List;

import cn.ldj.domain.MobileClassify;
import cn.ldj.domain.MobileForm;
import cn.ldj.domain.PageMobile;

public interface MobileService {
	List<MobileClassify> getMobileClassify() throws Exception;

	MobileForm getMobileForm(String version) throws Exception;

	PageMobile getMobileFormList(int begin, int end) throws Exception;

	PageMobile getMobileFormListByClassify(int mid, int begin, int end) throws Exception;

	PageMobile getMobileFormListByVersion(String version, int begin, int end) throws Exception;

	PageMobile getMobileFormListByName(int mid, int begin, int end) throws Exception;

	PageMobile getMobileFormListByPrice(int low, int high, int begin, int end) throws Exception;
}
