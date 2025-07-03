package com.OrderService.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrderService.DTO.ProductDTO;
import com.OrderService.Entity.OrderDetails;
import com.OrderService.Entity.OrderItem;
import com.OrderService.OpenFeign.ProductClient;
import com.OrderService.Repository.OrderDetailsRepository;



@Service("OrderServices")
public class OrderServiceImpl implements OrderServices {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private ProductClient productClient;
	
	@Override
	public OrderDetails placeOrder(OrderDetails orderdetails) {
		// TODO Auto-generated method stub
		 double totalAmount = 0.0;

		    for (OrderItem item : orderdetails.getItems()) {
		        // Fetch product details from Product Service
		        ProductDTO product = productClient.getProductByBarcode(item.getBarcode());
		        if (product.getQuantity() <item.getQuantity()) {
		            throw new RuntimeException("Not enough stock for product: " + item.getBarcode());
		        }
				if(!product.getSize().equals(item.getSize())) {
					throw new RuntimeException("Size is not available: " + item.getBarcode());
				}
		        // Calculate subtotal for each item
		        double itemTotal = product.getPrice() * item.getQuantity();
		        totalAmount += itemTotal;
		       
		      
					 item.setOrderDetails(orderdetails); 
		    }
		 

		    orderdetails.setTotalAmount(totalAmount);
		    orderdetails.setOrderStatus("PENDING");
           orderdetails.setOrderDate(LocalDateTime.now());
		    // Save order (items must be saved with Cascade in OrderDetails mapping)
		    return orderDetailsRepository.save(orderdetails);
	}

	@Override
	public OrderDetails fetchOrderByOrderId(Long orderId) {
		// TODO Auto-generated method stub
		return orderDetailsRepository.findById(orderId).orElseThrow();
	}

	@Override
	public OrderDetails updateStatusByOrderId(Long OrderId, String Status) {
		// TODO Auto-generated method stub
		OrderDetails od= new OrderDetails();
		od.setOrderStatus(Status);
		return orderDetailsRepository.save(od);
	}


	@Override
	public String cancelOrderByOrderId(Long orderId) {
		// TODO Auto-generated method stub
		
				orderDetailsRepository.findById(orderId).orElseThrow();
				return "order has been cancelled";
	}

	@Override
	public List<OrderDetails> getOrdersByUserId(String userName) {
		// TODO Auto-generated method stub
		return orderDetailsRepository.findByUserName(userName);
	}

	@Override
	public List<OrderDetails> getAllOrders() {
		// TODO Auto-generated method stub
		return orderDetailsRepository.findAll();
	}

}
