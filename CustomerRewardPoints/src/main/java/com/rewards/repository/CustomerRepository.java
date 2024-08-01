/**
 * Repository package to define interfaces 
 */
package com.rewards.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.rewards.entity.Customer;

/**
 * CustomerRepository for CRUD operations 
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
