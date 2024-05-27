package com.microservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	private String productName;
	private double price;
	private int quantity;

}
