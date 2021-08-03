package week2day1;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TwoSum {
	
	/*
	 * Input: Integer array & Target
	 * Output: Integer array
	 * Constraint: Two pointer
	 * Test Data:
	 * Positive: {1,4,5,8,11,12,16,21}; k = 19
	 * Output: {3,4}
	 * Negative: {2,4,6,8}; k =17
	 * Output: {-1,-1}
	 * Negative: {}; k = 2
	 * Output: {-1,-1}
	 * 
	 * Approach: Two sum
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */

	@Test
	void test1() {
		int[] num = {1,4,5,8,11,12,16,21};
		int k = 19;
		Assert.assertTrue(Arrays.equals(new int[] {3, 4}, findTwoSum(num,k)));
	}
	
	@Test
	void test2() {
		int[] num = {2,4,6,8};
		int k = 19;
		Assert.assertTrue(Arrays.equals(new int[] {-1, -1}, findTwoSum(num,k)));
	}
	
	@Test
	void test3() {
		int[] num = {};
		int k = 19;
		Assert.assertTrue(Arrays.equals(new int[] {-1, -1}, findTwoSum(num,k)));
	}
	
	/*
	 * Pseudo code
	 * If the array is empty, return -1,-1
	 * Initialize 2 pointers left as 0, right as length-1
	 * Traverse until left < right
	 * 		If left+right equals target
	 * 			return left,right
	 * 		Else If left+right>target
	 * 			right--
	 * 		Else
	 * 			decrement left
	 * Return -1,-1
	 */
	
	private int[] findTwoSum(int[] num, int k) {
		if(num.length == 0)
			return new int[] {-1,-1};
		int left = 0, right = num.length-1;
		while(left < right) {
			if(num[left] + num[right] == k)
				return new int[] {left,right};
			else if(num[left] + num[right] > k)
				right--;
			else left++;
		}
		return new int[] {-1,-1};
	}

}
