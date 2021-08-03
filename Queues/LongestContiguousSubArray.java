/**
 * 
 */
package assessment2;

import java.util.ArrayDeque;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class LongestContiguousSubArray {

	/*
		 * Input: Integer array, Integer
		 * Output: Integer
		 * Constraint: 
		 * Test Data:
		 * Positive: {8,2,4,7}, k = 4
		 * Output: 2
		 * Edge: {4,2,2,2,4,4,2,2}, k = 0
		 * Output: 3
		 * Negative: {10,1,2,4,7,2}, k = 5
		 * Output: 4
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */

	@Test
	public void test1() {
		int[] nums = {8,2,4,7};
		int k = 4;
		Assert.assertEquals(2, findLongestSubArray(nums,k));
	}

	@Test
	public void test2() {
		int[] nums = {4,2,2,2,4,4,2,2};
		int k = 0;
		Assert.assertEquals(3, findLongestSubArray(nums,k));	
	}

	@Test
	public void test3() {
		int[] nums = {10,1,2,4,7,2};
		int k = 5;
		Assert.assertEquals(4, findLongestSubArray(nums,k));
	}
	
	/*
	 * Pseudo code - Brute force
	 * Create 2 queues for max & min
	 * Initialize a variable for length 
	 * Traverse through the array
	 * 		Find max & min and add the corresponding index to the queues
	 * 		Find diff between both the top values
	 * 		If the diff is less than or equal to limit
	 * 			Find the longest from max of longest & top value of queues
	 * 		Increment left
	 * 		Initialize right with left
	 * 		Poll the queues
	 * Return longest	
	 * 			
	 */

	
	private int findLongestSubArray(int[] nums, int k) {
		int longest = 0;
		ArrayDeque<Integer> maxQueue = new ArrayDeque<Integer>();
		ArrayDeque<Integer> minQueue = new ArrayDeque<Integer>();
		int left = 0, right = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//		while(left < nums.length && right < nums.length) {
//			max = Math.max(max, nums[left])
		
		return 0;
	}
}
