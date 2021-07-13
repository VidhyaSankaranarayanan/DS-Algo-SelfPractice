package week2day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortColors {

	
	/*
	 * Given an array nums with n objects colored red, white, or blue, 
	 * sort them in-place so that objects of the same color are adjacent, 
	 * with the colors in the order red, white, and blue.
	 * We will use the integers 0, 1, and 2 
	 * to represent the color red, white, and blue, respectively.
	 * You must solve this problem without using the library's sort function.
	 */
	
	/*
	 * 	1) Did I understand the problem? Yes
	 * 		-> If No, Ask the person to provide more detail with examples
	 * 		-> If yes, go to Next step
	 * 		
	 * 		What is the input? -> Integer array
	 * 		What is the expected output? -> Integer array
	 * 		Do I have constraints to solve the problem? Do not use Sort function
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
	 *   	No - Can I break down the problem into sub problems?
	 *   
	 *   4) Ask for hint (if you do not know how to solve it)
	 *   
	 *   5) Do I know alternate solutions as well? Yes
	 *   
	 *   	Yes - What are those? Brute force
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
		int[] input = {2,0,2,1,1,0};
		assertArrayEquals(new int[] {0,0,1,1,2,2}, sortColorsUsingBruteForce(input));
	}
	
	@Test
	public void test2() {
		int[] input = {2,0,1};
		assertArrayEquals(new int[] {0,1,2}, sortColorsUsingBruteForce(input));
	}
	
	@Test
	public void test3() {
		int[] input = {0};
		assertArrayEquals(new int[] {0}, sortColorsUsingBruteForce(input));
	}
	
	@Test
	public void test4() {
		int[] input = {};
		assertArrayEquals(new int[] {}, sortColorsUsingBruteForce(input));
	}
	
	/*
	 * Pseudo code
	 * Create an output array of size input array's length
	 * Initialize 3 variables for red, blue & white count
	 * Traverse through the array
	 * 	if(value is 0) increment red count
	 * 	if(value is 1) increment white count
	 * 	if(value is 2) increment blue count
	 * Initialize index with length - red count
	 * Add 1 to the array until white count is 0
	 * Add 2 to the array until blue count is 0
	 * Return the output array
	 */
	
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	
	private int[] sortColorsUsingBruteForce(int[] input) {
		if(input.length < 2)
			return input;
		int[] output = new int[input.length];
		int whiteCount = 0, blueCount = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] == 1)
				whiteCount++;
			if(input[i] == 2)
				blueCount++;
		}
		int index = input.length - (whiteCount + blueCount);
		while(whiteCount != 0) {
			output[index++] = 1;
			whiteCount--;
		}
		while(blueCount != 0) {
			output[index++] = 2;
			blueCount--;
		}
		return output;
	}
	
	/*
	 * Pseudo code - 3 pointer
	 * If input length is < 2 return input
     * Create 3 ptr , low, mid as 0 and high as length -1
     * Iterate the input till mid < high
     *      a) if current element 0, swap low element and mid, increment low and mid
     *      b) if current element 1, increment mid
     *      c) if current element 2, swap mid and high, decrement high  
     * return the input
	 */
	

}
