package com.barclays.customercardapplication.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;
	
	private String emailid;
	private String name;
	private LocalDate date;
	
	public Customer() {
		super();
	}

	public Customer(String email_id, String name,LocalDate date) {
		super();
		this.setEmailid(email_id);
		this.setName(name);
		this.setDate(date);
	}

	public Customer(int customer_id, String email_id,String name, LocalDate date) {
		super();
		this.customerId = customer_id;
		this.setEmailid(email_id);
		this.setName(name);
		this.setDate(date);
	}

	public Customer(int customer_id, String name,LocalDate date) {
		super();
		this.customerId = customer_id;

	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", emailId=" + emailid + ", Name=" + name
				+ ", Issue Date=" + date + "]";
	}
}
