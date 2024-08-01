/*
 Data Transfer Object package 
 */
package com.rewards.dto;

import java.time.LocalDate;
import com.rewards.entity.Customer;

/**
 * CustomerTransactionDTO class to get and set the Customer Transaction values
 */
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

	

	/**
	 * @return the transactId
	 */
	public Integer getTransactId() {
		return transactId;
	}

	/**
	 * @param transactId the transactId to set
	 */
	public void setTransactId(Integer transactId) {
		this.transactId = transactId;
	}

	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the spentDetails
	 */
	public String getSpentDetails() {
		return spentDetails;
	}

	/**
	 * @param spentDetails the spentDetails to set
	 */
	public void setSpentDetails(String spentDetails) {
		this.spentDetails = spentDetails;
	}

	/**
	 * @return the amount
	 */
	public Integer getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * @return the transactDate
	 */
	public LocalDate getTransactDate() {
		return transactDate;
	}

	/**
	 * @param transactDate the transactDate to set
	 */
	public void setTransactDate(LocalDate transactDate) {
		this.transactDate = transactDate;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerTransactionDTO [transactId=" + transactId + ", customerId=" + ", spentDetails="
				+ spentDetails + ", amount=" + amount + ", transactDate=" + transactDate + "]";
	}

}
