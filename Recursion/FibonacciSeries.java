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
public class FibonacciSeries {

	/*
		 * Input: Integer
		 * Output: Integer
		 * Constraint: Use Recursion
		 * Test Data:
		 * Positive: 5
		 * Output: 3
		 * Edge: 
		 * Output: 
		 * Negative:
		 * Output: 
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */
	
	/*
	 * Recursion Steps
	 * Base case - if n is 0, return 0
	 * if n is 1, return 1
	 * Positive: 5
	 * 5-1 = 4 = 4-1 = 3 = 3-1 = 2 = 2-1 = 1
	 * if n is negative, return 0
	 * Logic: 0, 1, 1, 2, 3
	 * 		  0, 1, 2, 3, 4
	 * 		  1, 2, 3, 4, 5	
	 * (n-1)+(n-2)	
	 * f(5) = f(4) + f(3)	= f(3)+f(2)	= f(2)+ f(1) = 1+0+1
	 * 		  2
	 * f(3) = f(2) + f(1) = 1
	 * 2+1 = 3
	 */

	@Test
	public void test1() {
		int n = 5;
		Assert.assertEquals(3, findFibonacci(n));
	}

	@Test
	public void test2() {
		int n = 0;
		Assert.assertEquals(0, findFibonacci(n));
	}

	@Test
	public void test3() {
		int n = -1;
		Assert.assertEquals(0, findFibonacci(n));
	}
	
	/*
	 * Pseudo code
	 * Check if n is less than or equal to 0
	 * 	return 0
	 * Check if n is 1
	 * 	return 1
	 * Recursively call with n-1 & n-2
	 * Return the sum
	 */
	
	private int findFibonacci(int n) {
		if(n <= 1)
			return 0;
		if(n == 2)
			return 1;
		return findFibonacci(n-1) +  findFibonacci(n-2);
	}
}
