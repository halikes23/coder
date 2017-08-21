package com.fq.dao.entity.vo;

import java.util.List;

/**
 * 图表数据
 * @author Administrator
 *
 */
public class ChartInfoVO {
	
	private String name ;
	private List<Integer> data ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getData() {
		return data;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	}
}
