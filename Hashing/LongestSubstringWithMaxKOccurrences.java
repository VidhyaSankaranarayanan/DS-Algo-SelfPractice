package week3day1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class LongestSubstringWithMaxKOccurrences {

	/*
	 * find the max substring in the given string of k max occurrences
	 * eceba k=2
	 * Output: 3
	 */
	
	/*
	 * Input: String, Integer
	 * Output: Integer
	 * Constraint: Use sliding window with HashMap & ASCII
	 * Test Data
	 * Positive: "eceba", k = 2
	 * Output: 3
	 * Edge: "aabab", k = 2
	 * Output: 5
	 * Negative: "", k = 1
	 * Output: Empty string
	 * 
	 * Approach: Hash Map
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	
	@Test
	public void test1() {
		String str = "eceba";
		int k = 2;
		Assert.assertEquals(3, findLongestSubstring(str, k));
		Assert.assertEquals(3, findLongestSubstringUsingASCII(str, k));
	}
	
	@Test
	public void test2() {
		String str = "aabab";
		int k = 2;
		Assert.assertEquals(5, findLongestSubstring(str, k));
		Assert.assertEquals(5, findLongestSubstringUsingASCII(str, k));
	}
	
	@Test
	public void test3() {
		String str = "";
		int k = 2;
		Assert.assertEquals(0, findLongestSubstring(str, k));
		Assert.assertEquals(0, findLongestSubstringUsingASCII(str, k));
	}
	
	/*
	 * Pseudo code - Hash Map
	 * Check if the string is empty
	 * 		return string
	 * Create a map
	 * Initialize max as 0, left as 0, right as 0
	 * Traverse through the string from 0 to string length
	 * 		Add current element to the map
	 * 		If the map's size is greater than k
	 * 			remove first element
	 * 			Increment left
	 * 		Find max
	 * Return max
	 * 
	 */
	
	private int findLongestSubstring(String str, int k) {
		if(str.length() == 0)
			return str.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0, left = 0, right = 0;
		for(right = 0; right < str.length(); right++) {
			map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0)+1);
			if(map.size() > k) {
				if(map.get(str.charAt(left))==0)
					map.remove(str.charAt(left));
				else
					map.put(str.charAt(left), map.getOrDefault(str.charAt(left), 0)-1);
				left++;
			}
			max = Math.max(max, right-left+1);
		}
		return max;
	}
	
	/*
	 * Pseudo code - ASCII
	 * Create an array of size 128
	 * Initialize left, right, max and unique as 0
	 * Traverse through the string
	 * 		If the current element value is 0
	 * 			Add 1 to the corresponding index
	 * 			Increment unique
	 * 		Else
	 * 			Add 1 to the corresponding index
	 * 		If unique is greater than k
	 * 			Decrement value at left and increment left
	 * 			Decrement unique
	 * 		Find max
	 * Return max
	 */			
	
	private int findLongestSubstringUsingASCII(String str, int k) {
		int[] ascii = new int[128];
		int left = 0, right = 0, unique = 0, max = 0;
		for(right = 0; right < str.length(); right++) {
			if(ascii[str.charAt(right)] == 0) {
				ascii[str.charAt(right)]++;
				unique++;
			}
			else
				ascii[str.charAt(right)]++;
			if(unique > k) {
				while(--ascii[str.charAt(left++)]>0)
					unique--;
			}
			max = Math.max(max, right-left+1);
		}
		return max;
	}
}
