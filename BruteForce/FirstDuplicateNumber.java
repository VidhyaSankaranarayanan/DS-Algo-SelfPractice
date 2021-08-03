package week1day1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class FirstDuplicateNumber {
	
	/*
	 * Find first duplicate number in an integer array not the most recurring one
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
	 *   	Brute force - Using 2 for loops
	 *   	Hash set
	 *   	No - Can I break down the problem into sub problems?
	 *   
	 *   4) Ask for hint (if you do not know how to solve it)
	 *   
	 *   5) Do I know alternate solutions as well? Yes
	 *   
	 *   	Yes - What are those? Brute force using 2 for loop
	 *   	Hash set
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
	public void example1() {
		int[] num = {1,2,3,1,2,3};
		assertEquals(1, findDup(num));
		assertEquals(1, findDupUsingBruteForce(num));
	}
	
	@Test
	public void example2() {
		int[] num = {1,2,3};
		assertEquals(0, findDup(num));
		assertEquals(0, findDupUsingBruteForce(num));
	}
	
	@Test
	public void example3() {
		int[] num = {};
		assertEquals(0, findDup(num));
		assertEquals(0, findDupUsingBruteForce(num));
	}
	
	@Test
	public void example4() {
		int[] num = {1,1,1,1};
		assertEquals(1, findDup(num));
		assertEquals(1, findDupUsingBruteForce(num));
	}
	
	@Test
	public void example5() {
		int[] num = {1,1,1,1,2,2};
		assertEquals(1, findDup(num));
		assertEquals(1, findDupUsingBruteForce(num));
	}
	
	@Test
	public void example6() {
		int[] num = {1,1,2,2,2};
		assertEquals(1, findDup(num));
		assertEquals(1, findDupUsingBruteForce(num));
	}
	
	@Test
	public void example7() {
		int[] num = {1};
		assertEquals(0, findDup(num));
		assertEquals(0, findDupUsingBruteForce(num));
	}
	
	@Test
	public void example8() {
		int[] num = {-1, 1, 1, -1, 2, 3, 4, 5};
		assertEquals(1, findDup(num));
		assertEquals(1, findDupUsingBruteForce(num));
	}
	
	/*
	 * Pseudo code
	 * Check if the length is less than 2, throw exception
	 * Create a list 
	 * Traverse through the array
	 *  -> Traverse through the array from next index
	 *  -> If the element matches the current element
	 *  -> Add inner loop's index to list
	 * Sort the list
	 * If the list is empty, throw exception
	 * Else return the array element in the first value of list [to get the first occurring element]
	 * 
	 */
	
	// Brute Force
	
	// Time Complexity: O(n^2)
	// Space Complexity: O(n)
	
	public int findDupUsingBruteForce(int[] num)
	{
		if(num.length < 2)
			throw new RuntimeException("No Duplicates");
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < num.length; i++)
		{
			for(int j = i+1; j < num.length; j++)
			{
				if(num[i] == num[j])
					list.add(j);
			}
		}
		Collections.sort(list);
		if(list.isEmpty())
			throw new RuntimeException("No Duplicates");
		return num[list.get(0)];
		
	}
	
	/*
	 * Pseudo code
	 * Check if the length is less than 2, throw exception
	 * Create a set
	 * Traverse through the array
	 * If the set already contains the current element, return the current element
	 * Else add the element to the set
	 * Throw exception at the end if nothing is duplicate
	 */
	
	// Space Complexity: O(n)
	// Time Complexity: O(n)
	
	public int findDup(int[] num)
	{
		if(num.length < 2)
			throw new RuntimeException("Invalid Input");
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < num.length; i++)
		{
			if(set.contains(num[i]))
				return num[i];
			else
				set.add(num[i]);
		}
		throw new RuntimeException("Invalid Input");
	}

}
