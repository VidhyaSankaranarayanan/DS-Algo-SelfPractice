package week1day2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.junit.jupiter.api.Test;

class UniqueOccurrence {
	
	/*
	 * Given an array of integers arr, write a function that returns true if and only
	 * if the number of occurrences of each value in the array is unique
	 */

	/*
	 * 	1) Did I understand the problem? Yes
	 * 		-> If No, Ask the person to provide more detail with examples
	 * 		-> If yes, go to Next step
	 * 		
	 * 		What is the input? -> Integer array
	 * 		What is the expected output? -> Boolean
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
	 *   	Hash Map + Hash set
	 *   	No - Can I break down the problem into sub problems?
	 *   
	 *   4) Ask for hint (if you do not know how to solve it)
	 *   
	 *   5) Do I know alternate solutions as well? Yes
	 *   
	 *   	Yes - What are those? Brute force
	 *   	Hash Map + Hash set
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
		int[] input = {1,2,2,1,1,3};
		assertEquals(true, uniqueOccurence(input));
		//assertEquals(true, uniqueOccurrenceUsingMap(input));
	}
	
	@Test
	public void test2() {
		int[] input = {1,2,2,1,1,2};
		assertEquals(false, uniqueOccurence(input));
		//assertEquals(false, uniqueOccurrenceUsingMap(input));
	}
	
	@Test
	public void test3() {
		int[] input = {};
		assertEquals(false, uniqueOccurence(input));
		assertEquals(false, uniqueOccurrenceUsingMap(input));
	}
	
	@Test
	public void test4() {
		int[] input = {1,1,1,1,1,1};
		assertEquals(true, uniqueOccurence(input));
		assertEquals(true, uniqueOccurrenceUsingMap(input));
	}
	
	@Test
	public void test5() {
		int[] input = {1};
		assertEquals(true, uniqueOccurence(input));
		assertEquals(true, uniqueOccurrenceUsingMap(input));
	}
	
	/*
	 * Pseudo code
	 * Initial check -> if the length = 0, return false & length = 1, return true
	 * Initialize 2 variables, marker as first value of array & count variable as 1
	 * Declare an output array of input array's size & declare index variable as 0
	 * Traverse through the array & find the count of first value and add it to the output array, increment the index
	 * Traverse through the array from 1 to length array
	 * 	-> If the current element equals to marker, continue
	 * 	->  else initialize count as 1, traverse through the array from next index &
	 * 		 get the count of each value & assign marker to the traversed value
	 * 	-> Add the count to the output array
	 * Get the sub array from 0 to index
	 * Check if the length of sub array is 1, return true
	 * Else traverse through the sub array and check if there is a duplicate return false
	 * Return true at the end if all the conditions passed	
	 */
	
	// Time Complexity: O(n) + O(n^2) + O(m^2) = O(n^2)
	// Space Complexity: O(3) + O(n) + O(m) = O(n)
	
	private boolean uniqueOccurence(int[] input) {
		if(input.length == 0)
			return false;
		if(input.length == 1)
			return true;
		int marker = input[0], count = 1, index = 0;
		int[] occurrenceArray = new int[input.length];
		for(int i = 1; i < input.length; i++)
		{
			if(input[i] == marker)
				count++;
		}
		occurrenceArray[index++] = count;
		
		for(int i = 1; i < input.length; i++)
		{
			if(input[i] == marker)
				continue;
			else
			{
				count = 1;
				for(int j = i+1; j < input.length; j++)
				{
					if(input[i] == input[j])
					{
						count++;
						input[j] = marker;
					}
				}
				occurrenceArray[index++] = count;
			}
		}
		
		int[] uniqueArray = Arrays.copyOfRange(occurrenceArray, 0, index);
		if(uniqueArray.length == 1)
			return true;
		else
		{
			for(int i = 0; i < uniqueArray.length; i++)
			{
				for(int j = i+1; j < uniqueArray.length; j++)
				{
					if(uniqueArray[i] == uniqueArray[j])
						return false;
				}
			}
		}
		return true;
	}
	
	/*
	 * Pseudo code - Hash Map + Hash Set
	 * Initial check -> if the length = 0, return false & length = 1, return true
	 * Declare a map and add array values as key & its count as value
	 * If size of the map is 1, return true
	 * Else return the result of the condition,
	 * if size of the map is same as size of the set which has values of the map 
	 * 
	 */
	
	// Time Complexity: O(n)
	// Space Complexity: O(2n) -> O(n)
	
	private boolean uniqueOccurrenceUsingMap(int[] input) {
		if(input.length == 0)
			return false;
		if(input.length == 1)
			return true;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < input.length; i++)
			map.put(input[i], map.getOrDefault(input[i], 0) +1);
		
		if(map.size() == 1)
			return true;
		return map.size() == new HashSet<Integer>(map.values()).size();
	}
	

}
