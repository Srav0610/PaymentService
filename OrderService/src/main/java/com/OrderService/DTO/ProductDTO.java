package com.OrderService.DTO;

import java.util.Objects;

import com.OrderService.Enum.ProductSize;

public class ProductDTO {

	private String barcode;
    private String productName;
    private Double price;
    private ProductSize size;
    private  Integer quantity;
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public ProductSize getSize() {
		return size;
	}
	public void setSize(ProductSize size) {
		this.size = size;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public int hashCode() {
		return Objects.hash(barcode, price, productName, quantity, size);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		return Objects.equals(barcode, other.barcode) && Objects.equals(price, other.price)
				&& Objects.equals(productName, other.productName) && Objects.equals(quantity, other.quantity)
				&& size == other.size;
	}
	@Override
	public String toString() {
		return "ProductDTO [barcode=" + barcode + ", productName=" + productName + ", price=" + price + ", size=" + size
				+ ", quantity=" + quantity + "]";
	}
    
}
