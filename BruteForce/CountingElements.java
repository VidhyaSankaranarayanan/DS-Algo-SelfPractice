package week1day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class CountingElements {

	/*
	 * Given an integer array arr, count how many elements x there are,
	 * such that x + 1 is also in arr. 
	 * If there are duplicates in arr, count them separately.
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
	 *   	Using Set
	 *   	No - Can I break down the problem into sub problems?
	 *   
	 *   4) Ask for hint (if you do not know how to solve it)
	 *   
	 *   5) Do I know alternate solutions as well? Yes
	 *   
	 *   	Yes - What are those? Brute force
	 *   	Using Set
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
		int[] input = {1,2,3};
		assertEquals(2, countElements(input));
		assertEquals(2, countElementsUsingHashSet(input));
	}
	
	@Test
	public void test2() {
		int[] input = {1,1,3,3,5,5,7,7};
		assertEquals(0, countElements(input));
		assertEquals(0, countElementsUsingHashSet(input));
	}
	
	@Test
	public void test3() {
		int[] input = {1,3,2,3,5,0};
		assertEquals(3, countElements(input));
		assertEquals(3, countElementsUsingHashSet(input));
	}
	
	@Test
	public void test4() {
		int[] input = {1,1,2,2};
		assertEquals(2, countElements(input));
		assertEquals(2, countElementsUsingHashSet(input));
	}
	
	@Test
	public void test5() {
		int[] input = {1,1,2};
		assertEquals(2, countElements(input));
		assertEquals(2, countElementsUsingHashSet(input));
	}
	
	/*
	 * Pseudo code
	 * Initialize count variable as 0
	 * Traverse through the array
	 *  -> Traverse through the array
	 *  -> If the value at j is greater than i by 1
	 *  -> Increment count
	 * Return count 
	 * 
	 */
	
	// Time Complexity: O(n^2)
	// Space Complexity: O(1)
	
	private int countElements(int[] input) {
		int count = 0;
		for(int i = 0; i < input.length; i++)
		{
			for(int j = 0; j < input.length; j++)
			{
				if(input[j] > input[i] && input[j] - input[i] == 1)
				{
					count++;
					break;
				}
			}
		}
		return count;
	}
	
	/*
	 * Pseudo code - Using Hash Set
	 * Create a hash set & initialize count as 0
	 * Traverse through the array & add elements to the set
	 * Traverse through the array 
	 * -> If the current value + 1 present in the set
	 * -> Increment count
	 * Return count
	 */
	
	// Time Complexity: O(n) + O(n) = O(n)
	// Space Complexity: O(n)
	
	private int countElementsUsingHashSet(int[] input) {
		int count = 0;
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < input.length; i++)
			set.add(input[i]);
		
		for(int i = 0; i < input.length; i++)
		{
			if(set.contains(input[i] + 1))
				count++;
		}
		
		return count;
		
	}
	
	
}
