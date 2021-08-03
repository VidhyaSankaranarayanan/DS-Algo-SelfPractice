package week3day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class FindPeakElement {

	@Test
	public void test1() {
		int[] nums = {1,2,3,1};
		Assert.assertEquals(2, findPeakElementUsingBinarySearch(nums));
		Assert.assertEquals(2, findPeakElementUsingBinarySearchOptimized(nums));
	}
	
	@Test
	public void test2() {
		int[] nums = {1,2,1,3,5,6,4};
		Assert.assertEquals(5, findPeakElementUsingBinarySearch(nums));
		Assert.assertEquals(5, findPeakElementUsingBinarySearchOptimized(nums));
	}
	
	@Test
	public void test3() {
		int[] nums = {-3,-1,-2};
		Assert.assertEquals(1, findPeakElementUsingBinarySearch(nums));
		Assert.assertEquals(1, findPeakElementUsingBinarySearchOptimized(nums));
	}
	
	@Test
	public void test4() {
		int[] nums = {1};
		Assert.assertEquals(0, findPeakElementUsingBinarySearch(nums));
		Assert.assertEquals(0, findPeakElementUsingBinarySearchOptimized(nums));
	}
	
	@Test
	public void test5() {
		int[] nums = {1,2,3,4,5};
		Assert.assertEquals(-1, findPeakElementUsingBinarySearch(nums));
		Assert.assertEquals(-1, findPeakElementUsingBinarySearchOptimized(nums));
	}
	// 1,2,3,1
	private int findPeakElementUsingBinarySearch(int[] nums) {
		if(nums.length == 1)
			return 0;
		int low = 0, high = nums.length-1;
		while(low < high) {
			int mid = (low+high)/2;
			if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1])
				return mid;
			else if(nums[mid] < nums[mid]+1)
				low = mid+1;
			else
				high = mid-1;
			
		}
		return -1;	
	}
	
	private int findPeakElementUsingBinarySearchOptimized(int[] nums) {
		if(nums.length == 1)
			return 0;
		int low = 0, high = nums.length-1;
		while(low < high) {
			int mid = (low+high)/2;
			if(nums[mid] > nums[mid+1])
				high = mid;
			else
				low = mid+1;
		}
		return (low!=nums.length-1)?low:-1;	
	}

}
