/**
 * 
 */
package meetingschedule;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class TrainPlatforms {

	/*
		 * Input: 2 integer arrays
		 * Output: Integer
		 * Constraint: 
		 * Test Data:
		 * Positive: {0900, 0940, 0950, 1100, 1500, 1800}, {0910, 1200, 1120, 1130, 1900, 2000}
		 * Output: 3
		 * Edge: {0900, 1100, 1235}, {1000, 1200, 1240}
		 * Output: 1
		 * Negative:
		 * Output: 
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */

	@Test
	public void test1() {
		String[] arr = {"0900", "0940", "0950", "1100", "1500", "1800"};
		String[] dept = {"0910", "1200", "1120", "1130", "1900", "2000"};
		Assert.assertEquals(3, findPlatforms(arr, dept));
	}

	@Test
	public void test2() {
		String[] arr = {"0900", "1100", "1235"};
		String[] dept = {"1000", "1200", "1240"};
		Assert.assertEquals(1, findPlatforms(arr, dept));
	}
	
	/*
	 * Pseudo code
	 * Create a 2D array
	 * Add the values of string array to 2D array
	 * Sort the array by dept time
	 * Initialize min as size of array
	 * Traverse through the array
	 * 	If the end time of current time is greater than start time of next train
	 * 		Decrement min
	 * Return min
	 */
	
	private int findPlatforms(String[] arr, String[] dept) {
		int[][] train = new int[arr.length][2];
		for(int i = 0; i < arr.length; i++) {
			train[i][0] = Integer.parseInt(arr[i]);
			train[i][1] = Integer.parseInt(dept[i]);
		}
		Arrays.sort(train, (a,b) -> {
			if(a[1]!=b[1]) return a[1]-b[1];
			else return a[0]-b[0];
		});
		int min = train.length, start = 0, end = 0;
		while(start < train.length) {
			if(train[start++][0] >= train[end][1]) {
				min--;
				end++;
			}
		}
		return min;
	}
	
}
