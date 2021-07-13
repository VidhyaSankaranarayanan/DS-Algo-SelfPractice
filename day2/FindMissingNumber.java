package week1day2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class FindMissingNumber {
	
	/*
	 * Given an array nums containing n distinct numbers in the range [0,n]
	 * return the only number in the range that is missing from the array
	 */

	/*
	 * 	1) Did I understand the problem? Yes
	 * 		-> If No, Ask the person to provide more detail with examples
	 * 		-> If yes, go to Next step
	 * 		
	 * 		What is the input? -> Integer array
	 * 		What is the expected output? -> Integer
	 * 		Do I have constraints to solve the problem?
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
		int[] input = {3,1,0};
		assertEquals(2, findMissing(input));
		assertEquals(2, findMissingUsingSort(input));
		assertEquals(2, findMissingElement(input));
	}
	
	@Test
	public void test2() {
		int[] input = {0,1,2,3};
		//assertEquals(-1, findMissing(input));
		assertEquals(-1, findMissingUsingSort(input));
		assertEquals(-1, findMissingElement(input));
	}
	
	@Test
	public void test3() {
		int[] input = {};
		//assertEquals(-1, findMissing(input));
		assertEquals(-1, findMissingUsingSort(input));
		assertEquals(-1, findMissingElement(input));
	}
	
	@Test
	public void test4() {
		int[] input = {1};
		assertEquals(0, findMissing(input));
		assertEquals(0, findMissingUsingSort(input));
		assertEquals(0, findMissingElement(input));
	}
	
	@Test
	public void test5() {
		int[] input = {0};
		//assertEquals(-1, findMissing(input));
		assertEquals(-1, findMissingUsingSort(input));
		assertEquals(-1, findMissingElement(input));
	}
	
	@Test
	public void test6() {
		int[] input = {21,23,24};
		assertEquals(22, findMissingElement(input));
	}
	
	/*
	 * Pseudo code
	 * Check if the input length is 0, throw exception
	 * Check if the length is 1, and the value is 0, throw exception & if it is 1, return 0
	 * Initialize 4 variables - min, max, actual sum & find expected sum using [n*(n+1)]/2
	 * Traverse through the array & find max, min & actual sum
	 * Find missing element value by subtracting expected sum & actual sum
	 * Check if length > max, throw exception [Invalid Input]
	 * Else if the missing element value is greater than min & less than max, return missing value
	 * Otherwise return Invalid input
	 * 
	 */
	
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	// For range [0,n]
	
	private int findMissing(int[] input) {
		int length = input.length;
		if(length == 0)
			throw new RuntimeException("Invalid Input");
		if(length == 1 && input[0] == 0)
			throw new RuntimeException("Invalid Input");
		if(length == 1 && input[0] == 1)
			return 0;
		
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, actualSum = 0;
		int expectedSum = (length *(length+1))/2;
		for(int i = 0; i < input.length; i++)
		{
			max = Math.max(input[i], max);
			min = Math.min(input[i], min);
			actualSum += input[i];
		}
		int missingValue = expectedSum - actualSum;
		
		if(length > max)
			throw new RuntimeException("Invalid Input");
		if(missingValue > min && missingValue < max)
			return missingValue;
		
		throw new RuntimeException("Invalid Input");
	}
	
	// Find the missing number between any range
	/*
	 * Pseudo code
	 * Check if the input length is 0, throw exception
	 * Check if the length is 1, and the value is 0, throw exception & if it is 1, return 0
	 * Initialize 4 variables - min, max, actualSum, maxSum, minSum
	 * Traverse through the array & find max, min & actual sum
	 * Find maxSum & minSum by using the formula [n*(n+1)]/2 where n is max for maxSum, 
	 *  min-1 for minSum if min!=0
	 * Add minSum & actualSum then subtract from maxSum and assign it to result
	 * Check if result < min & result > max then return the result 
	 * Else throw exception
	 * 
	 */
	
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	
	private int findMissingElement(int[] input) {
		int length = input.length;
		if(length == 0)
			throw new RuntimeException("Invalid Input");
		if(length == 1 && input[0] == 0)
			throw new RuntimeException("Invalid Input");
		if(length == 1 && input[0] == 1)
			return 0;
		int min = Integer.MAX_VALUE, max = 0, actualSum = 0, minSum = 0, maxSum = 0, result = 0;
		for(int i = 0; i < input.length; i++)
		{
			max = Math.max(input[i], max);
			min = Math.min(input[i], min);
			actualSum += input[i];
		}
		maxSum = (max * (max+1))/2;
		if(min != 0)
			minSum = ((min-1) * (min))/2;
		result = maxSum - (minSum + actualSum);
		if(result > min && result < max)
			return result;
		else
			throw new RuntimeException("Invalid Input");
	}
	
	/*
	 * Pseudo code
	 * Sort the array
	 * Traverse through the array
	 * If the difference between current value & previous value is not equal to 1
	 * Return current value -1
	 */
	
	private int findMissingUsingSort(int[] input) {
		if(input.length == 0)
			throw new RuntimeException("Invalid Input");
		if(input.length == 1 && input[0] == 0)
			throw new RuntimeException("Invalid Input");
		if(input.length == 1 && input[0] == 1)
			return 0;
		
		Arrays.sort(input);
		for(int i = 1; i < input.length; i++)
		{
			if(input[i] - input[i-1] != 1)
				return input[i]-1;
		}
		throw new RuntimeException("Invalid Input");
			
	}
}
