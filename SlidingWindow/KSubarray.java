/**
 * 
 */
package apple;

import org.junit.Assert;
import org.junit.Test;



/**
 * @author Vidhya
 *
 */
public class KSubarray {

	/*
		 * Input: Integer array, integer
		 * Output: Integer 
		 * Constraint: 
		 * Test Data:
		 * Positive: {5,3,5,7,8}, k = 3
		 * Output: 2
		 * Edge: {5,3,5,7,8}, k = 2
		 * Output: 3
		 * Negative: {1,1,1,1}, k = 2
		 * Output: 0
		 * 
		 * Approach: Sliding Window 
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(1)
		 */

	@Test
	public void test1() {
		int[] nums = {5,3,5,7,8};
		int k = 3;
		Assert.assertEquals(2, findClosestSubarrayOptimized(nums, k));
	}

	@Test
	public void test2() {
		int[] nums = {5,3,5,7,8};
		int k = 2;
		Assert.assertEquals(3, findClosestSubarrayOptimized(nums, k));
	}

	@Test
	public void test3() {
		int[] nums = {1,2,3,3,4,5};
		int k = 2;
		Assert.assertEquals(4, findClosestSubarrayOptimized(nums, k));
	}
	
	@Test
	public void test4() {
		int[] nums = {1,2,3,4,2,1,3};
		int k = 2;
		Assert.assertEquals(4, findClosestSubarrayOptimized(nums, k));
	}
	
	@Test
	public void test5() {
		int[] nums = {5,4,3,2,1};
		int k = 2;
		Assert.assertEquals(0, findClosestSubarrayOptimized(nums, k));
	}
	
	@Test
	public void test6() {
		int[] nums = {1,2,3,4};
		int k = 5;
		Assert.assertEquals(0, findClosestSubarrayOptimized(nums, k));
	}
	
	/*
	 * Pseudo code
	 * Initialize count as 0
	 * Initialize left as 0, right as 1
	 * Traverse through the array
	 * 		If left < left+1,
	 * 			increment right
	 * 		If right - left == k-1
	 * 			increment count
	 * 			increment left, assign left + 1 to right
	 * Return count
	 */
	
	private int findSubArray(int[] nums, int k) {
		int count = 0;
		int left = 0, right = 1, index = left;
		while(left < nums.length-k+1) {
			if(nums[index] < nums[index+1]) {
				right++;
				index++;
			}
			else {
				left++;
				index++;
			}
			if(right - left == k-1) {
				count++;
				left++;
				right = left;
				index = left;
			}
		}
		return count;
	}
	
	/*
	 * Pseudo code - Optimized
	 * If k > nums.length, return 0
	 * Initialize count as 1
	 * Traverse through the array
	 * 		If the current element is greater than previous element
	 * 			increment count
	 * Return count-k+1
	 */
	
	private int findClosestSubarrayOptimized(int[] nums, int k) {
		if(nums.length < k) return 0;
		int count = 1;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] > nums[i-1])
				count++;
		}
		return count-k+1;
	}
}
