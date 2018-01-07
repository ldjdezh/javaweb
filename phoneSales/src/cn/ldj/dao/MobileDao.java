package cn.ldj.dao;

import java.util.List;

import cn.ldj.domain.MobileClassify;
import cn.ldj.domain.MobileForm;

public interface MobileDao {
	List<MobileClassify> getMobileClassify() throws Exception;

	MobileClassify getMobileClassify(int mid) throws Exception;

	MobileForm getMobileForm(String version) throws Exception;

	List<MobileForm> getMobileFormList(int begin, int end) throws Exception;

	List<MobileForm> getMobileFormListByClassify(int mid, int begin, int end) throws Exception;

	List<MobileForm> getMobileFormListByVersion(String version, int begin, int end) throws Exception;

	List<MobileForm> getMobileFormListByName(String name, int begin, int end) throws Exception;

	List<MobileForm> getMobileFormListByPrice(int low, int high, int begin, int end) throws Exception;
}
