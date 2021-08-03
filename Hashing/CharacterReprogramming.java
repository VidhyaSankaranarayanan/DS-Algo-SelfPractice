package assessment2;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class CharacterReprogramming {

	/*
	 * 
	 * 
	 * Input: String 
	 * Output: Integer
	 * Constraint: No
	 * 
	 * Test data set:
	 * Positive: "URDR"
	 * Output:2
	 * Edge: "RRR"
	 * Output:0
	 * Negative: "ULUDUULLUD"
	 * Output: 2
	 * 
	 * Approach: 
	 * Hash Map
	 * 
	 * 
	 * O Notations
	 */

	@Test
	public void test1() {
		String input = "URDR";
		Assert.assertEquals(2, findMaxDeletions(input));
	}
	
	@Test
	public void test2() {
		String input = "RRR";
		Assert.assertEquals(0, findMaxDeletions(input));
	}
	
	@Test
	public void test3() {
		String input = "ULUDUULLUD";
		Assert.assertEquals(4, findMaxDeletions(input));
	}
	
	@Test
	public void test4() {
		String input = "RURDL";
		Assert.assertEquals(4, findMaxDeletions(input));
	}
	
	/*
	 * Pseudo code
	 * Create a map
	 * Add character as key and value as map
	 * Check the current character & its matching char is present in the map
	 * 	If yes, check the value
	 * 		If 1, remove
	 * 		Else decrement the value
	 * 	increment count 
	 * Return count 
	 * 
	 */
	
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	
	private int findMaxDeletions(String input) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < input.length(); i++)
			map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0)+1);
		Map<Character, Character> mapPattern = new HashMap<Character, Character>();
		mapPattern.put('U', 'D');
		mapPattern.put('D', 'U');
		mapPattern.put('L', 'R');
		mapPattern.put('R', 'L');
		int count = 0;
		for(int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			char pattern = mapPattern.get(ch);
			if(map.containsKey(ch) && map.containsKey(pattern)) {
				if(map.get(ch) == 1)
					map.remove(ch);
				else
					map.put(ch, map.getOrDefault(ch, 0)-1);
				if(map.get(pattern) == 1)
					map.remove(pattern);
				else
					map.put(pattern, map.getOrDefault(pattern, 0)-1);
				count+=2;
			}
		}
		return count;
	}
}
