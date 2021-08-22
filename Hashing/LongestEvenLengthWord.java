/**
 * 
 */
package swiggy;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class LongestEvenLengthWord {

	/*
		 * Input: String
		 * Output: String
		 * Constraint: 
		 * Test Data:
		 * Positive: "Time to write great code"
		 * Output: "Time"
		 * Edge: "Is It"
		 * Output: "Is"
		 * Negative: "You win"
		 * Output: ""
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */

	@Test
	public void test1() {
		String str = "Time to write great code";
		Assert.assertEquals("Time", findLongestEvenWordOptimized(str));
	}

	@Test
	public void test2() {
		String str = "Is it";
		Assert.assertEquals("Is", findLongestEvenWordOptimized(str));
	}

	@Test
	public void test3() {
		String str = "You win";
		Assert.assertEquals("", findLongestEvenWordOptimized(str));
	}
	
	/*
	 * Pseudo code
	 * Create a tree map
	 * Convert the string to array 
	 * Traverse through the string
	 * 		Add string & even length
	 * Find max
	 * Return the key of the max value
	 * 		
	 * 		
	 */
	// Time Complexity: O(n); Space Complexity: O(n)
	
	private String findLongestEvenWord(String str) {
		if(str.length() == 0)
			return str;
		Map<String, Integer> map = new TreeMap<String, Integer>();
		String[] strArray = str.split(" ");
		for(int i = 0; i < strArray.length; i++) {
			if(strArray[i].length() %2 == 0)
				map.put(strArray[i], strArray[i].length());
		}
		if(map.isEmpty()) return "";
		int max = Collections.max(map.values());
		for(Entry<String, Integer> entry: map.entrySet()) {
			if(entry.getValue() == max)
				return entry.getKey();
		}
		return " ";
	}
	
	/*
	 * Pseudo code - Optimized
	 * Initialize max as 0
	 * Initialize maxWord as empty
	 * Traverse through the string
	 * 		If the current word's length is even & if it is greater than max
	 * 			Initialize max as current word's length
	 * 			maxWord as current word
	 * Return maxWord
	 */
	
	private String findLongestEvenWordOptimized(String str) {
		int max = 0; 
		String maxWord = "";
		String[] strArray = str.split("\\s+");
		for(int i = 0; i < strArray.length; i++) {
			if(strArray[i].length() %2 == 0 && strArray[i].length() > max) {
				max = strArray[i].length();
				maxWord = strArray[i];
			}
		}
		return maxWord;
	}
}
