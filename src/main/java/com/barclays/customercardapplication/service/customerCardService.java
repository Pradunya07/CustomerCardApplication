package com.barclays.customercardapplication.service;

import com.barclays.customercardapplication.exception.customerNotFoundException;
import com.barclays.customercardapplication.model.Card;
import com.barclays.customercardapplication.model.Customer;

public interface customerCardService {
	public Customer getCustomerById(int customer_id) throws customerNotFoundException;
	
	public Integer addCustomer(Customer customer) throws customerNotFoundException;
	
	public void issueCardToExistingCustomer(Integer customerId, Card card) throws customerNotFoundException;
}
