package assessment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class GroupTransactionNames {
	/*
	 * Given a string str = "aabbccddde"; output: "a2b2c2d3e1"
	 * 
	 * Input: String Array
	 * Output: String Array
	 * Constraint: No
	 * 
	 * Test data set:
	 * Positive: {"notebook","notebook","mouse","mouse","keyboard"}
	 * Output:{"mouse 2", "notebook 2", "keyboard 1"}
	 * Edge: {"almond","apple","apple","apple","almond"}
	 * Output:{"apple 3", "almond 2"}
	 * Negative: {notebook}; output: {"notebook 1"}
	 * 
	 * Approach: 
	 * Hash Map
	 * 
	 * 
	 * O Notations
	 */

	@Test
	public void test1() {
		String[] input = {"notebook","notebook","mouse","mouse","keyboard"};
		//findGroup(input);
		Assert.assertTrue(Arrays.equals(new String[] {"mouse 2", "notebook 2", "keyboard 1"}, findGroup(input)));
	}
	
	@Test
	public void test2() {
		String[] input = {"almond","apple","apple","apple","almond"};
		//findGroup(input);
		Assert.assertTrue(Arrays.equals(new String[] {"apple 3", "almond 2"}, findGroup(input)));
	}
	
	@Test
	public void test3() {
		String[] input = {"notebook"};
//		findGroup(input);
		Assert.assertTrue(Arrays.equals(new String[] {"notebook 1"}, findGroup(input)));
	}
	
	/*
	 * Pseudo code
	 * Create a tree map
	 * Add string as key and occurrence as value
	 * Create a list 
	 * Sort the map using stream
	 * Return the list
	 * 
	 */
	
	// Time Complexity: O(nlogn)
	// Space Complexity: O(n)
	
	
	private String[] findGroup(String[] input) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for(int i = 0; i < input.length; i++)
			map.put(input[i], map.getOrDefault(input[i], 0)+1);
		List<String> list = new ArrayList<String>();
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x->list.add(x.getKey()+" "+x.getValue()));
		String[] output = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			output[i] = list.get(i);
		}
		return output;
	}
}
