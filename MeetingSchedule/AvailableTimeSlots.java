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
public class AvailableTimeSlots {

	/*
		 * Input: 2 2D arrays & duration
		 * Output: array
		 * Constraint: 
		 * Test Data:
		 * Positive: [[10,50],[60,120],[140,210]], [[0,15],[60,70]]; duration = 8
		 * Output: [60,68]
		 * Edge: [[10,50],[60,120],[140,210]], [[0,15],[60,70]]; duration = 12
		 * Output: []
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
		int[][] slot1 = {{10,50}, {60,120}, {140,210}};
		int[][] slot2 = {{0,15}, {60,70}};
		int duration = 8;
		Assert.assertTrue(Arrays.equals(new int[] {60, 68}, findAvailableSlot(slot1,slot2,duration)));
	}

	@Test
	public void test2() {
		int[][] slot1 = {{10,50}, {60,120}, {140,210}};
		int[][] slot2 = {{0,15}, {60,70}};
		int duration = 12;
		Assert.assertTrue(Arrays.equals(new int[] {}, findAvailableSlot(slot1,slot2,duration)));
	}
	
	@Test
	public void test3() {
		int [] []slot1={{40,50},{40,70},{80,120}};
        int [] []slot2={{30,60},{125,135}};
        int duration=5;
		Assert.assertTrue(Arrays.equals(new int[] {40, 45}, findAvailableSlot(slot1,slot2,duration)));
	}

	/*
	 * Pseudo code
	 * Sort the arrays by start time
	 * Initialize left as 0, right as 0
	 * Traverse until right < slot2 length or left < slot1 length
	 * 		If start value at left = start value at right
	 * 			Find min between end value of left & right
	 * 				If min > duration, return left value, left value + duration
	 * 		        Else increment left & right
	 * 		If start value at left < less than right, increment left
	 * 		If start value at right < left, increment right
	 * Return []
	 * 
	 */
	// 30,50  40,50
	private int[] findAvailability(int[][] slot1, int[][] slot2, int duration) {
		Arrays.sort(slot1, (a,b) -> {
			if(a[0]!=b[0]) return a[0]-b[0];
			else return a[1]-b[1];
		});
		Arrays.sort(slot2, (a,b) -> {
			if(a[0]!=b[0]) return a[0]-b[0];
			else return a[1]-b[1];
		});
		int left = 0, right = 0;
		while(left < slot1.length && right < slot2.length) {
			int slot1Diff = Math.abs(slot1[left][0] - slot1[left][1]);
			int slot2Diff = Math.abs(slot2[right][0] - slot2[right][1]);
			if(slot1Diff >= duration && slot2Diff >= duration) {
				if(slot1[left][0] >= slot2[right][0] && slot2[right][1] > slot1[left][0])
					return new int[] {slot1[left][0], slot1[left][0]+duration};
				else if(slot1[left][0] < slot2[right][0] && slot1[left][1] > slot2[right][0])
					return new int[] {slot2[right][0], slot2[right][0]+duration};
			}
			left++;
			right++;
		}
		return new int[] {};
	}
	
	/*
	 * Pseudo code
	 * Sort the arrays by start time
	 * Initialize left & right pointers
	 * Traverse through the arrays until left < slot1 length & right < slot2 length
	 * 		Find slot1Diff between start & end time of left index
	 * 		Find dlot2Diff between start & end time of right index
	 * Create a 2D array of size 2
	 * 		Add maxDiff to index 1 & min Diff to index 2
	 * Check if maxDiff 0th index should be lesser than minDiff 0th index
	 * 		 and maxDiff 1st index should be greater than minDiff 0th index
	 * 		Find max Start time
	 * 		Find min End time
	 * 		If diff between start & end >= duration
	 * 			Return start time & start time + duration
	 * Return empty array
	 */
	
	private int[] findAvailableSlot(int[][] slot1, int[][] slot2, int duration) {
		Arrays.sort(slot1, (a,b) -> {
			if(a[0]!=b[0]) return a[0]-b[0];
			else return a[1]-b[1];
		});
		Arrays.sort(slot2, (a,b) -> {
			if(a[0]!=b[0]) return a[0]-b[0];
			else return a[1]-b[1];
		});
		int left = 0, right = 0;
		while(left < slot1.length && right < slot2.length) {
			int slot1Diff = Math.abs(slot1[left][0] - slot1[left][1]);
			int slot2Diff = Math.abs(slot2[right][0] - slot2[right][1]);
			int[][] diffSlots = new int[2][2];
			if(slot1Diff > slot2Diff) {
				diffSlots[0][0] = slot1[left][0];
				diffSlots[0][1] = slot1[left][1];
			}
			else {
				diffSlots[0][0] = slot2[right][0];
				diffSlots[0][1] = slot2[right][1];
			}
			if(slot1Diff < slot2Diff) {
				diffSlots[1][0] = slot1[left][0];
				diffSlots[1][1] = slot1[left][1];
			}
			else {
				diffSlots[1][0] = slot2[right][0];
				diffSlots[1][1] = slot2[right][1];
			}
			if(diffSlots[0][0] <= diffSlots[1][0] && diffSlots[1][0] < diffSlots[0][1]) {
				int start = Math.max(diffSlots[0][0], diffSlots[1][0]);
				int end = Math.min(diffSlots[0][1], diffSlots[1][1]);
				if(Math.abs(start - end) >= duration) return new int[] {start, start+duration};
			}
			left++; right++;
		}
		return new int[] {};
	}
	
	private int[] findCommonSlot(int[][] slots1, int[][] slots2,int duration) {
        int slotOneStart=0, slotTwoStart=0;
        Arrays.sort(slots1,(a,b)->{if(a[1]!=b[1]) return a[1]-b[1]; else return a[0]-b[0];});
        Arrays.sort(slots2,(a,b)->{if(a[1]!=b[1]) return a[1]-b[1]; else return a[0]-b[0];});

        int maxStartTime=0, minEndTime=0;

        while (slotOneStart<slots1.length && slotTwoStart<slots2.length){

            int slot1Diff=Math.abs(slots1[slotOneStart][0]-slots1[slotOneStart][1]); //40

            int slot2Diff=Math.abs(slots2[slotOneStart][0]-slots2[slotOneStart][1]); //15

            int[] bigSlot=new int[2]; //10 50
            int[] smallSlot=new int[2]; //0 15

            if(slot1Diff>slot2Diff){
                bigSlot[0]=slots1[slotOneStart][0]; //40
                bigSlot[1]=slots1[slotOneStart][1]; //50
            }else{
                bigSlot[0]=slots2[slotTwoStart][0];
                bigSlot[1]=slots2[slotTwoStart][1];
            }

            if(slot1Diff<slot2Diff){
                smallSlot[0]=slots1[slotOneStart][0]; //0
                smallSlot[1]=slots1[slotOneStart][1]; //15
            }else{
                smallSlot[0]=slots2[slotTwoStart][0];
                smallSlot[1]=slots2[slotTwoStart][1];
            }

            //0-15 //10-50  || smallSlot[1]>=bigSlot[0] && smallSlot[1]<bigSlot[1]
            if(smallSlot[0]>=bigSlot[0] && smallSlot[1]<=bigSlot[1]){
                maxStartTime=Math.max(slots1[slotOneStart][0],slots2[slotTwoStart][0]);
                minEndTime=Math.min(slots1[slotOneStart][1],slots2[slotTwoStart][1]);
                if(Math.abs(maxStartTime-minEndTime)>=duration) return new int[]{maxStartTime,maxStartTime+duration};
            }

            slotOneStart++;
            slotTwoStart++;

        }
        return new int[]{};
    }
}
