/**
 * 
 */
package week4day2;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class FindCanonicalPath {

	/*
		 * Input: String
		 * Output: String
		 * Constraint: Use Stack
		 * Test Data:
		 * Positive: "/home/"
		 * Output: "/home"
		 * Edge: "/../"
		 * Output: "/"
		 * Negative: "/home//foo/"
		 * Output: "/home/foo"
		 * "/a/./b/../../c/"
		 * Output: "/c"
		 * 
		 * Approach: Stack
		 * 
		 * Time Complexity: O(n) 
		 * Space Complexity: O(n)
		 */

	@Test
	public void test1() {
		String str = "/home/";
		Assert.assertEquals("/home", findCanonicalPath(str));
	}

	@Test
	public void test2() {
		String str = "/../";
		Assert.assertEquals("/", findCanonicalPath(str));
	}

	@Test
	public void test3() {
		String str = "/home//foo/";
		Assert.assertEquals("/home/foo", findCanonicalPath(str));
	}
	@Test
	public void test4() {
		String str = "/a/./b/../../c/";
		Assert.assertEquals("/c", findCanonicalPath(str));
	}
	
	/*
	 * Pseudo code
	 * Convert the string to string array by splitting with /
	 * Create a stack
	 * Traverse through the string array
	 * 		If the current character is .. & stack is not empty
	 * 			Pop the element
	 * 		If the current character is .. & stack is empty
	 * 			continue
	 * 		If the current character is . or null
	 * 			continue
	 * 		else push the character
	 * Return the stack to string
	 */
	
	private String findCanonicalPath(String str) {
		String[] strArray = str.split("/");
		Stack<String> stack = new Stack<String>();
		for(int i = 0; i < strArray.length; i++) {
			if(strArray[i].equals("") || strArray[i].equals("."))
				continue;
			else if(strArray[i].equals("..") && !stack.isEmpty())
				stack.pop();
			else if(strArray[i].equals("..") && stack.isEmpty())
				continue;
			else stack.push(strArray[i]);
		}
		StringBuilder sb = new StringBuilder();
		if(stack.isEmpty()) return "/";
		int size = stack.size();
		for(int i = 0 ; i < size; i++) {
			sb.insert(0, stack.pop());
			sb.insert(0, "/");
		}
		return sb.toString();
	}
	
}
