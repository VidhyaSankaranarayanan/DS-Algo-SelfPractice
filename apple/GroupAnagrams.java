/**
 * 
 */
package apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class GroupAnagrams {

	/*
		 * Input: Array of strings
		 * Output: List of List of strings
		 * Constraint: 
		 * Test Data: 
		 * Positive: ["eat","tea","tan","ate","nat","bat"]
		 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
		 * Edge: ["a"]
		 * Output: [["a"]]
		 * Negative:[""]
		 * Output: [[""]]
		 * 
		 * Approach: Hash Map + ASCII
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(n)
		 */

	@Test
	public void test1() {
		String[] str = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(findAnagrams(str));
	}

	@Test
	public void test2() {
		String[] str = {""};
		System.out.println(findAnagrams(str));
	}

	@Test
	public void test3() {
		String[] str = {"a"};
		System.out.println(findAnagrams(str));
	}
	
	/*
	 * Pseudo code
	 * Create a hash map
	 * Traverse through the string
	 * 		Create an ascii array of size 26
	 * 		Initialize temp as current string
	 * 		Traverse through the temp
	 * 			Update the ascii array
	 * 		Create a list of string
	 * 		If map contains ascii array
	 * 			update the value
	 * 		Else add the key & value to the map
	 * Return the values of the map
	 */
	
	private List<List<String>> findAnagrams(String[] str){
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(int i = 0; i < str.length; i++) {
			int[] ascii = new int[26];
			String temp = str[i];
			for(int j = 0; j < temp.length(); j++)
				ascii[temp.charAt(j) - 97]++;
			List<String> list = new ArrayList<String>();
			if(map.containsKey(Arrays.toString(ascii))){
				list.addAll(map.get(Arrays.toString(ascii)));
				list.add(temp);
				map.put(Arrays.toString(ascii), list);
			}
			else {
				list.add(temp);
				map.put(Arrays.toString(ascii), list);
			}
		}
		return new ArrayList<>(map.values());
	}
}
