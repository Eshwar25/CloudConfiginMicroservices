package com.microservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

	private Long productId;
	private int quantity;
	private Double amount;
	private PaymentMode paymentMode;
	
}
