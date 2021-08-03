package week2day1;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class StringPalindrome {

	/*
	 * Input: String
	 * Output: Boolean
	 * Constraint: Two pointer
	 * Test Data:
	 * Positive: "A man, a plan, a canal: Panama"
	 * Output: true
	 * Negative: "race a car"
	 * Output: false
	 * Negative: ""
	 * Output: Invalid Input
	 * 
	 * Approach: Two sum
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */

	@Test
	public void test1() {
		String input = "A man, a plan, a canal: Panama"; 
		Assert.assertEquals(true, checkPalindrome(input));
	}
	
	@Test
	public void test2() {
		String input = "race a car"; 
		Assert.assertEquals(false, checkPalindrome(input));
	}
	
	@Test 
	public void test3() {
		String input = ""; 
		Assert.assertEquals("Empty String", checkPalindrome(input));
	}
	
	@Test 
	public void test4() {
		String input = "@"; 
		Assert.assertEquals(false, checkPalindrome(input));
	}
	
	/*
	 * Pseudo code
	 * If the string is empty, throw exception
	 * If the string length is 1 & if it is alpha numeric, return true
	 * Initialize 2 pointers, left as 0, right as length-1 & initialize a flag as false
	 * Traverse until left < right
	 * 		If character at left is not alphabet or number, increment left
	 * 		Else if character at right not an alphabet or number, decrement right
	 * 		Else if the current character is alphabet or number & char at left & right are same
	 * 			Increment left & decrement right & make flag as true
	 * 		Else return false
	 * Return true if flag is true else false
	 */
	
	private boolean checkPalindrome(String input) {
		if(input.length() == 0)
			throw new RuntimeException("Empty String");
		if(input.length()==1 && Character.isLetterOrDigit(input.charAt(0)))
			return true;
		int left = 0, right = input.length()-1;
		boolean isPalindrome = false;
		while(left<right) {
			if(!Character.isLetterOrDigit(input.charAt(left))) left++;
			else if(!Character.isLetterOrDigit(input.charAt(right))) right--;
			else if(Character.toLowerCase(input.charAt(left)) == Character.toLowerCase(input.charAt(right))) {
				left++;
				right--;
				isPalindrome = true;
			}
			else return false;
		}
		return (isPalindrome==true)?true:false;
	}

}
