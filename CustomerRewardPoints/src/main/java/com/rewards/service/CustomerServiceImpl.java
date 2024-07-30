package com.rewards.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rewards.dto.CustomerDTO;
import com.rewards.dto.CustomerTransactionDTO;
import com.rewards.entity.Customer;
import com.rewards.entity.CustomerTransaction;
import com.rewards.exception.CustomerRewardPointException;
import com.rewards.repository.CustomerRepository;
import com.rewards.repository.CustomerTransactionRepository;

//Service class implementation of actual CRUD related operations
@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerTransactionRepository customertransactionrepo;

	//Get the transaction details by providing transaction Id
	@Override
	public CustomerTransactionDTO getCustomerTransactions(Integer transactId) throws CustomerRewardPointException {
		Optional<CustomerTransaction> optional = customertransactionrepo.findById(transactId);
		CustomerTransaction customer = optional.orElseThrow(() -> new CustomerRewardPointException("Service.CUSTOMER_NOT_FOUND"));
		CustomerTransactionDTO customer2 = new CustomerTransactionDTO();
		customer2.setCustomerId(customer.getCustomer().getCustomerId());
		customer2.setTransactId(customer.getTransactId());
		customer2.setSpentDetails(customer.getSpentDetails());
		customer2.setAmount(customer.getAmount());
		customer2.setTransactDate(customer.getTransactDate());
		return customer2;
	}

	//Get all the transactions of all customers spent on which category with the amount and date
	@Override
	public List<CustomerTransactionDTO> getAllCustomersTransactions() throws CustomerRewardPointException {
		Iterable<CustomerTransaction> customers = customertransactionrepo.findAll();
		List<CustomerTransactionDTO> customers2 = new ArrayList<>();
		customers.forEach(customer -> {
			CustomerTransactionDTO cust = new CustomerTransactionDTO();
			cust.setTransactId(customer.getTransactId());
			cust.setCustomerId(customer.getCustomer().getCustomerId());
			cust.setSpentDetails(customer.getSpentDetails());
			cust.setAmount(customer.getAmount());
			cust.setTransactDate(customer.getTransactDate());
			customers2.add(cust);
		});
		if (customers2.isEmpty())
			throw new CustomerRewardPointException("Service.CUSTOMERS_NOT_FOUND");
		return customers2;
	}
	
	//Get the all Customers data 
	@Override
	public List<CustomerDTO> getAllCustomers() throws CustomerRewardPointException {
		Iterable<Customer> customers = customerRepository.findAll();
		List<CustomerDTO> customers2 = new ArrayList<>();
		customers.forEach(customer -> {
			CustomerDTO cust = new CustomerDTO();
			cust.setCustomerId(customer.getCustomerId());
			cust.setDateOfBirth(customer.getDateOfBirth());
			cust.setEmailId(customer.getEmailId());
			cust.setName(customer.getName());
			customers2.add(cust);
		});
		if (customers2.isEmpty())
			throw new CustomerRewardPointException("Service.CUSTOMERS_NOT_FOUND");
		return customers2;
	}

    //To create the Customer data in Customer table
	@Override
	public Integer addCustomer(CustomerDTO customer) throws CustomerRewardPointException {
		Customer customerEntity = new Customer();
		customerEntity.setDateOfBirth(customer.getDateOfBirth());
		customerEntity.setEmailId(customer.getEmailId());
		customerEntity.setName(customer.getName());
		customerEntity.setCustomerId(customer.getCustomerId());
		Customer customerEntity2 = customerRepository.save(customerEntity);
		return customerEntity2.getCustomerId();
	}

	//To update the Customer email Id by providing customerId
	@Override
	public void updateCustomer(Integer customerId, String emailId) throws CustomerRewardPointException {
		// TODO Auto-generated method stub
		Optional<Customer> optional= customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new CustomerRewardPointException("Service.CUSTOMER_NOT_FOUND"));
		customer.setEmailId(emailId);		
	}

	//To delete the specific Customer data by providing customer ID
	@Override
	public void deleteCustomer(Integer customerId) throws CustomerRewardPointException {
		// TODO Auto-generated method stub
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new CustomerRewardPointException("Service.CUSTOMER_NOT_FOUND"));
		customerRepository.delete(customer);
	}
}
