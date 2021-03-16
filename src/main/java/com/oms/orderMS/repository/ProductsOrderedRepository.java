package com.oms.orderMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.orderMS.entity.OrderKeyID;
import com.oms.orderMS.entity.ProductOrdered;





public interface ProductsOrderedRepository extends JpaRepository<ProductOrdered, OrderKeyID> {

	List<ProductOrdered> findByIdOrderId(int orderId);
	
	List<ProductOrdered> findByIdProdId(int prodId);
}
