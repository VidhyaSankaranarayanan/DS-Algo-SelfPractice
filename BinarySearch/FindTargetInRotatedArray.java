package week3day2;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class FindTargetInRotatedArray {

	@Test
	public void test1() {
		int[] num = {4,5,6,7,0,1,2};
		int target = 0;
		Assert.assertEquals(4, findTargetElement(num,target));
	}
	
	@Test
	public void test2() {
		int[] num = {7,9,11,13,15,5,6};
		int target = 11;
		Assert.assertEquals(2, findTargetElement(num,target));
	}
	
	@Test
	public void test3() {
		int[] num = {8,9,11,13,15,5,6,7};
		int target = 6;
		Assert.assertEquals(6, findTargetElement(num,target));
	}
	
	@Test
	public void test4() {
		int[] num = {5,6,7,8,0,1,2,3,4};
		int target = 7;
		Assert.assertEquals(2, findTargetElement(num,target));
	}
	
	@Test
	public void test5() {
		int[] num = {5,1,2,3,4};
		int target = 1;
		Assert.assertEquals(1, findTargetElement(num,target));
	}
	
	
	
	
	
	/*
	 * Pseudo code
	 * Initialize low as 0, high as length - 1
	 * Traverse until low<high
	 * 		Find mid
	 * 		Compare mid = target
	 * 			return mid
	 * 		If target>=low & <mid
	 * 			high = mid-1
	 * 		else
	 * 			low = mid+1
	 * Return -1
	 */
	
	private int findTargetElement(int[] num, int target) {
		int low = 0, high = num.length-1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(num[mid] == target)
				return mid;
			else if(Math.abs(num[low] - target) < Math.abs(num[high] - target))
				high = mid-1;
			else
				low = mid+1;
		}
		return -1;
	}
}
