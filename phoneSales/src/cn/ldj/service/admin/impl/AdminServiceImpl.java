package cn.ldj.service.admin.impl;

import java.util.List;

import cn.ldj.dao.admin.AdminDao;
import cn.ldj.dao.admin.Impl.AdminDaoImpl;
import cn.ldj.domain.Manager;
import cn.ldj.domain.MobileClassify;
import cn.ldj.domain.MobileForm;
import cn.ldj.domain.PageMobile;
import cn.ldj.service.admin.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao = new AdminDaoImpl();

	@Override
	public void addMade(String made) throws Exception {
		adminDao.addMade(made);
	}

	@Override
	public List<MobileClassify> getAllMobileClassify() throws Exception {
		return adminDao.getAllMobileClassify();
	}

	@Override
	public Manager getManager(String name) throws Exception {
		return adminDao.getManager(name);
	}

	@Override
	public void addPhone(MobileForm mf) throws Exception {
		MobileClassify mc = adminDao.getMobileClassify(mf.getMobile_classify().getMid());
		mf.setMobile_classify(mc);
		mf.setMobile_made(mc.getName());
		adminDao.addPhone(mf);
	}

	@Override
	public void updatePhone(MobileForm mf) throws Exception {
		adminDao.updatePhone(mf);
	}

	@Override
	public void deletePhone(MobileForm mf) throws Exception {
		adminDao.deletePhone(mf);
	}

	@Override
	public PageMobile findPhoneList(int pageNum) throws Exception {
		PageMobile pm = new PageMobile();
		pm.setCurrentPage(pageNum); // 设置当前第几页
		pm.setPageSize(5); // 设置每页在大小
		int total = adminDao.getTotal();
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

		List<MobileForm> list = adminDao.findPhoneList(begin, 5);
		pm.setList(list);

		return pm;
	}

	@Override
	public MobileForm getMobileForm(String version) throws Exception {
		return adminDao.getMobileForm(version);
	}

	@Override
	public void deleteMade(int mid) throws Exception {
		adminDao.deleteMade(mid);
	}

}
