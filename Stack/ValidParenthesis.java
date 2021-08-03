/**
 * 
 */
package week4day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class ValidParenthesis {

	/*
		 * Input: String
		 * Output: Boolean
		 * Constraint: Use Stack
		 * Test Data:
		 * Positive: "((()))"
		 * Output: true
		 * Edge: "{(>}"
		 * Output: false
		 * Negative: ""
		 * Output: ""
		 * 
		 * Approach: Stack
		 * 
		 * Time Complexity: O(n) 
		 * Space Complexity: O(n)
		 */

	@Test
	public void test1() {
		String str = "((()))";
		Assert.assertEquals(true, findValidParenthesis(str));
	}

	@Test
	public void test2() {
		String str = "{(>}";
		Assert.assertEquals(false, findValidParenthesis(str));
	}

	@Test
	public void test3() {
		String str = "";
		Assert.assertEquals(false, findValidParenthesis(str));
	}
	
	/*
	 *  Pseudo code - Stack
	 *  Create a map
	 *  Add closed brackets as key and open brackets as value
	 *  Convert the string to char array
	 *  Create a stack
	 *  Traverse through the char array
	 *  	If the current character present in the map & its corresponding value matches the top element
	 *  		Pop the element
	 *  	Else
	 *  		Push the element
	 *  If the stack's size is 0
	 *  	Return true
	 *  Else 
	 *  	Return false
	 */
	
	private boolean findValidParenthesis(String str) {
		if(str.length() == 0)
			return false;
		char[] ch = str.toCharArray();
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put('>', '<');
		map.put('}', '{');
		map.put(']', '[');
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < ch.length; i++) {
			if(!stack.isEmpty() && stack.peek() == map.get(ch[i]))
				stack.pop();
			else
				stack.push(ch[i]);
		}
		return (stack.size() == 0)?true:false;
	}
}
