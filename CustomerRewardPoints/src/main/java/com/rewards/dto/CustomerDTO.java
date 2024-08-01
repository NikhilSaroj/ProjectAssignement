/*
 Data Transfer Object package 
 */
package com.rewards.dto;

import java.time.LocalDate;


import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

/**
 * CustomerDTO class to get and set the Customer values
 */
public class CustomerDTO {

	private Integer customerId;

	@Email(message = "{customer.emailid.invalid}")
	@NotNull(message = "{customer.emailid.absent}")
	private String emailId;

	@NotNull(message = "{customer.name.absent}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{customer.name.invalid}")
	private String name;

	@PastOrPresent(message = "customer.dob.invalid")
	private LocalDate dateOfBirth;
	
	public CustomerDTO() {

	}
	
	public CustomerDTO(Integer customerId,
			@Email(message = "{customer.emailid.invalid}") @NotNull(message = "{customer.emailid.absent}") String emailId,
			@NotNull(message = "{customer.name.absent}") @Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{customer.name.invalid}") String name,
			@PastOrPresent(message = "customer.dob.invalid") LocalDate dateOfBirth
		) {
		super();
		this.customerId = customerId;
		this.emailId = emailId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
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
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
	
}
