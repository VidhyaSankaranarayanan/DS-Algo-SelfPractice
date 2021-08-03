package week2day1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ClosestSum {

	/*
	 * Input: Integer array, Integer
	 * Output: Integer
	 * Constraint: Two pointer
	 * Test Data:
	 * Positive: {34,23,1,24,75,33,54,8}, k =60
	 * Output: 58
	 * Negative: {10,20,30}, K = 15
	 * Output: -1
	 * 
	 * 
	 * Approach: Two sum
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */

	@Test
	public void test1() {
		int[] input = {34,23,1,24,75,33,54,8}; 
		int k = 60;
		Assert.assertEquals(58, findClosestSum(input,k));
	}
	
	@Test
	public void test2() {
		int[] input = {10,20,30};
		int k = 15;
		Assert.assertEquals(-1, findClosestSum(input,k));
	}
	
	@Test 
	public void test3() {
		int[] input = {1,2,3,4,5};
		int k = 0;
		Assert.assertEquals(-1, findClosestSum(input,k));
	}
	
	/*
	 * Pseudo code
	 * Sort the array
	 * Initialize 2 pointers, left as 0, right as length-1
	 * Traverse until left < right
	 * 		Add value at left & right 
	 * 		If sum < target, Find max
	 * Return max
	 */
	
	private int findClosestSum(int[] input, int k) {
		Arrays.sort(input);
		int left = 0, right = input.length-1, sum = 0, max = -1;
		while(left <= right) {
			sum = input[left] + input[right];
			if(sum < k) {
				max = Math.max(max, sum);
				left++;
			}
			else if(sum >= k)
				right--;
		}
		return max;
	}
	

}
