package com.rewards.service;

import java.util.List;

import com.rewards.dto.CustomerDTO;
import com.rewards.dto.CustomerTransactionDTO;
import com.rewards.exception.CustomerRewardPointException;

//Customers and Customers transactions operations
public interface CustomerService {
	
	public CustomerTransactionDTO getCustomerTransactions(Integer transactId) throws CustomerRewardPointException;
	public List<CustomerTransactionDTO> getAllCustomersTransactions() throws CustomerRewardPointException;
	
	public List<CustomerDTO> getAllCustomers() throws CustomerRewardPointException;
	public Integer addCustomer(CustomerDTO customer) throws CustomerRewardPointException;
	public void updateCustomer(Integer customerId, String emailId) throws CustomerRewardPointException;
	public void deleteCustomer(Integer customerId) throws CustomerRewardPointException;
}
