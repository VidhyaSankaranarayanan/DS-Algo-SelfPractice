package week3day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class FindTargetUsingBinarySearch {
	
	/*
	 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
 
Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
Example 4:
Input: nums = [1,3,5,6], target = 0
Output: 0
	 */
	
	/*
	 * Input: Integer array & target
	 * Output: Integer
	 * Constraint: O(n) & Do not use extra space
	 */

	@Test
	public void test1() {
		int[] nums = {1,3,5,6};
		int k = 5;
		Assert.assertEquals(2, findTargetIndex(nums, k));
	}
	
	@Test
	public void test2() {
		int[] nums = {1,3,5,6};
		int k = 2;
		Assert.assertEquals(1, findTargetIndex(nums, k));
	}
	
	@Test
	public void test3() {
		int[] nums = {1,3,5,6};
		int k = 7;
		Assert.assertEquals(4, findTargetIndex(nums, k));
	}
	
	@Test
	public void test4() {
		int[] nums = {1,3,5,6};
		int k = 0;
		Assert.assertEquals(0, findTargetIndex(nums, k));
	}
	
	/*
	 * Pseudo code
	 * Initialize low as 0, high as length - 1
	 * Traverse until left<=high
	 * 		Find mid
	 * 		If the element at mid equals to target
	 * 			return mid
	 * 		Else if element at mid greater than target
	 * 			high = mid-1
	 * 		Else
	 * 			low = mid+1
	 * Return low
	 */

	private int findTargetIndex(int[] nums, int k) {
		int low = 0, high = nums.length-1;
		while(low <= high) {
			int mid = (low+high)/2;
			if(nums[mid] == k)
				return mid;
			else if(nums[mid] > k)
				high = mid-1;
			else
				low = mid+1;
		}
		return low;
	}
}
