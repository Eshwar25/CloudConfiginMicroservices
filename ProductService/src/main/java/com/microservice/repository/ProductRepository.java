package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
