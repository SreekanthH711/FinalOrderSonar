package com.oms.orderMS.dto;

import java.time.LocalDate;

import java.util.List;

import com.oms.orderMS.entity.OrderDetails;
import com.oms.orderMS.entity.ProductOrdered;









public class OrderDetailsDTO {

	int orderId;
	int buyerId;
	double amount;
	LocalDate date;
	String address;
	String status;
	
	List<ProductOrdered> productsOrder;
	
	
	
	
	
	public List<ProductOrdered> getProductsOrder() {
		return productsOrder;
	}
	public void setProductsOrder(List<ProductOrdered> productsOrder) {
		this.productsOrder = productsOrder;
	}
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public OrderDetailsDTO(int orderId,int buyerId,double amount,LocalDate date,String address,String status)
	{
		this();
		this.orderId=orderId;
		this.buyerId=buyerId;
		this.amount=amount;
		this.date=date;
		this.address=address;
		this.status=status;
		
	}
	
	public OrderDetailsDTO() {
		super();
	}
	
	//convert DTO to ENTITY
	public OrderDetails createOrder()
	{
		OrderDetails order=new OrderDetails();
		order.setOrderId(this.getOrderId());
		order.setBuyerId(this.getBuyerId());
		order.setAmount(this.getAmount());
		order.setDate(this.getDate());
		order.setAddress(this.getAddress());
		order.setStatus(this.getStatus());
		
		return order;
	}
	
	//convert ENTITY to DTO
	public static OrderDetailsDTO valueOf(OrderDetails order) {
		OrderDetailsDTO orderDetailsDTO=new OrderDetailsDTO();
		orderDetailsDTO.setOrderId(order.getOrderId());
		orderDetailsDTO.setBuyerId(order.getBuyerId());
		orderDetailsDTO.setAmount(order.getAmount());
		orderDetailsDTO.setDate(order.getDate());
		orderDetailsDTO.setAddress(order.getAddress());
		orderDetailsDTO.setStatus(order.getStatus());
		
		return orderDetailsDTO;
	}

	@Override
	public String toString() {
		return "OrderDetailsDTO [orderId=" + orderId + ", buyerId=" + buyerId + "]";
	}

}
