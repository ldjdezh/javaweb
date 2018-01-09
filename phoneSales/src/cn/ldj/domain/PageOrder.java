package cn.ldj.domain;

import java.util.List;

public class PageOrder {
	private int currentPage; // 当前第几页
	private int pre; // 前一页
	private int next; // 后一页
	private int total; // 共多少条记录
	private int pageNum; // 共多少页
	private int pageSize; // 一页多少条记录
	private List<OrderForm> list;

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

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<OrderForm> getList() {
		return list;
	}

	public void setList(List<OrderForm> list) {
		this.list = list;
	}

}
