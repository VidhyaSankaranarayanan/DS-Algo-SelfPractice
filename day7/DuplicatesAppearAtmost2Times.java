package week2day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class DuplicatesAppearAtmost2Times {

	/*
	 * Input: Integer array
	 * Output: Integer
	 * Constraint: O(1) space
	 * Test data: [1,1,1,2,2,3] -> [1,1,2,2,3] -> 5
	 * [0,0,0,0] -> [0,0] -> 2
	 * [] -> [] -> 0
	 * [1,1,2,2,3,3] -> [1,1,2,2,3,3] -> 6
	 * [1,2,3] -> [1,2,3] -> 3
	 * Using 2 pointer
	 */
	@Test
	public void test1() {
		int[] num = {1,1,1,2,2,3};
		Assert.assertEquals(5, findDuplicatesWithAtmost2Elements(num));
	}
	
	@Test
	public void test2() {
		int[] num = {0,0,0,0};
		Assert.assertEquals(2, findDuplicatesWithAtmost2Elements(num));
	}
	
	@Test
	public void test3() {
		int[] num = {};
		Assert.assertEquals(0, findDuplicatesWithAtmost2Elements(num));
	}
	
	@Test
	public void test4() {
		int[] num = {1,1,2,2,3,3};
		Assert.assertEquals(6, findDuplicatesWithAtmost2Elements(num));
	}
	
	@Test
	public void test5() {
		int[] num = {1,2,3};
		Assert.assertEquals(3, findDuplicatesWithAtmost2Elements(num));
	}
	
	/*
	 * Pseudo code
	 * Check if the length of the array is empty
	 * 		return 0
	 * Initialize left as 0, right as 1, dup as 1 & index as 1
	 * Traverse through the array until right < length
	 * 	 If the value at left is same as right
	 * 		increment dup
	 * 	 Else 
	 * 		initialize dup as 1
	 * 	 If dup<=2
	 * 		initialize value at index with value at right
	 * 	Increment left & right
	 * 		
	 * Return index
	 */
	
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	
	// 1,1,1,2,2,3(initial) -> 1,1,1,2,2,3(I1) -> 1,1,1,2,2,3(I2) -> 1,1,2,2,2,3(I3) 
	// 1,1,2,2,2,3(I4) -> 1,1,2,2,3,3(I5)
	private int findDuplicatesWithAtmost2Elements(int[] num) {
		if(num.length == 0)
			return 0;
		
		int left = 0, right = 1, dup = 1, index = 1;
		while(right < num.length) {
			if(num[left] == num[right]) dup++;
			else dup = 1;
			if(dup <= 2) num[index++] = num[right];
			left++;
			right++;
		}
		return index;
	}
}
