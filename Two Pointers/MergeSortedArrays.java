package week2day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergeSortedArrays {

	/*
	 * 	1) Did I understand the problem? Yes 
	 * 		
	 * 		What is the input? -> 2 input array & 2 integer for array lengths
	 * 		What is the expected output? -> Int array
	 * 		Do I have constraints to solve the problem? No
	 * 		Do I have all information to go to next step? Yes
	 * 		How big is your test data set will be? Smaller
	 * 
	 *  2) Test Data set
	 *  
	 *  	Minimum of 3 data sets - Positive, Edge, Negative
	 *  	Validate with the interviewer if the data set is fine by his/her assumptions
	 *  
	 *   3) Do I know how to solve it? Yes
	 *   
	 *   	Yes - great is there an alternate solution?
	 *   	No - Can I break down the problem into sub problems?
	 *   
	 *   4) Ask for hint (if you do not know how to solve it)
	 *   
	 *   5) Do I know alternate solutions as well? No
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
	
	// Brute Force Algorithm
	
	// Test Data set
	
	@Test
    public void example1() {
        int[] arr1 = {1,2,3,0,0,0};
        int m = 3, n = 3;
        int[] arr2 = {2,5,6};
        assertArrayEquals(new int[] {1,2,2,3,5,6}, mergeArrays(arr1, m, arr2, n));
    }
    @Test
    public void example2() {
    	int[] arr1 = {};
        int m = 0, n = 1;
        int[] arr2 = {1};
        assertArrayEquals(new int[] {1}, mergeArrays(arr1, m, arr2, n));
    }
    
    @Test
    public void example3() {
    	int[] arr1 = {1};
        int m = 1, n = 0;
        int[] arr2 = {0};
        assertArrayEquals(new int[] {1}, mergeArrays(arr1, m, arr2, n));
    }
    
    @Test
    public void example4() {
    	int[] arr1 = {2,2,0,0};
        int m = 2, n = 2;
        int[] arr2 = {2,2};
        assertArrayEquals(new int[] {2,2,2,2}, mergeArrays(arr1, m, arr2, n));
    }
    
    
    /*
     * Pseudo code
     * If m equals to 0, return arr2, if n equals to 0, return arr1
     * Initialize 2 pointers as m-1, n-1 and index as m+n-1
     * Traverse through the array until p1 >= 0 & p2 >= 0
     * 	If value at p1 greater than or equal to p2, value at index is value at p1
     * 		Decrement index, p2
     * 	Else value at index is value at p2
     * 		Decrement index, p1
     * Return the array1
     */
    
    private int[] mergeArrays(int[] arr1, int m, int[] arr2, int n) {
    	if(m == 0)
    		return arr2;
    	if(n == 0)
    		return arr1;
    	int p1 = m-1, p2 = n-1, index = m+n-1;
    	while(p1 >= 0 && p2 >= 0) {
    		if(arr1[p1] >= arr2[p2])
    			arr1[index--] = arr1[p1--];
    		else
    			arr1[index--] = arr2[p2--];
    	}
    	return arr1;
    }

}
