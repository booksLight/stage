package org.nurture.estore.vo;

import java.util.List;

public class OrderReport {
	
	private Integer draw;
	private Integer recordsTotal;
	private Integer recordsFiltered;
		  
	List<OrderMapper> data;

	public OrderReport() {
	}

	public OrderReport(Integer draw, Integer recordsTotal, Integer recordsFiltered, List<OrderMapper> data) {
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<OrderMapper> getData() {
		return data;
	}

	public void setData(List<OrderMapper> data) {
		this.data = data;
	}
	
	
}
