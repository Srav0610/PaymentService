package com.OrderService.Service;

import java.util.List;

import com.OrderService.Entity.OrderDetails;

public interface OrderServices {

	
	OrderDetails placeOrder(OrderDetails orderdetails);
	OrderDetails fetchOrderByOrderId(Long orderId);
	OrderDetails updateStatusByOrderId(Long OrderId, String Status);
	String cancelOrderByOrderId(Long orderId);
	List<OrderDetails> getOrdersByUserId(String userId);
	 List<OrderDetails> getAllOrders();
	
}
