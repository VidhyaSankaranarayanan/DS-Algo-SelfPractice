package week2day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ShortestDistanceOfACharacter {

	/*
	 * Given a string s and a character c that occurs in s, 
	 * return an array of integers answer 
	 * where answer.length == s.length and 
	 * answer[i] is the distance from index i to the closest occurrence of character c in s.
	 * The distance between two indices i and j is abs(i - j), 
	 * where abs is the absolute value function.
	 */

	/*
	 * 	1) Did I understand the problem? Yes
	 * 		-> If No, Ask the person to provide more detail with examples
	 * 		-> If yes, go to Next step
	 * 		
	 * 		What is the input? -> String & Character
	 * 		What is the expected output? -> Integer array
	 * 		Do I have constraints to solve the problem? 1 <= s.length <= 104
	 * 		s[i] and c are lowercase English letters. & It is guaranteed that c occurs at least once in s.
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
	 *   	Yes - great is there an alternate solution? 2 pointer
	 *   	No - Can I break down the problem into sub problems?
	 *   
	 *   4) Ask for hint (if you do not know how to solve it)
	 *   
	 *   5) Do I know alternate solutions as well? Yes
	 *   
	 *   	Yes - What are those? Brute force
	 *   	2 pointer
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
		String s = "loveleetcode";
		char c = 'e';
		int[] output = {3,2,1,0,1,0,0,1,2,2,1,0};
		assertArrayEquals(output, findShortestDistance(s,c));
	}
	
	@Test
	public void test2() {
		String s = "aaab";
		char c = 'b';
		int[] output = {3,2,1,0};
		assertArrayEquals(output, findShortestDistance(s,c));
	}
	
	@Test
	public void test3() {
		String s = "baaab";
		char c = 'b';
		int[] output = {0,1,2,1,0};
		assertArrayEquals(output, findShortestDistance(s,c));
	}
	
	@Test
	public void test4() {
		String s = "baaac";
		char c = 'b';
		int[] output = {0,1,2,3,4};
		assertArrayEquals(output, findShortestDistance(s,c));
	}
	
	@Test
	public void test5() {
		String s = "bbbbb";
		char c = 'b';
		int[] output = {0,0,0,0,0};
		assertArrayEquals(output, findShortestDistance(s,c));
	}
	
	@Test
	public void test6() {
		String s = "abaa";
		char c = 'b';
		int[] output = {1,0,1,2};
		assertArrayEquals(output, findShortestDistance(s,c));
	}
	
	/*
	 * Pseudo code
	 * Initialize 4 variables left, right, prev & index as 0
	 * Create output array
	 * Find the first occurrence index of character and initialize to right
	 * Iterate through the string until left less than right
	 * 	Add difference between left & right to the output array
	 * Iterate from left till length of the string
	 * 	If left & right are same
	 * 		Iterate through the string until character at right not equal to given character & right < length - 1
	 * 		Assign left value to prev
	 * 		If value at right index is not equal to given character, initialize right as prev
	 * 	Calculate the minimum value between difference of right & left and prev & left
	 * 	Add it to the output array
	 * 	Increment left
	 * Return the output array
	 * 
	 */
	
	// Time: O(2n) -> O(n)[For indexOf] + O(n)[Traversal] -> O(n)
	// Space: O(n)[For Array]
	
	private int[] findShortestDistance(String s, char c) {
		int left = 0, right = 0, prev = 0, index = 0;
		int[] outputArray = new int[s.length()];
		right = s.indexOf(c);
		for(left = 0; left < right; left++)
			outputArray[index++] = Math.abs(left - right);
		while(left < s.length()){
			if(left == right) {
				while(right < s.length()-1 && s.charAt(++right) != c)
					continue;
				prev = left;
				// Added below condition for one of the test data : String - baaac & char: b
				if(s.charAt(right) != c)
					right = prev;
			}
			outputArray[index++] = Math.min(Math.abs(right - left), Math.abs(prev - left));
				left++;
		}
		return outputArray;
	}
	
	/*
	 * Pseudo code
	 * Convert the string to char array
	 * Create an output array of string length
	 * Traverse through the array
	 * 	Initialize min as Integer's max value
	 * 	If the current character is same as given char
	 * 	Initialize current index value in array with 0
	 * 	Traverse through the array
	 * 		Find the minimum value of j for each occurrence
	 * 	Add the min value to the current index
	 * Return the array
	 */
	
	// Time: O(n^2)
	// Space: O(n)
	
	private int[] closestOccurrenceOfChar(String s, char c) {

        if(s.length()==1 && s.charAt(0)==c) return new int[]{0};
        char[] chars = s.toCharArray();
        int[] answer = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            int min = Integer.MAX_VALUE;
            if (chars[i] == c) {
                answer[i] = 0;
                continue;
            }
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == c)
                    min = Math.min(Math.abs(j - i), min);
            }
            answer[i] = min;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
