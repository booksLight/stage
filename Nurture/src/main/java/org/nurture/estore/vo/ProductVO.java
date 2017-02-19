package org.nurture.estore.vo;

import javax.validation.constraints.Min;

public class ProductVO {
	 	private Integer productId;

	    private String productName;
	    private String productCategory;

	    private Double productPrice;
	    private String productDescription;
	    private String productCondition;
	    private String productStatus;

	    private Integer unitStock;
	    private String productManufacture;
		
	    public ProductVO() {
			// TODO Auto-generated constructor stub
		}

		public Integer getProductId() {
			return productId;
		}

		public void setProductId(Integer productId) {
			this.productId = productId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getProductCategory() {
			return productCategory;
		}

		public void setProductCategory(String productCategory) {
			this.productCategory = productCategory;
		}

		public Double getProductPrice() {
			return productPrice;
		}

		public void setProductPrice(Double productPrice) {
			this.productPrice = productPrice;
		}

		public String getProductDescription() {
			return productDescription;
		}

		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}

		public String getProductCondition() {
			return productCondition;
		}

		public void setProductCondition(String productCondition) {
			this.productCondition = productCondition;
		}

		public String getProductStatus() {
			return productStatus;
		}

		public void setProductStatus(String productStatus) {
			this.productStatus = productStatus;
		}

		public Integer getUnitStock() {
			return unitStock;
		}

		public void setUnitStock(Integer unitStock) {
			this.unitStock = unitStock;
		}

		public String getProductManufacture() {
			return productManufacture;
		}

		public void setProductManufacture(String productManufacture) {
			this.productManufacture = productManufacture;
		}

		@Override
		public String toString() {
			return "ProductVO [productId=" + productId + ", productName=" + productName + ", productCategory="
					+ productCategory + ", productPrice=" + productPrice + ", productDescription=" + productDescription
					+ ", productCondition=" + productCondition + ", productStatus=" + productStatus + ", unitStock="
					+ unitStock + ", productManufacture=" + productManufacture + "]";
		}

	    
}
