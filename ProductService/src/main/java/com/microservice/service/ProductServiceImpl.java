package com.microservice.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.entity.Product;
import com.microservice.exception.ProductServiceException;
import com.microservice.model.ProductRequest;
import com.microservice.model.ProductResponse;
import com.microservice.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Long addProduct(ProductRequest productRequest) {
		
		Product product = Product.builder()
				          .productName(productRequest.getProductName())
				          .price(productRequest.getPrice())
				          .quantity(productRequest.getQuantity())
				          .build();
	    productRepository.save(product);
		return product.getProductId();
	}

	public ProductResponse findById(Long productId) throws ProductServiceException {
	    Product product = productRepository.findById(productId)
	    		          .orElseThrow(()->new ProductServiceException("Product id not Find!!!","Product_Not_Found"));
		
		 ProductResponse productResponse = ProductResponse.builder()
		                                   .productName(product.getProductName()) 
		                                   .price(product.getPrice())
		                                   .quantity(product.getQuantity()) 
		                                   .build();
	    
		/*
		 * ProductResponse productResponse = new ProductResponse();
		 * BeanUtils.copyProperties(product, productResponse); 
		 */
	    return productResponse;
	}

	
	public void reduceQuantity(Long productId, int quantity) throws ProductServiceException {
		log.info("Reducing Quantity Initiated");
		Product product = productRepository.findById(productId)
		       .orElseThrow(()->new ProductServiceException("Product id not Find!!!","Product_Not_Found"));
	     
		 if(product instanceof Product){
			 log.info("Checking Product Quantity");
	    	  if(product.getQuantity() < quantity) {
	    		  throw new ProductServiceException("Not having Enough Quantity of Products", "NOT_ENOUGGH_QUANTITY");
	    	  }
	    	  product.setQuantity(product.getQuantity() - quantity);
	    	  productRepository.save(product);
	    	  log.info("Product saved in DB!!!");
	      }
	
	}

}
