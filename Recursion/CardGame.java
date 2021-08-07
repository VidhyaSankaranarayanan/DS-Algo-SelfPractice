/**
 * 
 */
package week6day1;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class CardGame {

	/*
		 * Input: Integer array
		 * Output: Boolean
		 * Constraint: Use Recursion
		 * Test Data:
		 * Positive: {1,6,23,7}
		 * Output: true
		 * Edge: {1,2,2,1}
		 * Output: true
		 * Negative: {1,7,3}
		 * Output: false
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */
	
	/*
	 * Create 2 methods, one for getting player's score
	 * 	 Call helper function by passing start as 0, end as length-1, array for player1
	 *   Call helper function by passing start as 1, end as length-1, array for player2
	 *   If player1 >= player2, return true
	 *   Else false
	 * Recursive method
	 * Base condition: if start>end, return 0
	 * Add element at start, recursively call by incrementing start by 2, end as length & array
	 */

	@Test
	public void test1() {
		int[] nums = {1,6,23,7};
		Assert.assertEquals(true, findWinner(nums));
	}

	@Test
	public void test2() {
		int[] nums = {1,2,2,1};
		Assert.assertEquals(true, findWinner(nums));
	}

	@Test
	public void test3() {
		int[] nums = {1,7,3};
		Assert.assertEquals(false, findWinner(nums));
	}
	
	private boolean findWinner(int[] nums) {
		return (findScore(0,nums.length-1,nums) >= findScore(1,nums.length-1,nums))?true:false;
	}
	
	private int findScore(int start, int end, int[] nums) {
		if(start > end)
			return 0;
		return nums[start] + findScore(start+=2,nums.length-1,nums);
	}
}
