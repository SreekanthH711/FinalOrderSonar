package com.oms.orderMS.dto;

import com.oms.orderMS.entity.OrderKeyID;
import com.oms.orderMS.entity.ProductOrdered;

public class ProductsOrderedDTO {
	
	int orderId;
	int prodId;
	int sellerId;
	int quantity;
	String status;
	double price;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public ProductsOrderedDTO(int orderId,int prodId,int sellerId,int quantity,String status,double price)
	{
		this();
		this.orderId=orderId;
		this.prodId=prodId;
		this.sellerId=sellerId;
		this.quantity=quantity;
		this.price=price;
		this.status=status;
		
	}
	public ProductsOrderedDTO() {
		super();
	}
	
	
	//convert DTO to ENTITY
	public ProductOrdered createProductOrdered()
	{
		
		ProductOrdered orderedProduct=new ProductOrdered();
		
		orderedProduct.setSellerId(this.getSellerId());
		orderedProduct.setQuantity(this.getQuantity());
		orderedProduct.setPrice(this.getPrice());
		orderedProduct.setStatus(this.getStatus());
		orderedProduct.setId(this.getOrderId(), this.getProdId());
		 		
		return orderedProduct;
	}
	
	//convert ENTITY to DTO
	public static ProductsOrderedDTO valueOf(ProductOrdered order) {
		ProductsOrderedDTO productsOrderedDTO=new ProductsOrderedDTO();
		OrderKeyID orderKey=new OrderKeyID(order.getId().getOrderId(),order.getId().getProdId());
		productsOrderedDTO.setOrderId(orderKey.getOrderId());
		productsOrderedDTO.setProdId(orderKey.getProdId());
		productsOrderedDTO.setSellerId(order.getSellerId());
		productsOrderedDTO.setQuantity(order.getQuantity());
		productsOrderedDTO.setPrice(order.getPrice());
		productsOrderedDTO.setStatus(order.getStatus());
		return productsOrderedDTO;
	}
	
	@Override
	public String toString() {
		return "ProductsOrderedDTO [orderId=" + orderId + ", prodId=" + prodId + ",sellerId=" + sellerId +"]";
	}

}

