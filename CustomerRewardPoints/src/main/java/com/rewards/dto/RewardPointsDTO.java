package com.rewards.dto;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class RewardPointsDTO {
	
	private Map<Month, Integer> monthlyPoints = new HashMap<>();
	private Integer totalPoints =0;
		
	public Map<Month, Integer> getMonthlyPoints(){
		return monthlyPoints;
	}
	
	public int getTotalPoints() {
		return totalPoints;
	}
	
	public void addMonthlyPoints(Month month, int points) {
		monthlyPoints.merge(month, points, Integer::sum);
	}
	
	public void addTotalPoints(int points) {
		this.totalPoints += points;
	}
	
}
