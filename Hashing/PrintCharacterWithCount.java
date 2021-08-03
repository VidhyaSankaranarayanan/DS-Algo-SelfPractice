package week3day5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class PrintCharacterWithCount {
	
	/*
	 * Given a string str = "aabbccddde"; output: "a2b2c2d3e1"
	 * 
	 * Input: String
	 * Output: String
	 * Constraint: No
	 * 
	 * Test data set:
	 * Positive: "aabbccddde", output: "a2b2c2d3e1"
	 * Edge: "aaaaa", output: "a5"
	 * Negative: "", output: "" 
	 * 
	 * Approach: Brute Force
	 * Hash Map
	 * 
	 * 
	 * O Notations
	 */

	@Test
	public void test1() {
		String input = "aabbccddde";
		Assert.assertEquals("a2b2c2d3e1", findNoOfCharacters(input));
	}
	
	@Test
	public void test2() {
		String input = "aaaaa";
		Assert.assertEquals("a5", findNoOfCharacters(input));
	}
	
	@Test
	public void test3() {
		String input = "";
		Assert.assertEquals("", findNoOfCharacters(input));
	}
	
	/*
	 * Pseudo code
	 * If length of the string is 0, return empty string
	 * Create a map and char as key & count as value
	 * Create an output string
	 * Traverse through the map using entry Set 
	 * 	Add the current character & its value to the string
	 * Return the string
	 */
	
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	
	private String findNoOfCharacters(String input) {
		if(input.length() == 0)
			return "";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		StringBuilder output = new StringBuilder();
		for(int i = 0; i < input.length(); i++)
			map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0)+1);
		for(Entry<Character, Integer> entry : map.entrySet()) 
			output.append(entry.getKey()).append(entry.getValue());
		return output.toString();
	}

}
