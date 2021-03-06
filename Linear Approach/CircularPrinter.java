package swiggy;

import org.junit.Assert;
import org.junit.Test;

public class CircularPrinter {
	/**
	 * Input -String[] Output - int
	 * 
	 */
	@Test
	public void test1() {
		String str = "BZA";
		Assert.assertEquals(4, findCircularDistance(str));

	}

	@Test
	public void test2() {
		String str = "AA";
		Assert.assertEquals(0, findCircularDistance(str));

	}

	@Test
	public void test3() {
		String str = "AE";
		Assert.assertEquals(4, findCircularDistance(str));

	}

	@Test
	public void test4() {
		String str = "QL"; // AQL
		Assert.assertEquals(15, findCircularDistance(str));

	}

	@Test
	public void test5() {
		String str = "EE";
		Assert.assertEquals(4, findCircularDistance(str));

	}

	/**
	 * --> Test data + pseudo code - 6 mins Initialize distance as 0
	 * 
	 * Traverse from the string get current ASCII character - 96 Initialize asciidiff
	 * current value- ascii value of a Initialise freq-->find 26- ascii difference
	 * 
	 * find min of asciidiff and freq and add to distance
	 * 
	 * return distance
	 * 
	 * @param str
	 * @return
	 * 
	 * Coding --> 3 mins
	 * Debugging --> 6 mins
	 * 
	 * Time Complexity - O(n) Space Complexity - O(1)
	 */
	private int findDis(String str) {
		int distance = 0;
		// TODO Auto-generated method stub

		for (int i = 0; i < str.length(); i++) {
			int asciiDiff = 0;
			if (i == 0) // First time alone get distance from A
				asciiDiff = Math.abs((int) str.charAt(i) - 65);
			else // get distance from previous character
				asciiDiff = Math.abs((int) str.charAt(i) - (int) str.charAt(i - 1));
			int freq = 26 - asciiDiff;
			int min = Math.min(asciiDiff, freq);
			distance += min;
		}
		return distance;
	}
	
	private int findCircularDistance(String str) {
		int distance = 0;
		int currentChar = (int)'A';
		for(int i = 0; i < str.length(); i++) {
			int ascii = Math.abs((int) str.charAt(i) - currentChar);
			int diff = 26 - ascii;
			int min = Math.min(ascii, diff);
			distance += min;
			currentChar = str.charAt(i);
		}
		return distance;		
	}
}