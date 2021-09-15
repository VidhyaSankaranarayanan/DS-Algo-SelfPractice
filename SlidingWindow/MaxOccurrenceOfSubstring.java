/**
 * 
 */
package slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class MaxOccurrenceOfSubstring {

	/*
		 * Input: String, Integers
		 * Output: Integer
		 * Constraint: 
		 * Test Data:
		 * Positive: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4 
		 * Output: 2
		 * Edge: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
		 * Output: 2
		 * Negative: s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
		 * Output: 3
		 * 
		 * Approach: Sliding Window + Hash Map
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(n)
		 */

	@Test
	public void test1() {
		String s = "aababcaab";
		int maxLetters = 2, minSize = 3, maxSize = 4;
		Assert.assertEquals(2, findMaxOccurrence(s, maxLetters, minSize, maxSize));
	}

	@Test
	public void test2() {
		String s = "aaaa";
		int maxLetters = 1, minSize = 3, maxSize = 3;
		Assert.assertEquals(2, findMaxOccurrence(s, maxLetters, minSize, maxSize));
	}

	@Test
	public void test3() {
		String s = "aabcabcab";
		int maxLetters = 2, minSize = 2, maxSize = 3;
		Assert.assertEquals(3, findMaxOccurrence(s, maxLetters, minSize, maxSize));
	}
	
	@Test
	public void test4() {
		String s = "abcde";
		int maxLetters = 2, minSize = 3, maxSize = 3;
		Assert.assertEquals(0, findMaxOccurrence(s, maxLetters, minSize, maxSize));
	}
	
	@Test
	public void test5() {
		String s = "abcabababacabcabc";
		int maxLetters = 3, minSize = 3, maxSize = 10;
		Assert.assertEquals(3, findMaxOccurrence(s, maxLetters, minSize, maxSize));
	}
	
	/*
	 * Pseudo code
	 * Create 2 hash map
	 * Initialize start & end as 0
	 * Add first char to the map
	 * Traverse through the string until end < length
	 * 		If end-start+1 < maxSize
	 * 			increment end & add char & occurrence to the map
	 * 		If map.size <= maxLetters & end-start+1 >= minSize & <= maxSize
	 * 			Add the substring to the map with the occurrence
	 * 			Remove the char at start & increment it
	 * 		Else
	 * 			Remove the char at start & increment it
	 * Return the length of the key with max Value
	 */
	
	private int findMaxOccurrence(String s, int maxLetters, int minSize, int maxSize) {
		Map<Character, Integer> mapC = new HashMap<Character, Integer>();
		Map<String, Integer> mapS = new HashMap<String, Integer>();
		int start = 0, end = 1;
		mapC.put(s.charAt(0), 1);
		while(start < s.length()) {
			if(end-start < minSize && end < s.length())
				mapC.put(s.charAt(end), mapC.getOrDefault(s.charAt(end++), 0)+1);
			else {
				if(mapC.get(s.charAt(start)) > 1)
					mapC.put(s.charAt(start), mapC.getOrDefault(s.charAt(start), 0)-1);
				else
					mapC.remove(s.charAt(start));
				start++;
			}
			if(mapC.size() <= maxLetters && end-start >= minSize)
				mapS.put(s.substring(start, end), mapS.getOrDefault(s.substring(start, end), 0)+1);
		}
		if(mapS.size() == 0) return 0;
		return Collections.max(mapS.values());
	}
}
