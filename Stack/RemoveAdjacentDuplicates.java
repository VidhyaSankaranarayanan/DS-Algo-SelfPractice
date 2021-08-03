package week4day2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class RemoveAdjacentDuplicates {
	
	/*Remove the adjacent duplicates (lowercase)
Only O(n)
		 */
		
		/*
		 * Input: String
		 * Output: String
		 * Constraint: Use Stack
		 * Test data:
		 * Positive: "abbaaba"; Output: "aba"
		 * Negative:"abccba" ; Output: ""
		 * Edge: "abcacba"; Output: "a"
		 * 
		 * Approach: Using Stack
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(n)
		 * 
		 * 
		 */
		
		
		
		@Test
		public void test1() {
			String s = "abbaaba"; 
			Assert.assertEquals("aba", removeAdjacentDuplicatesUsingSet(s));
		}
		

		

		@Test
		public void test2() {
			String s = "abcacba";
			Assert.assertEquals("abcacba", removeAdjacentDuplicatesUsingSet(s));
		}
		
		@Test
		public void test3() {
			String s = "abccba";
			Assert.assertEquals("", removeAdjacentDuplicatesUsingSet(s));
		}
		
		@Test
		public void test4() {
			String s = "";
			Assert.assertEquals("", removeAdjacentDuplicatesUsingSet(s));
		}
		
		/*
		 * Pseudo code
		 * If the string is empty, return empty string
		 * Convert string to char array
		 * Create stack
		 * Traverse through the char array
		 * 		If the stack is empty
		 * 			Push the character
		 * 		If the current character not equal to pop character
		 * 			Push the character
		 * 		Else pop
		 * Return stack by converting to string
		 */
		
		private String removeAdjacentDuplicates(String s) {
			if(s.length() == 0)
				return s;
			char[] ch = s.toCharArray();
			Stack<Character> stack = new Stack<Character>();
			for(int i = 0; i < ch.length; i++) {
				if(stack.isEmpty() || stack.peek()!=ch[i])
					stack.push(ch[i]);
				else
					stack.pop();
			}
			StringBuilder output = new StringBuilder();
			while(!stack.isEmpty())
				output.append(stack.pop());
			return output.toString();
		}
		
		/*
		 * Pseudo code
		 * If the string is empty, return empty string
		 * Create a set
		 * TRaverse through the string
		 * 	 If the current character is present in the set, remove it
		 * 	 Else add it
		 * Return set
		 */
		
		private String removeAdjacentDuplicatesUsingSet(String s) {
			if(s.length() == 0)
				return s;
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for(int i = 0; i < s.length(); i++) {
//				if(map.contains(s.charAt(i)))
//					map.remove(s.charAt(i));
//				else
//					map.add(s.charAt(i));
			}
			return map.toString();
		}

		
}
