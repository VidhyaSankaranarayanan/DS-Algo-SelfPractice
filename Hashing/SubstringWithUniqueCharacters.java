package week3day5;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class SubstringWithUniqueCharacters {
	
	/*
	 * Write a program to return the shortest substring having 
	 * all the unique characters of the string
	 * Input: "abbcfcb", output: "bcaf"
	 */
	
	/*
	 * Input: String
	 * Output: String
	 * Constraint: No constraints
	 * Test Data
	 * Positive: "abbcfcb"; Output: "bcaf"
	 * Negative: ""; Output: ""
	 * Edge: "aaaaaa"; Output: "a"
	 * Edge: "abc"; Output: "abc"
	 * 
	 * Approach: Using Hash set
	 * 
	 * O Notations
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 */
	
	@Test
	public void test1() {
		String input = "abbcfcb";
		Assert.assertEquals("abcf", findUniqueSubstring(input));
	}
	
	@Test
	public void test2() {
		String input = "";
		Assert.assertEquals("", findUniqueSubstring(input));
	}
	
	@Test
	public void test3() {
		String input = "aaaaaa";
		Assert.assertEquals("a", findUniqueSubstring(input));
	}
	
	@Test
	public void test4() {
		String input = "abc";
		Assert.assertEquals("abc", findUniqueSubstring(input));
	}
	
	/*
	 * Pseudo code
	 * If the string length is 0, return empty string
	 * Create a Hash set & String for output
	 * Traverse through the string
	 * 		If the set not contains the current value, add it
	 * Return the elements of a set to string
	 */
	
	private String findUniqueSubstring(String input) {
		if(input.length() == 0)
			return "";
		Set<Character> set = new HashSet<Character>();
		String output = "";
		for(int i = 0; i < input.length(); i++) {
			if(!set.contains(input.charAt(i))) {
				set.add(input.charAt(i));
				output += input.charAt(i);
			}
		}
		return output;
	}

}
