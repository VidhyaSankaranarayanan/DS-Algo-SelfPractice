/**
 * 
 */
package slidingwindow;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class MaxFrequency {

	/*
		 * Input: Integer array & Integer
		 * Output: Integer
		 * Constraint: 
		 * Test Data:
		 * Positive: {1,2,4}, k = 5
		 * Output: 3
		 * Edge: {1,4,8,13}, k = 5
		 * Output: 2
		 * Negative: {5,6,7,8}, k = 6
		 * Output: 4
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */

	@Test
	public void test1() {
		int[] nums = {1,2,4};
		int k = 5;
		Assert.assertEquals(3, findMax(nums, k));
	}

	@Test
	public void test2() {
		int[] nums = {1,4,8,13};
		int k = 5;
		Assert.assertEquals(2, findMax(nums, k));
	}

	@Test
	public void test3() {
		int[] nums = {5,6,7,8};
		int k = 6;
		Assert.assertEquals(4, findMax(nums, k));
	}
	
	/*
	 * Pseudo code
	 * Initialize left & right as 0, max & sum as 0
	 * Sort the array
	 * Traverse through the array until right < length
	 * 		Add current value to the sum
	 * 		Traverse until current value * traversed sub array length > sum+k
	 * 			Decrement left value from sum
	 * 			Increment left
	 * 		Find max between max & right-left+1
	 * Return max
	 * 
	 */
	
	private int findMax(int[] nums, int k) {
		int left = 0, right = 0, sum = 0, max = 0;
		Arrays.sort(nums);
		while(right < nums.length) {
			sum += nums[right];
			while((nums[right] * (right-left+1)) > sum+k) {
				sum -= nums[left++];
			}
			max = Math.max(max, right-left+1);
			right++;
		}
		return max;
	}
}
