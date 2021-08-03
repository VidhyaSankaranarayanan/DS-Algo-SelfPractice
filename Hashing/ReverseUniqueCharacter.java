package week3day4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ReverseUniqueCharacter {
	
	/*
	 * Input: char array
	 * Output: char array
	 * Constraint: 
	 * 
	 * Test data set:
	 * Positive: {'b','b','d','h','e','h'}, ; Output: {'e','d'}
	 * Edge: {'b','d','f','h','j'}; Output: {'j','h','f','d','b'}
	 * Edge: {'b','b','b'}; Output: {}
	 * 
	 * Approach: Brute Force
	 * 
	 * 
	 * O Notations
	 */

	@Test
	public void test1() {
		char[] arr = {'b','b','d','h','e','h'};
		reverseUniqueCharacters(arr);
		//Assert.assertTrue(Arrays.equals(new char[] {'e', 'd'}, reverseUniqueCharacters(arr)));
	}
	
	@Test
	public void test2() {
		char[] arr = {'b','d','f','h','j'};
		reverseUniqueCharacters(arr);
		//Assert.assertTrue(Arrays.equals(new char[] {'j','h','f','d','b'}, reverseUniqueCharacters(arr)));
	}
	
	@Test
	public void test3() {
		char[] arr = {'b','b','b'};
		reverseUniqueCharacters(arr);
		//Assert.assertTrue(Arrays.equals(new char[] {}, reverseUniqueCharacters(arr)));
	}

	
		
	/*
	 * Pseudo code
	 * Create a hash map & add char as key & count as value
	 * Create a list for output
	 * Traverse through the char array from last to 0
	 * 		If the current character's value is 1, add it to the list
	 * Return list 
	 *
	 * 
	 */
	
	private String reverseUniqueCharacters(char[] arr) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		List<Character> list = new ArrayList<Character>();
		for(int i = 0; i < arr.length; i++)
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		for(int i = arr.length-1; i >= 0; i--) {
			if(map.get(arr[i])==1)
				list.add(arr[i]);
		}
		System.out.println(list.toString());
		return list.toString();
	}

}
