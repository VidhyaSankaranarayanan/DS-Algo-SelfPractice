package week2day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class ValidPalindrome {

	/*
	 * 	1) Did I understand the problem? Yes 
	 * 		
	 * 		What is the input? -> String
	 * 		What is the expected output? -> Boolean
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
	 *   	Using HashSet
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
	
	// Test Data set
	
	@Test
    public void example1() {
        String s = "aba";
        assertEquals(true, validPalindrome(s));
    }
    @Test
    public void example2() {
    	String s = "abca";
        assertEquals(true, validPalindrome(s));
    }
    
    @Test
    public void example3() {
    	String s = "abc";
        assertEquals(false, validPalindrome(s));
    }
    
    @Test
    public void example4() {
    	String s = "aaaaa";
        assertEquals(true, validPalindrome(s));
    }
    
    @Test
    public void example5() {
    	String s = "";
        assertEquals(false, validPalindrome(s));
    }
    
    /*
     * Pseudo code
     * If string length is 0, throw exception
     * Create a set
     * Traverse through the string
     * 	-> If the set already contains the current character, remove it
     * 	-> Else add it
     * If the set size is 2 & string length is even return true
     * If the set size is 1 & string length is odd, return true
     * Else return false
     */
    
    private boolean validPalindrome(String input) {
    	if(input.length() == 0)
    		throw new RuntimeException("Invalid Input");
    	Set<Character> set = new HashSet<Character>();
    	for(int i = 0; i < input.length(); i++) {
    		if(set.contains(input.charAt(i)))
    			set.remove(input.charAt(i));
    		else
    			set.add(input.charAt(i));
    	}
    	return set.size()==2 || set.size()==1 ? true : false;
    }

}
