package com.OrderService.OpenFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.OrderService.DTO.UserDetails;



@FeignClient(name="EcommerceNikee01Registrationlogin", url="http://localhost:8081")
public interface RegistrationClient {

	 @GetMapping("/api/get/{userName}")
	    UserDetails getUserById(@PathVariable Long userName);
	
	
}
