/**
 * 
 */
package twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class FindKDiffPairs {

	/*
	 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i < j < nums.length
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.

 

Example 1:

Input: nums = [3,1,4,1,5], k = 2 --> 1,1,3,4,5
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:

Input: nums = [1,2,3,4,5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:

Input: nums = [1,3,1,5,4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Example 4:

Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
Output: 2
Example 5:

Input: nums = [-1,-2,-3], k = 1
Output: 2
	 */
	
	/*
		 * Input: Integer array, Integer
		 * Output: Integer
		 * Constraint: 
		 * Test Data:
		 * Positive: 
		 * Output: 
		 * Edge: 
		 * Output: 
		 * Negative:
		 * Output: 
		 * 
		 * Approach: Sorting
		 * 
		 * Time Complexity: O(nlogn)
		 * Space Complexity: O(1)
		 */

	@Test
	public void test1() {
		int[] nums = {1,3,1,5,4};
		int k = 0;
		Assert.assertEquals(1, findPairs(nums, k));
	}

	@Test
	public void test2() {
		int[] nums = {1,2,4,4,3,3,0,9,2,3};
		int k = 3;
		Assert.assertEquals(2, findPairs(nums, k));
	}

	@Test
	public void test3() {
		int[] nums = {1,2,3,4,5};
		int k = 1;
		Assert.assertEquals(4, findPairs(nums, k));
	}
	
	/*
	Pseudo code - Sorting & 2 pointers
	Sort the array
	Initialize 2 pointers slow, fast as 0 & 1
	Initialize count as 0
	Traverse until fast < array's length
		If the diff btw values in fast & slow equals to k
			Increment count, slow, fast
			Traverse until fast == fast-1 & increment fast
		Else if the diff btw values in fast & slow is less than k, increment slow
		Else increment fast
	Return count
	*/
	public int findPairsUsingSort(int[] nums, int k) {
	        if(nums.length < 2)
	            return 0;
	        Arrays.sort(nums); 
	        int slow = 0, fast = 0, count = 0, prev = nums[0], next = nums[1];
	        while(fast < nums.length){
	            if(Math.abs(nums[slow]-nums[fast]) == k && slow != fast){
	                count++;
	                slow++;
	                fast++;
	                while(fast < nums.length && nums[fast] == nums[fast-1]){
	                    fast++;
	                }
	            }
	            else if(Math.abs(nums[slow]-nums[fast]) > k){
	                slow++;
	            }
	            else
	            fast++;
	        }
	        return count;
	    }
	
	
	/*
	 * Pseudo code - Using HashMap
	 * Create a map 
	 * Initialize count as 0
	 * Traverse through the array 
	 * 		Add elements as key & occurrence as value
	 * Traverse through the map's key set
	 * 		If k!=0 or if k == 0 and the value of that key is greater than 1
	 * 			Increment count
	 * Return count
	 */
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	
	public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
//        for(int i = 0; i < nums.length; i++){
//            if(map.containsKey(nums[i] - k)){
//                if(map.get(nums[i] - k) != nums[i]){
//                    count++;
//                    map.put(nums[i]-k, nums[i]);
//                    map.put(nums[i], nums[i]-k);
//                }
//            }
//            else if(map.containsKey(nums[i] + k)){
//                if(map.get(nums[i] + k) != nums[i]){
//                    count++;
//                    map.put(nums[i]+k, nums[i]);
//                    map.put(nums[i], nums[i]+k);
//                }
//            }
//            else map.put(nums[i], Integer.MAX_VALUE);
//        }
        for(int i = 0; i < nums.length; i++)
        	map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        for(int num : map.keySet()) {
        	if(map.containsKey(num + k)) {
        		if(k!=0 || k == 0 && map.get(num)>1)
        			count++;
        	}
        }
        return count;
    }
	
	/*
	 * Pseudo code - Using HashSet
	 * Create 2 sets
	 * Initialize count as 0
	 * Traverse through the array
	 * 		Add the elements to the set
	 * 		If the set already contains that elements, add it to the dup set
	 * Traverse through the array
	 * 		If the set element + k & k !=0
	 * 			Increment count
	 * 		else if the set contains element + k & k == 0
	 * 			Increment count
	 * Return count
	 */
	
	public int findPairsUsingSet(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> dup = new HashSet<Integer>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i]))
                dup.add(nums[i]);
            else
        	    set.add(nums[i]);
        }
        for(int num : set) {
        	if(k!=0 && set.contains(num + k)) 
        		count++;
            else if(k==0 && dup.contains(num + k))
                count++;
        }
        return count;
    }
}
