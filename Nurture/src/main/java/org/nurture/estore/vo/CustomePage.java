package org.nurture.estore.vo;

import java.util.List;

import org.nurture.estore.Constants;

public class CustomePage {

	private Integer pageLength ;   		
	private boolean hasPrevious; 	
	private boolean hasNext;  		
	private Integer current;
	
	public CustomePage() {
		
	}

	public CustomePage(Integer pageLength, boolean hasPrevious, boolean hasNext, Integer current) {
		this.pageLength = pageLength;
		this.hasPrevious = hasPrevious;
		this.hasNext = hasNext;
		this.current = current;
	}
	
	public Integer getPageLength() {
		return pageLength;
	}
	public void setPageLength(Integer pageLength) {
		this.pageLength = pageLength;
	}
	public boolean isHasPrevious() {
		return hasPrevious;
	}
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	public boolean isHasNext() {
		return hasNext;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	public Integer getCurrent() {
		return current;
	}
	public void setCurrent(Integer current) {
		this.current = current;
	}
	
	@Override
	public String toString() {
		return "CustomePage [pageLength=" + pageLength + ", hasPrevious=" + hasPrevious + ", hasNext=" + hasNext
				+ ", current=" + current + "]";
	} 		

}
