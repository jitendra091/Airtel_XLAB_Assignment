package com.wynk.assignment.Response;

public class OrderDeliveryResponse {

	String status;
	Integer orderId;
	String timeToReach;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getTimeToReach() {
		return timeToReach;
	}

	public void setTimeToReach(String timeToReach) {
		this.timeToReach = timeToReach;

	}
}
