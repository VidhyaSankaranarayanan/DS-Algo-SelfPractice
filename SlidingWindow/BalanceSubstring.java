/**
 * 
 */
package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class BalanceSubstring {

	/*
	 * Input: String
	 * Output: Integer
	 * Constraint: 
	 * Test Data:
	 * Positive: "QWER"
	 * Output: 0
	 * Edge: "QQWE"
	 * Output: 1
	 * Negative: "QQQW"
	 * Output: 2
	 * 
	 * Approach: Using Hash Map + Sliding Window
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(m)
	 */

	@Test
	public void test1() {
		String s = "QWER";
		Assert.assertEquals(0, balanceSubString(s));
	}

	@Test
	public void test2() {
		String s = "QQWE";
		Assert.assertEquals(1, balanceSubString(s));
	}

	@Test
	public void test3() {
		String s = "WWEQERQWQWWRWWERQWEQ";
		Assert.assertEquals(4, balanceSubString(s));
	}

	@Test
	public void test4() {
		String s = "WQWRQQQW";
		Assert.assertEquals(3, balanceSubString(s));
	}

	@Test
	public void test5() {
		String s = "QQWQRRWRRQWWEWRQEREWQQWQREWRWQRQRWRQEQWE";
		Assert.assertEquals(4, balanceSubString(s));
	}

	/*
	 * Pseudo code
	 * Create a hash set
	 * Traverse through the string
	 * 		Add each character to the set
	 * Return 4 - set's size
	 */

	private int balanceString(String s) {
		Set<Character> set = new HashSet<Character>();
		for(int i = 0; i < s.length(); i++)
			set.add(s.charAt(i));
		return 4-set.size();
	}

	/*
	 * Pseudo code
	 * Create a hash map
	 * Traverse through the string
	 * 		Add each character and its occurrence to the map
	 * Find n/4 as length & initialize sum as 0
	 * Traverse through the map
	 * 		If value of each character is greater than length
	 * 			subtract length - value and add it to the sum
	 * Return sum
	 */

	private int balanceStringHashMap(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++)
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		int length = s.length()/4;
		int sum = 0;
		for(Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() > length)
				sum += entry.getValue()-length;
		}
		return sum;
	}

	/*
	 * Pseudo code
	 * Calculate length as n/4
	 * Initialize 4 variables for Q,W,E,R count as 0
	 * Initialize a hash map and add characters as key & value as 0
	 * Traverse through the string
	 * 		Find count of each character and update the value with count-1/4th length
	 * If the values of all the characters in the map is 0, return 0
	 * Initialize min, start, end as 0
	 * Traverse through the string
	 * 		Decrement the value of the end char in the map to remove the extra characters [Expand the window]
	 * 		If values of all the characters in the map <= 0 [Substring contains same number of extra characters]
	 * 			Find min value btw min value & end-start+1
	 * 			Increment the value of the character at start
	 * 			Increment start 
	 * Return min
	 */

	private int balanceSubString(String s) {
		int length = s.length()/4;
		int q = 0, w = 0, e = 0, r = 0;
		Map<Character, Integer> mapP = new HashMap<Character, Integer>();
		mapP.put('Q', 0);
		mapP.put('W', 0);
		mapP.put('E', 0);
		mapP.put('R', 0);
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'Q') {
				q++;
				mapP.put('Q', q-length);
			}
			else if(s.charAt(i) == 'W') {
				w++;
				mapP.put('W', w-length);
			}
			else if(s.charAt(i) == 'E') {
				e++;
				mapP.put('E', e-length);
			}
			else if(s.charAt(i) == 'R') {
				r++;
				mapP.put('R', r-length);
			}
		}
		if(mapP.get('Q') <= 0 && mapP.get('W') <= 0 && mapP.get('E') <= 0 && mapP.get('R') <= 0) return 0;
		int min = Integer.MAX_VALUE, start = 0, end = 0;
		for(end = 0; end < s.length(); end++) {
			mapP.put(s.charAt(end), mapP.getOrDefault(s.charAt(end), 0)-1);
			while(mapP.get('Q') <= 0 && mapP.get('W') <= 0 && mapP.get('E') <= 0 && mapP.get('R') <= 0) {
				min = Math.min(min, end-start+1);
				mapP.put(s.charAt(start), mapP.getOrDefault(s.charAt(start++), 0)+1);
			}
		}
		return min;
	}
}
