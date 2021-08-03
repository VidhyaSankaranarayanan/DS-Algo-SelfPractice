package week3day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class StringPermutation {
	
	/*
	 * Given two strings s1 and s2, return true if s2 contains the permutation of s1.
	 * In other words, one of s1's permutations is the substring of s2.
	 * 
	 * Example 1:
	 * Input: s1 = "ab", s2 = "eidbaooo"
	 * Output: true
	 * Explanation: s2 contains one permutation of s1 ("ba").
	 * Example 2:
	 * Input: s1 = "ab", s2 = "eidboaoo"
	 * Output: false
	 */
	
	/*
	 * Input: 2 strings
	 * Output: boolean
	 * Constraint: Brute Force & Sliding Window 
	 * Test data
	 * s1 = "ab", s2 = "eidbaooo" -> Output: true
	 * s1 = "xy", s2 = "eidbaooo" -> Output: false
	 * s1 = "abcd", s2 = "dbac" -> Output: true
	 * s1 = "ab", s2 = "eidbaooo" -> Output: false
	 */

	@Test
	public void test1() {
		String s1 = "ab";
		String s2 = "eidbaooo";
		Assert.assertEquals(true, findStringPermutationUsingBruteForce(s1, s2));
		Assert.assertEquals(true, findStringPermutationUsingSlidingWindow(s1, s2));
	}
	
	@Test
	public void test2() {
		String s1 = "abc";
		String s2 = "aaa";
		Assert.assertEquals(false, findStringPermutationUsingBruteForce(s1, s2));
		Assert.assertEquals(false, findStringPermutationUsingSlidingWindow(s1, s2));
	}
	
	@Test
	public void test3() {
		String s1 = "ab";
		String s2 = "eidboaooo";
		Assert.assertEquals(false, findStringPermutationUsingBruteForce(s1, s2));
		Assert.assertEquals(false, findStringPermutationUsingSlidingWindow(s1, s2));
	}
	
	@Test
	public void test4() {
		String s1 = "abcd";
		String s2 = "mnoiabddaacbd";
		Assert.assertEquals(true, findStringPermutationUsingBruteForce(s1, s2));
		Assert.assertEquals(true, findStringPermutationUsingSlidingWindow(s1, s2));
	}
	
	@Test
	public void test5() {
		String s1 = "acc";
		String s2 = "zxeaabbcacabcba";
		Assert.assertEquals(true, findStringPermutationUsingBruteForce(s1, s2));
		Assert.assertEquals(true, findStringPermutationUsingSlidingWindow(s1, s2));
	}
	@Test
	public void test6() {
		String s1 = "acc";
		String s2 = "bdacdecca";
		Assert.assertEquals(true, findStringPermutationUsingBruteForce(s1, s2));
		Assert.assertEquals(true, findStringPermutationUsingSlidingWindow(s1, s2));
	}
	
	
	
	
	
	/*
	 * Pseudo code
	 * Create a Character list and add characters of s1 to the list
	 * Initialize count as 0
	 * Traverse through s2
	 * 		Initialize count as list size
	 * 		If list contains char at current index of s2, 
	 * 			Traverse until count becomes 0
	 * 			Return true
	 * Return false
	 */
	
	/* Below method is failing for below data, because it is checking 'a' in the list and returning true
	 * String s1 = "abc";
	 * String s2 = "aaa";
	 */
	
	// Time Complexity: O(m+n)
	// Space Complexity: O(m)
	
	private boolean findStringPermutation(String s1, String s2) {
		List<Character> charList = new ArrayList<Character>();
		int count = 0;
		for(int i = 0; i < s1.length(); i++) 
			charList.add(s1.charAt(i));
		for(int i = 0; i < s2.length(); i++) {
			count = charList.size();
			if(charList.contains(s2.charAt(i))) {
				while(count != 0) {
					if(!charList.contains(s2.charAt(i++)))
						break;
					else 
						count--;
				}
				if(count == 0)
					return true;
			}
		}
		return false;
	}
	
	/*
	 * Pseudo code
	 * Convert s1 to array & sort it
	 * Create another array s2 of size s1
	 * Traverse through the string s2
	 * 		Traverse through the string from i to i + s1 length
	 * 		Add characters to s2 array & sort it
	 * 		Compare with s1 array 
	 * 			If yes, return true
	 * Return false
	 * 
	 */
	
	// Time Complexity: O(n*m) + O(nlogn)
	// Space Complexity: O(m)
	
	private boolean findStringPermutationUsingBruteForce(String s1, String s2) {
		char[] s1Array = s1.toCharArray();
		Arrays.sort(s1Array);
		char[] s2Array = new char[s1.length()];
		for(int i = 0; i <= s2.length()-s1.length(); i++) {
			int index = 0;
			for(int j = i; j < i + s1.length(); j++) 
				s2Array[index++] = s2.charAt(j);
			Arrays.sort(s2Array);
			if(Arrays.equals(s1Array, s2Array))
				return true;
		}
		return false;
	}
	
	/*
	 * Pseudo code - Sliding Window + Hash Map
	 * Create 2 maps for s1 & s2
	 * Add characters as key & occurrence as elements of s1 in s1map & elements of s2 till s1 length
	 * Check if 2 maps are equal
	 * 		If yes, return true
	 * Traverse through the string from s1length to s2-s1length
	 * 		if the value of element at first index is 0	
	 * 			Remove the element from the map
	 * 		else
	 * 			Decrement the value by 1
	 * 		Add next element to the s2map
	 * 		Compare s1 & s2 map
	 * 			If equal, return true
	 * Return false 
	 * 		
	 * 		
	 */
	/*
	 * String s1 = "abcd";
	 * String s2 = "mnoiabddaacbd";
	 */
	
	// Time Complexity: O(n)
	// Space Complexity: O(2m) -> O(m)
	
	private boolean findStringPermutationUsingSlidingWindow(String s1, String s2) {
		Map<Character, Integer> mapS1 = new HashMap<Character, Integer>();
		Map<Character, Integer> mapS2 = new HashMap<Character, Integer>();
		for(int i = 0; i < s1.length(); i++) {
			mapS1.put(s1.charAt(i), mapS1.getOrDefault(s1.charAt(i), 0)+1);
			mapS2.put(s2.charAt(i), mapS2.getOrDefault(s2.charAt(i), 0)+1);
		}
		if(mapS1.equals(mapS2)) return true;
		int k = s1.length();
		for(int i = k; i < s2.length(); i++) {
			if(mapS2.get(s2.charAt(i-k)) == 1)
				mapS2.remove(s2.charAt(i-k));
			else
				mapS2.put(s2.charAt(i-k), mapS2.getOrDefault(s2.charAt(i-k), 0)-1);
			mapS2.put(s2.charAt(i), mapS2.getOrDefault(s2.charAt(i), 0)+1);
			if(mapS1.equals(mapS2))
				return true;
		}
		return false;
	}
}
