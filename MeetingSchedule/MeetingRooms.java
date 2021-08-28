/**
 * 
 */
package meetingschedule;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MeetingRooms {

    /*

    String[][] meetingTimes = {{"09 00", "09 45"},{"09 30", "10 30"},{"10 40", "12 00"},{"11 00", "13 00"},{"11 45", "14 00"},{"16 00", "17 00"}};


   */
    @Test
    public void test1(){
        String[][] meetingTimes={{"0900", "0945"},{"0930", "1030"},{"1040", "1200"},{"1100", "1300"},{"1145", "1400"},{"1600", "1700"}};
        Assert.assertEquals(findMeetingRooms(meetingTimes),3);
    }
    
    @Test
    public void test2(){
        String[][] meetingTimes={{"0900", "1120"},{"1100", "1110"},{"0930", "1000"},{"1040", "1140"}};
        Assert.assertEquals(findMeetingRooms(meetingTimes),3);
    }

    /*
    Solution
    - Initialize two variables, availableRooms=0, meetingRooms=1
    - get the end time of meeting one and compare with the start time of subsequent meeting
    - if the value is lesser and availableRooms count =0 then increment meetingRoom
    - if the value is greater then continue
    - compare end times of consecutive meetings, if prev meeting end time is lesser than current meeting increment availablerooms by 1
    - return maxRooms
     */
//    private int findMeetingRooms(String[][] meetingTimes) {
//        int availableRooms=6, minRooms=1;
//
//        Arrays.sort(meetingTimes, (a,b)->{ if (a[0]!=b[0]) return Integer.parseInt(a[0])-Integer.parseInt(b[0]);
//            else return Integer.parseInt(a[1])-Integer.parseInt(b[1]);
//        });
//        for (int i=1;i<meetingTimes.length-1;i++){
//            int prevMeetEndTime= Integer.parseInt(meetingTimes[i-1][1].replaceAll(" ",""));
//            int currMeetStartTime= Integer.parseInt(meetingTimes[i][0].replaceAll(" ",""));
//            int currMeetEndTime=Integer.parseInt(meetingTimes[i][1].replaceAll(" ",""));
//            int nextMeetStartTime = Integer.parseInt(meetingTimes[i][0].replaceAll(" ",""));
//
//            if(prevMeetEndTime>currMeetStartTime && availableRooms==0){
//                minRooms++;
//            }
//            else{
//                availableRooms--;
//            }
//            if(prevMeetEndTime < currMeetEndTime && currMeetEndTime < nextMeetStartTime)
//            	availableRooms += 2;
//
//        }
//        return minRooms;
//    }
    
    /*
     * Pseudo code
     * Convert the string array to 2D int array
     * Sort the array by end time
     * Initialize start as 0 & end as 1
     * Initialize minRooms as size of the array
     * Traverse through the array
     * 		If the startTime < endTime, decrement minRoom
     * 	Return minRoom
     */
    
    private int findMeetingRooms(String[][] meetingTimes) {
    	int[][] meetings = new int[meetingTimes.length][2];
    	for(int i = 0; i < meetings.length; i++) {
    		meetings[i][0] = Integer.parseInt(meetingTimes[i][0].replaceAll(" ", ""));
    		meetings[i][1] = Integer.parseInt(meetingTimes[i][1].replaceAll(" ", ""));
    	}
    	
    	Arrays.sort(meetings, (a,b) -> {
    		if(a[1]!=b[1]) return a[1]-b[1];
    		else return (a[0] - b[0]);
    	});
    	int start = 0, end = 0, minRooms = meetings.length;
    	while(start < meetings.length) {
    		if(meetings[start++][0] >= meetings[end][1]) {
    			minRooms--;
    			end++;
    		}
    	}
    	return minRooms;
    }
}