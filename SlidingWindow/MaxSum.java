package week2day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class MaxSum {
	
	/*
	 * Find the highest sum of K consecutive elements
	 * 
	 * Input: Integer array, Integer
	 * Output: Integer
	 * Constraint: Sliding Window
	 * Test Data
	 * Positive: {1,5,2,3,7,1}, k = 3
	 * Output: 12
	 * Negative: {1,2,3,4}, k = 5
	 * Output: 0
	 * Edge: {5,5,5,5,5,5}, k = 2
	 * Output: 10
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */

	@Test
	public void test1() {
		int[] nums = {1,5,2,3,7,1};
		int k = 3;
		Assert.assertEquals(12, findMaxSum(nums,k));
	}
	
	@Test
	public void test2() {
		int[] nums = {1,2,3,4};
		int k = 5;
		Assert.assertEquals(0, findMaxSum(nums,k));
	}
	
	@Test
	public void test3() {
		int[] nums = {5,5,5,5,5,5};
		int k = 2;
		Assert.assertEquals(10, findMaxSum(nums,k));
	}
	
	/*
	 * Pseudo code
	 * Check if the length of the array is less than k, return 0
	 * Initialize sum as 0, maxSum as 0
	 * Traverse through the array until k and find sum
	 * Initialize maxSum as sum
	 * Traverse through the array from k till length
	 * 		Add current element and remove first element
	 * 		Compare and find maxSum
	 * Return maxSum
	 */
	
	private int findMaxSum(int[] nums, int k) {
		if(nums.length < k)
			return 0;
		int sum = 0, maxSum = 0;
		for(int i = 0; i < k; i++)
			sum += nums[i];
		maxSum = sum;
		for(int i = k; i < nums.length; i++) {
			sum += nums[i] - nums[i-k];
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}
}
