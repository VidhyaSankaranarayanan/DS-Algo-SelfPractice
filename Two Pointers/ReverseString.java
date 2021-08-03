package week2day1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ReverseString {

	/*
	 * Input: String
	 * Output: String
	 * Constraint: Two pointer
	 * Test Data:
	 * Positive: "ab-cd"
	 * Output: "dc-ba"
	 * Negative: "a-bC-dEf-ghIj"
	 * Output: "j-Ih-gfE-dCba"
	 * Negative: "Test1ng-Leet=code-Q!"
	 * Output: "Qedo1ct-eeLg=ntse-T!"
	 * 
	 * Approach: Two sum
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */

	@Test
	public void test1() {
		String input = "ab-cd"; 
		Assert.assertEquals("dc-ba", reverseString(input));
	}
	
	@Test
	public void test2() {
		String input = "a-bC-dEf-ghIj"; 
		Assert.assertEquals("j-Ih-gfE-dCba", reverseString(input));
	}
	
	@Test 
	public void test3() {
		String input = ""; 
		Assert.assertEquals("", reverseString(input));
	}
	
	@Test 
	public void test4() {
		String input = "Test1ng-Leet=code-Q!"; 
		Assert.assertEquals("Qedo1ct-eeLg=ntse-T!", reverseString(input));
	}
	
	/*
	 * Pseudo code
	 * If the string length is empty, return the same string
	 * Initialize 2 pointers left as 0, right as length-1
	 * Traverse until left < right
	 * 		If character at left is not an alphabet, increment left
	 * 		Else if character at right is not an alphabet, decrement right
	 * 		Else swap the characters
	 * Return the string
	 */
	
	private String reverseString(String input) {
		if(input.length() == 0)
			return input;
		char[] ch = input.toCharArray();
		int left = 0, right = ch.length-1;
		while(left < right) {
			if(!Character.isLetter(ch[left])) left++;
			else if(!Character.isLetter(ch[right])) right--;
			else {
				char c = ch[left];
				ch[left++] = ch[right];
				ch[right--] = c;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char c : ch) {
			sb.append(c);
		}
		return sb.toString();
		
	}

}
