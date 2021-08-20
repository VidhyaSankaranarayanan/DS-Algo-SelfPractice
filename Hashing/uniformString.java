/**
 * 
 */
package assessment2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class uniformString {

	/*
		 * Input: String, Integer array, Integer
		 * Output: boolean array
		 * Constraint: 
		 * Test Data:
		 * Positive: "abbccaadf"; {4,2,5,3,7}; 5
		 * Output: {true, true, false, true, false}
		 * Edge: "aaabbbccc"; {3,2,1}
		 * Output: {true, true, true}
		 * Negative: "a"; {2}
		 * Output: {false}
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */

	@Test
	public void test1() {
		String input = "abbccaadf";
		int[] target = {4,2,5,3,7};
		int n = 5;
		Assert.assertTrue(Arrays.equals(new boolean[] {true, true, false, true, false}, findUniformStringOptimized(input, target, n)));
	}

	@Test
	public void test2() {
		String input = "aaabbbccc";
		int[] target = {3,2,1};
		int n = 3;
		Assert.assertTrue(Arrays.equals(new boolean[] {true, true, true}, findUniformStringOptimized(input, target, n)));	
	}

	@Test
	public void test3() {
		String input = "a";
		int[] target = {4};
		int n = 1;
		Assert.assertTrue(Arrays.equals(new boolean[] {false}, findUniformStringOptimized(input, target, n)));
	}
	
	/*
	 * Pseudo code
	 * Create 2 maps for alphabets and target values
	 * Add each character as key and values as current char - 97 to alphabets map
	 * Add each value as key, false as value to target
	 * Initialize 2 pointers left as 0, right as 0 and sum as value of first char in string
	 * Traverse through the string
	 * 		If map contains sum, change the value as true
	 * 		If value at left is not equal to right
	 * 			update left as right
	 * 			update sum as value of char at right
	 * 		Else add the value of chat at right to the sum 
	 * Return the target map's values
	 * 
	 * 
	 */
	
	// Time Complexity: O(n) -> n - String length
	// Space Complexity: O(n) -> n - String length
	
	private boolean[] findUniformString(String input, int[] target, int n) {
		Map<Character, Integer> alphabetMap = new HashMap<Character, Integer>();
		Map<Integer, Boolean> targetMap = new HashMap<Integer, Boolean>();
		for(int i = 0; i < input.length(); i++)
			alphabetMap.put(input.charAt(i), input.charAt(i)-97);
		for(int i = 0; i < target.length; i++)
			targetMap.put(target[i], false);
		int left = 0, right = 0, sum = alphabetMap.get(input.charAt(0));
		for(right = 0; right < input.length(); right++) {
			if(targetMap.containsKey(sum))
				targetMap.put(sum, true);
			if(input.charAt(left) != input.charAt(right)) {
				left = right;
				sum = alphabetMap.get(input.charAt(right));
			}
			else
				sum += alphabetMap.get(input.charAt(right));
		}
		boolean[] output = new boolean[n];
		for(int i = 0; i < n; i++)
			output[i] = targetMap.get(target[i]);
		return output;
	}
	
	/*
	 * Pseudo code - Optimized Solution
	 * Create a map for target and add each value as key and value as false
	 * Initialize 2 pointers left, right as 0 sum as value of char at first index
	 * Traverse through the string
	 * 		If the target contains the sum
	 * 			update the target value as true
	 * 		If value at left is not equal to right
	 * 			update left as right
	 * 			update sum as value of char at right
	 * 		Else add the value of chat at right to the sum
	 * Return the values of the target map
	 *
	 */
	
	// Time Complexity: O(m) -> String length
	// Space Complexity: O(n) -> Target length
	//aaabbbccc
	private boolean[] findUniformStringOptimized(String input, int[] target, int n) {
		Map<Integer, Boolean> targetMap = new HashMap<Integer, Boolean>();
		for(int i = 0; i < target.length; i++)
			targetMap.put(target[i], false);
		int left = 0, right = 0, sum = input.charAt(0)-96;
		for(right = 0; right < input.length(); right++) {
			if(targetMap.containsKey(sum))
				targetMap.put(sum, true);
			if(input.charAt(left) != input.charAt(right)) {
				left = right;
				sum = input.charAt(right)-96;
			}
			else
				sum += input.charAt(right)-96;
		}
		boolean[] output = new boolean[n];
		for(int i = 0; i < n; i++)
			output[i] = targetMap.get(target[i]);
		return output;
	}
}
