package com.oms.orderMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oms.orderMS.dto.ProductsOrderedDTO;
import com.oms.orderMS.service.OrderService;





@RestController
@RequestMapping("/ordered")
@CrossOrigin
public class ProductController {
	
	@Autowired
	OrderService orderService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	  
	 

		//for all orders in product ordered
		@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<ProductsOrderedDTO> getAllOrdered()
		{
			logger.info("Fetching all ordered products");
			return orderService.getAllOrdered();
		}
		
		//create productordered
		@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void saveFriend(@RequestBody ProductsOrderedDTO orderDTO) 
		{
			logger.info("Product order creation", orderDTO); 
			orderService.saveProduct(orderDTO);
		}
		
		//reorderProduct
		@PostMapping(value = "/{orderId}/{prodId}",consumes = MediaType.APPLICATION_JSON_VALUE)
		public String saveFriend(@PathVariable int orderId,@PathVariable int prodId)
		{
			logger.info("Product Reordering"); 
			ProductsOrderedDTO orderDTO=orderService.getSpecificOrdered(orderId,prodId);
			orderService.saveProduct(orderDTO);
			return "Reordered Succesfully";
		}
		 
		//fetch details for specific orderid and prodid
		 @GetMapping(value = "/{orderId}/{prodId}", produces =MediaType.APPLICATION_JSON_VALUE) 
		 public ProductsOrderedDTO getSpecificOrdered(@PathVariable int orderId,@PathVariable int prodId)
		 {
		  logger.info("Fetching for secific ordered"); 
		  return orderService.getSpecificOrdered(orderId,prodId); 
		  }
		 
		  //fetch details for specific orderId
		  @GetMapping(value = "/{orderId}", produces =MediaType.APPLICATION_JSON_VALUE) 
		  public List<ProductsOrderedDTO> getForOrder(@PathVariable int orderId)
		  {
		  logger.info("Fetching all ordered of orderid"); 
		  return orderService.getForOrder(orderId);
		  }
		  
		

}
