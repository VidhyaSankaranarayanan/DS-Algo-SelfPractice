package week1day2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class IntersectionOfArrays {

	/*
	 * 	1) Did I understand the problem? Yes
	 * 		-> If No, Ask the person to provide more detail with examples
	 * 		-> If yes, go to Next step
	 * 		
	 * 		What is the input? -> 2 Integer arrays
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
		int[] arr1 = {1,2,2,1};
		int[] arr2 = {2,2};
		int[] res = {2};
		Assert.assertArrayEquals(res, findIntersection(arr1, arr2));
	}
	
	@Test
	public void test2() {
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {5,6,7,8};
		int[] res = {};
		Assert.assertArrayEquals(res, findIntersection(arr1, arr2));
	}
	
	@Test
	public void test3() {
		int[] arr1 = {1,2,3,4,5,4,3,2,1};
		int[] arr2 = {1,2,3,4,6,4,4,2,2,1};
		int[] res = {1,2,3,4};
		Assert.assertArrayEquals(res, findIntersection(arr1, arr2));
	}
	
	@Test
	public void test4() {
		int[] arr1 = {};
		int[] arr2 = {2,2};
		int[] res = {};
		Assert.assertArrayEquals(res, findIntersection(arr1, arr2));
	}
	
	@Test
	public void test5() {
		int[] arr1 = {};
		int[] arr2 = {};
		int[] res = {};
		Assert.assertArrayEquals(res, findIntersection(arr1, arr2));
	}

	/*
	 * Pseudo code
	 * Check if any one of the array is empty, return empty array
	 * Create an array of min length and declare a count variable
	 * Traverse through the array
	 *  -> Check if the current element is not present in the output array
	 *  	-> Traverse through the second array
	 *  	-> If the current element matches with the second array element
	 *  	-> Increment the count 
	 *  	-> Add it to the output array
	 *  	-> Break
	 *  -> Else continue
	 *  Return sub array of range from 0 to count
	 *  
	 */
	
	// Time Complexity: <O(n^3)
	// Space Complexity: O(n)
	
	private int[] findIntersection(int[] arr1, int[] arr2) {
		if(arr1.length == 0 || arr2.length == 0)
			return new int[] {};
		int length = (arr1.length < arr2.length)? arr1.length: arr2.length;
		int[] outputArray = new int[length];
		int index = 0;
		for(int i = 0; i < arr1.length; i++)
		{
			if(checkDataInOutputArray(outputArray, arr1[i]) && i!=0)
				continue;
			else
				for(int j = 0; j < arr2.length; j++)
				{
					if(arr1[i] == arr2[j])
					{
						outputArray[index++] = arr1[i];
						break;
					}
				}
		}
		
		return Arrays.copyOfRange(outputArray, 0, index);
	}
	
	
	private boolean checkDataInOutputArray(int[] arr, int num)
	{
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == num)
				return true;
		}
		return false;
	}
}
