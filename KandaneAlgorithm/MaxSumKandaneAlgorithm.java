/**
 * 
 */
package week3day2;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class MaxSumKandaneAlgorithm {

	/*
		 * Input: Integer array
		 * Output: Integer
		 * Constraint: Kandane Algorithm
		 * Test Data:
		 * Positive: {1,-5,2,-3,7,1}
		 * Output: 8
		 * Edge: {3,3,5,5} 
		 * Output: 16
		 * Negative:{-1,-2,-9}
		 * Output: -1
		 * 
		 * Approach: Kandane algorithm
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(1)
		 */

	@Test
	public void test1() {
		int[] nums = {1,-5,2,-3,7,1};
		Assert.assertEquals(8, findMaxSum(nums));
	}
	
	@Test
	public void test2() {
		int[] nums = {3,3,5,5};
		Assert.assertEquals(16, findMaxSum(nums));
	}
	
	@Test
	public void test3() {
		int[] nums = {-1,-2,-9};
		Assert.assertEquals(-1, findMaxSum(nums));
	}
	
	/*
	 * Pseudo code
	 * Initialize window sum & maxSum as first element
	 * Add next element to the window sum
	 * Compare index value & windowSum & initialize maxvalue to windowSum
	 * Compare maxSum & windowSum & store maxSum
	 * Return maxSum
	 */
	
	private int findMaxSum(int[] nums) {
		int windowSum = nums[0], maxSum = nums[0];
		for(int i = 1; i < nums.length; i++) {
			windowSum += nums[i];
			windowSum = Math.max(windowSum, nums[i]);
			maxSum = Math.max(windowSum, maxSum);
		}
		return maxSum;
	}
}
