package com.rewards.dto;

import java.time.LocalDate;

import com.rewards.entity.Customer;

public class CustomerTransactionDTO {

	private Integer transactId;
	private Integer customerId;
	private String spentDetails;
	private Integer amount;
	private LocalDate transactDate;
	private Customer customer;
	
	public CustomerTransactionDTO() {}

	public CustomerTransactionDTO(Integer transactId, Integer customerId, String spentDetails, Integer amount,
			LocalDate transactDate,Customer customer) {
		super();
		this.transactId = transactId;
		this.customerId = customerId;
		this.spentDetails = spentDetails;
		this.amount = amount;
		this.transactDate = transactDate;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	@Override
	public String toString() {
		return "CustomerTransactionDTO [transactId=" + transactId + ", customerId=" + ", spentDetails="
				+ spentDetails + ", amount=" + amount + ", transactDate=" + transactDate + "]";
	}

}
