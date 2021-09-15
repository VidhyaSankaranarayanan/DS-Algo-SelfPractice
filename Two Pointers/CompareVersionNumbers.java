/**
 * 
 */
package twopointers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class CompareVersionNumbers {

	/*
		 * Input: Strings
		 * Output: Integer
		 * Constraint: 2 pointers
		 * Test Data:
		 * Positive: 
		 * Output: 
		 * Edge: 
		 * Output: 
		 * Negative:
		 * Output: 
		 * 
		 * Approach: 2 pointers
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(n)
		 */

	@Test
	public void test1() {
		String version1 = "1.01";
		String version2 = "1.001";
		Assert.assertEquals(0, compareVersionsUsingTwoPointers(version1, version2));
	}

	@Test
	public void test2() {
		String version1 = "1.0";
		String version2 = "1.0.0";
		Assert.assertEquals(0, compareVersionsUsingTwoPointers(version1, version2));
	}

	@Test
	public void test3() {
		String version1 = "0.1";
		String version2 = "1.1";
		Assert.assertEquals(-1, compareVersions(version1, version2));
	}
	
	@Test
	public void test4() {
		String version1 = "1";
		String version2 = "0";
		Assert.assertEquals(1, compareVersionsUsingTwoPointers(version1, version2));
	}
	
	@Test
	public void test5() {
		String version1 = "1.0.1";
		String version2 = "1";
		Assert.assertEquals(1, compareVersionsUsingTwoPointers(version1, version2));
	}
	
	@Test
	public void test6() {
		String version1 = "1.1";
		String version2 = "1.01.0";
		Assert.assertEquals(0, compareVersionsUsingTwoPointers(version1, version2));
	}
	
	@Test
	public void test7() {
		String version1 = "1.9.9.9";
		String version2 = "1.10.0.0";
		Assert.assertEquals(-1, compareVersionsUsingTwoPointers(version1, version2));
	}
	
	/*
	 * Pseudo code
	 * Convert the strings into arrays by splitting with '.'
	 * Find max length between 2 string arrays
	 * Initialize left as 0
	 * Traverse until left less than length
	 * 		Initialize 2 variables for 2 string arrays as 0
	 * 		If left is less than array's length, initialize 0 otherwise corresponding element
	 * 		Do the above for both the arrays
	 * 		Check if both the values are not same
	 * 			If first element value > second element, return 1
	 * 			If first element value < second element, return -1
	 * 		Increment left
	 * Return 0
	 */
	
	private int compareVersions(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int length = (v1.length > v2.length)?v1.length:v2.length;
		int left = 0;
		while(left < length) {
			int v1Left = 0, v2Left = 0;
			v1Left = (left < v1.length)?Integer.valueOf(v1[left]):0;
			v2Left = (left < v2.length)?Integer.valueOf(v2[left]):0;
			
			if(v1Left != v2Left) {
				if(v1Left > v2Left) return 1;
				else if(v1Left < v2Left) return -1;
			}
			left++;
		}
		return 0;
	}
	
	/*
	 * Pseudo code
	 * Check which version's length is greater
	 * Convert the strings into array of greater length
	 * Initialize 2 pointers left as 0, right as length-1
	 * Traverse until left < right
	 * 		If the value at left of both the arrays are not same, check which one is greater
	 * 			If version1 is greater, return 1
	 * 			else if version2 is greater, return -1
	 * 			else return 0
	 * 		If the value at right of both the arrays are not same, check the values
	 * 			If version1 is greater, return 1
	 * 			else if version2 is greater, return -1
	 * 			else return 0
	 * Return 0
	 */
	
	private int compareVersionsUsingTwoPointers(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int length = (v1.length < v2.length)?v1.length:v2.length;
		int left = 0, right = length-1;
		while(left <= right) {
			int v1Left = Integer.valueOf(v1[left]);
			int v2Left = Integer.valueOf(v2[left]);
			int v1Right = Integer.valueOf(v1[right]);
			int v2Right = Integer.valueOf(v2[right]);
			if(v1Left != v2Left && v1Left != 0 || v2Left != 0) {
				if(v1Left > v2Left) return 1;
				else if(v1Left < v2Left) return -1;
			}
			else if(v1Right != v2Right && v1Right != 0 || v2Right != 0) {
				if(v1Right > v2Right) return 1;
				else if(v1Right < v2Right) return -1;
			}
			left++;
			right--;
		}if (v1.length == v2.length) return 0;
		else if(length == v1.length && length < v2.length){
			left++;
            while(left < v2.length){
                if(!v2[left++].equals("0")) return -1;
            }
        }
		else if(length == v2.length && length < v1.length){
            while(left < v1.length){
                if(!v1[left++].equals("0")) return 1;
            }
        }
//		else if(length == v1.length && length < v2.length && Integer.valueOf(v2[v2.length-1]) != 0)
//			return -1;
//		else if(length == v2.length && length < v1.length && Integer.valueOf(v1[v1.length-1]) != 0)
//		return 1;
		return 0;
	}
	
	
	
}
