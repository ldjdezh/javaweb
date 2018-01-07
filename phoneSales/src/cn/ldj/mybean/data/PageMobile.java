package cn.ldj.mybean.data;

import java.util.List;

public class PageMobile {
	private int currentPage; // 当前第几页
	private int pre; // 前一页
	private int next; // 后一页
	private int total; // 共多少条记录
	private int pageNum; // 共多少页
	private int num; // 一页多少条记录
	private List<MobileForm> list;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPre() {
		return pre;
	}

	public void setPre(int pre) {
		this.pre = pre;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<MobileForm> getList() {
		return list;
	}

	public void setList(List<MobileForm> list) {
		this.list = list;
	}

}
