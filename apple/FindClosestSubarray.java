/**
 * 
 */
package apple;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class FindClosestSubarray {

	/*
	 * Input: Integer array, Integer k, x
	 * Output: Integer array
	 * Constraint: 
	 * Test Data:
	 * Positive: {1,2,3,4,5}, k = 4, x = 3
	 * Output: {1,2,3,4}
	 * Edge: {1,2,3,4,5}, k = 4, x = -1
	 * Output: {1,2,3,4}
	 * Negative: {8,17,24,25,28}, k = 3, x = 23
	 * Output: {24,25,28}
	 * 
	 * Approach: Using Binary Search & 2 pointer
	 * 
	 * Time Complexity: 
	 * Space Complexity: 
	 */

	@Test
	public void test1() {
		int[] nums = {1,2,3,4,5};
		int k = 4;
		int x = 3;
		Assert.assertTrue(Arrays.equals(new int[] {1,2,3,4}, findClosestSubArrayOptimized(nums, k, x)));
	}

	@Test
	public void test2() {
		int[] nums = {1,2,3,4,5};
		int k = 4;
		int x = 6;
		Assert.assertTrue(Arrays.equals(new int[] {2,3,4,5}, findClosestSubArrayOptimized(nums, k, x)));
	}

	@Test
	public void test3() {
		int[] nums = {8,17,21,24,28};
		int k = 3;
		int x = 23;
		Assert.assertTrue(Arrays.equals(new int[] {21,24,28}, findClosestSubArrayOptimized(nums, k, x)));
	}

	/*
	 * Pseudo code
	 * Initialize low as 0, high as length-1
	 * Traverse until low < high
	 * 		Find mid
	 * 		If mid == x, break
	 * 		If mid > x && mid-1 < x, break
	 * 		If mid < x && mid+1 >x, break
	 * 		If mid > x && mid-1 > x, high = mid-1
	 * 		else low = mid+1
	 * Initialize left as mid-1, right as mid+1
	 * Initialize an array of size k, add mid to the array, decrement k
	 * Traverse until k becomes less than 1
	 * 		If diff btw left & mid < right & mid && left > 0,
	 * 			add left to the array, decrement k, left
	 * 		If diff btw left & mid > right & mid && right < length-1
	 * 			add right to the array, increment right, decrement left
	 * 		If diff btw left & mid == right & mid && left > 0 && right < length-1
	 * 			if left < right
	 * 				add left to the array, decrement k, left
	 * 			else
	 * 				add right to the array, decrement k, increment right
	 * Return output array
	 */

	private int[] findClosestSubArray(int[] nums, int k, int x) {
		int low = 0, high = nums.length-1;
		int mid = 0;
		while(low <= high) {
			mid = (low + high)/2;
			if(mid > 0 && mid < nums.length-1) {
				if(nums[mid] == x) break;
				else if(nums[mid] > x && nums[mid-1] < x) break;
				else if(nums[mid] < x && nums[mid+1] > x) {
					mid = mid+1;
					break;
				}
				else if(nums[mid] > x && nums[mid-1] > x)
					high = mid-1;
				else
					low = mid+1;
			}
			else break;
		}
		int left = mid-1, right = mid+1;
		int[] output = new int[k];
		output[k-1] = nums[mid];
		k-=2;
		while(k >= 0) {
			if((left >= 0 && right <= nums.length-1) && (Math.abs(nums[left] - nums[mid]) < Math.abs(nums[right] - nums[mid])))
				output[k--] = nums[left--];
			else if((left >= 0 && right <= nums.length-1) && (Math.abs(nums[right] - nums[mid]) < Math.abs(nums[left] - nums[mid])))
				output[k--] = nums[right++];
			else if((left >= 0 && right <= nums.length-1) && (Math.abs(nums[left] - nums[mid]) == Math.abs(nums[right] - nums[mid]))) {
				if(nums[left] < nums[right])
					output[k--] = nums[left--];
				else
					output[k--] = nums[right++];
			}
			else if(left == -1) {
				output[k--] = nums[right++];
			}
			else
				output[k--] = nums[left--];
		}
		Arrays.sort(output);
		return output;
	}
	
	/*
	 * Pseudo code - Optimized solution
	 * Initialize low as 0, high as length-k
	 * Traverse until low < right
	 * 		Find mid
	 * 		If x - value at mid > value at mid+k - x
	 * 			low = mid+1
	 * 		else
	 * 			high = mid
	 * Create an array of length k
	 * Traverse from low to k
	 * 	  Add elements to output array
	 * Return output array
	 */
	
	private int[] findClosestSubArrayOptimized(int[] nums, int k, int x) {
		int low = 0, high = nums.length-k;
		while(low < high) {
			int mid = (low+high)/2;
			if(x - nums[mid] > nums[mid+k] - x)
				low = mid+1;
			else
				high = mid;
		}
		int[] output = new int[k];
		int index = 0;
		for(int i = low; i < low + k; i++) 
			output[index++] = nums[i];
		return output;
	}
}
