package com.atguigu.jf.console.common.bean.bo;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

public class PageModel<T> {
	private int pageSize;
	private int pageNo;
	private int totalCount;
	private List<T> list;

	public PageModel() {
	}

	public PageModel(int pageSize, int pageNo, int totalCount, List<T> list) {
		super();
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.totalCount = totalCount;
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
