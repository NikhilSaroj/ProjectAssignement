package com.rewards.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//CustomerTransaction entity class will have the CustomerTransaction table in DB with following fields
@Entity
public class CustomerTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactId; // primary key
	private String spentDetails;
	private Integer amount;
	private LocalDate transactDate;
	
	//Customer table mapped to CustomerTransaction table by foreign key as customer ID
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_Id")
	private Customer customer;
	
	public CustomerTransaction() {}	
	
    public CustomerTransaction(Integer transactId, String spentDetails, Integer amount, LocalDate transactDate,
			Customer customer) {
		super();
		this.transactId = transactId;
		this.spentDetails = spentDetails;
		this.amount = amount;
		this.transactDate = transactDate;
		this.customer = customer;
	}

	public Integer getTransactId() {
		return transactId;
	}
	public void setTransactId(Integer transactId) {
		this.transactId = transactId;
	}
	public String getSpentDetails() {
		return spentDetails;
	}
	public void setSpentDetails(String spentDetails) {
		this.spentDetails = spentDetails;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public LocalDate getTransactDate() {
		return transactDate;
	}
	public void setTransactDate(LocalDate transactDate) {
		this.transactDate = transactDate;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}
