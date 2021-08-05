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
		Assert.assertEquals(2, findLongestSubArrayUsing2Pointer(nums,k));
	}

	@Test
	public void test2() {
		int[] nums = {4,2,2,2,4,4,2,2};
		int k = 0;
		Assert.assertEquals(3, findLongestSubArrayUsing2Pointer(nums,k));	
	}

	@Test
	public void test3() {
		int[] nums = {10,1,2,4,7,2};
		int k = 5;
		Assert.assertEquals(4, findLongestSubArrayUsing2Pointer(nums,k));
	}
	
	/*
	 * Pseudo code - 2 pointer
	 * Create 2 variables left, right as 0 and result as 0
	 * Traverse through the array
	 * 		If the difference between left & right values are less than limit
	 * 			Find result
	 * 		Else
	 * 			Initialize right as left
	 * 			Increment left
	 * Return result
	 */
	
	private int findLongestSubArrayUsing2Pointer(int [] nums, int k) {
		int left = 0, right = 0, result = 0;
		for(right = 0; right < nums.length; right++) {
			if(Math.abs(nums[right] - nums[left]) <= k)
				result = Math.max(result, right-left+1);
			else 
				right = left++;
		}
		return result;
	}
	
	/*
	 * Pseudo code - Brute force
	 * Create 2 queues for max & min
	 * Initialize a variable for result
	 * Initialize 2 pointers left and right as 0
	 * Traverse through the array
	 * 		Traverse until max queue is empty & last element is lesser than current element
	 * 			Remove last element
	 * 		Add current element
	 * 		Traverse until min queue is empty & last element is greater than current element
	 * 			Remove last element
	 * 		Add current element
	 * 		Traverse until difference between first element of min & max greater than limit
	 * 			If max queue's element is equal to element at left, remove that
	 * 			If min queue's element is equal to element at left, remove that
	 * 			Increment left
	 * 		Calculate result 
	 * Return result			
	 */

	
	private int findLongestSubArray(int[] nums, int k) {
		ArrayDeque<Integer> maxQueue = new ArrayDeque<Integer>();
		ArrayDeque<Integer> minQueue = new ArrayDeque<Integer>();
		int left = 0, right = 0, result = 0;
		for(right = 0; right < nums.length; right++) {
			while(!maxQueue.isEmpty() && maxQueue.peekLast() < nums[right])
				maxQueue.pollLast();
			maxQueue.addLast(nums[right]);
			while(!minQueue.isEmpty() && minQueue.peekLast() > nums[right])
				minQueue.pollLast();
			minQueue.addLast(nums[right]);
			while(maxQueue.peekFirst() - minQueue.peekFirst() > k) {
				if(maxQueue.peekFirst() == nums[left]) maxQueue.pollFirst();
				if(minQueue.peekFirst() == nums[left]) minQueue.pollFirst();
				left++;
			}
			result = Math.max(result, right-left+1);
		}
		return result;
	}
}
