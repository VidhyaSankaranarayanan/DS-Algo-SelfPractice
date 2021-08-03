package week2day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TotalCaloriesSlidingWindow {

   /* 1) A dieter consumes calories[i] calories on the i-th day.
    * For every consecutive sequence of k days, they look at T, 
    * the total calories consumed during that sequence of k days:
	* If T < lower, they performed poorly on their diet and lose 1 point;
	* If T > upper, they performed well on their diet and gain 1 point;
	* Otherwise, they performed normally and there is no change in points.
	* Return the total number of points the dieter has after all calories.length days.
	* Note that: The total points could be negative.
	* Example 1:
	* Input: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3 -1,-1,0,1,1 
	* Output: 0  
	* Explanation: calories[0], calories[1] < lower and calories[3], calories[4] > upper, total points = 0.
	* Example 2:
	* Input: calories = [3,2], k = 2, lower = 0, upper = 1
	* Output: 1
	* Explanation: calories[0] + calories[1] > upper, total points = 1.
	* Example 3:
	* Input: calories = [6,5,0,0], k = 2, lower = 1, upper = 5 
	* Output: 0
	* Explanation: calories[0] + calories[1] > upper, calories[2] + calories[3] < lower, total points = 0.
	*/

   /* 1) Input -> calories, k, lower, upper
    * 2) Output -> Integer
    * 3) Constraint -> Sliding window
    * Test data:
    * positive -> calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3 
    * negative -> calories = [1,2,3,4,5], k = 6, lower = 3, upper = 3 
    * negative -> calories = [], k = 1, lower = 3, upper = 3 
    * edge-> calories = [1,1,1,1], k = 2, lower = 1, upper = 1 
    */

	@Test //positive
	public void test1() {

		int[] calories = {1,2,3,4,5};
		int k = 1, lower = 3, upper = 3;
		Assert.assertEquals(findTotalCalories(calories,k,lower,upper), 0);
	}

	@Test //negative
	public void test2() {

		int[] calories = {1,2,3,4,5};
		int k = 6, lower = 3, upper = 3;
		Assert.assertEquals(findTotalCalories(calories,k,lower,upper), 0);
	}

	@Test //edge
	public void test3() {

		int[] calories = {1,0,1,0};
		int k = 2, lower = 1, upper = 1;
		Assert.assertEquals(findTotalCalories(calories,k,lower,upper), 0);
	}

	@Test //edge
	public void test4() {

		int[] calories = {};
		int k = 1, lower = 3, upper = 3;
		Assert.assertEquals(findTotalCalories(calories,k,lower,upper), 0);
	}
	
	@Test //edge
	public void test5() {

		int[] calories = {6,5,0,0};
		int k = 2, lower = 1, upper = 5;
		Assert.assertEquals(findTotalCalories(calories,k,lower,upper), 0);
	}
	
	/*
	 * Pseudo code
	 * Initialize totalCalories & sum as zero
	 * Iterate through the array till K and find sum
	 * Compare the sum with lower & upper
	 * 		if sum is less than lower, then add -1 to the totalCalories
	 * 		if sum is greater than upper, then add 1 to the totalCalories
	 * Iterate through the array from 1 to the length-k
	 * 	Remove the first index and add Kth index value and find sum
	 * 	Compare sum with lower & upper
	 * 		if sum is less than lower, then add -1 to the totalCalories
	 * 		if sum is greater than upper, then add 1 to the totalCalories
	 * Return totalCalories
	 */

	private int findTotalCalories(int[] calories, int k, int lower, int upper) {
		if(calories.length < k || calories.length==0) throw new RuntimeException("Invalid Input");
		int totalCalories = 0, windowSum=0;
		for (int i = 0; i < k; i++) windowSum += calories[i];
		if(windowSum < lower) totalCalories += -1;
		else if(windowSum > upper) totalCalories += 1;

		for (int i = 1; i <= calories.length - k; i++) {
			windowSum += calories[i+k-1] - calories[i-1];
			if(windowSum < lower) totalCalories += -1;
			else if(windowSum > upper) totalCalories += 1;
		} 
		System.out.println(totalCalories);
		return totalCalories;
	}

}


