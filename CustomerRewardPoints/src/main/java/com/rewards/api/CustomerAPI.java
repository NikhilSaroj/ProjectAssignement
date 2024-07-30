	package com.rewards.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.dto.CustomerDTO;
import com.rewards.dto.CustomerTransactionDTO;
import com.rewards.dto.RewardPointsDTO;
import com.rewards.exception.CustomerRewardPointException;
import com.rewards.service.CustomerService;
import com.rewards.service.RewardPointsService;

import jakarta.validation.Valid;

//Controller class
@RestController
@RequestMapping(path = "/reward")
@Validated
public class CustomerAPI {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private Environment environment;
	
	@Autowired
	private RewardPointsService rewardPointsService;

	//API end point to get the all Customers transactions 
	@GetMapping(path = "/customersTransaction")
	public ResponseEntity<List<CustomerTransactionDTO>> getAllCustomersTransactions() throws CustomerRewardPointException {
		List<CustomerTransactionDTO> customerList = customerService.getAllCustomersTransactions();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

	//API end point to get the specific Customer transactions by given transaction ID
	@GetMapping(path = "/customersTransaction/{transactId}")
	public ResponseEntity<CustomerTransactionDTO> getCustomerTransactions(@PathVariable (value="transactId") Integer transactId) throws CustomerRewardPointException {
		CustomerTransactionDTO customer = customerService.getCustomerTransactions(transactId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	//API end point to get all the customer details
	@GetMapping(value = "/customers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() throws CustomerRewardPointException {
		List<CustomerDTO> customerList = customerService.getAllCustomers();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

	//API end point to create Customer record in Customer table
	@PostMapping(value = "/customers")
	public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerDTO customer) throws CustomerRewardPointException {
		Integer customerId = customerService.addCustomer(customer);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + customerId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	//API end point to updates emailId for the given customer ID
	@PutMapping(value="/customers/{customerId}")
	public ResponseEntity<String> updateCustomer(@PathVariable(value="customerId") Integer customerId,@Valid @RequestBody CustomerDTO customer) throws CustomerRewardPointException  {
		//TODO: process PUT request
		customerService.updateCustomer(customerId, customer.getEmailId());		
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS") + customerId;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	//API end point to deletes the customer record by given customer ID
	@DeleteMapping(value="/customers/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable(value="customerId") Integer customerId) throws CustomerRewardPointException{		
		customerService.deleteCustomer(customerId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS") + customerId;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	//API end point to get the Reward points for each customer transactions
	@GetMapping(path = "/rewardPoints")
	public Map<Integer, RewardPointsDTO> getRewardPoints(){
		return rewardPointsService.getRewardPoints();
	}
}
