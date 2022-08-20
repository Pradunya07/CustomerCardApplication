package com.barclays.customercardapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.customercardapplication.exception.customerNotFoundException;
import com.barclays.customercardapplication.model.Card;
import com.barclays.customercardapplication.model.Customer;
import com.barclays.customercardapplication.service.customerCardService;


@RestController
public class customerController {
//controller-> service(interface)->implementation->repository
	
	@Autowired
	private customerCardService customerCardService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/customers/{customerid}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(name = "customerid") int customerid) throws customerNotFoundException {
		//LOG.info("getEmpById " + eid);
		return new ResponseEntity<Customer>(customerCardService.getCustomerById(customerid), HttpStatus.OK);
	}
	@PostMapping(value = "/customers")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) throws customerNotFoundException {
		Integer customerId = customerCardService.addCustomer(customer);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + customerId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/cards")
	public void issueCardToExistingCustomer(Integer customerId, Card card) throws customerNotFoundException{
		customerCardService.issueCardToExistingCustomer(customerId,card);
		//String successMessage = environment.getProperty("API.INSERT_SUCCESS") + customerId;
		System.out.println("Customer card added Successfullly");
	}
	
}
