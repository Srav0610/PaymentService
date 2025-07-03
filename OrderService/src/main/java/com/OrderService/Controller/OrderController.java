package com.OrderService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OrderService.Entity.OrderDetails;
import com.OrderService.Service.OrderServices;

@RestController
@RequestMapping("/api")
public class OrderController {

	
	@Autowired
    private OrderServices orderService;

    // 1. Place a new order
    @PostMapping("/place")
    public ResponseEntity<OrderDetails> placeOrder(@RequestBody OrderDetails orderDetails) {
        OrderDetails placedOrder = orderService.placeOrder(orderDetails);
        return ResponseEntity.ok(placedOrder);
    }

    // 2. Get order by ID
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDetails> getOrderById(@PathVariable Long orderId) {
        OrderDetails order = orderService.fetchOrderByOrderId(orderId);
        if (order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.notFound().build();
    }

    // 3. Get orders by user ID
    @GetMapping("/user/{userName}")
    public ResponseEntity<List<OrderDetails>> getOrdersByUserId(@PathVariable String userName) {
        List<OrderDetails> orders = orderService.getOrdersByUserId(userName);
        return ResponseEntity.ok(orders);
    }

    // 4. Cancel order by ID
    @PutMapping("/cancel/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long orderId) {
        String result = orderService.cancelOrderByOrderId(orderId);
        return ResponseEntity.ok(result);
    }

    // 5. Update status
    @PutMapping("/status/{orderId}")
    public ResponseEntity<OrderDetails> updateStatus(@PathVariable Long orderId,
                                                     @RequestParam String status) {
        OrderDetails updated = orderService.updateStatusByOrderId(orderId, status);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // 6. Track status
    @GetMapping("/track/{orderId}")
    public ResponseEntity<OrderDetails> trackOrder(@PathVariable Long orderId,
                                                   @RequestParam(required = false) String status) {
        OrderDetails tracked = orderService.updateStatusByOrderId(orderId, status);
        if (tracked != null) {
            return ResponseEntity.ok(tracked);
        }
        return ResponseEntity.notFound().build();
    }

  
    @GetMapping
    public ResponseEntity<List<OrderDetails>> getAllOrders() {
        List<OrderDetails> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }
}
