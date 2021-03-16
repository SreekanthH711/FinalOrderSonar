package com.oms.orderMS.service;

import java.util.ArrayList;
import java.util.List;
/*import java.util.ArrayList;
import java.util.List;*/
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.orderMS.dto.OrderDetailsDTO;
import com.oms.orderMS.dto.ProductsOrderedDTO;
import com.oms.orderMS.entity.OrderDetails;
import com.oms.orderMS.entity.OrderKeyID;
import com.oms.orderMS.entity.ProductOrdered;
import com.oms.orderMS.repository.OrderRepository;
import com.oms.orderMS.repository.ProductsOrderedRepository;










@Service
public class OrderService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	ProductsOrderedRepository productsOrderedRepo;

	
	
	  //creating a order
	  public void saveOrder(OrderDetailsDTO orderDTO) 
	  {
	  logger.info("Creation Request for Order"); 
	  OrderDetails order =orderDTO.createOrder(); 
	  orderRepo.save(order); 
	  }
	  //creating a product order
	  public void saveProduct(ProductsOrderedDTO productDTO) 
	  {
	  logger.info("Creation request for Product");
	  ProductOrdered product =productDTO.createProductOrdered();
	  productsOrderedRepo.save(product);
	  }
	
	  //get specific order from orderdetails
	  public OrderDetailsDTO getSpecificOrder(int buyerId)
	  {
		logger.info("Order details for specific order no");
		OrderDetailsDTO orderDetailsDTO = null;
		Optional<OrderDetails> optOrder = orderRepo.findBybuyerId(buyerId);
		if (optOrder.isPresent()) 
		{
			OrderDetails order = optOrder.get();
			orderDetailsDTO = OrderDetailsDTO.valueOf(order);
		}
		return orderDetailsDTO;
	  }
	  
	  //get all orders from productordered
	  public List<ProductsOrderedDTO> getAllOrdered() 
	  {
		  List<ProductOrdered> orders = productsOrderedRepo.findAll();
		  List<ProductsOrderedDTO> orderDTOs = new ArrayList<>();
		  for (ProductOrdered order : orders)
		  {
			ProductsOrderedDTO orderDTO = ProductsOrderedDTO.valueOf(order);
			orderDTOs.add(orderDTO);
		  }
		  return orderDTOs;
	  }
	
	  //specific order from productsordered
	  public ProductsOrderedDTO getSpecificOrdered(int orderId,int prodId)
	  {
		  logger.info("products ordered details of specific order and product");
		  OrderKeyID orderKeyID=new OrderKeyID(orderId,prodId);
		  ProductsOrderedDTO productsOrderedDTO = null; 
		  Optional<ProductOrdered> optOrder =productsOrderedRepo.findById(orderKeyID); 
		  if (!optOrder.isEmpty()) 
		  {
			  ProductOrdered order = optOrder.get(); 
			  productsOrderedDTO =ProductsOrderedDTO.valueOf(order); 
		  }
		  return productsOrderedDTO;
	  }
	  
	  //list of orders with specific orderid
	  public List<ProductsOrderedDTO> getForOrder(int orderId)
	  {
		  List<ProductOrdered> orders=productsOrderedRepo.findByIdOrderId(orderId);
		  List<ProductsOrderedDTO> orderDTOs=new ArrayList<>();
		  for(ProductOrdered order:orders)
		  {
			  ProductsOrderedDTO orderDTO=ProductsOrderedDTO.valueOf(order);
			  orderDTOs.add(orderDTO);
		  }
		  return orderDTOs;
	  }
	  
}
