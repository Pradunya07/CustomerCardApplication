package com.barclays.customercardapplication.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.customercardapplication.exception.customerNotFoundException;
import com.barclays.customercardapplication.model.Card;
import com.barclays.customercardapplication.model.Customer;
import com.barclays.customercardapplication.repository.customerCardRepository;
import com.barclays.customercardapplication.repository.cardRepository;

@Service
@Transactional
public class customerCardServiceImpl implements customerCardService{

	@Autowired
	private customerCardRepository customercardRepository;
	
	@Autowired
	private cardRepository cardRepository;
	
	public Customer getCustomerById(int cust_id) throws customerNotFoundException {
		java.util.Optional<Customer> optional = customercardRepository.findById(cust_id);
		Customer customer = optional.orElseThrow(() -> new customerNotFoundException("Service.CUSTOMER_NOT_FOUND"));
		/*if (optional.isPresent())
			return optional.get();
		throw new customerNotFoundException("Service.CUSTOMER_NOT_FOUND");
		*/
		Customer customerEntity = new Customer();
		//customer2.setCustomerId(customer.getCustomerId());
		customerEntity.setName(customer.getName());
		customerEntity.setEmailid(customer.getEmailid());
		customerEntity.setDate(customer.getDate());
		return customerEntity;
	}

	@Override
	public Integer addCustomer(Customer customer) throws customerNotFoundException {
		Customer customerEntity = new Customer();
		customerEntity.setName(customer.getName());
		customerEntity.setEmailid(customer.getEmailid());
		customerEntity.setDate(customer.getDate());
		//customerEntity.setCustomerId(customer.getCustomerId());
		Customer customerEntity2 = customercardRepository.save(customerEntity);
		return customerEntity2.getCustomerId();
	}
	
	@Override
	public void issueCardToExistingCustomer(Integer customerId, Card card) throws customerNotFoundException{
		java.util.Optional<Customer> optional = customercardRepository.findById(customerId);
		optional.orElseThrow(() -> new customerNotFoundException("Service.CUSTOMER_NOT_FOUND"));
		Card cardEntity=new Card();
		cardEntity.setCard_number(card.getCard_number());
		cardEntity.setDate(card.getDate());
		cardRepository.save(cardEntity);
		
	}
	
	
	
	
	
	
}
