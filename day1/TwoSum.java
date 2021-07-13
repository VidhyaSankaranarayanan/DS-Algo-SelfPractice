package week1day1;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TwoSum {

	/*
	 * Return the first solution,
	 * If there is no solution, return -1,-1 and sum of same index can be a solution
	 */
	
	/*
	 * 	1) Did I understand the problem? Yes
	 * 		-> If No, Ask the person to provide more detail with examples
	 * 		-> If yes, go to Next step
	 * 		
	 * 		What is the input? -> Integer array, Integer
	 * 		What is the expected output? -> Integer array
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
	 *   	No - Can I break down the problem into sub problems?
	 *   
	 *   4) Ask for hint (if you do not know how to solve it)
	 *   
	 *   5) Do I know alternate solutions as well? Yes
	 *   
	 *   	Yes - What are those? Brute force using 2 for loop
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
		int[] num = {2,4,6,8,12};
		int target = 10;
		int[] expected = {0,3};
		Assert.assertArrayEquals(expected, findTwoSum(num, target));
	}
	
	@Test
	public void example2() {
		int[] num = {2,4,6,8};
		int target = 16;
		int[] expected = {3, 3};
		Assert.assertArrayEquals(expected, findTwoSum(num, target));
	}
	
	@Test
	public void example3() {
		int[] num = {2,4,6,8};
		int target = 17;
		int[] expected = {-1, -1};
		Assert.assertArrayEquals(expected, findTwoSum(num, target));
	}
	
	@Test
	public void example4() {
		int[] num = {};
		int target = 16;
		int[] expected = {-1, -1};
		Assert.assertArrayEquals(expected, findTwoSum(num, target));
	}
	
	@Test
	public void example5() {
		int[] num = {7,3,5,5,7};
		int target = 10;
		int[] expected = {0,1};
		Assert.assertArrayEquals(expected, findTwoSum(num, target));
	}
	
	public int[] findTwoSum(int[] num, int target)
	{
		if(num.length < 1)
			return new int[] {-1,-1};
		for(int i = 0; i < num.length; i++)
		{
			int diff = Math.abs(target - num[i]);
			for(int j = 0; j < num.length; j++)
			{
				if(num[j] == diff)
				return new int[] {i, j};
			}
		}
		return new int[] {-1,-1};
	}

}
