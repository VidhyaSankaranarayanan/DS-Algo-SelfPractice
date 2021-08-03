/**
 * 
 */
package week3day1;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class LongestSubstrinWithoutRepetition {

	/*
		 * Input: String
		 * Output: Integer
		 * Constraint: Use HashMap & ASCII
		 * Test Data:
		 * Positive: "abcabcbb"
		 * Output: 3
		 * Edge: "bbbbb"
		 * Output: 1
		 * Negative: "pwwkew"
		 * Output: 3
		 * 
		 * Approach: Hash Map & ASCII
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */

	@Test
	public void test1() {
		String str = "abcabcbb";
		Assert.assertEquals(3, findLongestSubstring(str));
		Assert.assertEquals(3, findLongestSubstringUsingASCII(str));
	}

	@Test
	public void test2() {
		String str = "bbbbb";
//		Assert.assertEquals(1, findLongestSubstring(str));
		Assert.assertEquals(1, findLongestSubstringUsingASCII(str));
	}

	@Test
	public void test3() {
		String str = "pwwkew";
//		Assert.assertEquals(3, findLongestSubstring(str));
		Assert.assertEquals(3, findLongestSubstringUsingASCII(str));
	}
	
	/*
	 * Pseudo code
	 * Create a map
	 * Initialize left, right, max as 0
	 * Traverse through the string
	 * 		If the map not contains current character
	 * 			Add it to the map
	 * 		Else
	 * 			remove left character 
	 * 			Increment left
	 * 		Find max
	 * Return max
	 * 
	 */
	
	private int findLongestSubstring(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0, right = 0, max = 0;
		for(right = 0; right < str.length(); right++) {
			if(!map.containsKey(str.charAt(right)))
				map.put(str.charAt(right), right);
			else
				map.remove(str.charAt(left++));
			max = Math.max(max, map.size());
		}
		return max;
	}
	
	/*
	 * Pseudo code - ASCII
	 * Create an ascii array of size 128
	 * Initialize left as 0, right as 0, max as 0
	 * Traverse through the string
	 * 		Increment 1 to the current char's index
	 * 		Traverse until char at right > 1
	 * 			Increment left & decrement value [to remove duplicates]
	 * 		Find max
	 * Return max
	 */
	
	private int findLongestSubstringUsingASCII(String str) {
		int[] ascii = new int[128];
		int left = 0, right = 0, max = 0;
		for(right = 0; right < str.length(); right++) {
			ascii[str.charAt(right)]++;
			while(ascii[str.charAt(right)]>1)
				--ascii[str.charAt(left++)];
			max = Math.max(max, right-left+1);
		}
		return max;
	}
}
