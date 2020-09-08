package com.wynk.assignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wynk.assignment.ExceptionHandler.DeliveryPersonNotFoundException;
import com.wynk.assignment.Requests.DeliveryRequests.OrderDeliveryRequest;
import com.wynk.assignment.Response.OrderDeliveryResponse;
import com.wynk.assignment.constants.DeliveryPersonConstants;
import com.wynk.assignment.entities.DeliveryPerson;
import com.wynk.assignment.entities.OrderDeliveryDetail;
import com.wynk.assignment.repositories.DeliveryPersonRepository;
import com.wynk.assignment.repositories.DeliveryRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;

	@Autowired
	DeliveryPersonRepository deliveryPersonRepository;

	public static final String ORDER_ACCEPTED = "accepted";

	@Override
	public String deliveryRequest(OrderDeliveryRequest orderDeliveryRequest) {
		DeliveryPerson deliveryPerson = null;
		try {
			deliveryPerson = deliveryPersonRepository.findById(orderDeliveryRequest.getDeliveryPersonId()).get();

		} catch (Exception e) {
			throw new DeliveryPersonNotFoundException("Delivery Person for deliveryPersonId: "
					+ orderDeliveryRequest.getDeliveryPersonId() + " not found");
		}
		OrderDeliveryDetail orderDeliveryDetail = new OrderDeliveryDetail();
		orderDeliveryDetail.setPersonId(deliveryPerson.getPersonId());
		orderDeliveryDetail.setOrderId(orderDeliveryRequest.getOrderId());
		orderDeliveryDetail.setTimeToDeliver(DeliveryPersonConstants.MAX_TIME_TO_DELIVERY_IN_MIN);
		deliveryRepository.save(orderDeliveryDetail);
		return ORDER_ACCEPTED;
	}

	@Override
	public OrderDeliveryResponse deliveryStatus(Integer deliveryPersonId) {
		DeliveryPerson deliveryPerson = null;
		OrderDeliveryDetail orderDeliveryDetail = null;
		OrderDeliveryResponse orderDeliveryResponse = null;
		deliveryPerson = deliveryPersonRepository.findById(deliveryPersonId).get();

		if (deliveryPerson == null) {
			throw new DeliveryPersonNotFoundException(
					"Delivery Person for deliveryPersonId: " + deliveryPersonId + " not found");
		}

		if (deliveryPerson.getCurrentStatus().equals(DeliveryPersonConstants.ACTIVE)) {
			orderDeliveryDetail = deliveryRepository.findByPersonId(deliveryPersonId);
			orderDeliveryResponse.setOrderId(orderDeliveryDetail.getOrderId());
			orderDeliveryResponse.setStatus(deliveryPerson.getCurrentStatus());
			orderDeliveryResponse.setTimeToReach(orderDeliveryDetail.getTimeToDeliver());
		} else {
			orderDeliveryResponse.setStatus(deliveryPerson.getCurrentStatus());
		}

		return orderDeliveryResponse;
	}

	@Override
	public List<DeliveryPerson> activeDeliveryPerson() {

		List<DeliveryPerson> deliveryPerson = deliveryPersonRepository
				.findByCurrentStatus(DeliveryPersonConstants.ACTIVE);

		return deliveryPerson;
	}

}
