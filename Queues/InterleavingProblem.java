/**
 * 
 */
package assessment2;

import java.util.ArrayDeque;
import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class InterleavingProblem {

	/*
		 * Input: Integer array
		 * Output: Integer array
		 * Constraint: Queue
		 * Test Data:
		 * Positive: {1,3,5,7,2,4,6,8}
		 * Output: {1,2,3,4,5,6,7,8}
		 * Edge: {1,2}
		 * Output: {1,2}
		 * Negative: {1}
		 * Output: {1}
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(n)
		 */

	@Test
	public void test1() {
		int[] num = {1,3,5,7,2,4,6,8};
		Assert.assertTrue(Arrays.equals(new int[] {1,2,3,4,5,6,7,8}, interleavingProblem(num)));
	}

	@Test
	public void test2() {
		int[] num = {1,3};
		Assert.assertTrue(Arrays.equals(new int[] {1,3}, interleavingProblem(num)));
	}

	@Test
	public void test3() {
		int[] num = {};
		Assert.assertTrue(Arrays.equals(new int[] {}, interleavingProblem(num)));
	}
	
	/*
	 * Pseudo code
	 * Create a queue
	 * Initialize 2 pointers as 0, length/2
	 * Traverse until pointer1 reaches length/2 or pointer2 reaches length
	 * 		Add pointer values to the queue
	 * Return queue
	 */

	
	private int[] interleavingProblem(int[] num) {
		int pointer1 = 0, pointer2 = num.length/2;
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		while(pointer1 < num.length/2) {
			queue.offer(num[pointer1++]);
			queue.offer(num[pointer2++]);
		}
		int index = 0;
		while(!queue.isEmpty())
			num[index++] = queue.poll();
		return num;
	}
}
