package week2day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class GrumpyOwner_SlidingWindow {
	
	/*
	 * Today, the bookstore owner has a store open for customers.length minutes.  
	 * Every minute, some number of customers (customers[i]) enter the store, 
	 * and all those customers leave after the end of that minute.
	 * On some minutes, the bookstore owner is grumpy.  
	 * If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
	 * The bookstore owner knows a secret technique to keep themselves 
	 * not grumpy for X minutes straight, but can only use it once.
	 * Return the maximum number of customers that can be satisfied throughout the day.
	 * Example 1:
	 * Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
	 * Output: 16
	 * Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
	 * The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
	 */
	
	/*
	 * Input: 2 integer array & integer
	 * Output: integer
	 * Constraint: Sliding Window
	 * Test data: c[1,0,1,2,1,1,7,5], g[0,1,0,1,0,1,0,1] & X = 3 -> Output: 16
	 * c[1,1,1,1,1,1], g[1,1,1,1,1,1] & X = 1 -> Output: 1
	 * c[1,0,0,0,1], g[0,1,0,1,0] & X = 2 -> Output: 2
	 */

	@Test
	public void test1() {
		int[] customers = {1,0,1,2,1,1,7,5};
		int[] grumpy = {0,1,0,1,0,1,0,1};
		int x = 3;
		Assert.assertEquals(16, findHappyCustomers(customers, grumpy, x));
	}
	
	@Test
	public void test2() {
		int[] customers = {1,1,1,1,1,1};
		int[] grumpy = {1,1,1,1,1,1};
		int x = 1;
		Assert.assertEquals(1, findHappyCustomers(customers, grumpy, x));
	}
	
	@Test
	public void test3() {
		int[] customers = {1,0,0,0,1};
		int[] grumpy = {0,1,0,1,0};
		int x = 2;
		Assert.assertEquals(2, findHappyCustomers(customers, grumpy, x));
	}
	
	/*
	 * Pseudo code
	 * Initialize maxCustomers & currentCustomers as 0
	 * Traverse through the grumpy array,
	 * 		if the value at current index is 0, add the value in the customer array to currentCustomers
	 * Initialize maxCustomers with currentCustomers
	 * Traverse through the array until x
	 * 		if the value at current index of grumpy array is 1, add customer value to currentCustomers
	 * Compare with maxCustomers & store the max 
	 * Iterate through the array from 1 to length-k
	 * 		Remove the first index if the value is 1 from the currentCustmomers
	 * 		and add next index value if value is 1 to the currentCustomers
	 * 		Compare with maxCustomers and store max
	 * Return maxCustomers	
	 * 
	 */
	
	private int findHappyCustomers(int[] customers, int[] grumpy, int x) {
		int maxCustomers = 0, currentCustomers = 0;
		for(int i = 0; i < grumpy.length; i++) {
			if(grumpy[i] == 0)
				currentCustomers += customers[i];
		}
		maxCustomers = currentCustomers;
		for(int i = 0; i < x; i++) {
			if(grumpy[i] == 1)
				currentCustomers += customers[i];
		}
		maxCustomers = Math.max(maxCustomers, currentCustomers);
		for(int i = 1; i <= grumpy.length-x; i++) {
			if(grumpy[i+x-1] == 1)
				currentCustomers += customers[i+x-1];
			if(grumpy[i-1] == 1)
				currentCustomers -= customers[i-1];
			maxCustomers = Math.max(maxCustomers, currentCustomers);
		}
		return maxCustomers;
	}
	
	

}
