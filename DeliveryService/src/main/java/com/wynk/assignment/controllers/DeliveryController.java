package com.wynk.assignment.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wynk.assignment.Requests.DeliveryRequests.OrderDeliveryRequest;
import com.wynk.assignment.Response.OrderDeliveryResponse;
import com.wynk.assignment.entities.DeliveryPerson;
import com.wynk.assignment.services.DeliveryService;

@RestController
@RequestMapping(value = "/delivery")

public class DeliveryController {
	private static final Logger logger = LoggerFactory.getLogger(DeliveryController.class);
	@Autowired
	private DeliveryService deliveryService;

	@RequestMapping(value = "/deliveryRequest", method = RequestMethod.POST)
	public ResponseEntity<String> deliveryRequest(@RequestBody OrderDeliveryRequest orderDeliveryRequest) {
		String status = deliveryService.deliveryRequest(orderDeliveryRequest);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/status/{deliveryPersonId}", method = RequestMethod.POST)
	public ResponseEntity<OrderDeliveryResponse> deliveryPersonStatus(@PathVariable Integer deliveryPersonId) {
		OrderDeliveryResponse orderDeliveryResponse = deliveryService.deliveryStatus(deliveryPersonId);
		return new ResponseEntity<OrderDeliveryResponse>(orderDeliveryResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/activeDeliverPerson", method = RequestMethod.GET)
	public ResponseEntity<List<DeliveryPerson>> activeDeliverPerson() {
		List<DeliveryPerson> activeDeliveryPerson = deliveryService.activeDeliveryPerson();
		return new ResponseEntity<List<DeliveryPerson>>(activeDeliveryPerson, HttpStatus.OK);
	}
}
