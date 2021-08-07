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
@SuppressWarnings("deprecation")
public class CountNoOfOnes {

	/*
		 * Input: 
		 * Output: 
		 * Constraint: 
		 * Test Data:
		 * Positive: 
		 * Output: 
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
	 * {1,0,1,0}
	 * Pass low, high, array
	 * if(i == 1), increment count
	 * low>high, break & return count
	 * 1010
	 * Find mod
	 * If rem == 1
	 * count++
	 * Recursively send quotient
	 * If n/10 is 0, break
	 * 
	 * 
	 */

	@Test
	public void test1() {
		int n = 1010;
		Assert.assertEquals(2, findCount(n));
	}

	@Test
	public void test2() {
		int n = 1111;
		Assert.assertEquals(4, findCount(n));
	}

	@Test
	public void test3() {
		int n = 0000;
		Assert.assertEquals(0, findCount(n));
	}
	
	/**
	 * @param i
	 * @param j
	 * @param nums
	 * @return
	 */
	//1010
	private int findCount(int n) {
		if(n/10 == 0 && n%10 == 1)
			return 1;
		if(n/10 == 0 && n%10 == 0)
			return 0;
		return (n%10)+findCount(n/10);
	}
}
