/**
 * 
 */
package week5day5;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class FindKthFactor {

	/*
		 * Input: 2 Integer
		 * Output: Integer
		 * Constraint: 
		 * Test Data:
		 * Positive: 7, 2
		 * Output: 7
		 * Edge: 1, 1
		 * Output: 1
		 * Negative: 6, 3
		 * Output: 3
		 * 
		 * Approach1: Brute force using List
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(n)
		 * 
		 * Approach2: Brute force without using List
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(1)
		 * 
		 * Approach3: 2 pointer using List
		 * Time Complexity: O(n/2)
		 * Space Complexity: O(n)
		 * 
		 * Approach4: 2 pointer without using List
		 * Time Complexity: O(n/2)
		 * Space Complexity: O(1)
		 */

	@Test
	public void test1() {
		int n = 7;
		int k = 2;
		Assert.assertEquals(7, findKthFactorWithoutList2Pointer(n, k));
	}

	@Test
	public void test2() {
		int n = 1;
		int k = 1;
		Assert.assertEquals(1, findKthFactorWithoutList2Pointer(n, k));
	}

	@Test
	public void test3() {
		int n = 4;
		int k = 4;
		Assert.assertEquals(-1, findKthFactorWithoutList2Pointer(n, k));
	}
	
	@Test
	public void test4() {
		int n = 12;
		int k = 7;
		Assert.assertEquals(-1, findKthFactorWithoutList2Pointer(n, k));
	}
	
	/*
	 * Pseudo code - Using List
	 * Create a list 
	 * Traverse from 1 until n
	 * 	 If the modulus of n by current index is 0
	 * 		Add it to the list
	 * Return value at k-1th index from the list if not present return -1
	 */
	
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	
	private int findKthFactor(int n, int k) {
		List<Integer> list = new ArrayList<Integer>();
		int index = 1;
		while(index <= n) {
			if(n % index == 0)
				list.add(index);
			index++;
		}
		return (k-1 < list.size())?list.get(k-1):-1;
	}
	
	/*
	 * Pseudo code - Brute force without using List
	 * Initialize count as 0
	 * Traverse from 1 until n
	 * 	 If the modulus of n by current index is 0
	 * 		Increment count
	 * 	 If the count is equal to k
	 * 		return i
	 * Return -1
	 */
	
	// Time Complexity: O(n)
	// Space Complexity: O(1)
		
	private int findKthFactorWithoutList(int n, int k) {
		int count = 0;
		for(int i = 1; i <= n; i++) {
			if(n%i == 0 && ++count == k)
				return i;
		}
		return -1;
	}
	
	/*
	 * 2 pointer - Using List
	 * Create a list for factors
	 * Create 2 pointers left as 1, right as 2
	 * Traverse until left less than or equal to n
	 * 		If the modulus of n by left & n by right is 0
	 * 			Add left, right to the list
	 * 		Increment left by right + 1
	 * 		Increment right by left + 1
	 * Return k-1 th index from the list if present
	 * Else return -1, if the index is not found
	 * 
	 */
	
	// Time Complexity: O(n/2)
	// Space Complexity: O(n)
	
	private int findKthFactorUsing2Pointer(int n, int k) {
		List<Integer> list = new ArrayList<Integer>();
		int left = 1, right = 2;
		while(left <= n) {
			if(n % left == 0)
				list.add(left);
			if(n % right == 0)
				list.add(right);
			left = right+1;
			right = left+1;
		}
		return (k-1 < list.size())?list.get(k-1):-1;
	}
	
	
	
	/*
	 * 2 pointer without using list
	 * Initialize count as 0
	 * Create 2 pointers left as 1, right as 2
	 * Traverse until left less than or equal to n
	 * 		If the modulus of n by left is 0 ++count equals to k
	 * 			return left
	 * 		If the modulus of n by right is 0, ++count equals to k
	 * 			return right
	 * 		Increment left by right + 1
	 * 		Increment right by left + 1
	 * return -1
	 * 
	 */
	
	// Time Complexity: O(n/2)
	// Space Complexity: O(1)
	
	private int findKthFactorWithoutList2Pointer(int n, int k) {
		int count = 0;
		int left = 1, right = 2;
		while(left <= n) {
			if(n % left == 0 && ++count == k)
				return left;
			if(n % right == 0 && ++count == k)
				return right;
			left = right + 1;
			right = left + 1;
		}
		return -1;
	}
		
}
