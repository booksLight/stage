package org.nurture.estore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;


@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 7133306564321319662L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

    //@NotEmpty(message = "The product name must not be null.")
    private String productName;
    private String productCategory;

    @Min(value = 0, message = "The product price must not be less than zero")
    private Double productPrice;
    private String productDescription;
    private String productCondition;
    private String productStatus;

    @Min(value = 0, message = "The product unit must not be less than zero")
    private Integer unitStock;
    private String productManufacture;

    @Transient
    private MultipartFile productImage;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;

    public Product(){}
    
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

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productPrice=" + productPrice + ", productDescription=" + productDescription
				+ ", productCondition=" + productCondition + ", productStatus=" + productStatus + ", unitStock="
				+ unitStock + ", productManufacture=" + productManufacture + ", productImage=" + productImage
				+ ", cartItemList=" + cartItemList + "]";
	}
    
}
