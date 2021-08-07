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
public class CountSubstring {

	/*
		 * Input: 2 strings
		 * Output: Integer
		 * Constraint: Use Recursion
		 * Test Data:
		 * Positive: "Welcome to programming! Welcome to Java language!", "to"
		 * Output: 2
		 * Edge: "aaaaaaa", "a"
		 * Output: 7
		 * Negative: "abcdef", "h"
		 * Output: 0
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */
	
	/*
	 * Base condition if string1 not contains string2, return 0
	 * Add 1 & recursively call with replacing first occurrence of s2 in s1
	 */
	@Test
	public void test1() {
		String s1 = "abcdea";
		String s2 = "a";
		Assert.assertEquals(2, countSubstring(s1, s2));
	}

	@Test
	public void test2() {
		String s1 = "Welcome to programming! Welcome to Java language!";
		String s2 = "to";
		Assert.assertEquals(2, countSubstring(s1, s2));
	}

	@Test
	public void test3() {
		String s1 = "aaaaaaa";
		String s2 = "a";
		Assert.assertEquals(7, countSubstring(s1, s2));
	}
	
	@Test
	public void test4() {
		String s1 = "aaaaaaa";
		String s2 = "b";
		Assert.assertEquals(0, countSubstring(s1, s2));
	}
	
	private int countSubstring(String s1, String s2) {
		if(!s1.contains(s2))
			return 0;
		return 1 + countSubstring(s1.replaceFirst(s2, ""),s2);
	}
}
