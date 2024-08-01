/*
 Data Transfer Object package 
 */
package com.rewards.dto;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

/*
 RewardPointsDTO class to get customers monthly and total points 
*/
public class RewardPointsDTO {
	
	private Map<Month, Integer> monthlyPoints = new HashMap<>();
	private Integer totalPoints =0;

	/*
	 @return the monthlyPoints
	*/
	public Map<Month, Integer> getMonthlyPoints(){
		return monthlyPoints;
	}
	/*
	 @return the totalPoints
	*/	
	public int getTotalPoints() {
		return totalPoints;
	}
	/*
	 calculate monthly points
	*/	
	public void addMonthlyPoints(Month month, int points) {
		monthlyPoints.merge(month, points, Integer::sum);
	}
	/*
	 sum the monthly points
	*/	
	public void addTotalPoints(int points) {
		this.totalPoints += points;
	}
	
}
