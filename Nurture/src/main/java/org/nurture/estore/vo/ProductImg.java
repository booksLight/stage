package org.nurture.estore.vo;

import org.springframework.web.multipart.MultipartFile;

public class ProductImg {

	private Integer productId;
	private MultipartFile productImage;
	
	public ProductImg() {
		// TODO Auto-generated constructor stub
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "ProductImg [productId=" + productId + ", productImage=" + productImage + "]";
	}
    
}
