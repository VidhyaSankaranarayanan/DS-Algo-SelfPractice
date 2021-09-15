/**
 * 
 */
package twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class LongestWordInDictionary {

	/*
		 * Input: String & List of strings
		 * Output: String
		 * Constraint: 
		 * Test Data:
		 * Positive: "abpcplea", dictionary = ["ale","apple","monkey","plea"]
		 * Output: "apple"
		 * Edge: "abpcplea", dictionary = ["a","b","c"]
		 * Output: "a"
		 * Negative:
		 * Output: 
		 * 
		 * Approach: 2 pointers
		 * 
		 * Time Complexity: O(n*m)
		 * Space Complexity: O(n)
		 */

	@Test
	public void test1() {
		String s = "abpcplea";
		List<String> dictionary = new ArrayList<String>();
		dictionary.add("ale");
		dictionary.add("apple");
		dictionary.add("monkey");
		dictionary.add("plea");
		Assert.assertEquals("apple", findLongestWord(s, dictionary));
	}

	@Test
	public void test2() {
		String s = "abpcplea";
		List<String> dictionary = new ArrayList<String>();
		dictionary.add("a");
		dictionary.add("b");
		dictionary.add("c");
		Assert.assertEquals("a", findLongestWord(s, dictionary));
	}

	@Test
	public void test3() {
		String s = "aaa";
		List<String> dictionary = new ArrayList<String>();
		dictionary.add("aaa");
		dictionary.add("aa");
		dictionary.add("a");
		Assert.assertEquals("aaa", findLongest(s, dictionary));
	}
	
	/*
	 * Pseudo code
	 * Initialize max as 0
	 * Initialize maxString as empty string
	 * Traverse through the dictionary list
	 * 		Add each char as key & occurrence as value to the map
	 * 		Traverse through the string
	 * 			If the char is present in the map, add the char to the string
	 * 		Find the max between length & max
	 * 		Add the current dictionary word to maxString
	 * Return max String
	 */
	
	private String findLongestWord(String s, List<String> dictionary) {
		int max = 0;
		String maxString = "";
		for(int i = 0; i < dictionary.size(); i++) {
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			String temp = "";
			String curr = dictionary.get(i);
			for(int k = 0; k < curr.length(); k++)
				map.put(curr.charAt(k), map.getOrDefault(curr.charAt(k), 0)+1);
			for(int j = 0; j < s.length(); j++) {
				if(map.containsKey(s.charAt(j)))
					temp += s.charAt(j);
			}
			if(temp.length() > max || temp.length() == max && curr.compareTo(maxString) < 0) {
				max = temp.length();
				maxString = curr;
			}
		}
		return maxString;
	}
	
	private String findLongest(String s, List<String> dictionary) {
		int max = 0;
		String maxString = "";
		for(int i = 0; i < dictionary.size(); i++) {
			String temp = "";
			String curr = dictionary.get(i);
			int x = 0;
			for(int j = 0; j < s.length() && x < curr.length(); j++) {
				if(curr.charAt(x) == s.charAt(j))
					x++;
					if(x == curr.length()) temp = curr;
			}
			if(temp.length() > max || temp.length() == max && curr.compareTo(maxString) < 0) {
				max = temp.length();
				maxString = curr;
			}
		}
		return maxString;
	}
}
