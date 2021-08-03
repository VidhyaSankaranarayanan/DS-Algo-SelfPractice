package week3day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class FindStartAndEndPosition {
	
	/*
	 * Given an array of integers nums sorted in ascending order, 
	 * find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
 
Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
	 */
	
	/*
	 * Input: Integer array & integer
	 * Output: Integer array
	 * Constraint: O(log n)
	 * 
	 */

	@Test
	public void test1() {
		int[] num = {5,7,7,8,8,10};
		int k = 8;
		Assert.assertTrue(Arrays.equals(new int[]{3, 4}, findIndex(num, k)));
	}
	
	@Test
	public void test2() {
		int[] num = {7,7,7,7,7,7};
		int k = 7;
		Assert.assertTrue(Arrays.equals(new int[]{0, 5}, findIndex(num, k)));
	}
	
	/*
	 * Pseudo code
	 * Initialize low1, low2 as 0, high1 & high2 as length-1
	 * Traverse until low1<=high1 or low2<=high2
	 * 	 Find mid1 using low1 & high1 & mid2 using low2 & high2
	 * 	 If mid1 equals target & mid1+1 equals target & mid1-1 not equals target
	 * 		low1 = mid1+1
	 * 	 If mid1 equals target & mid1-1 equals target & mid1+1 not equals target
	 * 		high1 = mid1-1
	 * 	 If both equals target
	 * 		high1= mid1-1 & low2 = mid1+1
	 */
	
	private int[] findIndex(int[] num, int k) {
		int low = 0, high = num.length-1, start = -1, end = -1;
		start = binarySearch(num, k, low, (num.length/2)-1);
		end = binarySearch(num, k, (num.length/2), high);
		return new int[] {start, end};
	}
	
	public int binarySearch(int[] num, int k, int low, int high) {
		int mid = 0;
		while(low <= high) {
			mid = (low + high)/2;
			if(num[mid] == k && num[mid-1] == k && num[mid+1] != k)
				high = mid-1;
			else if(num[mid] == k && num[mid+1] == k && num[mid-1] != k)
				low = mid+1;
				
		}
		return mid;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
