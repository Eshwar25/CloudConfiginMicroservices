package com.microservice.service;

import com.microservice.model.OrderRequest;

public interface OrderService {
	
	public Long placeOrder(OrderRequest orderRequest);

}
