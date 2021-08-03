package week3day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class FindSingleElementUsingBinarySearch {

	@Test
	public void test1() {
		int[] nums = {1,1,2,3,3,4,4,8,8};
		Assert.assertEquals(2, findSingleElementUsingBinarySearch(nums));
	}
	
	@Test
	public void test2() {
		int[] nums = {3,3,7,7,10,11,11};
		Assert.assertEquals(10, findSingleElementUsingBinarySearch(nums));
	}
	
	@Test
	public void test3() {
		int[] nums = {3,3,4,4,5,5,6};
		Assert.assertEquals(6, findSingleElementUsingBinarySearch(nums));
	}
	
	@Test
	public void test4() {
		int[] nums = {3,3,4,4,5,5};
		Assert.assertEquals(-1, findSingleElementUsingBinarySearch(nums));
	}
	
	
	
	/*
	 * Input: Integer array
	 * Output: Element appears once
	 * Test data: [1,1,2,3,3,4,4,8,8]
	 * Output: 2
	 * [3,3,7,7,10,11,11] -> 10
	 * [3,3,7,7,11,11] -> 0
	 * [3,3,4,4,5,5,6] -> 6
	 */
	
	/*
	 * Pseudo code
	 * Initialize low as 0, high as length-1
	 * Traverse until low <= high
	 * 		find mid by (low+high)/2
	 * 		if value at mid not equals to mid+1 & mid-1
	 * 			return value at mid
	 * 		else if value at mid equals to mid+1
	 * 			if (mid-low) is odd, high = mid-1
	 * 			if(high-mid+1) is odd, low = mid+2
	 * 		else if value at mid equals mid-1
	 * 			if (mid-1-low) is odd, high = mid-2
	 * 			if(high-mid) is odd, low = mid+1`
	 * 
	 */

	private int findSingleElementUsingBinarySearch(int[] nums) {
		int low = 0, high = nums.length-1;
		while(low <= high) {
			int mid = (low+high)/2;
			if(mid == nums.length-1)
				return nums[mid];
			if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1])
				return nums[mid];
			else if(nums[mid] == nums[mid+1]) {
				if((mid-low)%2 != 0)
					high = mid-1;
				else low = mid+2;
			}
			else if(nums[mid] == nums[mid-1]) {
				if((high-mid)%2 != 0)
					low = mid+1;
				else high = mid-2;
			}
		}
		return -1;
	}

}
