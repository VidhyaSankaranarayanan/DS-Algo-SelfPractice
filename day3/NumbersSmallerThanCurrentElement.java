package week1day3;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class NumbersSmallerThanCurrentElement {

	/*
	 * Given the array nums, for each nums[i] 
	 * find out how many numbers in the array are smaller than it. 
	 * That is, for each nums[i] you have to count the number of valid j's 
	 * such that j != i and nums[j] < nums[i].
	 * Return the answer in an array.
	 * return the only number in the range that is missing from the array
	 */

	/*
	 * 	1) Did I understand the problem? Yes
	 * 		-> If No, Ask the person to provide more detail with examples
	 * 		-> If yes, go to Next step
	 * 		
	 * 		What is the input? -> Integer array
	 * 		What is the expected output? -> Integer array
	 * 		Do I have constraints to solve the problem? 2 <= nums.length <= 500 & 0 <= nums[i] <= 100
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
	 *   	Using Sort
	 *   	No - Can I break down the problem into sub problems?
	 *   
	 *   4) Ask for hint (if you do not know how to solve it)
	 *   
	 *   5) Do I know alternate solutions as well? Yes
	 *   
	 *   	Yes - What are those? Brute force
	 *   	Using Sort
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
		int[] input = {8,1,2,2,3};
		assertArrayEquals(new int[] {4,0,1,1,3}, findSmallerElements(input));
		assertArrayEquals(new int[] {0,1,1,3,4}, findSmallerElementsUsingSort(input));
		assertArrayEquals(new int[] {0,1,1,3,4}, findSmallerElementsUsingMap(input));
	}
	
	@Test
	public void test2() {
		int[] input = {6,5,4,8};
		assertArrayEquals(new int[] {2,1,0,3}, findSmallerElements(input));
		assertArrayEquals(new int[] {0,1,2,3}, findSmallerElementsUsingSort(input));
		assertArrayEquals(new int[] {0,1,2,3}, findSmallerElementsUsingMap(input));
	}
	
	@Test
	public void test3() {
		int[] input = {7,7,7,7};
		assertArrayEquals(new int[] {0,0,0,0}, findSmallerElements(input));
		assertArrayEquals(new int[] {0,0,0,0}, findSmallerElementsUsingSort(input));
		assertArrayEquals(new int[] {0,0,0,0}, findSmallerElementsUsingMap(input));
	}
	
	/*
	 * Pseudo code - Brute force
	 * Initialize count variable with 0 and declare an array of input size
	 * Traverse through the array
	 *  -> Initialize count as 1
	 *  -> Traverse through the array
	 *  -> Check if i!=j and value at i > value at j
	 *  -> If yes, increment count
	 * Add the count to the output array of index i
	 * Return the array
	 */
	
	// Time Complexity: O(n^2)
	// Space Complexity: O(n)
	
	private int[] findSmallerElements(int[] input) {
		int count = 0;
		int[] output = new int[input.length];
		
		for(int i = 0; i < input.length; i++)
		{
			count = 0;
			for(int j = 0; j < input.length; j++)
			{
				if(i!=j && input[i] > input[j])
					count++;
			}
			output[i] = count;
		}
		return output;
	}
	
	/*
	 * Pseudo code - Using Sort
	 * Sort the array
	 * Create an output array of input array's size
	 * Traverse through the array
	 * If i = 0, initialize value at 0th index as 0 in output array
	 * Else
	 * check if the value at previous index is not same as current index, if yes
	 * initialize current value as current index in output array
	 * Else current value as previous value
	 * Return the output array 
	 */
	
	// Time Complexity: O(nlogn) + O(n) = O(nlogn)
	// Space Complexity: O(n)
	
	private int[] findSmallerElementsUsingSort(int [] input) {
		Arrays.sort(input);
		
		int[] output = new int[input.length];
		for(int i = 0; i < input.length; i++)
		{
			if(i==0)
				output[i] = 0;
			else {
				if(input[i] != input[i-1])
					output[i] = i;
				else
					output[i] = output[i-1];
			}
		}
		return output;
	}
	
	/*
	 * Pseudo code
	 * Sort the array
	 * Create an output array of input array's length
	 * Create a Hash map and add array elements as key & its occurrence as value
	 * Get the values of map and store it an array list
	 * Get the sum of elements in the list
	 * Get the size as list's size -1
	 * Traverse from the last of the output array
	 * -> Initialize temp with list's last value
	 * -> Subtract temp from sum
	 * -> Traverse until temp becomes 0 
	 *   -> and add sum to the output array
	 *   -> Decrement temp & i
	 * -> Decrement size
	 * Return the output array
	 */
	
	// Time Complexity: O(nlogn) + O(n) + O(n) + O(n) = O(nlogn)
	// Space Complexity: O(n) + O(n) + O(n) = O(n)
	
	 private int[] findSmallerElementsUsingMap(int[] input) {
		 int[] output = new int[input.length];
		 Arrays.sort(input);
		 Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		 for(int i : input)
			 map.put(i, map.getOrDefault(i, 0)+1);
		 
		 List<Integer> list = new ArrayList<Integer>(map.values());
		 int size = list.size()-1;
		 int sum = 0;
		 for(int i = 0; i < list.size(); i++)
			 sum += list.get(i);
		 int i = output.length-1;
		 while(i>=0)
		 {
			 int temp = list.get(size);
			 sum -= temp;
				
			 while(temp!=0)
			 {
				output[i] = sum; 
				temp--;
				i--;
			 }
			 size--;
		 }
		 return output;
	 }
	
	
	
	
}
