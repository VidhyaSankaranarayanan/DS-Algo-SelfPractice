/**
 * 
 */
package week4day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
		 * Constraint: Use Stack
		 * Test Data:
		 * Positive: "3[a2[bc]]"
		 * Output: "abcbcabcbcabcbc"
		 * Edge: "3[a]2[c]"
		 * Output: "accaccacc"
		 * Negative: "[ac]"
		 * Output: "ac"
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
		String str = "3[a]2[c]";
		Assert.assertEquals("aaacc", decodeString(str));
	}

	@Test
	public void test3() {
		String str = "[ac]";
		Assert.assertEquals("ac", decodeString(str));
	}
	
	/*
	 * Pseudo code
	 * Create a stack
	 * Convert the string to char array
	 * Traverse through the char array
	 * 		If the stack is empty & current character is not a closed bracket
	 * 			push the current character
	 * 		else
	 * 			Pop the characters from the stack until top element is open bracket
	 * 				Add the characters to the list
	 * 			Pop the open bracket
	 * 			If the top element is a digit, 
	 * 				pop it and assign it to a variable
	 * 			Traverse until k becomes 0 
	 * 				push the characters from the list to stack in reverse order
	 * Return the stack as a string
	 */
	
	private String decodeString(String str) {
		Stack<Character> stack = new Stack<Character>();
		char[] ch = str.toCharArray();
		for(int i = 0; i < ch.length; i++) {
			if(ch[i] != ']')
				stack.push(ch[i]);
			else {
				List<Character> list = new ArrayList<Character>();
				while(stack.peek() != '[')
					list.add(stack.pop());
				stack.pop();
				int k = 1;
				if(!stack.isEmpty() && Character.isDigit(stack.peek()))
					k = Character.getNumericValue(stack.pop());
				while(k > 0) {
					for(int j = list.size()-1; j >=0; j--)
						stack.push(list.get(j));
					k--;
				}
			}
		}
		StringBuilder output = new StringBuilder();
		for(Character each : stack)
			output.append(each);
		return output.toString();
	}
}
