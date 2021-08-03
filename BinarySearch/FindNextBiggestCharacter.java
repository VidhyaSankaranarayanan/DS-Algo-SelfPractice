package week3day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class FindNextBiggestCharacter {
	
	/*
	 * Input: char array
	 * Output: Character
	 * Constraint: Solve in O(log n) & do not use extra space
	 * 
	 * Test data set:
	 * Positive: {'b','d','h'}, char c = 'e'; Output: 'h'
	 * Negative: {'b','d','f','h','j'}, c = 'a'; Output: 'b'
	 * Edge: {'b','b','b'}; Output: 'a'
	 * 
	 * Approach: Brute Force
	 * Binary Search
	 * 
	 * O Notations
	 */
	
	@Test
	public void test1() {
		char[] arr = {'b','d','h'};
		char ch = 'e';
		Assert.assertEquals('h', findNextBiggestCharacter(arr,ch));
	}
	
	@Test
	public void test2() {
		char[] arr = {'b','d','f','h','j'};
		char ch = 'a';
		Assert.assertEquals('b', findNextBiggestCharacter(arr,ch));
	}
	
	@Test
	public void test3() {
		char[] arr = {'b','b','b'};
		char ch = 'a';
		Assert.assertEquals('b', findNextBiggestCharacter(arr,ch));
	}

	
	
	/*
	 * Pseudo code
	 * Initialize low as 0, high as length-1
	 * Traverse until low<=high
	 *		Find mid
	 *		If mid < target, low = mid+1
	 *		else high = mid-1
	 * Return char at low
	 */
	
	
	private char findNextBiggestCharacter(char[] arr, char ch) {
		int low = 0, high = arr.length-1;
		while(low <= high) {
			int mid = (low+high)/2;
			if(arr[mid] < ch)
				low = mid+1;
			else
				high = mid-1;
		}
		return arr[low];
	}
	
	

}
