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
public class TrappingRainWater {

	/*
		 * Input: 
		 * Output: 
		 * Constraint: 
		 * Test Data:
		 * Positive: 
		 * Output: 
		 * Edge: 
		 * Output: 
		 * Negative:
		 * Output: 
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */

	@Test
	public void test1() {
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
		Assert.assertEquals(6, findMaxUnits(nums));
	}

	@Test
	public void test2() {
		int[] nums = {4,2,0,3,2,5};
		Assert.assertEquals(9, findMaxUnits(nums));
	}

	@Test
	public void test3() {
		int[] nums = {2,3,2,2};
		Assert.assertEquals(0, findMaxUnits(nums));
	}

	
	
	/*
	 * Pseudo code
	 * Initialize left, right, min, max, sum as 0
	 * Traverse through the array from 0
	 * 		If the value at current index is greater than min
	 * 			Initialize max as current value, right to current index
	 * 		Traverse from left+1 to right
	 * 			Find diff between current element & min and add it to sum
	 * 		If i reaches length-1
	 * 			assign i as right+1
	 * 			left as i, min as i
	 * Return sum
	 */
	
	// The below solution works when the array has elements of greater value until length
	// It will not work for data like {4,2,3} & works for {3,2,4}
	
	private int findMax(int[] nums) {
		int left = 0, right = 0, sum = 0, min = nums[0], max = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] >= max) {
				min = max;
				left = right;
				max = nums[i];
				right = i;
				left++;
			}
			while(left < right)
				sum += Math.abs(min-nums[left++]);
			if(i == nums.length-1 && right+1 < nums.length) {
				i = right+1;
				left = i;
				min = nums[i];
				max = nums[i];
			}
		}
		return sum;
	}
	
	/*
	 * Pseudo code 
	 * Initialize left as 0, right as 0, sum as 0
	 * Traverse through the array
	 * 		Traverse through the array from current element to 0 in descending order
	 * 			Find Max and assign it to left
	 * 		Traverse from current element to length
	 * 			Find Max and assign it to right
	 * 		Find difference between min of left & right and current element, then add it to sum
	 * Return sum
	 */
	
	private int findMaxUnits(int[] nums) {
		int sum = 0;
		for(int i = 1; i < nums.length-1; i++) {
			int left = 0, right = 0;
			for(int j = i; j >= 0; j--)
				left = Math.max(nums[j], left);
			for(int k = i; k < nums.length; k++)
				right = Math.max(nums[k], right);
			sum += Math.abs(nums[i] - Math.min(left, right));
		}
		return sum;
	}
	
	
}
