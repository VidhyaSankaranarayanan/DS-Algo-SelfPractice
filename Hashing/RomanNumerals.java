package week3day6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class RomanNumerals {
	
	/*
	 * Roman numerals are represented by seven different symbols: 
	 * I, V, X, L, C, D and M.
	 * Symbol       Value
	 * I             1
	 * V             5
	 * X             10
	 * L             50
	 * C             100
	 * D             500
	 * M             1000
	 * For example, 2 is written as II in Roman numeral, 
	 * just two one's added together. 12 is written as XII, 
	 * which is simply X + II. The number 27 is written as XXVII, 
	 * which is XX + V + II.
	 * Roman numerals are usually written largest to smallest from left to right. 
	 * However, the numeral for four is not IIII. 
	 * Instead, the number four is written as IV. 
	 * Because the one is before the five we subtract it making four. 
	 * The same principle applies to the number nine, which is written as IX. 
	 * There are six instances where subtraction is used:
	 * I can be placed before V (5) and X (10) to make 4 and 9. 
	 * X can be placed before L (50) and C (100) to make 40 and 90. 
	 * C can be placed before D (500) and M (1000) to make 400 and 900.
	 * Given a roman numeral, convert it to an integer.
	 */
	
	/*
	 * Input: String
	 * Output: Integer
	 * Constraint: No Constraint
	 * 
	 * Test Data
	 * Positive: IV - 4
	 * LVIII - 58
	 * MCMXCIV - 1994
	 * Edge: IVIVIV - 444 
	 * Negative: XLX
	 * 
	 * Approach : Using Hash Map
	 * 
	 * Time Complexity: 
	 * Space Complexity:
	 */

	@Test
	public void test1() {
		String input = "IV";
		Assert.assertEquals(4, findInteger(input));
	}
	
	@Test
	public void test2() {
		String input = "LVIII";
		Assert.assertEquals(58, findInteger(input));
	}
	
	@Test
	public void test3() {
		String input = "MCMXCIV";
		Assert.assertEquals(1994, findInteger(input));
	}
	
		
	@Test
	public void test4() {
		String input = "XLIV";
		Assert.assertEquals(44, findInteger(input));
	}
	
	@Test
	public void test5() {
		String input = "MCDXLIV";
		Assert.assertEquals(1444, findInteger(input));
	}

	
	
	/*
	 * Pseudo code
	 * Initialize an integer for output
	 * Create a hash map
	 * Add Roman numerals as key & its value as value
	 * Traverse through the String
	 * 		If the current character is there in the map, & if it is lesser
	 * 		than previous value
	 * 			Add its value to the output
	 * 		Else
	 * 			Subtract previous value from the integer & 
	 * 			add current value & subtract previous value from current value
	 * Return output
	 */
	
	private int findInteger(String input) {
		int output = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		output = map.get(input.charAt(0));
		for(int i = 1; i < input.length(); i++) {
			int prev = map.get(input.charAt(i-1)), next = map.get(input.charAt(i));
			if(map.containsKey(input.charAt(i)) && prev >= next)
				output += map.get(input.charAt(i));
			else
				output = output - prev + next - prev;
		}
		return output;
	}
	
	

}
