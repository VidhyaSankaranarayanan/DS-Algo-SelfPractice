package week2day2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class AbsoluteDifference {
	
	/*
	 * Given an array of integers and an integer k, find out whether there are two 
    distinct indices i and j in the array such that nums[i] = nums[j] 
    and the absolute difference between i and j is at most k.
	 */
	
	/*
	 * Input: Integer array, Integer
	 * Output: Boolean
	 * Constraint: Sliding Window
	 * Test Data
	 * Positive: {1,2,3,1}, k = 3
	 * Output: true
	 * [1,0,1,1], k = 1
	 * Output: true
	 * Negative: {1,2,3,1,2,3}, k = 2
	 * Output: false
	 * Edge: {1,2,3,4,5,6,7}, k = 3
	 * Output: false
	 * 
	 * Approach: Sliding Window
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */

	@Test
	public void test1() {
		int[] nums = {1,2,3,1};
		int k = 3;
		Assert.assertEquals(true, findAbsoluteDifference(nums, k));
	}
	
	@Test
	public void test2() {
		int[] nums = {1,0,1,1};
		int k = 1;
		Assert.assertEquals(true, findAbsoluteDifference(nums, k));
	}
	
	@Test
	public void test3() {
		int[] nums = {1,2,3,1,2,3};
		int k = 2;
		Assert.assertEquals(false, findAbsoluteDifference(nums, k));
	}
	
	@Test
	public void test4() {
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		Assert.assertEquals(false, findAbsoluteDifference(nums, k));
	}
	
	/*
	 * Pseudo code
	 * Create a map
	 * Traverse through the array
	 * 		If map contains the current element
	 * 			Find the difference between index & value of the corresponding element, if it equal to target
	 * 				Return true
	 * 		Add the value to the map
	 * Return false
	 */

	private boolean findAbsoluteDifference(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				if(Math.abs(map.get(nums[i]) - i) <= k)
					return true;
			}
			map.put(nums[i], i);
		}
		return false;
	}
}
