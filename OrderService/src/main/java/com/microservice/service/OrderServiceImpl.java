package com.microservice.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.client.ProductService;
import com.microservice.entity.Order;
import com.microservice.model.OrderRequest;
import com.microservice.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductService productService;
	
	
	public Long placeOrder(OrderRequest orderRequest) {
	 
		log.info("before placing order");
		productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
		log.info("After checking product avaialbility for product : "+orderRequest.getProductId());
		Order order =	Order.builder()
			        .productId(orderRequest.getProductId())
			        .price(orderRequest.getAmount())
			        .orderDate(Instant.now())
			        .orderStatus("CREATED")
			        .quantity(orderRequest.getQuantity())
			        .build();
	
		log.info("Order placed");
		order =	orderRepository.save(order);
		log.info("Product saved successfully after placing order");
		return order.getOrderId();
	}
}
