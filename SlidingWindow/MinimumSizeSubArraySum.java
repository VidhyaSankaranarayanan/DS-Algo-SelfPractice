package week3day1;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class MinimumSizeSubArraySum {

	/*
	 * Given an array of positive integers nums and a positive integer target, 
	 * return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] 
	 * of which the sum is greater than or equal to target. If there is no such subarray, 
	 * return 0 instead.
	 * 
	 * Example 1:
	 * Input: target = 7, nums = [2,3,1,2,4,3]
	 * Output: 2
	 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
	 */
	
	/*
	 * Input: Integer array & integer target
	 * Output: integer
	 * Constraint: Brute force [2 pointer/sliding window]
	 */
	
	@Test
	public void test1() {
		int[] nums = {4,3,1,2,2,3};
		int target = 7;
		Assert.assertEquals(2, findMinimumLengthUsingSlidingWindow(nums, target));
	}
	
	@Test
	public void test2() {
		int[] nums = {};
		int target = 7;
		Assert.assertEquals(0, findMinimumLengthUsingSlidingWindow(nums, target));
	}
	
	@Test
	public void test3() {
		int[] nums = {1,1,1,1,1,1,1};
		int target = 7;
		Assert.assertEquals(7, findMinimumLengthUsingSlidingWindow(nums, target));
	}
	
	@Test
	public void test4() {
		int[] nums = {1,2,3,4,5,1,2};
		int target = 20;
		Assert.assertEquals(0, findMinimumLengthUsingSlidingWindow(nums, target));
	}
	
	@Test
	public void test5() {
		int[] nums = {0,0,0,2};
		int target = 2;
		Assert.assertEquals(1, findMinimumLengthUsingSlidingWindow(nums, target));
	}
	
	/*
	 * Pseudo code
	 * Check if length of the array is empty
	 * 		return 0
	 * Check if the length of the array is 1 
	 * 		If array element is greater than or equal to target 
	 * 			return value
	 * 		Else return 0
	 * Initialize sum as 0 & min as MaxValue
	 * Traverse through the array 
	 * 	Initialize sum as 0
	 * 	Traverse through the array from i to length
	 * 		Find sum by adding each element
	 * 		If sum is greater than or equal to target
	 * 			Find min by comparing min & right-left+1
	 * Return min if it is not equal to MaxValue else 0
	 */
	
	// Time Complexity: O(n^2)
	// Space Complexity: O(1)
	
	private int findMinimumLength(int[] nums, int target) {
		if(nums.length == 0)
			return 0;
		if(nums.length == 1) {
			if(nums[0] >= target)
				return nums[0];
			else
				return 0;
		}
		
		int sum = 0, min = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++) {
			sum = 0;
			for(int j = i; j < nums.length; j++) {
				sum += nums[j];
				if(sum >= target)
				min = Math.min(min, j-i+1);
			}
		}
		return (min!=Integer.MAX_VALUE)?min:0;	
	}
	
	/*
	 * Pseudo code - Sliding Window
	 * If array length is 0
	 * 		return 0
	 * If array length is 1 & value>=target
	 * 		return 1
	 * Else
	 * 		return 0
	 * Initialize left as 0, right as 0, sum as first element, min as Integer.MAXVALUE
	 * If sum greater to equal to target, 
	 * 		return 1
	 * Traverse through the array from 1 to length
	 * 		Add current value to the sum
	 * 		Traverse until the sum is greater than or equal to target
	 * 			Calculate min by comparing min & difference btw right & left + 1
	 * 			Subtract previous value and add next value, increment left
	 * If min not equal to Integer.MAXVALUE
	 * 		return min
	 * Else
	 * 		return 0 
	 */
	//2,3,1,2,4,3 = 15, target - 7
	//1,1,1,1 - 4
	
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	
	private int findMinimumLengthUsingSlidingWindow(int[] nums, int target) {
		if(nums.length == 0)
			return 0;
		if(nums.length == 1 && nums[0] >= target)
			return 1;
		int left = 0, right = 0, sum = nums[0], min = Integer.MAX_VALUE;
		if(sum >= target)
			return 1;
		for(right = 1; right < nums.length; right++) {
			sum += nums[right];
			while(sum >= target) {
				min = Math.min(min, right-left+1);
				sum -= nums[left++];
			}
		}
		
		return (min != Integer.MAX_VALUE) ? min : 0;
	}

}
