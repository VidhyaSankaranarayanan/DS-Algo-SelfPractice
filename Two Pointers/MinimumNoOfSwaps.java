/**
 * 
 */
package twopointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class MinimumNoOfSwaps {

	/*
		 * Input: String
		 * Output: Integer
		 * Constraint: 
		 * Test Data:
		 * Positive: "][]["
		 * Output: 1
		 * Edge: "]]][[["
		 * Output: 2
		 * Negative: "[]"
		 * Output: 0
		 */

	@Test
	public void test1() {
		String s = "][][";
		Assert.assertEquals(1, findMinimumSwaps(s));
	}

	@Test
	public void test2() {
		String s = "]]][[[";
		Assert.assertEquals(2, findMinimumSwaps(s));
	}

	@Test
	public void test3() {
		String s = "[]";
		Assert.assertEquals(0, findMinimumSwaps(s));
	}
	
	/*
	 * Pseudo code
	 * Initialize count as 0 and swap as 0
	 * Traverse through the string
	 * 		If the current element is ']', decrement the count
	 * 		If the current element is '[', increment the count
	 * 		Find max between count & max
	 * Return max+1/2
	 */
	
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	
	private int findMinimumSwaps(String s) {
		int count = 0, max = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ']')
				count++;
			if(s.charAt(i) == '[') count--;
			max = Math.max(count, max);
		}
		return (max + 1)/2;
	}
	
//	private int findMinimumSwapsUsing2pointer(String s) {
//		int lcount = 0, rcount = 0, max = 0, left = 0, right = s.length()-1;
//		while(left < right) {
//			if(s.charAt(left) == ']')
//				lcount++;
//			if(s.charAt(left++) == '[') lcount--;
//			max = Math.max(lcount, max);
//			if(s.charAt(right) == ']') rcount++;
//			if(s.charAt(right--) == '[') rcount--;
//			max = Math.max(rcount, max);
//		}
//		return (max + 1)/2;
//	}
}
