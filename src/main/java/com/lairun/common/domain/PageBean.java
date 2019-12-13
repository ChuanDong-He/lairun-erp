package com.lairun.common.domain;

import com.github.pagehelper.Page;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class PageBean<T> implements Serializable {

	private Pagination pagination; //分页信息

	private List<T> list; // 分页数据

	public PageBean(List<T> list) {
		this.list = list;
		if (list instanceof Page) {
			Page<T> page = (Page<T>) list;
			pagination = new Pagination();
			pagination.setCurrent(page.getPageNum());
			pagination.setPageSize(page.getPageSize());
			pagination.setTotal(page.getTotal());
		}
	}

	@Getter
	@Setter
	@ToString
	static class Pagination {
		private Integer current;
		private Integer pageSize;
		private Long total;
	}

}
