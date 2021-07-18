package week2day3;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MaximumAverageSubArray {
	/*
	 * You are given an integer array nums consisting of n elements, and an integer k.
	 * Find a contiguous subarray whose length is equal to k 
	 * that has the maximum average value and return this value. 
	 * Any answer with a calculation error less than 10-5 will be accepted.
	 * Example 1:
	 * Input: nums = [1,12,-5,-6,50,3], k = 4
	 * Output: 12.75000
	 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
	 * Example 2:
	 * Input: nums = [5], k = 1
	 * Output: 5.00000
	 */
	
	/*
	 * Input Integer array & Integer for target
	 * Output: Double
	 * Constraint: Sliding Window
	 * Test Data set: [1,12,-5,-6,50,3], k = 4 -> Output: 12.75000
	 * Negative [1], k = 2 -> Invalid Input
	 * Edge: [0,0,0], k = 2 -> Output: 0
	 * [-1,-2,-3], k = 2 -> Output: -1.5
	 */

	@Test
	public void test1() {
		int[] num = {1,12,-5,-6,50,3};
		int k = 4;
		Assert.assertEquals(12.75000, findMaxAverage(num, k),2);
	}
	
	@Test
	public void test2() {
		int[] num = {1};
		int k = 2;
		Assert.assertEquals(0, findMaxAverage(num, k),2);
	}
	
	@Test
	public void test3() {
		int[] num = {0,0,0};
		int k = 2;
		Assert.assertEquals(0.000, findMaxAverage(num, k),2);
	}
	
	/*
	 * Pseudo code
	 * Initialize sum & maxSum as Double.MIN_VALUE
	 * Traverse through the array from 0 to k
	 * 		Add each value to the sum
	 * Initialize maxSum with sum
	 * Traverse through the array from 1 to length-k
	 * 		Add current value to the sum & remove first index from the sum
	 * 		Find maxSum by comparing sum & maxSum
	 * Return Average by dividing maxSum by k
	 */
	
	private double findMaxAverage(int[] num, int k) {
		if(num.length < k)
			throw new RuntimeException("Invalid Input");
		double sum = Double.MIN_VALUE, maxSum = Double.MIN_VALUE;
		for(int i = 0; i < k; i++) 
			sum += num[i];
		maxSum = sum;
		for(int i = 1; i <= num.length-k; i++) {
			sum += num[i+k-1] - num[i-1];
			maxSum = Math.max(sum, maxSum);
		}
		System.out.println(maxSum/k);
		return maxSum/k;
	}
	
	

}
