package com.OrderService.Entity;

import java.util.Objects;

import com.OrderService.Enum.ProductSize;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id; // Unique ID for the item

	    private String barcode;     // Product ID
	    private Integer quantity; 
	    @Enumerated(EnumType.STRING)
        private ProductSize size;
	    // Many items belong to one order
	    @ManyToOne
	    @JoinColumn(name = "order_id")
	    private OrderDetails order;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getBarcode() {
			return barcode;
		}

		public void setBarcode(String barcode) {
			this.barcode = barcode;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public OrderDetails getOrderDetails() {
			return order;
		}

		public void setOrderDetails(OrderDetails orderDetails) {
			this.order = orderDetails;
		}

		public ProductSize getSize() {
			return size;
		}

		public void setSize(ProductSize size) {
			this.size = size;
		}

		public OrderDetails getOrder() {
			return order;
		}

		public void setOrder(OrderDetails order) {
			this.order = order;
		}

		@Override
		public String toString() {
			return "OrderItem [id=" + id + ", barcode=" + barcode + ", quantity=" + quantity + ", size=" + size
					+ ", order=" + order + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(barcode, id, order, quantity, size);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			OrderItem other = (OrderItem) obj;
			return Objects.equals(barcode, other.barcode) && Objects.equals(id, other.id)
					&& Objects.equals(order, other.order) && Objects.equals(quantity, other.quantity)
					&& size == other.size;
		}
	    
		
	    
    
    
}
