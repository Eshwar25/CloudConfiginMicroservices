package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
