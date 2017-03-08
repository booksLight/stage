package org.nurture.estore.vo;

import java.util.List;

import org.nurture.estore.model.Product;

public class ProductJsonObject {

	int iTotalRecords;

    int iTotalDisplayRecords;

    String sEcho;

    String sColumns;

    List<Product> aaData;

	public int getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsColumns() {
		return sColumns;
	}

	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}

	public List<Product> getAaData() {
		return aaData;
	}

	public void setAaData(List<Product> aaData) {
		this.aaData = aaData;
	}
    
    
}
