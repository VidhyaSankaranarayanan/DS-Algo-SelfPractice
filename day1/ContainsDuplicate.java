/**
 * 
 */
package assessment1;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class ContainsDuplicate {

	/*
		1) Did I understand the problem? Yes
	 * 		-> If No, Ask the person to provide more detail with examples
	 * 		-> If yes, go to Next step
	 * 		
	 * 		What is the input? -> Integer array
	 * 		What is the expected output? -> Boolean 
	 * 		Do I have constraints to solve the problem? 1 <= nums.length <= 105 & -109 <= nums[i] <= 109
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
	 *   	Hash Set
     *      Hash Map
	 *   	No - Can I break down the problem into sub problems?
	 *   
	 *   4) Ask for hint (if you do not know how to solve it)
	 *   
	 *   5) Do I know alternate solutions as well? Yes
	 *   
	 *   	Yes - What are those?
	 *   	Hash Map
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
		int[] nums = {1,2,3,1,4};
		Assert.assertEquals(true, containsDuplicate(nums));
	}

	@Test
	public void test2() {
		int[] nums = {1,2,3,4,5};
		Assert.assertEquals(false, containsDuplicate(nums));
	}

	@Test
	public void test3() {
		int[] nums = {1,1};
		Assert.assertEquals(true, containsDuplicate(nums));
	}
	
	/*
	    * Pseudo code - Using Hash set
	    * Create a Hash set
	    * Traverse through the array
	    *   If the set already contains the current value
	    *       return true
	    *   Else add the value to the set
	    * return false 
	    */


	public boolean containsDuplicate(int[] nums) {
	        Set<Integer> set = new HashSet<Integer>();
	        for(int i = 0; i < nums.length; i++) {
	            if(set.contains(nums[i]))
	                return true;
	            else
	                set.add(nums[i]);
	        }
	        return false;
	    }
}
