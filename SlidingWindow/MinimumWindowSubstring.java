package week3day6;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class MinimumWindowSubstring {
	/*
	 * Given two strings s and t of lengths m and n respectively, 
	 * return the minimum window substring of s 
	 * such that every character in t (including duplicates) 
	 * is included in the window. If there is no such substring, 
	 * return the empty string "".
	 * The testcases will be generated such that the answer is unique.
	 * A substring is a contiguous sequence of characters within the string.
	 */
	
	/*
	 * Input: 2 Strings
	 * Output: String
	 * Constraint: No constraint
	 * 
	 * Test Data:
	 * Positive: "ADOBECODEBANC", "ABC" Output: "BANC"
	 * Edge: "a", "a" Output: "a"
	 * Negative: "a", "aa" Output: ""
	 * 
	 * Approach: Sliding Window & Hash Map
	 * 
	 * Time Complexity:
	 * Space Complexity:
	 */
	
	@Test
	public void test1() {
		String s = "ABAACBAB";
		String t = "ABC";
		Assert.assertEquals("ACB", findMinWindowSubstring(s,t));
	}
	
	@Test
	public void test2() {
		String s = "a";
		String t = "a";
		Assert.assertEquals("a", findMinWindowSubstring(s,t));
	}
	
	@Test
	public void test3() {
		String s = "a";
		String t = "aa";
		Assert.assertEquals("", findMinWindowSubstring(s,t));
	}
	
	/*
	 * Pseudo code
	 * If the length of t is greater than s
	 * 		return empty string
	 * Create a map and add character of string s to map until t length
	 * Initialize min length as 0
	 * Check the map contains characters of t using helper function
	 * If it contains, initialize min as t length
	 * Traverse through the string from length of t to s length-t length
	 * 		Add the current character to the map
	 * 		Check if the map contains characters of t using helper function
	 * 			Find min
	 * 		Remove first char from the map
	 * Return min
	 * 
	 * Helper function
	 * Traverse through the string
	 * 		If the current character not present in the map
	 * 			return false
	 * 		Remove the character from the map if the value is 0
	 * 		Substract the occurrence value from the map
	 * Return true
	 */
	
	private String findMinWindowSubstring(String s, String t) {
		if(t.length() > s.length())
			return "";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int min = Integer.MAX_VALUE;
		String output = "";
		for(int i = 0; i < t.length(); i++)
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		if(checkStringPresent(map, t)) {
			min = t.length()+1;
			output = s.substring(0,t.length());
		}
		int left = 0;
		for(int i = t.length(); i < s.length(); i++) {
			if(checkStringPresent(map, t)) {
				if(min > map.size()) {
					output = s.substring(left,i);
					min = output.length();
				}
				if(map.get(s.charAt(left)) == 1)
					map.remove(s.charAt(left));
				else
					map.put(s.charAt(left), map.getOrDefault(s.charAt(left), map.get(s.charAt(left))-1));
				left++;
			}
			else
				map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
				
		}
		return output;	
	}
	
	public boolean checkStringPresent(Map<Character, Integer> map, String t) {
		int left = t.length()-1;
		while(left!=-1) {
			if(!map.containsKey(t.charAt(left)))
				return false;
//			else {
//				if(map.get(t.charAt(left)) == 1)
//					map.remove(t.charAt(left--));
//				else {
//					map.put(t.charAt(left), map.getOrDefault(t.charAt(left), map.get(t.charAt(left))-1));
					left--;
//				}
//			}
		}
		return true;
	}
	
	

}
