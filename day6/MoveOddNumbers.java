package week2day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class MoveOddNumbers {
	/*
	 * Do I understand the problem? yes
	 * Input: Input array
	 * Output: Output array
	 * Do I have any constraints? Any specific algorithm or data structure
	 * Any specific Order to send the array back -> Any Order
	 * Do I have all the information? Yes
	 * Test data
	 * {1,2,3,4,5} -> {2,4,1,3,5}
	 * {2,4,6,8,0} -> {2,4,6,8,0}
	 * {} -> {}
	 * {1,2,4,6,8} -> {2,4,6,8,1}
	 * Do I know alternate solution? Brute force, 2 pointer
	 */
	
	@Test
	public void example1() {
		int[] input = {1,2,3,4,5};
		Assert.assertTrue(Arrays.equals(new int[] {4,2,3,1,5}, moveOddNumbersToRight(input)));
	}
	@Test
	public void example2() {
		int[] input = {2,4,6,8,0};
		Assert.assertTrue(Arrays.equals(new int[] {2,4,6,8,0}, moveOddNumbersToRight(input)));
	}
	@Test
	public void example3() {
		int[] input = {};
		Assert.assertTrue(Arrays.equals(new int[] {}, moveOddNumbersToRight(input)));
	}
	@Test
	public void example4() {
		int[] input = {1,2,6,4,8};
		Assert.assertTrue(Arrays.equals(new int[] {8,2,6,4,1}, moveOddNumbersToRight(input)));
	}
	@Test
	public void example5() {
		int[] input = {2,2,2,2};
		Assert.assertTrue(Arrays.equals(new int[] {2,2,2,2}, moveOddNumbersToRight(input)));
	}
	@Test
	public void example6() {
		int[] input = {1,1,1,1};
		Assert.assertTrue(Arrays.equals(new int[] {1,1,1,1}, moveOddNumbersToRight(input)));
	}
	@Test
	public void example7() {
		int[] input = {2,3,5};
		Assert.assertTrue(Arrays.equals(new int[] {2,3,5}, moveOddNumbersToRight(input)));
	}
	
	/*
	 * 12345 -> 24315
	 * Pseudo code
	 * if array is empty, return empty array
	 * Initialize 2 pointers, left as 0 & right as length-1
	 * Traverse through the array until left < right
	 * 	-> If left is odd & right is even swap the values, increment left & decrement right
	 *  -> Else If both left & right are odd, decrement right
	 *  -> Else increment left & decrement right
	 * Return array
	 */

	// Time Complexity: O(n)
	// Space Complexity: O(1)
	
	private int[] moveOddNumbersToRight(int[] input) {
		if(input.length <= 1)
			return input;
		int left = 0, right = input.length-1;
		while(left < right) {
			if(input[left] %2 != 0 && input[right] %2 == 0) {
				int swap = input[left];
				input[left++] = input[right];
				input[right--] = swap;
			}
			else if(input[left] %2 != 0 && input[right] %2 != 0) right--;
			else {
				left++;
				right--;
			}
		}
		return input;
	}
	
	/*
	 * Pseudo code
	 * Create 2 array list for odd & even values
	 * Traverse through the array
	 * 	-> If the value at current index is odd, add it to the odd array list
	 *  -> Else to the even array list
	 * Initialize index as 0
	 * Add even array list first & then odd array list
	 * Return the output array
	 */
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	private int[] moveOddNumbersUsingBruteForce(int[] input) {
		if(input.length <= 1)
			return input;
		
		List<Integer> oddList = new ArrayList<Integer>();
		List<Integer> evenList = new ArrayList<Integer>();
		for(int i = 0; i < input.length; i++) {
			if(input[i] %2 != 0)
				oddList.add(input[i]);
			else
				evenList.add(input[i]);
		}
		int index = 0;
		for(int i = 0; i < input.length; i++) {
			if(!evenList.isEmpty())
			input[index++] = evenList.remove(0);
			else
				input[index++] = oddList.remove(0);
		}
//		for(int i : evenList) 
//			outputArray[index++] = i;
//		for(int i : oddList)
//			outputArray[index++] = i;
		return input;
	}

}
