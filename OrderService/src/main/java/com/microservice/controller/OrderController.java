package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.model.OrderRequest;
import com.microservice.service.OrderServiceImpl;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderServiceImpl orderService;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest )
	{
		Long orderId = orderService.placeOrder(orderRequest);
		return new ResponseEntity<Long>(orderId,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	

}
