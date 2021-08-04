/**
 * 
 */
package week5day5;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Vidhya
 *
 */
public class AverageSalary {

	/*
		 * Input: long array 
		 * Output: double
		 * Constraint: 
		 * Test Data:
		 * Positive: {4000,3000,1000,2000}
		 * Output: 2500.00000
		 * Edge: {1000,2000}
		 * Output: 0
		 * Negative: {8000,9000,2000,3000,6000,1000}
		 * Output: 4750.00000
		 * 
		 * Approach: Brute force
		 * Time Complexity: O(n)
		 * Space Complexity: O(1)
		 * 
		 * Approach: 2 pointer
		 * Time Complexity: O(n/2)
		 * Space Complexity: O(1)
		 */

	@Test
	public void test1() {
		long[] salary = {4000,3000,1000,2000};
		Assert.assertEquals(2500.00000, findAverageSalaryUsing2Pointer(salary));
	}

	@Test (expected = RuntimeException.class)
	public void test2() {
		long[] salary = {1000,2000};
		Assert.assertEquals(0, findAverageSalaryUsing2Pointer(salary));
	}

	@Test
	public void test3() {
		long[] salary = {8000,9000,2000,3000,6000,1000};
		Assert.assertEquals(4750.00000, findAverageSalaryUsing2Pointer(salary));
	}
	
	@Test (expected = RuntimeException.class)
	public void test4() {
		long[] salary = {1000};
		Assert.assertEquals(1000, findAverageSalaryUsing2Pointer(salary));
	}
	
	/*
	 * Pseudo code
	 * If the length of the array is less than 3, throw exception
	 * Initialize 3 variables maxSalary, minSalary, sum as 0
	 * Traverse through the array
	 * 		Find maxSalary, minSalary and sum
	 * Return sum -(maxSalary + minSalary)/length-2
	 */
	
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	
	private double findAverageSalary(long[] salary) {
		if(salary.length < 3)
			throw new RuntimeException("Invalid Input");
		long maxSalary = 0, minSalary = Integer.MAX_VALUE;
		double sum = 0;
		for(int i = 0; i < salary.length; i++) {
			maxSalary = Math.max(maxSalary, salary[i]);
			minSalary = Math.min(minSalary, salary[i]);
			sum += salary[i];
		}
		return (sum - (maxSalary + minSalary))/(salary.length-2);
	}
	
	/*
	 * Pseudo code - 2 pointer
	 * If the length of the array is less than 3, throw exception
	 * Initialize 3 variables maxSalary, minSalary, sum as 0
	 * Initialize 2 variables left as 0, right as length - 1
	 * Traverse until left less than right
	 * 		Find max, min and sum
	 * Return sum -(maxSalary + minSalary)/length-2
	 */
	
	// Time Complexity: O(n/2)
	// Space Complexity: O(1)
	
	private double findAverageSalaryUsing2Pointer(long[] salary) {
		if(salary.length < 3)
			throw new RuntimeException("Invalid Input");
		long maxSalary = 0, minSalary = Integer.MAX_VALUE;
		double sum = 0;
		int left = 0, right = salary.length-1;
		while(left < right) {
			maxSalary = Math.max(maxSalary, Math.max(salary[left], salary[right]));
			minSalary = Math.min(minSalary, Math.min(salary[left], salary[right]));
			sum += salary[left++] + salary[right--];
		}
		return (sum - (maxSalary + minSalary))/(salary.length-2);
	}
}
