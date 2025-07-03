package com.OrderService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OrderService.Entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

	List<OrderDetails> findByUserName(String userName);

}
