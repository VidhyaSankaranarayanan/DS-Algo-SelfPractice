package week1day2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class FindMajorityElement {

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
		int[] arr = {1,2,2,2};
		assertEquals(2, findMajorityOptimized(arr));
	}
	
	@Test
	public void test2() {
		int[] arr = {1,1,1,1};
		assertEquals(1, findMajorityOptimized(arr));
	}
	
	@Test
	public void test3() {
		int[] arr = {1,2,1};
		assertEquals(1, findMajorityOptimized(arr));
	}
	
	@Test
	public void test4() {
		int[] arr = {1,2};
		assertEquals(0, findMajorityOptimized(arr));
	}
	
	

	/*
	 * Pseudo code
	 * Initialize 3 variables max, count & value
	 * Traverse through the array
	 * 	-> Traverse through the array from next index
	 *  -> If the element matches, increment the count
	 * If count greater than max, initialize max as count, current value as value
	 * Check if max > length/2
	 * Return value
	 * else
	 * Throw exception
	 * 
	 *  
	 */
	
	// Time Complexity: O(n^2)
	// Space Complexity: O(1)
	
	private int findMajority(int[] num) {
		int max = Integer.MIN_VALUE, count = 0, majorityElement = 0;
		for(int i = 0; i < num.length; i++)
		{
			count = 1;
			for(int j = i+1; j < num.length; j++)
			{
				if(num[i] == num[j])
					count++;
			}
			if(max < count)
			{
				max = count;
				majorityElement = num[i];
			}
		}
		if(max > num.length/2)
			return majorityElement;
		else
			throw new RuntimeException("Invalid Input");
	}
	
	
	/*
	 * Pseudo code
	 * Create a hash map and add the elements of the array as key& count as value
	 * traverse through the map by its key and find the max value from the map
	 * Get the key of the max value
	 * Check if the max value is greater than n/2
	 * If so return key of that value
	 * Else
	 * Throw the exception
	 */
	// Time Complexity: O(2n) -> O(n)
	// Space Complexity: O(n)
	private int findMajorityOptimized(int[] num) {
		int length = num.length/2;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < num.length; i++)
		{
			map.put(num[i], map.getOrDefault(num[i], 0)+1);
			if(map.get(num[i]) > length)
				return num[i];
		}
		throw new RuntimeException("Invalid Input");
	}

}
