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
public class ReverseString {

	/*
		 * Input: String
		 * Output: String
		 * Constraint: Use Recursion
		 * Test Data:
		 * Positive: abc
		 * Output: cba
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
	
	/* abc
	 * cba
	 * Base case: when length is 0, return ""
	 * Add last character and Recursively call with substring from 0 to length-1
	 */

	@Test
	public void test1() {
		String str = "abc";
		Assert.assertEquals("cba", findReverse(str));
	}

	@Test
	public void test2() {
		String str = "abc defe";
		Assert.assertEquals("efed cba", findReverse(str));
	}

	@Test
	public void test3() {
		String str = "aaa";
		Assert.assertEquals("aaa", findReverse(str));
	}
	
	@Test
	public void test4() {
		String str = "";
		Assert.assertEquals("", findReverse(str));
	}
	
	private String findReverse(String str) {
		if(str.length() == 0)
			return "";
		return str.charAt(str.length()-1)+findReverse(str.substring(0,str.length()-1));
	}
}
