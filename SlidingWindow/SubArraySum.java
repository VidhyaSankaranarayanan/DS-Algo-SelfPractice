/**
 * 
 */
package assessment2;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class SubArraySum {

	/*
		 * Input: Integer array, Integer
		 * Output: Boolean
		 * Constraint: Optimized solution
		 * Test Data:
		 * Positive: {1,4,20,3,10,5}, k = 33
		 * Output: true
		 * Edge: {1,4,20,3,10,5}, k = 15
		 * Output: true
		 * Negative: {1,4,20,3,10,5}, k = 50
		 * Output: false
		 * 
		 * Approach: Sliding Window
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(1)
		 */

	@Test
	public void test1() {
		int[] nums = {1,4,20,3,10,5};
		int k = 33;
		Assert.assertEquals(true, findSubArray(nums, k));
	}

	@Test
	public void test2() {
		int[] nums = {1,2,20,3,10,5};
		int k = 5;
		Assert.assertEquals(true, findSubArray(nums, k));
	}

	@Test
	public void test3() {
		int[] nums = {1,4,20,3,10,5};
		int k = 50;
		Assert.assertEquals(false, findSubArray(nums, k));
	}

	/**
	 * @param nums
	 * @param k
	 * @return
	 */
	
	
	/*
	 * Pseudo code
	 * Initialize 2 pointers left and right as 1 and sum as nums[0]
	 * If sum equals to k, return true
	 * Traverse through the array until left is less than length
	 * 	If sum less than target	
	 * 		Add right to the sum, increment right
	 *  If sum equals to target, return true
	 *  If sum greater than target
	 *  	subtract left from the sum, increment left
	 * Return false
	 *
	 * 
	 */
	private boolean findSubArray(int[] nums, int k) {
		int left = 0, right = 1, sum = nums[0];
		if(sum == k) return true;
		while(left < nums.length) {
			if(sum == k) return true;
			else if(sum < k && right < nums.length) sum += nums[right++];
			else sum -= nums[left++];
		}
		return false;
	}
	
}
