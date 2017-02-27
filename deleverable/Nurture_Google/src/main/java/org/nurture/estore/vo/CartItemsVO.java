package org.nurture.estore.vo;

public class CartItemsVO {

	
	    private Integer cartItemId;

	 
	    private Integer cartId;

	  
	    private ProductVO productVo;

	    private Integer quantity;
	    private Double totalPrice;
	    
		public CartItemsVO() {
			// TODO Auto-generated constructor stub
		}

		public Integer getCartItemId() {
			return cartItemId;
		}

		public void setCartItemId(Integer cartItemId) {
			this.cartItemId = cartItemId;
		}

		public Integer getCartId() {
			return cartId;
		}

		public void setCartId(Integer cartId) {
			this.cartId = cartId;
		}

		public ProductVO getProductVo() {
			return productVo;
		}

		public void setProductVo(ProductVO productVo) {
			this.productVo = productVo;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public Double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(Double totalPrice) {
			this.totalPrice = totalPrice;
		}

		@Override
		public String toString() {
			return "CartItemsVO [cartItemId=" + cartItemId + ", cartId=" + cartId + ", productVo=" + productVo
					+ ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
		}
}
