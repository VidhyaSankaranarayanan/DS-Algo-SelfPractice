/**
 * 
 */
package week6day1;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class DecodeString {

	/*
		 * Input: String
		 * Output: String
		 * Constraint: Use Recursion
		 * Test Data:
		 * Positive: 3[a2[bc]]
		 * Output: abcbcabcbcabcbc 
		 * Edge: 3[a]2[bc]
		 * Output: aaabcbc 
		 * Negative: [ac]
		 * Output: ac
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */

	@Test
	public void test1() {
		String str = "3[a2[bc]]";
		Assert.assertEquals("abcbcabcbcabcbc", decodeString(str));
	}

	@Test
	public void test2() {
		String str = "3[a]2[bc]";
		Assert.assertEquals("aaabcbc", decodeString(str));
	}

	@Test
	public void test3() {
		String str = "[ac]";
		Assert.assertEquals("ac", decodeString(str));
	}
	/*
	 * Base condition: if string not contains ']', return input
	 * Find the index of first closing bracket
	 * Find the last index of opening bracket from the substring of 0 to closing bracket
	 * Store the string from open bracket to close bracket
	 * Get the number from open bracket index - 1
	 * Append the string to the output string builder until number becomes 0
	 * Insert the string from 0 to number before the string builder
	 * Add the remaining after close bracket to the string builder
	 * Convert the string builder to string and recursively call
	 * 
	 */
	
	private String decodeString(String str) {
		if(!str.contains("]"))
			return str;
		StringBuilder output = new StringBuilder();
		int count = 1;
		int closeIndex = str.indexOf("]");
		int openIndex = str.substring(0,closeIndex).lastIndexOf("[");
		String data = str.substring(openIndex+1, closeIndex);
		if(openIndex-1 >= 0)
		count = (Character.isDigit(str.charAt(openIndex-1)))?Character.getNumericValue(str.charAt(openIndex-1)):1;
		else openIndex++;
		while(count>0) {
			output.append(data);
			count--;
		}
		str = str.substring(0, openIndex-1)+output+str.substring(closeIndex+1,str.length());
		return decodeString(str);
	}
}
