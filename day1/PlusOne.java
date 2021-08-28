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
public class PlusOne {

	/*
		* 	1) Did I understand the problem? Yes
	 * 		-> If No, Ask the person to provide more detail with examples
	 * 		-> If yes, go to Next step
	 * 		
	 * 		What is the input? -> Integer array
	 * 		What is the expected output? -> Integer array
	 * 		Do I have constraints to solve the problem? 1 <= digits.length <= 100 & 0 <= digits[i] <= 9
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
	 *   	
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
		int[] digits = {9,8,7,6,5,4,3,2,1,9};
		Assert.assertTrue(Arrays.equals(new int[]{9,8,7,6,5,4,3,2,2,0}, findPlusOne(digits)));
	}

	@Test
	public void test2() {
		int[] digits = {4,3,2,1};
		Assert.assertTrue(Arrays.equals(new int[]{4,3,2,2}, findPlusOne(digits)));
	}

	@Test
	public void test3() {
		int[] digits = {0};
		Assert.assertTrue(Arrays.equals(new int[] {1}, findPlusOne(digits)));
	}
	
	 /*
	    *   Pseudo code
	    *   If the array length is empty, 
	    *       return the input
	    *   Convert the array to string
	    *   Initialize value and convert the string to integer value
	    *   Add 1 to the value
	    *   Convert and assign the value to same string
	    *   Return the string value by converting it to array
	    */

	// Time Complexity: O(n)
	// Space Complexity : O(n)

	public int[] plusOne(int[] digits) {
	        if(digits.length == 0)
	            return digits;
	        String str = "";  
	        for(int i = 0; i < digits.length; i++)
	            str = str + digits[i];
	        long integerValue = Long.parseLong(str);
	        integerValue += 1;
	        str = Long.toString(integerValue);
	        int[] output = new int[str.length()];
	        // Failing in converting character to integer
	        for(int i = str.length()-1; i >=0; i--) {
	           output[i] = (int) (integerValue%10);
	           integerValue /= 10;
	        }
	        return output;
	    }
	
	/*
	 * Pseudo code
	 * If the length of the array is 0, return the array
	 * Initialize div as 1, placeHolder as 1
	 * Initialize n as 0
	 * Traverse through the array
	 * 		Multiply 10 to n and add current element
	 * Add 1 to n
	 * Traverse until n/div >= 10
	 * 		Increment placeHolder by 1
	 * 		Multiply div by 10
	 * Create an array of size placeHolder
	 * Initialize index as placeHolder-1
	 * Traverse until placeHolder becomes 0
	 * 		Add each value to the array from the last (using mod)
	 * 		Divide the number by 10
	 * Create an integer array
	 * Traverse through the output long array
	 * 		Add each element to the integer array
	 * Return integer array
	 */
	
	public int[] plusOneOptimized(int[] digits) {
		if(digits.length == 0)
            return digits;
		int div = 1, placeValue = 1;
		long n = 0;
		for(int i = 0; i < digits.length; i++) 
			n = n * 10 + digits[i];
		n = n+1;
		while(n/div >= 10) {
			placeValue++;
			div *=10;
		}
		
		long[] output = new long[placeValue];
		int index = placeValue - 1;
		while(n!=0) {
			output[index--] = n%10;
			n = n/10;
		}
		int[] arr = new int[output.length];
		for(int i = 0; i < arr.length; i++)
			arr[i] = (int)output[i];
		return arr;
	}
	
	/*
	 * Pseudo code
	 * Initialize n as array's length
	 * Traverse from the array end
	 * 		If current element is less than 9
	 * 			increment current element and return the array
	 * 		initialize current value as 0
	 * Create an array of size n+1
	 * Assign 1 to the first element 
	 * Return new array
	 */
	
	private int[] findPlusOne(int[] digits) {
		int n = digits.length;
	    for(int i=n-1; i>=0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++;
	            return digits;
	        }
	        
	        digits[i] = 0;
	    }
	    
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;
	    
	    return newNumber;
	}
}
