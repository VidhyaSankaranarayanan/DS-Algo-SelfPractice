package week3day1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class KSmallestSubarraySum {
	
	/*
	 * Given an integer array nums of length n and an integer k, 
	 * return the kth smallest subarray sum.
	 * A subarray is defined as a non-empty contiguous sequence of elements in an array. 
	 * A subarray sum is the sum of all elements in the subarray.
	 * Example 1:
	 * Input: nums = [2,1,3], k = 4
	 * Output: 3
	 * Explanation: The subarrays of [2,1,3] are: 
	 * - [2] with sum 2
	 * - [1] with sum 1
	 * - [3] with sum 3
	 * - [2,1] with sum 3
	 * - [1,3] with sum 4
	 * - [2,1,3] with sum 6 
	 * Ordering the sums from smallest to largest gives 1, 2, 3, 3, 4, 6. 
	 * The 4th smallest is 3.
	 */
	
	/*
	 * Input: Integer array & integer
	 * Output: Integer
	 * Constraint: Brute force
	 * Test data: [2,1,3], k=4 -> 3
	 * [1,1,1], k = 2 -> 1
	 * [1,-1,-2] k = 5 -> -3
	 * [3,3,5,5] k = 7 -> 10
	 */
	

	@Test
	public void test1() {
		int[] nums = {2,1,3};
		int k = 4;
		Assert.assertEquals(3, findKSum(nums, k));
	}
	
	@Test
	public void test2() {
		int[] nums = {1,1,1};
		int k = 2;
		Assert.assertEquals(1, findKSum(nums, k));
	}

	@Test
	public void test3() {
		int[] nums = {1,-1,-2};
		int k = 5;
		Assert.assertEquals(0, findKSum(nums, k));
	}
	
	@Test
	public void test4() {
		int[] nums = {3,3,5,5};
		int k = 7;
		Assert.assertEquals(10, findKSum(nums, k));
	}
	
	@Test
	public void test5() {
		int[] nums = {3};
		int k = 2;
		Assert.assertEquals(0, findKSum(nums, k));
	}
	
	/*
	 * Pseudo code
	 * If array length is less than or equal to 1 & k > 1
	 * 		return 0
	 * Create an array list for adding sum
	 * Initialize sum as 0
	 * Traverse through the array from 1 to length [for no of elements to consider]
	 * 		Traverse through the array from 0 to length
	 * 			Initialize tempPosition as i, tempCurrent as j, sum as 0
	 * 			Initialize flag as false
	 * 			Traverse until tempPosition becomes 0 & j+1<= length
	 * 			Add elements at tempCurrent to sum
	 * 			Increment tempCurrent & decrement tempPosition
	 * 			Set flag as true
	 * 		If flag is true 
	 * 			Add sum to the list
	 * Sort the list
	 * Return the value at k-1th index
	 */
	
	private int findKSum(int[] nums, int k) {
		if(nums.length <= 1 && k > 1)
			return 0;
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for(int i = 1; i <= nums.length; i++) {
			for(int j = 0; j < nums.length; j++) {
				int tempPosition = i, tempCurrent = j;
				sum = 0;
				boolean sumFlag = false;
				while(tempPosition != 0 && j + i <= nums.length) {
					sum += nums[tempCurrent++];
					tempPosition--;
					sumFlag = true;
				}
				if(sumFlag == true)
				list.add(sum);
			}
		}
		Collections.sort(list);
		return list.get(k-1);
	}

}
