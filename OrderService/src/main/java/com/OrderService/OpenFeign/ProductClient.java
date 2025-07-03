package com.OrderService.OpenFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.OrderService.DTO.ProductDTO;

@FeignClient(name="ProductService", url = "http://localhost:8082")
public interface ProductClient {

	  @GetMapping("/api/products/{barcode}")
	    ProductDTO getProductByBarcode(@PathVariable String barcode);
}
