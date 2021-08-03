/**
 * 
 */
package assessment2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class ReverseKElements {

	

	/*
		 * Input: Array, Integer
		 * Output: Integer array
		 * Constraint: Queue & Stack
		 * Test Data:
		 * Positive: {2,4,6,8,10}, K =3
		 * Output: {6,4,2,8,10}
		 * Edge: {1,2,3}, k =3
		 * Output: {3,2,1}
		 * Negative:{1,2,3}, k = 0
		 * Output: {1,2,3}
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */

	@Test
	public void test1() {
		int[] nums = {2,4,6,8,10};
		int k = 3;
		Assert.assertTrue(Arrays.equals(new int[] {6,4,2,8,10}, reverseKElements(nums, k)));
	}

	@Test
	public void test2() {
		int[] nums = {1,2,3};
		int k = 3;
		Assert.assertTrue(Arrays.equals(new int[] {3,2,1}, reverseKElements(nums, k)));
	}

	@Test
	public void test3() {
		int[] nums = {1,2,3};
		int k = 0;
		Assert.assertTrue(Arrays.equals(new int[] {1,2,3}, reverseKElements(nums, k)));
	}
	
	@Test (expected = RuntimeException.class)
	public void test4() {
		int[] nums = {1,2,3};
		int k = 4;
		Assert.assertTrue(Arrays.equals(new int[] {1,2,3}, reverseKElements(nums, k)));
	}

	/**
	 * @param nums
	 * @return
	 */
	
	
	
	/*
	 * Pseudo code
	 * Create a stack & queue
	 * Traverse through the array until k
	 * 		Add elements of array to the stack
	 * Traverse through the stack
	 * 		Pop the elements and add it to the queue
	 * Add the remaining elements to the queue
	 * Return the queue
	 */
	
	private int[] reverseKElements(int[] nums, int k) {
		if(k > nums.length)
			throw new RuntimeException("Invalid Input");
		Stack<Integer> stack = new Stack<Integer>();
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		for(int i = 0; i < k; i++)
			stack.push(nums[i]);
		while(!stack.isEmpty())
			queue.offer(stack.pop());
		for(int i = k; i < nums.length; i++)
				queue.offer(nums[i]);
		
		int[] output = new int[nums.length];
		int index = 0;
		while(!queue.isEmpty())
			output[index++] = queue.poll();
		return output;
	}
	
	
	
	
	
	
	
	
	
	
}
