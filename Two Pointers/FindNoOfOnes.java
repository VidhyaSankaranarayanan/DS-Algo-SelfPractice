package week3day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class FindNoOfOnes {
	
	/*
	 * Input: Integer array
	 * Output: Integer
	 * Constraint: Solve in O(n) & do not use extra space
	 * 
	 * Test data set:
	 * Positive: {0,0,0,1,1,1}; Output: 3
	 * Negative: {0,0,0,0}; Output: 0
	 * Edge: {1,1,1}; Output: 3
	 * 
	 * Approach: Brute Force
	 * 2 pointer
	 * 
	 * O Notations
	 */

	@Test
	public void test1() {
		int[] num = {0,0,0,1,1,1};
		Assert.assertEquals(3, findNoOfOnesUsing2Pointer(num));
	}
	
	@Test
	public void test2() {
		int[] num = {0,0,0};
		Assert.assertEquals(0, findNoOfOnesUsing2Pointer(num));
	}
	
	@Test
	public void test3() {
		int[] num = {1,1,1};
		Assert.assertEquals(3, findNoOfOnesUsing2Pointer(num));
	}
	
	/*
	 * Pseudo code
	 * Traverse through the array
	 * 		If the element equals to 1
	 * 			return length-index
	 * Return 0
	 */
	
	private int findNoOfOnes(int[] num) {
		for(int i = 0; i < num.length; i++) {
			if(num[i] == 1)
				return num.length-i;
		}
		return 0;
	}

	/*
	 * Pseudo code
	 * Initialize left as 0, right as length-1
	 * Traverse until left < right
	 * 		If value at left is 1 & value at right is 0
	 * 			return right-left
	 * 		Increment left & decrement right
	 * 			
	 * Return 0
	 */
	
	private int findNoOfOnesUsing2Pointer(int[] num) {
		int left = 0, right = num.length-1;
		while(left <= right) {
			if(num[left] == 1)
				return num.length - left;
			if(num[right] == 0)
				return num.length - right-1;
			left++;
			right--;
		}
		return left;
	}
}
