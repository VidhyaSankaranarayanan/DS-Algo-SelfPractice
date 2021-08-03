/**
 * 
 */
package week3day6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class LastMatchingAnagram {

	/*
		 * Input: 2 strings
		 * Output: String
		 * Constraint: Sliding Window + Hash map
		 * Test Data:
		 * Positive: "abcbadefcba", "abc"
		 * Output: "cba"
		 * Edge: "abcd", "abcd"
		 * Output: "abcd"
		 * Negative: "abcd", "ef"
		 * Output: ""
		 * 
		 * Approach: Sliding Window + Hash Map
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(n)
		 */

	@Test
	public void test1() {
		String s1 = "abcbadefcba";
		String s2 = "abc";
		Assert.assertEquals("cba", findLastMatchingAnagramUsingASCII(s1,s2));
	}

	@Test
	public void test2() {
		String s1 = "abcd";
		String s2 = "abcd";
		Assert.assertEquals("abcd", findLastMatchingAnagramUsingASCII(s1,s2));
	}

	@Test
	public void test3() {
		String s1 = "abcd";
		String s2 = "ef";
		Assert.assertEquals("", findLastMatchingAnagramUsingASCII(s1,s2));
	}
	
	/*
	 * Pseudo code
	 * Create 2 maps
	 * Initialize output string
	 * Traverse until second string length
	 * 		Add strings to maps
	 * Check if maps are equal 
	 * 		Initialize output string with string 1 from 0 to string2's length
	 * Traverse through the string 1 from 1 to string1 length - string 2 length
	 * 		Remove first character from the map2 if the value is 1
	 * 		Else decrement the value by 1
	 * 		Add character at index + string2 length - 1
	 * 		Compare maps are equal 
	 * 			If yes, initialize substring from current index to index+string2 length
	 * Return output string
	 */
	
	private String findLastMatchingAnagram(String s1, String s2) {
		Map<Character, Integer> mapInput = new HashMap<Character, Integer>();
		Map<Character, Integer> mapPattern = new HashMap<Character, Integer>();
		String output = "";
		for(int i = 0; i < s2.length(); i++) {
			mapInput.put(s1.charAt(i), mapInput.getOrDefault(s1.charAt(i), 0)+1);
			mapPattern.put(s2.charAt(i), mapPattern.getOrDefault(s2.charAt(i), 0)+1);
		}
		if(mapInput.equals(mapPattern))
			output = s1.substring(0,s2.length());
		for(int i = 1; i < s1.length()-s2.length(); i++) {
			if(mapInput.get(s1.charAt(i-1))>1)
				mapInput.put(s1.charAt(i-1), mapInput.getOrDefault(s1.charAt(i-1), 0)-1);
			else
				mapInput.remove(s1.charAt(i-1));
			mapInput.put(s1.charAt(i+s2.length()-1), mapInput.getOrDefault(s1.charAt(i+s2.length()-1), 0)+1);
			if(mapInput.equals(mapPattern))
				output = s1.substring(i, i+s2.length());
		}
		return output;
	}
	
	/*
	 * Pseudo code
	 * Initialize an 2arrays of size 26 for s1, s2
	 * Initialize output string
	 * Traverse through the strings until s2 length
	 * 		Increment value at current character's index
	 * If both the arrays are equal
	 * 		Initialize output from substring of 0 to s2 length
	 * Traverse through the string from 1 to s1length-s2length
	 * 		Decrement first character's value
	 * 		Add next character
	 * 		If the arrays are equal 
	 * 			Find substring and initialize to output
	 * Return output
	 */
	
	private String findLastMatchingAnagramUsingASCII(String s1, String s2) {
		int[] asciiS1 = new int[128];
		int[] asciiS2 = new int[128];
		String output = "";
		for(int i = 0; i < s2.length(); i++) {
			asciiS2[s2.charAt(i)]++;
			asciiS1[s1.charAt(i)]++;
		}
		if(Arrays.equals(asciiS1, asciiS2))
			output = s1.substring(0, s2.length());
		for(int i = 1; i < s1.length()-s2.length(); i++) {
			asciiS1[s1.charAt(i+s2.length()-1)]++;
			asciiS1[s1.charAt(i-1)]--;
			if(Arrays.equals(asciiS1, asciiS2))
				output = s1.substring(i, i+s2.length());
		}
		return output;
	}
	
}
