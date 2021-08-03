package week3day2;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class MinSumKandaneAlgorithm {

	@Test
	public void test1() {
		int[] nums = {1,-5,2,-3,7,1};
		Assert.assertEquals(-6, findMinSum(nums));
	}
	
	@Test
	public void test2() {
		int[] nums = {3,3,5,5};
		Assert.assertEquals(3, findMinSum(nums));
	}
	
	@Test
	public void test3() {
		int[] nums = {-1,-2,-9};
		Assert.assertEquals(-12, findMinSum(nums));
	}
	
	private int findMinSum(int[] nums) {
		int windowSum = nums[0], minSum = nums[0];
		for(int i = 1; i < nums.length; i++) {
			windowSum = Math.min(windowSum+nums[i], nums[i]);
			minSum = Math.min(minSum, windowSum);
		}
		return minSum;
	}

}
