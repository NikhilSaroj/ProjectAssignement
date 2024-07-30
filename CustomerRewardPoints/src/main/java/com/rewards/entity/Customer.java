package com.rewards.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//Customer entity class will have the Customer table in DB with following fields
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;  // primary key of Customer table
	private String emailId;
	private String name;
	private LocalDate dateOfBirth;
	
	//Customer table mapped to CustomerTransaction table by customerId as foreign key
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<CustomerTransaction> customertransaction;
	
	public Customer(){}

	public Customer(Integer customerId, String emailId, String name, LocalDate dateOfBirth,
			Set<CustomerTransaction> customertransaction) {
		super();
		this.customerId = customerId;
		this.emailId = emailId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.customertransaction = customertransaction;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Set<CustomerTransaction> getCustomertransaction() {
		return customertransaction;
	}

	public void setCustomertransaction(Set<CustomerTransaction> customertransaction) {
		this.customertransaction = customertransaction;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth="
				+ dateOfBirth + "]";
	}	
}
