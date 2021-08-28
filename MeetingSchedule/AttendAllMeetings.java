/**
 * 
 */
package meetingschedule;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class AttendAllMeetings {

	/*
		 * Input: 2D array
		 * Output: Boolean
		 * Constraint: 
		 * Test Data:
		 * Positive: [[7,10],[2,4]]
		 * Output: True
		 * Edge: [[0,30],[5,10],[15,20]]
		 * Output: False
		 * Negative: [[0,5], [5,10]]
		 * Output: True
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */

	@Test
	public void test1() {
		int[][] intervals = {{7,10}, {2,4}};
		Assert.assertEquals(true, findPossibility(intervals));
	}

	@Test
	public void test2() {
		int[][] intervals = {{0,30}, {5,10}, {15,20}};
		Assert.assertEquals(false, findPossibility(intervals));
	}

	@Test
	public void test3() {
			int[][] intervals = {{0,5}, {5,10}};
			Assert.assertEquals(true, findPossibility(intervals));
	}
	
	/*
	 * Pseudo code
	 * Sort the array based on endTime
	 * Traverse through the array
	 * 		If the end time > next Start time
	 * 			Return false
	 * Return True
	 */
	
	private boolean findPossibility(int[][] intervals) {
		Arrays.sort(intervals, (a,b) -> {
			if(a[1] != b[1]) return a[1] - b[1];
			else return a[0] - b[0];
		});
		
		for(int i = 0; i < intervals.length-1; i++) {
			int startTime = intervals[i+1][0];
			int endTime = intervals[i][1];
			if(endTime > startTime)
				return false;
		}
		return true;
	}
}
