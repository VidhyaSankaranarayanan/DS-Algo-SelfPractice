package week2day1;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class HappyNumber {

	/*
	 * Write an algorithm to determine if a number n is happy. 
	 * A happy number is a number defined by the following process:
	 * Starting with any positive integer, 
	 * replace the number by the sum of the squares of its digits.
	 * Repeat the process until the number equals 1 (where it will stay), 
	 * or it loops endlessly in a cycle which does not include 1.
	 * Those numbers for which this process ends in 1 are happy.
	 * Return true if n is a happy number, and false if not.
	 */
	
	/*
	 * 	1) Did I understand the problem? Yes
	 * 		-> If No, Ask the person to provide more detail with examples
	 * 		-> If yes, go to Next step
	 * 		
	 * 		What is the input? -> Integer
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
		int num = 19;
		Assert.assertEquals(true, findHappyNumber(num));
	}
	
	@Test
	public void test2() {
		int num = 2;
		Assert.assertEquals(false, findHappyNumber(num));
	}
	
	@Test
	public void test3() {
		int num = 25;
		Assert.assertEquals(false, findHappyNumber(num));
	}
	

	/*
	 * Pseudo code
	 * 1. Initialize sum as num
	 * 2. Create a set for storing square values
	 * 3. Initialize num as sum & sum as 0
	 * 4. Traverse until num becomes 0
	 * 	-> For each digit in the num (using modulo)
	 *  -> Compute the square (using *) and add it to the sum
	 *  -> Divide the num by 10 to get the remaining digits
	 * 5. Add the sum to the set, if it not contains
	 * 	-> otherwise return false
	 * 6. Repeat 3,4,5 till sum is 1 (using do-while)
	 * 7. return true 
	 *  
	 */
	
	// Time Complexity: O(n*m)
	// Space Complexity: O(n)
	
	private boolean findHappyNumber(int num) {
		int sum = num;
        Set<Integer> set = new HashSet<>();
        do {
            num = sum;
            sum = 0;
            while (num != 0) {
                int digit = num % 10;
                digit *= digit;
                sum += digit;
                num /= 10;

            }
            if (!set.add(sum)) return false;
        } while (sum != 1);

        return true;
	}

}
