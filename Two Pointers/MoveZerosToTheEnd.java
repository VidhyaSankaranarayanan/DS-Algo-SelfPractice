package week2day1;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class MoveZerosToTheEnd {

	/*
	 * Input: Integer array
	 * Output: Integer array
	 * Constraint: Two pointer
	 * Test Data:
	 * Positive: {1,0,3,0,4,0,5}
	 * Output: {1,3,4,5,0,0,0}
	 * Negative: {2,4,6,8}
	 * Output: {2,4,6,8}
	 * Negative: {}
	 * Output: {}
	 * 
	 * Approach: Two sum
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */

	@Test
	void test1() {
		int[] num = {1,0,3,0,4,0,5};
		Assert.assertTrue(Arrays.equals(new int[] {1,5,3,4,0,0,0}, moveZerosToTheEnd(num)));
	}
	
	@Test
	void test2() {
		int[] num = {2,4,6,8};
		Assert.assertTrue(Arrays.equals(new int[] {2,4,6,8}, moveZerosToTheEnd(num)));
	}
	
	@Test
	void test3() {
		int[] num = {};
		int k = 19;
		Assert.assertTrue(Arrays.equals(new int[] {}, moveZerosToTheEnd(num)));
	}

	/*
	 * Pseudo code
	 * If the array is empty, return empty array
	 * Initialize 2 pointers left as 0, right as length-1
	 * Traverse until left less than right
	 * 		If value at left is 0, right is non-zero
	 * 			swap the values, increment left, decrement right
	 * 		Else if value at left is non-zero, right is 0
	 * 			decrement right
	 * 		Else increment left
	 * Return array
	 */
	
	private int[] moveZerosToTheEnd(int[] num) {
		if(num.length == 0)
			return num;
		int left = 0, right = num.length-1;
		while(left < right) {
			if(num[left] == 0 && num[right] != 0) {
				int swap = num[left];
				num[left++] = num[right];
				num[right--] = swap;
			}
			else if(num[left]!=0 && num[right]==0)
				right--;
			else left++;
		}
		return num;
	}
}
