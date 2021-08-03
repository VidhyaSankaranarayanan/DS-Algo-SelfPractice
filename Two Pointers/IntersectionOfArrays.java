package week2day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	 *   	2 pointer
	 *   	No - Can I break down the problem into sub problems?
	 *   
	 *   4) Ask for hint (if you do not know how to solve it)
	 *   
	 *   5) Do I know alternate solutions as well? Yes
	 *   
	 *   	Yes - What are those? 
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
		Assert.assertArrayEquals(res, findIntersectionUsing2Pointer(arr1, arr2));
	}
	
	@Test
	public void test2() {
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {5,6,7,8};
		int[] res = {};
		Assert.assertArrayEquals(res, findIntersectionUsing2Pointer(arr1, arr2));
	}
	
	@Test
	public void test3() {
		int[] arr1 = {1,2,3,4,5,4,3,2,1};
		int[] arr2 = {1,2,3,4,6,4,4,2,2,1};
		int[] res = {1,2,3,4};
		Assert.assertArrayEquals(res, findIntersectionUsing2Pointer(arr1, arr2));
	}
	
	@Test
	public void test4() {
		int[] arr1 = {};
		int[] arr2 = {2,2};
		int[] res = {};
		Assert.assertArrayEquals(res, findIntersectionUsing2Pointer(arr1, arr2));
	}
	
	@Test
	public void test5() {
		int[] arr1 = {};
		int[] arr2 = {};
		int[] res = {};
		Assert.assertArrayEquals(res, findIntersectionUsing2Pointer(arr1, arr2));
	}

	/*
	 * Pseudo code
	 * Check the length of the arrays, if any one is empty return empty array
	 * Create an array list
	 * Sort 2 arrays
	 * Initialize 2 pointers for array1 as 0 & array2 as 0
	 * Traverse through the arrays until array1 and array2's pointers becomes length-1
	 * 	-> Compare value at p1 in array1 with p2 in array2
	 *  -> If same, add it to the list if the value is not there in the list
	 *  	-> Increment p1 & p2
	 *  -> else if value at p1 of array1 is less than value at p2 of array2
	 *  	-> Increment p1
	 *  -> else if value at p1 of array1 is greater than value at p2 of array2
	 *  	-> Increment p2
	 *  Return the list by converting it to array 
	 *  
	 */
	
	// Time Complexity: O(n logn) + O(n) + O(n) = O(n logn)
	// Space Complexity: O(2n) = O(n)
	
	private int[] findIntersectionUsing2Pointer(int[] arr1, int[] arr2) {
		if(arr1.length == 0 || arr2.length == 0)
			return new int[] {};
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int p1 = 0, p2 = 0;
		while(p1 < arr1.length && p2 < arr2.length) {
			if(arr1[p1] == arr2[p2]) {
				if(!list.contains(arr1[p1]))
					list.add(arr1[p1]);
				p1++;
				p2++;
			}
			else if(arr1[p1] < arr2[p2])
				p1++;
			else if(arr1[p1] > arr2[p2])
				p2++;
					
		}
		int[] output = new int[list.size()];
		for(int i = 0; i < list.size(); i++)
			output[i] = list.get(i);
		return output;
	}
	
	
}
