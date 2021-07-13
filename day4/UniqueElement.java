package week2day1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class UniqueElement {

	/*
	 * Given a non-empty array of integers nums, every element appears twice except for one. 
	 * Find that single one.
	 * You must implement a solution with a linear runtime complexity 
	 * and use only constant extra space.
	 */
	
	/*
	 * 	1) Did I understand the problem? Yes
	 * 		-> If No, Ask the person to provide more detail with examples
	 * 		-> If yes, go to Next step
	 * 		
	 * 		What is the input? -> Integer array
	 * 		What is the expected output? -> Integer 
	 * 		Do I have constraints to solve the problem? 2 pointer
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
	 *   	2 Pointer
	 *   	No - Can I break down the problem into sub problems?
	 *   
	 *   4) Ask for hint (if you do not know how to solve it)
	 *   
	 *   5) Do I know alternate solutions as well? Yes
	 *   
	 *   	Yes - What are those?
	 *   	2 pointer
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
		int[] input = {2,2,1};
		assertEquals(1, findUniqueElement(input));
	}
	
	@Test
	public void test2() {
		int[] input = {4,1,2,1,2};
		assertEquals(4, findUniqueElement(input));
	}
	
	@Test
	public void test3() {
		int[] input = {2,2,3,1};
		assertEquals(1, findUniqueElement(input));
	}
	
	@Test
	public void test4() {
		int[] input = {};
		assertEquals(0, findUniqueElement(input));
	}
	
	/*
	 * Pseudo code
	 * If the array length is less than 1, throw exception
	 * Sort the array
	 * Initialize 2 pointers p1 as 0, p2 as 1
	 * Traverse through the array until p2 less than length - 1
	 * 	-> Compare value at p1 & p2
	 * 	-> If equal, increment p1 by p2+1 & p2 by p1+1
	 * 	-> If not return value at p1
	 * Return value at p1
	 * 
	 */
	
	// Time Complexity: O(nlogn) + O(n) = O(n logn)
	// Space Complexity: O(1)
	
	private int findUniqueElement(int[] input) {
		if(input.length < 1)
			throw new RuntimeException("Invalid Input");
		Arrays.sort(input);
		int p1 = 0, p2 = 1;
		while(p2 < input.length-1) {
			if(input[p1] == input[p2]) {
				p1 = p2+1;
				p2 = p1+1;
			}
			else
				return input[p1];
		}
		return input[p1];
	}
	

}
