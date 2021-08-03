package week2day2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class FindSubArray {

	/*
	 * Find the highest sum of K consecutive elements
	 * 
	 * Input: Integer array, Integer
	 * Output: Integer
	 * Constraint: Sliding Window
	 * Test Data
	 * Positive: {1,7,4,3,1,2,1,5,1}, k = 7
	 * Output: {2,3}
	 * Edge: {1,2,3,4}, k = 15
	 * Output: {-1,-1}
	 * Negative: {5,5,5,5,5,5}, k = 30
	 * Output: {0,6}
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */

	@Test
	public void test1() {
		int[] nums = {1,7,4,3,1,2,1,5,1};
		int k = 7;
		Assert.assertTrue(Arrays.equals(new int[] {2, 3}, findSubArray(nums,k)));
	}
	
	@Test
	public void test2() {
		int[] nums = {1,2,3,4};
		int k = 15;
		Assert.assertTrue(Arrays.equals(new int[] {-1, -1}, findSubArray(nums,k)));
	}
	
	@Test
	public void test3() {
		int[] nums = {5,5,5,5,5,5};
		int k = 30;
		Assert.assertTrue(Arrays.equals(new int[] {0, 5}, findSubArray(nums,k)));
	}
	
	/*
	 * Pseudo code
	 * Initialize sum as first element
	 * If sum is equal to target
	 * 		return {0,0}
	 * Initialize left as 0
	 * Traverse through the array from 1 to length
	 * 		Add the next element to the sum
	 * 		If the sum equals to target, return left & right
	 * 		If the sum greater than target, remove left, increment left
	 * 		If the sum lesser than the target, add right element and increment right
	 * Return -1,-1
	 */
	
	private int[] findSubArray(int[] nums, int k) {
		int sum = nums[0];
		if(sum == k)
			return new int[] {0,0};
		int left = 0;
		for(int right = 1; right < nums.length; right++) {
			sum += nums[right];
			if(sum == k)
				return new int[] {left, right};
			else if(sum > k) 
				sum -= nums[left++];
			else
				sum += nums[right++];
		}
		return new int[] {-1,-1};
	}

}
