package com.oms.orderMS.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.orderMS.entity.OrderDetails;






public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {

	Optional<OrderDetails> findBybuyerId(int orderId);
}

