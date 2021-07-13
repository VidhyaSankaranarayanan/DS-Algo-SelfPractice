package week1day1;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ReverseInteger {

	/*
	 * 	1) Did I understand the problem? Yes
	 * 		-> If No, Ask the person to provide more detail with examples
	 * 		-> If yes, go to Next step
	 * 		
	 * 		What is the input? -> Integer
	 * 		What is the expected output? -> Integer
	 * 		Do I have constraints to solve the problem? Integer can be signed or unsigned
	 * 		Do I have all information to go to next step? Yes
	 * 		How big is your test data set will be? Max 10 digits
	 * 
	 *  2) Test Data set
	 *  
	 *  	Minimum of 3 data sets - Positive, Edge, Negative
	 *  	Validate with the interviewer if the data set is fine by his/her assumptions
	 *  
	 *   3) Do I know how to solve it? Yes
	 *   
	 *   	For loop with mod operator
	 *   	Yes - great is there an alternate solution?
	 *   	Stack
	 *   	No - Can I break down the problem into sub problems?
	 *   
	 *   4) Ask for hint (if you do not know how to solve it)
	 *   
	 *   5) Do I know alternate solutions as well? Yes
	 *   
	 *   	Yes - What are those? Stack
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
		long num = 1234;
		long res = 4321;
		Assert.assertEquals(res, reverse(num));
	}
	
	@Test
	public void example2() {
		long num = 1234567890;
		long res = 987654321;
		Assert.assertEquals(res, reverse(num));
	}
	
	@Test
	public void example3() {
		long num = -123;
		long res = -321;
		Assert.assertEquals(res, reverse(num));
	}
	
	
	
	// Space Complexity - O(1)
	// Time Complexity - O(N)
	public long reverse(long num)
	{
		long res;
		String output = "";
		if(num < 0)
		{
			output += "-";
			num *= -1;
		}
		long temp = num;
		while(temp != 0)
		{
			long rem = temp%10;
			if(rem!=0)
			output = output+rem;
			temp = temp/10;
		}
		res = Integer.parseInt(output);
		return res;
	}

}
