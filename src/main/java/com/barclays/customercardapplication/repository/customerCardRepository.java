package com.barclays.customercardapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.barclays.customercardapplication.model.Customer;

@Repository
public interface customerCardRepository extends CrudRepository<Customer,Integer> {
	
}
