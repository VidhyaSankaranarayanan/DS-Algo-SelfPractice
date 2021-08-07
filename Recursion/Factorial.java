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
public class Factorial {

	/*
		 * Input: Integer
		 * Output: Integer
		 * Constraint: Use Recursion
		 * Test Data:
		 * Positive: 5
		 * Output: 120
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

	@Test
	public void test1() {
		int n = 5;
		Assert.assertEquals(120, findFactorial(n));
	}

	@Test
	public void test2() {
		int n = 0;
		Assert.assertEquals(0, findFactorial(n));
	}

	@Test
	public void test3() {
		int n = -1;
		Assert.assertEquals(0, findFactorial(n));
	}
	
	/*
	 * Base condition
	 * n==1, return 1
	 * n<=0, return 0
	 * Multiply n & recursively call with n-1
	 */
	
	private int findFactorial(int n) {
		if(n == 1)
			return 1;
		if(n <= 0)
			return 0;
		return n*findFactorial(n-1);
	}
}
