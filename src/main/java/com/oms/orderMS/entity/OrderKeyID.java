package com.oms.orderMS.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderKeyID implements Serializable{
	@Column(name="ORDERID")
	private int orderId;
	@Column(name="PRODID")
	private int prodId;
	
	
	public OrderKeyID() {
		
	}
	public OrderKeyID(int orderId, int prodId) {
		super();
		this.orderId = orderId;
		this.prodId = prodId;
	}
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
	
	
}