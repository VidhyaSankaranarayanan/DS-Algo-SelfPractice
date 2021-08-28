/**
 * 
 */
package meetingschedule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class MaximumConference {

	/*
		 * Input: 2 integer list
		 * Output: Integer
		 * Constraint: 
		 * Test Data:
		 * Positive: {1,1,2}, {3,2,4}
		 * Output: 2
		 * Edge: {1,1,2,3}, {2,3,3,4}
		 * Output: 3
		 * Negative: {6,1,2,3}, {8,9,4,7}
		 * Output: 2
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */

	@Test
	public void test1() {
		List<Integer> slot1 = new ArrayList<>();
		slot1.add(1);
		slot1.add(1);
		slot1.add(2);
		List<Integer> slot2 = new ArrayList<>();
		slot2.add(3);
		slot2.add(2);
		slot2.add(4);
		Assert.assertEquals(2, findMaxConference(slot1, slot2));
	}

	@Test
	public void test2() {
		List<Integer> slot1 = new ArrayList<>();
		slot1.add(1);
		slot1.add(1);
		slot1.add(2);
		slot1.add(3);
		List<Integer> slot2 = new ArrayList<>();
		slot2.add(2);
		slot2.add(3);
		slot2.add(3);
		slot2.add(4);
		Assert.assertEquals(3, findMaxConference(slot1, slot2));
	}

	@Test
	public void test3() {
		List<Integer> slot1 = new ArrayList<>();
		slot1.add(6);
		slot1.add(1);
		slot1.add(2);
		slot1.add(3);
		List<Integer> slot2 = new ArrayList<>();
		slot2.add(8);
		slot2.add(9);
		slot2.add(4);
		slot2.add(7);
		Assert.assertEquals(2, findMaxConference(slot1, slot2));
	}
	
	/*
	 * Pseudo code
	 * Create a 2D array
	 * Traverse through the list
	 * 		Add list elements to the 2D array
	 * Sort the array by end time
	 * Initialize endTime as first meeting's end time
	 * Initialize max as 1
	 * Traverse through the array
	 * 		If the end time is lesser than conference time
	 * 			increment max
	 * 			Reset the end time
	 * Return max 
	 */
	
	private int findMaxConference(List<Integer> slot1, List<Integer> slot2) {
		int[][] conferenceTimes = new int[slot1.size()][2];
		for(int i = 0; i < conferenceTimes.length; i++) {
			conferenceTimes[i][0] = slot1.get(i);
			conferenceTimes[i][1] = slot2.get(i);
		}
		
		Arrays.sort(conferenceTimes, (a,b) -> {
			if(a[1] != b[1]) return a[1] - b[1];
			else return a[0] - b[0];
		});
		
		int endTime = conferenceTimes[0][1];
		int max = 1;
		for(int i = 1; i < conferenceTimes.length; i++) {
			if(conferenceTimes[i][0] >= endTime) {
				max++;
				endTime = conferenceTimes[i][1];
			}
		}
		return max;
	}
}

