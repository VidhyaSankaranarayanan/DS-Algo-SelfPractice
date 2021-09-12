/**
 * 
 */
package twopointers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class PancakeSort {

	/*
		 * Input: Integer array
		   Output: Integer array
		   Approach: 2 pointers
		   Space Complexity: O(n)
		   Time Complexity: O(n^2)
		 */

	@Test
	public void test1() {
		int[] nums = {3,2,4,1};
		System.out.println(pancakeSort(nums));
	}

	@Test
	public void test2() {
		int[] nums = {1,2,3};
		System.out.println(pancakeSort(nums));
	}

	@Test
	public void test3() {
		int[] nums = {3,2,1,4};
		System.out.println(pancakeSort(nums));
	}
	
	/*Pseudo code
	Create an array list
	Initialize left as 0, right as length-1
	Traverse until left < right
		If value at left equals to left + 1, increment left
		If value at right equals to right+1, decrement right
		else
		Initialize low as left, high as right
		Traverse until low < high
			Reverse the array
		Add right-left+1 to the list
	Return list
	*/
	
	public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        int left = 0, right = arr.length-1, start = arr.length, end = 1;
        while(left < right){
            if(arr[left] == start) {
                left++;
                start--;
            }
            if(arr[right] == end) {
                right--;
            	end++;
            }
            if(arr[left]!=start && arr[right]!=end){
                int low = left, high = right;
                while(low < high){
                    int swap = arr[low];
                    arr[low++] = arr[high];
                    arr[high--] = swap;
                }
                list.add(right-left+1);
            }
        }
        left = 0; right = arr.length-1;
        while(left < right) {
        	int swap = arr[left];
        	arr[left++] = arr[right];
        	arr[right--] = swap;
        }
        list.add(arr.length);
        return list;
    }
}
