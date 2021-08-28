/**
 * 
 */
package assessment1;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;



/**
 * @author Vidhya
 *
 */
public class IntersectionOfArrays {

	/*
		 * 	1) Did I understand the problem? Yes
	 * 		-> If No, Ask the person to provide more detail with examples
	 * 		-> If yes, go to Next step
	 * 		
	 * 		What is the input? -> 2 Integer arrays
	 * 		What is the expected output? -> Integer array
	 * 		Do I have constraints to solve the problem? 1 <= nums1.length, nums2.length <= 1000
     *          & 0 <= nums1[i], nums2[i] <= 1000
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
     *      Hash Map
     *      No - Can I break down the problem into sub problems?
	 *   
	 *   4) Ask for hint (if you do not know how to solve it)
	 *   
	 *   5) Do I know alternate solutions as well? Yes
	 *   
	 *   	Yes - What are those?  Hash Map
     *      No - That is still fine, proceed to solve what you know
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
		int[] nums1 = {5,4,3,2,1};
		int[] nums2 = {2,3,5};
		Assert.assertTrue(Arrays.equals(new int[] {2,3,5}, intersect(nums1,nums2)));
	}

	@Test
	public void test2() {
		int[] nums1 = {5,4,3,4,1};
		int[] nums2 = {2,4,4};
		Assert.assertTrue(Arrays.equals(new int[] {4,4}, intersect(nums1,nums2)));
	}

	@Test
	public void test3() {
		int[] nums1 = {5,4,3,2,1};
		int[] nums2 = {};
		Assert.assertTrue(Arrays.equals(new int[] {}, intersect(nums1,nums2)));
	}
	
	 /*
	    *   Pseudo code - 2 pointer
	    *   Check if any one of the array is empty, return empty array
	    *   Find the minimum length between 2 arrays
	    *   Create an array of minimum length
	    *   Initialize 2 pointers p1, p2 as 0 for two arrays and index for output array
	    *   Sort the arrays
	    *   Traverse through the array until p1 < arr1 and p2 < arr2
	    *   If value at p1 is same as value at p2
	    *       add value at p1 to output array, increment index
	    *   If value at p1 is less than value at p2
	    *       increment p1
	    *   If value at p2 is less than value at p1
	    *       increment p2
	    *   Return the subarray from 0 to index
	    */

	// Time Complexity: O(nlogn)
	// Space Complexity: O(n)

	public int[] intersect(int[] nums1, int[] nums2) {
	        if(nums1.length == 0 || nums2.length == 0)
	            return new int[] {};
	        int length = (nums1.length < nums2.length) ? nums1.length : nums2.length;
	        int[] output = new int[length];
	        int p1 = 0, p2 = 0, index = 0;
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        while(p1 < nums1.length && p2 < nums2.length) {
	            if(nums1[p1] == nums2[p2])  {
	               output[index++] = nums1[p1];
	                p1++;
	                p2++;
	            }
	            else if(nums1[p1] < nums2[p2])
	                p1++;
	            else
	                p2++;
	        }
	        return Arrays.copyOfRange(output, 0, index);
	    }
}
