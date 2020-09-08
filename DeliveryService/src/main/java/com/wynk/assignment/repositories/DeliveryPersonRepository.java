package com.wynk.assignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wynk.assignment.entities.DeliveryPerson;

@Repository
public interface DeliveryPersonRepository extends CrudRepository<DeliveryPerson, Integer> {

	List<DeliveryPerson> findByCurrentStatus(String status);

}
