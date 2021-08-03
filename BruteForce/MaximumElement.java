package week1day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaximumElement {
	/*
	 * 	1) Did I understand the problem? Yes
	 * 		-> If No, Ask the person to provide more detail with examples
	 * 		-> If yes, go to Next step
	 * 		
	 * 		What is the input? -> Integer array
	 * 		What is the expected output? -> Integer
	 * 		Do I have constraints to solve the problem? If there are multiple occurrence, find first max
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
		int[] input = {1,2,5,6,5,7,1};
		assertEquals(7, findMax(input));
	}
	
	@Test
	public void test2() {
		int[] input = {7,6,5,4,3,2,9};
		assertEquals(9, findMax(input));
	}
	
	@Test
	public void test3() {
		int[] input = {};
		assertEquals(0, findMax(input));
	}
	
	@Test
	public void test4() {
		int[] input = {1,1,-1,-6};
		assertEquals(1, findMax(input));
	}

	/*
	 * Pseudo code
	 * If the array is empty, throw the exception
	 * Initialize an element as max with first index value
	 * Traverse through the array 
	 * Check if the value at current index is greater than max
	 * If so, initialize max with the current element
	 * Return max
	 */
	
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	
	private int findMax(int[] input) {
		if(input.length == 0)
			throw new RuntimeException("Given Array is Empty");
		int max = input[0];
		for(int i = 0; i < input.length; i++)
		{
			max = (max > input[i]) ? max : input[i];
		}
		return max;
	}
}
