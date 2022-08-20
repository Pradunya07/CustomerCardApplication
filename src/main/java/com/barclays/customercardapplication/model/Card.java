package com.barclays.customercardapplication.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "card")
public class Card {
	
	

		@Id // primary key
//		@GeneratedValue(strategy = GenerationType.IDENTITY) // value generated automatically 1, 2, 3, ...
		@Column(name = "card_id")
		private int cardId;
		
		private String card_number;

		private LocalDate date;
		
		@OneToOne
		@JoinColumn(name = "customer_id", nullable = false)
		private Customer customer;

		public Card() {
			super();
		}

		public Card(String card_number, LocalDate date) {
			super();
			this.setCard_number(card_number);
			this.setDate(date);
		}

		public Card(int cardId, String card_number, LocalDate date) {
			super();
			this.cardId = cardId;
			this.setCard_number(card_number);
			this.setDate(date);
		}

		public Card(String card_number, LocalDate date, Customer customer) {
			super();
			this.setCard_number(card_number);
			this.setDate(date);
			this.customer = customer;
		}

		public Card(int cardId, String card_number, LocalDate date, Customer customer) {
			super();
			this.cardId=cardId;
			this.setCard_number(card_number);
			this.setDate(date);
			this.customer = customer;
			
		}

		public String getCard_number() {
			return card_number;
		}

		public void setCard_number(String card_number) {
			this.card_number = card_number;
		}

		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		
		@Override
		public String toString() {
			return "Card [CardId=" + cardId + ", CardNumber=" + card_number + ", Date=" + date
					+ ", Customer=" + customer + "]";
		}

}
