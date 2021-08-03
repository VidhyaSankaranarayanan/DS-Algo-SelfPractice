package week4day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class FindNumberOfBracketsToMakeItValid {
	/*Find out how many missing brackets to make a valid parentheses !! 
Input can have only open and closing brackets ( )
String st = “((((” -> 4 brackets 
String st = “(()))” -> 1 bracket
	 */
	
	/*
	 * Input: String
	 * Output: Integer
	 * Constraint: Use Stack
	 * Test data:
	 * Positive: "(((("; Output: 4
	 * Negative:"()" ; Output: 0
	 * Edge: "(()))"; Output: 1
	 * 
	 * Approach: Using Stack
	 * 
	 * Time Complexity: 
	 * Space Complexity: 
	 * 
	 * 
	 */
	
	
	
	@Test
	public void test1() {
		String s = "((((";
		Assert.assertEquals(4, findParenthesis(s));
	}
	

	@Test
	public void test2() {
		String s = "()";
		Assert.assertEquals(0, findParenthesis(s));
	}
	
	@Test
	public void test3() {
		String s = "(()))";
		Assert.assertEquals(1, findParenthesis(s));
	}
	
	@Test
	public void test4() {
		String s = "())(";
		Assert.assertEquals(2, findParenthesis(s));
	}
	
	/*
	 * Pseudo code
	 * If the string is empty, throw exception
	 * Convert string to char array
	 * Create a map & add closed brackets as key & open brackets as value
	 * Create a stack
	 * Initialize count as 0
	 * Traverse through the char array
	 * 		If the stack is not empty & if the value of the current key matches with the pop value
	 * 		else
	 * 			add the character to the stack
	 * Return the size of the stack
	 * 
	 */
	

	private int findParenthesis(String s) {
		if(s.length() == 0)
			throw new RuntimeException("String is empty");
		char[] ch = s.toCharArray();
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');
		map.put('>', '<');
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < ch.length; i++) {
			if(!stack.isEmpty() && map.get(ch[i]) == stack.peek())
				stack.pop();
			else
				stack.push(ch[i]);
		}
		return stack.size();
	}
}
