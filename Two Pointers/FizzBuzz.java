/**
 * 
 */
package assessment2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class FizzBuzz {

	/*
		 * Input: Integer
		 * Output: String array
		 * Constraint: Use 2 pointer with Hash Map
		 * Test Data: 
		 * Positive: n = 5
		 * Output: {"1","2","Fizz","4","Buzz"}
		 * Edge: n = 1
		 * Output: {"1"}
		 * Negative:
		 * Output: 
		 * 
		 * Approach: 2 pointer with hash map
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(n)
		 */

	@Test
	public void test1() {
		int n = 5;
		Assert.assertTrue(Arrays.equals(new String[] {"1","2","Fizz","4","Buzz"}, findFizzBuzzSeries(n)));
	}

	@Test
	public void test2() {
		int n = 1;
		Assert.assertTrue(Arrays.equals(new String[] {"1"}, findFizzBuzzSeries(n)));
	}

	@Test
	public void test3() {
		int n = 3;
		Assert.assertTrue(Arrays.equals(new String[] {"1","2","Fizz"}, findFizzBuzzSeries(n)));
	}

	
	/*
	 * Pseudo code
	 * Create a map 
	 * Initialize 2 pointers left as 1, right as n
	 * Traverse until left <= right
	 * 		If left%3 == 0 && left%5 ==0, add left as key and FizzBuzz as value
	 * 		If left%3 ==0 && left%5 != 0, add left as key and Fizz as value
	 * 		If left%5 ==0 && left%3 != 0, add left as key and Buzz as value
	 * 		else add left as key & left as value
	 * 	  If left is not equal to right, check the following conditions
	 * 		If right%3 == 0 && right%5 ==0, add right as key and FizzBuzz as value
	 * 		If right%3 ==0 && right%5 != 0, add right as key and Fizz as value
	 * 		If right%5 ==0 && right%3 != 0, add right as key and Buzz as value
	 * 		else add right as key & right as value
	 * Return map values
	 */
	
	private String[] findFizzBuzzSeries(int n) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(3, "Fizz");
		String[] output = new String[n];
		int left = 1, right = n;
		while(left <= right) {
			if((left % 3 == 0) && (left % 5 == 0))
				map.put(left, "FizzBuzz");
			else if((left % 3 == 0) && (left % 5 != 0))
				map.put(left, "Fizz");
			else if((left % 3 != 0) && (left % 5 == 0))
				map.put(left, "Buzz");
			else
				map.put(left, Integer.toString(left));
			if((right % 3 == 0) && (right % 5 == 0))
					map.put(right, "FizzBuzz");
				else if((right % 3 == 0) && (right % 5 != 0))
					map.put(right, "Fizz");
				else if((right % 3 != 0) && (right % 5 == 0))
					map.put(right, "Buzz");
				else
					map.put(right, Integer.toString(right));
			
			left++; right--;
		}
		
		for(int i = 0; i < n; i++)
			output[i] = map.get(i+1);
		return output;
	}
	
}
