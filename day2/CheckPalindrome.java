package week1day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckPalindrome {

	/*
	 * 	1) Did I understand the problem? Yes
	 * 		-> If No, Ask the person to provide more detail with examples
	 * 		-> If yes, go to Next step
	 * 		
	 * 		What is the input? -> Integer
	 * 		What is the expected output? -> Boolean
	 * 		Do I have constraints to solve the problem? No
	 * 		Do I have all information to go to next step? Yes
	 * 		How big is your test data set will be? 
	 * 
	 *  2) Test Data set
	 *  
	 *  	Minimum of 3 data sets - Positive, Edge, Negative
	 *  	Validate with the interviewer if the data set is fine by his/her assumptions
	 *  
	 *   3) Do I know how to solve it? Yes
	 *   
	 *   	Yes - great is there an alternate solution?
	 *   	Brute force
	 *   	Convert into string & reverse
	 *   	No - Can I break down the problem into sub problems?
	 *   
	 *   4) Ask for hint (if you do not know how to solve it)
	 *   
	 *   5) Do I know alternate solutions as well? Yes
	 *   
	 *   	Yes - What are those? Brute force
	 *   	
	 *   	No - That is still fine, proceed to solve what you know
	 *   
	 *   6) If you know the alternate solutions -> find out the O notations (performance)
	 *   
	 *    	Then, explain either both or the best (depends on the time)
	 *    
	 *    	Approach 1: Start with the worst -> Improve (Optimize) -> End up with the best 
	 *    	Approach 2: Write down the options and benefits and code the best 
	 *    
	 *   7) Start always with the Pseudo code 
	 *   
	 *   8) Implement them in the code (editor)
	 *   
	 *   9) Test against the different data set
	 *   
	 *   10) If it fails, debug them to solve it
	 *   
	 */
	@Test
	public void test1() {
		int input = 12321;
		assertEquals(true, palindrome(input));
	}
	
	@Test
	public void test2() {
		int input = 1;
		assertEquals(true, palindrome(input));
	}
	
	@Test
	public void test3() {
		int input = 123;
		assertEquals(false, palindrome(input));
	}
	
	@Test
	public void test4() {
		int input = -121;
		assertEquals(true, palindrome(input));
	}
	
	@Test
	public void test5() {
		int input = -9;
		assertEquals(true, palindrome(input));
	}
	
	/*
	 * Pseudo code
	 * Check if input is from -9 to 9, return true [Single digit]
	 * Declare the variable for reversed integer and Initialize the temp varible with input integer
	 * If the number is negative, multiply the temp with -1
	 * Traverse until the quotient of temp is not equal to zero
	 *  -> Multiply the output by 10 & add mod of temp by 10 to it
	 *  -> find quotient of temp by dividing it by 10
	 * Check whether reversed integer is same as input and if the input is negative multiply reversed integer with -1 & check with input
	 * If it is same, return true
	 * Else return false
	 * 
	 */
	
	// Time Complexity: O(n)
	// Space Complexity: O(1)

	private boolean palindrome(int input) {
		if(input > -10 && input < 10)
			return true;
		int output = 0;
		int temp = input;
		if(input < 0)
			temp *= -1;
		
		while(temp != 0)
		{
			output = (output*10) + temp%10;
			temp = temp/10;
		}
		
		if(input < 0)
			output *= -1;
		if(output == input)
			return true;
		else
			return false;
	}
	
	/*
	 * Pseudo code
	 * 
	 * Check if input is from -9 to 9, return true [Single digit]
	 * Convert the given integer to string
	 * Create a variable for reversed string
	 * If the number is negative, add '-' to the reversed string & remove from the input string
	 * Traverse through the string from last
	 * Add each character to the output string
	 * Convert the output string to integer
	 * Check if the converted integer is same as input
	 * If so, return true
	 * Else return false
	 * 
	 */
	
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	
	private boolean checkPalindromeUsingString(int input) {
		if(input > -10 && input < 10)
			return true;
		String inputString = Integer.toString(input);
		String reverseString = "";
		if(input < 0)
		{
			reverseString += "-";
			inputString = inputString.replaceFirst("-", "");
		}
		for(int i = inputString.length()-1; i >= 0; i--)
			reverseString += inputString.charAt(i);
		int reverseInteger = Integer.parseInt(reverseString);
		if(reverseInteger == input)
			return true;
		else
			return false;
	}
}
