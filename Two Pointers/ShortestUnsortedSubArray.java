/**
 * 
 */
package twopointers;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class ShortestUnsortedSubArray {

	/*
	 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.



Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
	 */

	/*
		 Input: Integer array
Output: Integer
Approach: Sorting
Time Complexity: O(nlogn)
Space Complexity: O(n)
	 */

	@Test
	public void test1() {
		int[] nums = {1,3,2,4,5};
		Assert.assertEquals(2, findUnsortedSubarray(nums));
	}

	@Test
	public void test2() {
		int[] nums = {2,6,4,8,10,9,15};
		Assert.assertEquals(5, findUnsortedSubarray(nums));
	}

	@Test
	public void test3() {
		int[] nums = {1,2,3,4};
		Assert.assertEquals(0, findUnsortedSubarray(nums));
	}

	/*
	 * Pseudo code
	   If the length of the array is less than 2
			return 0
	   Create a temp array and copy the input array
	   Sort the temp array
	   Initialize 2 pointers left as 0, right as length-1
	   Traverse until left < right
	   If value at left of both input & temp arrays are same & values at right of both temp & input are same
			Increment left & decrement right
	   Else if value at left of input & temp are same & right values differ
			Increment left
	   Else if values at right are same & left values differ
			Decrement right
	   Else return right-left+1
	   If left & right are same indices, return 0
	   Else return right-left+1
	 */

	public int findUnsortedSubarray(int[] nums) {
		if(nums.length < 2)
			return 0;
		int[] temp = Arrays.copyOfRange(nums, 0, nums.length);
		Arrays.sort(temp);
		int left = 0, right = nums.length-1;
		while(left < right){
			if(nums[left] == temp[left] && nums[right] == temp[right]){
				left++;
				right--;
			}
			else if(nums[left] == temp[left] && nums[right] != temp[right])
				left++;
			else if(nums[left] != temp[left] && nums[right] == temp[right])
				right--;
			else
				return right-left+1;
		}
		if(left == right) return 0;
		return right-left+1;
	}
}
