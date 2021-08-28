/**
 * 
 */
package apple;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;



/**
 * @author Vidhya
 *
 */
public class RemoveKDuplicates {

	/*
		 * Input: String, Integer
		 * Output: String
		 * Constraint: 
		 * Test Data:
		 * Positive: s = "abcd", k = 2
		 * Output: "abcd"
		 * Edge: s = "deeedbbcccbdaa", k = 3
		 * Output: "aa"
		 * Negative: "pbbcggttciiippooaais", k = 2
		 * Output: "ps"
		 * 
		 * Approach: Using Stack
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */

	@Test
	public void test1() {
		String s = "abcd";
		int k = 2;
		Assert.assertEquals("abcd", removeDuplicates(s, k));
	}

	@Test
	public void test2() {
		String s = "deeedbbcccbdaa";
		int k = 3;
		Assert.assertEquals("aa", removeDuplicates(s, k));
	}

	@Test
	public void test3() {
		String s = "pbbcggttciiippooaais";
		int k = 2;
		Assert.assertEquals("ps", removeDuplicates(s, k));
	}

	
	
	/*
	 * Pseudo code
	 * Create 2 stacks for characters & Integers[Index]
	 * Initialize count as 1
	 * Traverse through the string
	 * 		If the stack is empty or top char is not equal to current char
	 * 			Push the char to the char stack, assign 1 to count
	 * 			Push count to the index stack
	 * 		Else
	 * 			If the current character is same as top character & count is not equal to k, 
	 * 				increment count by top of index stack +1 and add count to the index stack
	 * 				add the char to character stack
	 * 			If count == k
	 * 				Traverse until count > 0
	 * 				Pop the character from char stack, decrement the count
	 * 				Pop the top index from the index stack
	 * Return the char stack
	 * 			
	 */
	
	
	private String removeDuplicates(String s, int k) {
		Stack<Character> charStack = new Stack<Character>();
		Stack<Integer> indexStack = new Stack<Integer>();
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(charStack.isEmpty() || s.charAt(i)!=charStack.peek()) {
				charStack.push(s.charAt(i));
				count = 1;
				indexStack.push(count);
			}
			else {
				if(s.charAt(i)==charStack.peek() && count < k) {
					charStack.push(s.charAt(i));
					count = indexStack.peek()+1;
					indexStack.push(count);
				}
				if(indexStack.peek() == k) {
					while(count > 0) {
						charStack.pop();
						indexStack.pop();
						count--;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!charStack.isEmpty())
		sb.insert(0,charStack.pop());
		return sb.toString();
	}
}
