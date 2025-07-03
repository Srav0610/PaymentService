package com.OrderService.Entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class OrderDetails {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long orderId;
	    private String userName;
	    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<OrderItem> items;
	    private Double totalAmount;
	    private String orderStatus;
	    private LocalDateTime orderDate;
		public Long getOrderId() {
			return orderId;
		}
		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public List<OrderItem> getItems() {
			return items;
		}
		public void setItems(List<OrderItem> items) {
			this.items = items;
		}
		public Double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(Double totalAmount) {
			this.totalAmount = totalAmount;
		}
		public String getOrderStatus() {
			return orderStatus;
		}
		public void setOrderStatus(String orderStatus) {
			this.orderStatus = orderStatus;
		}
		public LocalDateTime getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(LocalDateTime orderDate) {
			this.orderDate = orderDate;
		}
		@Override
		public String toString() {
			return "OrderDetails [orderId=" + orderId + ", userName=" + userName + ", items=" + items + ", totalAmount="
					+ totalAmount + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(items, orderDate, orderId, orderStatus, totalAmount, userName);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			OrderDetails other = (OrderDetails) obj;
			return Objects.equals(items, other.items) && Objects.equals(orderDate, other.orderDate)
					&& Objects.equals(orderId, other.orderId) && Objects.equals(orderStatus, other.orderStatus)
					&& Objects.equals(totalAmount, other.totalAmount) && Objects.equals(userName, other.userName);
		}
	    
	    
}
