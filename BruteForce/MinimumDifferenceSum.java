package assessment2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class MinimumDifferenceSum {

	/*
		 * Input: Integer array
		 * Output: Integer
		 * Constraint: No
		 * Test data: [1,3,3,2,4] -> 3
		 * [0,0,0,0] 0
		 * [] -> [] -> 0
		 * [1,-2,3,-4,5] -> 3
		 * 
		 * Approach: Using Sort
		 * 
		 * Time Complexity: O(nlogn)
		 * Space Complexity: O(1)
		 */
		@Test
		public void test1() {
			int[] num = {1,3,3,2,4};
			Assert.assertEquals(3, findMinDiffSum(num));
		}
		
		@Test
		public void test2() {
			int[] num = {0,0,0,0};
			Assert.assertEquals(0, findMinDiffSum(num));
		}
		
		@Test
		public void test3() {
			int[] num = {};
			Assert.assertEquals(0, findMinDiffSum(num));
		}
		
		@Test
		public void test4() {
			int[] num = {1,-2,3,-4,5};
			Assert.assertEquals(9, findMinDiffSum(num));
		}
		
		/*
		 * Pseudo code
		 * If the array length is 0
		 * 	return 0
		 * If the array length is 1
		 * 	return num[0]
		 * Sort the array
		 * Traverse through the array from 1
		 * 	Find diff between prev & curr element
		 * 	Add it to the sum
		 * Return sum
		 * 
		 * 
		 */
		
		private int findMinDiffSum(int[] num) {
			if(num.length == 0)
				return 0;
			if(num.length == 1)
				return num[0];
			Arrays.sort(num);
			int sum = 0;
			for(int i = 1; i < num.length; i++) {
				sum += num[i]-num[i-1]; 
			}
			return sum;
		}
}
