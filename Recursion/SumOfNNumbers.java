/**
 * 
 */
package week6day1;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class SumOfNNumbers {

	/*
		 * Input: Integer
		 * Output: Integer
		 * Constraint: Use Recursion
		 * Test Data:
		 * Positive: 5
		 * Output: 15
		 * Edge: 0
		 * Output: 0 
		 * Negative: -1
		 * Output: 0
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */
	/*
	 * Base condition: n<=0, return 0
	 * Add n & recursively call with n-1
	 */

	@Test
	public void test1() {
		int n = 5;
		Assert.assertEquals(15, findSum(n));
	}

	@Test
	public void test2() {
		int n = 0;
		Assert.assertEquals(0, findSum(n));
	}

	@Test
	public void test3() {
		int n = -1;
		Assert.assertEquals(0, findSum(n));
	}
	
	private int findSum(int n) {
		if(n <= 0)
			return 0;
		return n + findSum(n-1);
	}
}
