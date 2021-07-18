package week3day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class MaxConsecutiveSum {
	
	/*
	 * Given an array of integers, return the highest sum of any consecutive elements in the array.
	 * {1,-5,2,-3,7,1}
	 * 
	 * Input: Integer array
	 * Output: Integer
	 * Constraint: Brute force
	 */

	@Test
	public void test1() {
		int[] num = {1,-5,2,-3,7,1};
		Assert.assertEquals(8, findMaxConsecutiveSum(num));
	}
	
	@Test
	public void test2() {
		int[] num = {1,2,3,4,5,-15};
		Assert.assertEquals(15, findMaxConsecutiveSum(num));
	}
	
	@Test
	public void test3() {
		int[] num = {1,2,3,4,5};
		Assert.assertEquals(15, findMaxConsecutiveSum(num));
	}
	
	/*
	 * Pseudo code
	 * 
	 * What if the input is 1,2,3,4,5,-15?
	 * It is returning 0 at this point
	 * How to return 15? Add comparison inside the second for loop
	 */
	
	private int findMaxConsecutiveSum(int[] num) {
		if(num.length <= 1)
			return num[0];
		int max = Integer.MIN_VALUE, sum = 0;
		for(int i = 0; i < num.length; i++) {
			sum = 0;
			for(int j = i; j < num.length; j++) {
				sum += num[j];
				max = Math.max(sum, max);
			}
		}
		return max;
	}
	
	/*
	 * Pseudo code - Sliding Window
	 * Initialize max as Integer.MIN
	 */

}
