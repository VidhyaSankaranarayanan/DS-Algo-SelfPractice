/**
 * 
 */
package week3day6;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class SecondMaxElement {

	/*
		 * Input: Integer array
		 * Output: Integer
		 * Constraint: 
		 * Test Data:
		 * Positive: {1,2,3,4}
		 * Output: 3
		 * Edge: {1,1,1,1}
		 * Output: -1
		 * Negative: {1}
		 * Output: -1
		 * 
		 * Approach: Brute force
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(1)
		 */

	@Test
	public void test1() {
		int[] nums = {1,2,3,4};
		Assert.assertEquals(3, findSecMax(nums));
	}

	@Test
	public void test2() {
		int[] nums = {1,1,1,1};
		Assert.assertEquals(-1, findSecMax(nums));
	}

	@Test
	public void test3() {
		int[] nums = {1};
		Assert.assertEquals(-1, findSecMax(nums));
	}
	
	/*
	 * Pseudo code
	 * Initialize max as 0, secMax as -1
	 * Traverse through the array
	 * 		If the current element is greater than max & secMax
	 * 			Initialize secMax as max
	 * 			Initialize max as current element
	 * 		If the current element is greater than secMax & less than max
	 * 			Initialize secMax as current element
	 * Return secMax
	 */
	
	private int findSecMax(int[] nums) {
		if(nums.length < 2)
			return -1;
		int max = -1, secMax = -1;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > max && nums[i] > secMax) {
				secMax = max;
				max = nums[i];
			}
			else if(nums[i] < max && nums[i] > secMax)
				secMax = nums[i];
		}
		return secMax;
	}
}
