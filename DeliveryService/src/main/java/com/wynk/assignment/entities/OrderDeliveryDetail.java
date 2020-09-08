package com.wynk.assignment.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDeliveryDetail")
public class OrderDeliveryDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderDeliveryId;
	private Integer orderId;
	private Integer personId;
	private String timeToDeliver;
	public Integer getOrderDeliveryId() {
		return orderDeliveryId;
	}
	public void setOrderDeliveryId(Integer orderDeliveryId) {
		this.orderDeliveryId = orderDeliveryId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getTimeToDeliver() {
		return timeToDeliver;
	}
	public void setTimeToDeliver(String timeToDeliver) {
		this.timeToDeliver = timeToDeliver;
	}
	
}
