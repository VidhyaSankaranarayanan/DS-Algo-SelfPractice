package week3day2;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class SquareRoot {

	@Test
	public void test1() {
		int k = 3;
		Assert.assertEquals(findSquareRootLinear(k), "1");
		Assert.assertEquals(findSquareRootBinarySearch(k), "1");
	}

	@Test
	public void test2() {
		int k = 16;
		Assert.assertEquals(findSquareRootLinear(k), "4");
		Assert.assertEquals(findSquareRootBinarySearch(k), "4");
	}

	@Test
	public void test3() {
		int k = 2;
		Assert.assertEquals(findSquareRootLinear(k), "1");
		Assert.assertEquals(findSquareRootBinarySearch(k), "1");
	}
	@Test
	public void test4() {
		int k = 0;
		Assert.assertEquals(findSquareRootLinear(k), "0");
		Assert.assertEquals(findSquareRootBinarySearch(k), "0");
	}
	
	@Test
	public void test5() {
		int k = -4;
		Assert.assertEquals(findSquareRootLinear(k), "2i");
		Assert.assertEquals(findSquareRootBinarySearch(k), "2i");
	}

	/*
	 * 8
	 * 1,2,3,4,5
	 * 3
	 * 1
	 */

	 /*
	  * Linear
	  * Find the range by dividing the number by 2
	  * Traverse from 1 to range+1
	  * 		If the square of current value is greater than target, return prev value
	  * 		If the square of current value is equal, return current value
	  * Return -1
	  * 
	  */

	private String findSquareRootLinear(int k) {
		int temp = k;
		if(k < 0)
			temp *= -1;
		int range = temp/2;
		for(int i = 0; i <= range+1; i++) {
			if(i*i == temp)
				return (k>=0)?String.valueOf(i):i+"i";
			else if(i*i > temp)
				return String.valueOf(i-1);
		}
		return "-1";
	}

	/*
	 * Binary search
	 * Find the range by dividing the num by 2
	 * initialize low as 0 & high as range+1
	 * Traverse until low <= high
	 * 		Find mid by (low + high) /2
	 * 		if mid square equals to num or mid square less than num and mid+1 square greater than num
	 * 			return mid
	 * 		else if mid square > num
	 * 			low = mid + 1
	 * 		else
	 * 			high = mid -1 
	 * return -1
	 */

	private String findSquareRootBinarySearch(int k) {
		if(k == 0)
			return "0";
		int temp = k;
		if(k < 0)
			temp *= -1;
		int range = temp/2;
		int low = 0, high = range+1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(mid*mid == temp || (mid*mid < temp && (mid+1)*(mid+1) > temp))
				return (k>=0)?String.valueOf(mid):String.valueOf(mid)+"i";
			else if(mid*mid > temp)
				high = mid-1;
			else
				low = mid+1;
		}
		return "-1";
	}

}
