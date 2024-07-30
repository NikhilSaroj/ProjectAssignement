package com.rewards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rewards.entity.Customer;
import com.rewards.entity.CustomerTransaction;

public interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction,Integer>{

	List<CustomerTransaction> findByCustomer(Customer customer);
}
