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
public class MergeIntervals {

	/*
		 * Input: 2D Integer array
		 * Output: 2D Integer array
		 * Constraint: Brute force
		 * Test Data:
		 * Positive: [[1,3],[2,4],[6,9]]
		 * Output: [[1,4],[6,9]]
		 * Edge: [[1,4],[2,3],[3,6]]
		 * Output: [1,6]
		 * Negative: [[1,4], [5,6], [7,8]]
		 * Output: [[1,4], [5,6], [7,8]]
		 * 
		 * Approach: 
		 * 
		 * Time Complexity: 
		 * Space Complexity: 
		 */

	@Test
	public void test1() {
		int[][] nums = {{1,3},{3,4}};
		Assert.assertEquals(Arrays.deepToString(new int[][] {{1,4}}), Arrays.deepToString(mergeIntervals(nums)));
	}

	@Test
	public void test2() {
		int[][] nums = {{1,4},{2,3},{3,6}};
		Assert.assertEquals(Arrays.deepToString(new int[][] {{1,6}}), Arrays.deepToString(mergeIntervals(nums)));
	}

	@Test
	public void test3() {
		int[][] nums = {{1,4},{5,6},{7,8}};
		Assert.assertEquals(Arrays.deepToString(new int[][] {{1,4},{5,6},{7,8}}), Arrays.deepToString(mergeIntervals(nums)));
	}
	
	@Test
	public void test4() {
		int[][] nums = {{1,4},{3,4},{5,7},{8,10},{9,13}};
		Assert.assertEquals(Arrays.deepToString(new int[][] {{1,4},{5,7},{8,13}}), Arrays.deepToString(mergeIntervals(nums)));
	}
	
	@Test
	public void test5() {
		int[][] nums = {{1,4},{3,4},{5,7},{8,10},{9,13},{1,13}};
		Assert.assertEquals(Arrays.deepToString(new int[][] {{1,13}}), Arrays.deepToString(mergeIntervals(nums)));
	}
	
	/*
	 * Pseudo code
	 * Sort the array by start time
	 * Create a list of list 
	 * Initialize start as first start time & end as first end time
	 * Traverse through the array
	 * 		if the end time is greater than next start time & end time is greater than next end time
	 * 			end = same end
	 * 		if the end time is greater than next start time & end time is lesser than next end time
	 * 			end = next end
	 * 		else if end < next start time
	 * 			add start & end to the list
	 * 			move the start & end
	 * Return the list of list
	 */
	
	private int[][] mergeIntervals(int[][] nums){
		Arrays.sort(nums, (a,b) -> {
			if(a[0] != b[0]) return a[0]-b[0];
			else return a[1]-b[1];
		});
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int start = nums[0][0];
		int end = nums[0][1];
		for(int i = 0; i < nums.length-1; i++) {
			int nextStart = nums[i+1][0];
			int nextEnd = nums[i+1][1];
			if(end >= nextStart)
				end = Math.max(end, nextEnd);
			else {
				list.add(Arrays.asList(start,end));
				start = nextStart;
				end = nextEnd;
			}
		}
		list.add(Arrays.asList(start,end));
		System.out.println(list);
		int[][] output = new int[list.size()][2];
		for(int i = 0; i < output.length; i++) {
			output[i][0] = list.get(i).get(0);
			output[i][1] = list.get(i).get(1);
		}
		return output;
	}
}
