package week3day2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ClosestSum {
	
	/*
	 * Input: Integer array, integer
	 * Output: Integer
	 * Constraint: Use Binary Search
	 */

	@Test
	void test() {
		int[] num = {34,23,1,24,75,33,54,8};
		int k = 60;
		Assert.assertEquals(58, findClosestSum(num, k));
	}
	
	/*
	 * Pseudo code
	 * Sort the array
	 * Initialize low as 0, high as length-1, max as -1
	 * Traverse until low < high
	 * 		Find mid
	 * 		Compare and get the greatest sum of (mid & mid+1) and (mid & mid-1) and less that target
	 * 		if the sum of mid & mid+1 greater than target
	 * 			high = mid-1
	 * 		else
	 * 			low - mid+1
	 * return max	
	 * 
	 * 
	 *  
	 */
	
	private int findClosestSum(int[] num, int k) {
		Arrays.sort(num);
		int low = 0, high = num.length-1, max = -1;
		return 0;
	}

}
