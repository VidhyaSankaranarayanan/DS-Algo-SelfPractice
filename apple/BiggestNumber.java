/**
 * 
 */
package apple;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;



/**
 * @author Vidhya
 *
 */
public class BiggestNumber {

	/*
		 * Input: Integer
		 * Output: Integer
		 * Constraint: 
		 * Test Data:
		 * Positive: 
		 * Output: 
		 * Edge: 
		 * Output: 
		 * Negative:
		 * Output: 
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */

	@Test
	public void test1() {
		int num = 2736;
		Assert.assertEquals(7236, findBiggestNumber(num));
	}

	@Test
	public void test2() {
		int num = 9973;
		Assert.assertEquals(9973, findBiggestNumber(num));
	}

	@Test
	public void test3() {
		int num = 1996;
		Assert.assertEquals(9916, findBiggestNumber(num));
	}
	
	@Test
	public void test4() {
		int num = 98143;
		Assert.assertEquals(98413, findBiggestNumber(num));
	}
	
	@Test
	public void test5() {
		int num = 98419;
		Assert.assertEquals(99418, findBiggestNumber(num));
	}
	
	@Test
	public void test6() {
		int num = 99739;
		Assert.assertEquals(99937, findBiggestNumber(num));
	}
	
//1996, 2736, 9973, 98143, 98419,  
	
	/*
	 * Pseudo code
	 * Create a list 
	 * Traverse through the number until > 0
	 * 		Find mod and add it to the list
	 * 		Divide the number by 10
	 * Initialize max as value at 0 and index as 0
	 * Traverse through the list
	 * 		Compare the values, find max and update the index
	 * Traverse through the list until maximum number's index
	 * 		If the value at the current index is less than max
	 * 			swap the value at current index and maximum value's index
	 * Using the string builder, append the values from the list
	 * Return the string builder to integer 
	 */
	//1996, 2736, 9973, 98143, 98419, 	
	private int findBiggestNumber(int num) {
		List<Integer> list = new ArrayList<Integer>();
		int temp = num;
		while(temp > 0) {
			list.add(0, temp%10);
			temp = temp/10;
		}
		int left = 0, right = 0, max = Integer.MIN_VALUE;
		for(left = 1; left < list.size()-1; left++) {
			if(list.get(left) > list.get(left-1)) 
				break;
		}
		for(int i = left; i < list.size(); i++) {
			if(list.get(i) >= max) {
				max = list.get(i);
				right = i;
			}
		}
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) < max) {
				int swap = list.get(i);
				list.set(i, max);
				list.set(right, swap);
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int each : list)
			sb.append(each);
		return Integer.parseInt(sb.toString());
	}
}
	
	
	
	
	
	
	
	
	

