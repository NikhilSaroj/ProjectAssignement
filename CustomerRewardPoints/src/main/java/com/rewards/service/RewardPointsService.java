package com.rewards.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewards.dto.RewardPointsDTO;
import com.rewards.entity.CustomerTransaction;
import com.rewards.repository.CustomerTransactionRepository;

//Reward points calculation logic
@Service
public class RewardPointsService {
	
	@Autowired
	private CustomerTransactionRepository customerTransactionRepository;
	
	//To calculate the monthly reward points and total reward points for each customer
	public Map<Integer, RewardPointsDTO> getRewardPoints(){
		List<CustomerTransaction> transactions = customerTransactionRepository.findAll();
		Map<Integer, RewardPointsDTO> customerPoints = new HashMap<>();
		
		for(CustomerTransaction transaction: transactions) {
			Integer customerId = transaction.getCustomer().getCustomerId();
			LocalDate date = transaction.getTransactDate();
			Month month = date.getMonth();
			int points = calculatePoints(transaction.getAmount());
		    
			RewardPointsDTO reward = customerPoints.computeIfAbsent(customerId, k -> new RewardPointsDTO());
			reward.addMonthlyPoints(month, points);
			reward.addTotalPoints(points);
		}
		return customerPoints;
	}
	
	//Logic for calculation of reward point
	private int calculatePoints(Integer amount) {
		
		int points = 0;
		if (amount>100) {
			points = (amount - 100)*2 + 50;
		}
		else if(amount>=50 && amount <=100) {
			points = 50;
		}
		else
			points =0;
		return points;
	}

}
