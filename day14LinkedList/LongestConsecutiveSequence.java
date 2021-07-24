package week4day1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class LongestConsecutiveSequence {
	
	/*Given an unsorted array of integers nums, 
	 * return the length of the longest consecutive elements sequence.
	 * You must write an algorithm that runs in O(n) time.
	 */
	
	/*
	 * Input: Integer array
	 * Output: Integer
	 * Constraint: Solve by O(n)
	 * Test data:
	 * Positive: nums[100,4,200,1,3,2]; Output: 4
	 * Negative: nums[]; Output: 0
	 * Edge: nums[0,3,7,2,5,8,4,6,0,1]; Output: 9
	 * 
	 * Approach: Using Sort
	 * 
	 * Time Complexity: O(nlogn)
	 * Space Complexity: O(1)
	 * 
	 * Approach: Using Hash Set
	 * Time Complexity: O(n) + O(n*m)
	 * Space Complexity: O(n)
	 */
	
	
	
	@Test
	public void test1() {
		int[] nums = {100,4,200,1,3,2};
		Assert.assertEquals(4, findLongestConsecutiveSequenceUsingHashSet(nums));
	}
	
	@Test
	public void test2() {
		int[] nums = {0,3,7,2,5,8,4,6,0,1};
		Assert.assertEquals(9, findLongestConsecutiveSequenceUsingHashSet(nums));
	}
	
	@Test
	public void test3() {
		int[] nums = {};
		Assert.assertEquals(0, findLongestConsecutiveSequenceUsingHashSet(nums));
	}
	
	/*
	 * Pseudo code
	 * If the array is empty, return 0
	 * Sort the array
	 * Initialize max as 0, count as 1, index as 0
	 * Traverse until index reaches length
	 * 	If the difference between current & next element is 1
	 * 		Increment count
	 * 	Else
	 * 		Find max
	 * Return max
	 * 	
	 */
	
	private int findLongestConsecutiveSequence(int[] nums) {
		if(nums.length == 0)
			return 0;
		Arrays.sort(nums);
		int index = 0, count = 1, max = 0;
		while(index < nums.length-1) {
			if(nums[index+1] - nums[index] == 1)
				count++;
			max = Math.max(max,count);
			index++;
		}
		return max;
	}
	
	/*
	 * Pseudo code
	 * If the array is empty, return 0
	 * Create a hash set and add values of the array to it
	 * Initialize max as 0 & count as 0
	 * Traverse through the array
	 * 		Initialize curr as first element & count as 0
	 * 		Traverse through the set until current element -1 is not present
	 * 			Increment count
	 * 		Find max
	 * Return max
	 */
	
	private int findLongestConsecutiveSequenceUsingHashSet(int[] nums) {
		if(nums.length == 0)
			return 0;
		Set<Integer> set = new HashSet<Integer>();
		int max = 0, count = 0;
		for(int i = 0; i < nums.length; i++)
			set.add(nums[i]);
		for(int i = 0; i < nums.length; i++) {
			int curr = nums[i];
			count = 0;
			while(set.contains(curr--)) 
				count++;
			max = Math.max(max, count);
		}
		return max;
		
	}
}
