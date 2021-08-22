package swiggy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;



public class UniqueCharacter {
	/**
	 * Input- String Output - int
	 * 
	 */
	//-->2 mins
	@Test
	public void test1() {
		String str = "statistics";
		Assert.assertEquals(3, findUniqueUsingStringFunction(str));
	}

	@Test
	public void test2() {
		String str = "q";
		Assert.assertEquals(1, findUniqueUsingStringFunction(str));
	}

	@Test
	public void test3() {
		String str = "qrstqrst";
		Assert.assertEquals(-1, findUniqueUsingStringFunction(str));
	}

	/**
	 * -->3 mins Intialize a map with character and index Intialize a set and store
	 * the character Iterate from 0 index to str length push in the set and map
	 * alsong with the index If the character appears again remove from set and map
	 * get the min index from map
	 * 
	 * 
	 * 
	 * 
	 *
	 * @param str
	 * @return
	 */
	// Coding --> 3 mins Debugging --> 3 mins

	// Time complexity --> O(n) Space --> O(n)
	private int findUniq(String str) {
		Map<Character, Integer> charIndex = new HashMap<Character, Integer>();
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) { // O(n)
			if (set.contains(str.charAt(i))) {
				set.remove(str.charAt(i));
				charIndex.remove(str.charAt(i));
			} else {
				set.add(str.charAt(i));
				charIndex.put(str.charAt(i), i + 1);
			}
		}
		if (!charIndex.isEmpty()) {
			for (Entry<Character, Integer> entrySet : charIndex.entrySet()) // O(1)
				return entrySet.getValue();
		}
		return -1;
	}
	
	/*
	 * Pseudo code - Using String function
	 * Traverse through the string
	 * 		If the first index & last index of the current character is same
	 * 			Return i+1
	 * Return -1
	 */
	
	private int findUniqueUsingStringFunction(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i)))
				return i+1;
		}
		return -1;
	}
}