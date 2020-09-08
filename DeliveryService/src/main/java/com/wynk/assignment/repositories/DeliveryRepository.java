package com.wynk.assignment.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wynk.assignment.entities.OrderDeliveryDetail;

@Repository
public interface DeliveryRepository extends CrudRepository<OrderDeliveryDetail, Integer> {

	OrderDeliveryDetail findByPersonId(Integer personId);

}
