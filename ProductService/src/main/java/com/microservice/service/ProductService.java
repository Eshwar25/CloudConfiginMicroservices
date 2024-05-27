package com.microservice.service;

import com.microservice.exception.ProductServiceException;
import com.microservice.model.ProductRequest;
import com.microservice.model.ProductResponse;

public interface ProductService {

	Long addProduct(ProductRequest productRequest);

	ProductResponse findById(Long productId) throws ProductServiceException;

	void reduceQuantity(Long productId, int quantity) throws ProductServiceException;

}
