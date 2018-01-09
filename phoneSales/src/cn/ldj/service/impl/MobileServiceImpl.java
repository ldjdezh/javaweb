package cn.ldj.service.impl;

import java.util.List;

import cn.ldj.dao.MobileDao;
import cn.ldj.dao.impl.MobileDaoImpl;
import cn.ldj.domain.MobileClassify;
import cn.ldj.domain.MobileForm;
import cn.ldj.domain.PageMobile;
import cn.ldj.service.MobileService;

public class MobileServiceImpl implements MobileService {
	private MobileDao mobileDao = new MobileDaoImpl();

	@Override
	public List<MobileClassify> getMobileClassify() throws Exception {
		return mobileDao.getMobileClassify();
	}

	@Override
	public MobileForm getMobileForm(String version) throws Exception {
		return mobileDao.getMobileForm(version);
	}

	@Override
	public PageMobile getMobileFormList(int pageNum) throws Exception {
		PageMobile pm = new PageMobile();
		pm.setCurrentPage(pageNum); // 设置当前第几页
		pm.setPageSize(5); // 设置每页在大小
		int total = mobileDao.getTotal();
		pm.setTotal(total); // 设置共有多少条记录
		int num = total % 5 == 0 ? (total / 5) : (total / 5 + 1);
		pm.setPageNum(num); // 设置共有多少页
		int pre = pageNum - 1; // 设置前一页的页码

		if (pre <= 0) {
			pre = 1;
		}

		int next = pageNum + 1; // 设置后一页的页码

		if (next > num) {
			next = num;
		}
		pm.setPre(pre);
		pm.setNext(next);

		int begin = (pageNum - 1) * 5;

		List<MobileForm> list = mobileDao.getMobileFormList(begin, 5);
		pm.setList(list);

		return pm;
	}

	@Override
	public PageMobile getMobileFormListByClassify(int mid, int pageNum) throws Exception {
		PageMobile pm = new PageMobile();
		pm.setCurrentPage(pageNum); // 设置当前第几页
		pm.setPageSize(5); // 设置每页在大小
		int total = mobileDao.getTotal();
		pm.setTotal(total); // 设置共有多少条记录
		int num = total % 5 == 0 ? (total / 5) : (total / 5 + 1);
		pm.setPageNum(num); // 设置共有多少页
		int pre = pageNum - 1; // 设置前一页的页码

		if (pre <= 0) {
			pre = 1;
		}

		int next = pageNum + 1; // 设置后一页的页码

		if (next > num) {
			next = num;
		}
		pm.setPre(pre);
		pm.setNext(next);

		int begin = (pageNum - 1) * 5;

		List<MobileForm> list = mobileDao.getMobileFormListByClassify(mid, begin, 5);
		pm.setList(list);

		return pm;
	}

	@Override
	public PageMobile getMobileFormListByVersion(String version, int pageNum) throws Exception {
		PageMobile pm = new PageMobile();
		pm.setCurrentPage(pageNum); // 设置当前第几页
		pm.setPageSize(5); // 设置每页在大小
		int total = mobileDao.getTotal();
		pm.setTotal(total); // 设置共有多少条记录
		int num = total % 5 == 0 ? (total / 5) : (total / 5 + 1);
		pm.setPageNum(num); // 设置共有多少页
		int pre = pageNum - 1; // 设置前一页的页码

		if (pre <= 0) {
			pre = 1;
		}

		int next = pageNum + 1; // 设置后一页的页码

		if (next > num) {
			next = num;
		}
		pm.setPre(pre);
		pm.setNext(next);

		int begin = (pageNum - 1) * 5;

		List<MobileForm> list = mobileDao.getMobileFormListByVersion(version, begin, 5);
		pm.setList(list);

		return pm;
	}

	@Override
	public PageMobile getMobileFormListByName(String name, int pageNum) throws Exception {
		PageMobile pm = new PageMobile();
		pm.setCurrentPage(pageNum); // 设置当前第几页
		pm.setPageSize(5); // 设置每页在大小
		int total = mobileDao.getTotal();
		pm.setTotal(total); // 设置共有多少条记录
		int num = total % 5 == 0 ? (total / 5) : (total / 5 + 1);
		pm.setPageNum(num); // 设置共有多少页
		int pre = pageNum - 1; // 设置前一页的页码

		if (pre <= 0) {
			pre = 1;
		}

		int next = pageNum + 1; // 设置后一页的页码

		if (next > num) {
			next = num;
		}
		pm.setPre(pre);
		pm.setNext(next);

		int begin = (pageNum - 1) * 5;

		List<MobileForm> list = mobileDao.getMobileFormListByName(name, begin, 5);
		pm.setList(list);

		return pm;
	}

	@Override
	public PageMobile getMobileFormListByPrice(int low, int high, int pageNum) throws Exception {
		PageMobile pm = new PageMobile();
		pm.setCurrentPage(pageNum); // 设置当前第几页
		pm.setPageSize(5); // 设置每页在大小
		int total = mobileDao.getTotal();
		pm.setTotal(total); // 设置共有多少条记录
		int num = total % 5 == 0 ? (total / 5) : (total / 5 + 1);
		pm.setPageNum(num); // 设置共有多少页
		int pre = pageNum - 1; // 设置前一页的页码

		if (pre <= 0) {
			pre = 1;
		}

		int next = pageNum + 1; // 设置后一页的页码

		if (next > num) {
			next = num;
		}
		pm.setPre(pre);
		pm.setNext(next);

		int begin = (pageNum - 1) * 5;

		List<MobileForm> list = mobileDao.getMobileFormListByPrice(low, high, begin, 5);
		pm.setList(list);

		return pm;
	}

}
