package week3day2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class FindMissingNumber {

	/*
	 * Input: Integer array & target
	 * Output: Integer
	 * Constraint: Binary Search
	 * Test data: [2,3,4,7,11]; k = 5; Output: 9
	 * [1,2,3,4]; k = 2; Output: 6
	 * [2,3,4,7,11]; k = -1; Output: -1
	 */

	@Test
	public void test1() {
		int[] num = {2,3,4,7,11};
		int k = 5;
		Assert.assertEquals(9, findMissingNumberLinear(num, k));
		Assert.assertEquals(9, findMissingUingBinary(num, k));
	}

	@Test
	public void test2() {
		int[] num = {2,3,4,7,11};
		int k = -1;
		Assert.assertEquals(-1, findMissingNumberLinear(num, k));
		Assert.assertEquals(-1, findMissingUingBinary(num, k));
	}

	@Test
	public void test3() {
		int[] num = {1,2,3,4};
		int k = 2;
		Assert.assertEquals(6, findMissingNumberLinear(num, k));
		Assert.assertEquals(6, findMissingUingBinary(num, k));
	}

	/*
	 * Pseudo code
	 * Find length as last value + k
	 * Create an array list 
	 * Traverse from 1 to length
	 * Add each value to array list
	 * Traverse through the array
	 * 		If the current element is present in the list, remove it
	 * Return value at kth position
	 */

	private int findMissingNumberLinear(int[] num, int k) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= num.length+k; i++) 
			list.add(i);
		for(int i = 0; i < num.length; i++) {
			Integer	temp = num[i];
			list.remove(temp);
		}

		return list.get(k-1);
	}

	/*
	 * Pseudo code
	 * Initialize low as 0, high as length-1, mid as 0, missing as 0
	 * Traverse until low less than or equal to high
	 * 		Find mid
	 * 		Find missing from value at mid & index mid+1
	 * 		If missing < k
	 * 			low = mid+1
	 * 		else high = mid-1
	 * If high is -1, return k
	 * Find missing from value at high & index high + 1
	 * Return diff between value at high & k-missing
	 */

	private int findMissingUingBinary(int[] num, int k) {
		int low=0, high=num.length-1, mid=0;
		while(low<=high) {
			mid=(low+high)/2;
			if (num[mid]-(mid + 1) < k) low = mid + 1;    
			else high = mid -1;
		} 
		return high+k+1;
	}
}
