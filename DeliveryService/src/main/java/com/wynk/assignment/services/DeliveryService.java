package com.wynk.assignment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wynk.assignment.Requests.DeliveryRequests.OrderDeliveryRequest;
import com.wynk.assignment.Response.OrderDeliveryResponse;
import com.wynk.assignment.entities.DeliveryPerson;

@Service
public interface DeliveryService {

	String deliveryRequest(OrderDeliveryRequest orderDelegateRequest);

	OrderDeliveryResponse deliveryStatus(Integer deliveryPersonId);

	List<DeliveryPerson> activeDeliveryPerson();

}
