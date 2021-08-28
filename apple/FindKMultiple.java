/**
 * 
 */
package apple;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class FindKMultiple {

	/*
		 * Input: Integer array, Integer
		 * Output: Boolean
		 * Constraint: 
		 * Test Data: 
		 * Positive: {23,2,4,6,7}, k = 6
		 * Output: true
		 * Edge: {23,2,4,6,0}, k = 13
		 * Output: true
		 * Negative: {23,2,6,4,7}, k = 13
		 * Output: false
		 * 
		 * Approach: Hashing
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(n)
		 */

	@Test
	public void test1() {
		int[] nums = {23,2,4,6,7};
		int k = 6;
		Assert.assertEquals(true, findKMultiple(nums, k));
	}

	@Test
	public void test2() {
		int[] nums = {23,2,4,6,0};
		int k = 13;
		Assert.assertEquals(true, findKMultiple(nums, k));
	}

	@Test
	public void test3() {
		int[] nums = {23,2,6,4,7};
		int k = 13;
		Assert.assertEquals(false, findKMultiple(nums, k));
	}
	
	/*
	 * Pseudo code
	 * Create a hash map
	 * Traverse through the array
	 * 		If the current element is 0, return true
	 * 		If mod of current element+prev is present in the map
	 * 			Check the diff btw index & corresponding value, if the diff > 1
	 * 				return true
	 * 		Else add the key & value
	 * Return false
	 */
	
	private boolean findKMultiple(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int prev = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0)
				return true;
			int currMod = (nums[i] + prev)%k;
			if(map.containsKey(currMod)) {
				if(Math.abs(map.get(currMod) - i) > 1)
					return true;
			}
			else
				map.put(currMod, i);
			prev = currMod;
		}
		return false;
	}
}
