package week2day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class FindAnagrams {

	/*
	 * 	1) Did I understand the problem? Yes 
	 * 		
	 * 		What is the input? -> 2 string
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
	 *   	Using HashMap + Sliding Window
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
        String s = "cbaebabacd";
        String p = "abc";
        assertArrayEquals(new int[] {0,6}, findAnagrams(s,p));
    }
    @Test
    public void example2() {
    	String s = "cbaebabacd";
        String p = "";
        assertArrayEquals(new int[] {}, findAnagrams(s,p));
    }
    
    @Test
    public void example3() {
    	String s = "cbaebabacd";
        String p = "fgh";
        assertArrayEquals(new int[] {}, findAnagrams(s,p));
    }
    
    @Test
    public void example4() {
    	String s = "ccccc";
        String p = "c";
        assertArrayEquals(new int[] {0,1,2,3,4}, findAnagrams(s,p));
    }
    
    @Test
    public void example5() {
    	String s = "abcdefhg";
        String p = "fgh";
        assertArrayEquals(new int[] {5}, findAnagrams(s,p));
    }
    
    /*
     * Pseudo code
     * If the pattern length is 0, return empty array
     * Create an output array of string length & index as 0
     * Create 2 maps, add pattern characters as key & occurrence as value in a map
     * Add string characters as key & occurrence as value in another map till pattern length
     * Check both the maps are same, if so add 0 to index 1 of output array
     * Traverse through the string from 1 to length - pattern length
     * 	-> If the map contains the value of the previous character greater than 1
     * 		Decrement 1 from the value
     * 	-> Else assign it as 0
     * 	-> Add character at pattern's length - 1 to the map
     * 	-> Compare two maps, if it same, add current index to the array
     * Return array
     */
    // cbaebabacd
    private int[] findAnagrams(String input, String pattern) {
    	if(pattern.length() == 0)
    		return new int[] {};
    	int[] outputArray = new int[input.length()];
    	int index = 0;
    	Map<Character, Integer> mapInput = new HashMap<Character, Integer>();
    	Map<Character, Integer> mapPattern = new HashMap<Character, Integer>();
    	for(int i = 0; i < pattern.length(); i++) {
    		mapInput.put(input.charAt(i), mapInput.getOrDefault(input.charAt(i), 0) +1);
    		mapPattern.put(pattern.charAt(i), mapPattern.getOrDefault(pattern.charAt(i), 0) +1);
    	}
    	if(mapInput.equals(mapPattern)) outputArray[index++] = 0;
    	
    	for(int i = 1; i <= input.length()-pattern.length(); i++) {
    		if(mapInput.get(input.charAt(i-1)) > 1)
    			mapInput.put(input.charAt(i-1), mapInput.getOrDefault(input.charAt(i-1), 0)-1);
    		else
    			mapInput.remove(input.charAt(i-1));
    		mapInput.put(input.charAt(i+pattern.length()-1), 
    				mapInput.getOrDefault(input.charAt(i+pattern.length()-1), 0)+1);
    		if(mapInput.equals(mapPattern))
    			outputArray[index++] = i;
    	}
    	return Arrays.copyOf(outputArray, index);
    }

}
