/**
 * 
 */
package assessment2;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class MinimumSpeed {

	/*
		 * Input: Integer array, double
		 * Output: Integer
		 * Constraint: Optimized solution
		 * Test Data:
		 * Positive: {1,3,2}, hour = 6
		 * Output: 1
		 * Edge: {1,3,2}, hour = 2.7
		 * Output: 3
		 * Negative: {1,3,2}, hour = 1.9
		 * Output: -1
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */

	@Test
	public void test1() {
		int[] train = {1,3,2};
		double hour = 6;
		Assert.assertEquals(1, minSpeedOnTime(train, hour));
	}

	@Test
	public void test2() {
		int[] train = {1,3,2};
		double hour = 2.7;
		Assert.assertEquals(3, minSpeedOnTime(train, hour));
	}

	@Test
	public void test3() {
		int[] train = {1,3,2};
		double hour = 1.9;
		Assert.assertEquals(-1, minSpeedOnTime(train, hour));
	}

	
	/*
	 * Pseudo code - Brute force
	 * If hour is less than train's length - 1, return -1
	 * Round off the hour value and assign it to range
	 * Initialize sum as 0
	 * Traverse from 1 to range
	 * 	Traverse each through each element until length
	 * 		Divide each element by range
	 * 		If it is less than i & greater than i-1, add i to the sum
	 * If the sum equals to hour, return i
	 * Return -1
	 * 
	 */
	
	/*
	 * Pseudo code - Binary Search
	 * Round off the hour value and assign it to range
	 * If hour is less than train's length, return -1
	 * Initialize low as 1, high as range
	 * Traverse low <= high
	 * 		Find mid & Initialize sum as 0
	 * 		Traverse through the array until length - 1
	 * 			Divide each element by mid and assign it to temp
	 * 			Round off temp to next nearest integer and add it to the sum
	 * 		Divide the last digit with mid and add it to the sum
	 * 		If the sum == hour, return mid
	 * 		If sum < high, high = mid-1
	 * 		else low = mid+1
	 * Return -1
	 */
	// 1,3,2
	// hour - 2.7 -> 3
	private int findSpeed(int[] train, double hour) {
		int range = (int) Math.round(hour);
		if(range < train.length) return -1;
		int low = 1, high = range;
		while(low <= high) {
			int mid = (low + high)/2;
			double sum = 0;
			for(int i = 0; i < train.length-1; i++) {
				double temp = (double)train[i]/mid;
				sum += (int) Math.ceil(temp);
			}
				sum += (double)train[train.length-1]/mid;
			if(sum == hour || (Math.abs(sum-hour)<1)) return mid;
			else if(sum < hour) high = mid-1;
			else low = mid+1;
		}
		return -1;
	}
	
	 public int minSpeedOnTime(int[] dist, double hour) {
	        int range = (int) Math.floor(hour);
	        System.out.println(range);
			if(range < dist.length) return -1;
			long low = 1, high = 1000000000;
			while(low <= high) {
				long mid = (low + high)/2;
				double sum = (double)dist[dist.length-1]/mid;
				double temp = hour - range;
				if(sum == temp) return (int) mid;
				else if(sum < temp) high = mid-1;
				else low = mid+1;
			}
			return -1;   
	    }
}
