package week4day1;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class WordDictionary {
	/* Given a string s and a dictionary of strings wordDict, 
	 * return true if s can be segmented into a 
	 * space-separated sequence of one or more dictionary words.
	 * Note that the same word in the dictionary 
	 * may be reused multiple times in the segmentation.
	 */
	
	/*
	 * Input: String & String array
	 * Output: Boolean
	 * Constraint: Use Hashing
	 * Test data:
	 * Positive: String s = "leetcode", String[] wordDict = ["leet","code"]
	 * Output: true 
	 * Negative: String s = "applepenapple", String[] wordDict = ["apple","pen"]
	 * Output: true
	 * Edge: String s = "catsandog", String[] wordDict = ["cats","dog","sand","and","cat"]
	 * Output: false
	 * 
	 * Approach: Using Hash Map + Sliding Window
	 * 
	 *
	 * Time Complexity: O(n) + O(n*m)
	 * Space Complexity: O(n)
	 */
	
	
	
	@Test
	public void test1() {
		String s = "leetcode";
		String[] nums = {"leet","code"};
		Assert.assertEquals(true, findWordDictionary(s, nums));
	}
	
	@Test
	public void test2() {
		String s = "applepenapple";
		String[] nums = {"apple","pen"};
		Assert.assertEquals(true, findWordDictionary(s, nums));
	}
	
	@Test
	public void test3() {
		String s = "catsandog";
		String[] nums = {"cats","dog","sand","and","cat"};
		Assert.assertEquals(false, findWordDictionary(s, nums));
	}

	@Test
	public void test4() {
		String s = "abcdef";
		String[] nums = {"cats","dog","sand","and","cat"};
		Assert.assertEquals(false, findWordDictionary(s, nums));
	}
	
	
	/*
	 * Pseudo code
	 * Create a map 
	 * Add strings of the array to the map 
	 * Initialize left and right as zero
	 * Traverse through the string
	 * 	 Find map contains substring of right - left
	 * 	 If yes, add the count in value
	 * 	 Increment left as right 
	 * If left is not equal to right-1, return false
	 * Else return true
	 */
	
	private boolean findWordDictionary(String s, String[] nums) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < nums.length; i++)
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		int left = 0, right = 0;
		for(right = 1; right <= s.length(); right++) {
			if(map.containsKey(s.substring(left, right))) {
				map.put(s.substring(left, right), map.getOrDefault(s.substring(left, right), 0)+1);
				left = right;
			}
		}
		if(left != right-1)
			return false;
		else
			return true;
	}
}
