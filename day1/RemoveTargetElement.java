package week1day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class RemoveTargetElement {

	//  {2,3,4,5,6}
	//  target = 5
	//  {2,3,4,6}
	//
	//  {2,3,4,5,5,6}
	//  target = 5
	//  {2,3,4,6}
	// Remove target element from the given array
  
  
  
	  @Test
	  public void test1()
	  {
		   int[] input = {2,3,4,5,6};
		   int target = 5;
		   Assert.assertArrayEquals(removeTargetUsingTwoPass(input,target), new int[]{2,3,4,6});
		   Assert.assertArrayEquals(removeTargetUsingList(input,target), new int[]{2,3,4,6});
		   Assert.assertArrayEquals(removeTargetUsingSinglePass(input,target), new int[]{2,3,4,6});
	  }
	  @Test
	  public void test2()
	  {
		   int[] input = {5,3,4,5,5,6};
		   int target = 5;
		   Assert.assertArrayEquals(removeTargetUsingTwoPass(input,target), new int[]{3,4,6});
		   Assert.assertArrayEquals(removeTargetUsingList(input,target), new int[]{3,4,6});
		   Assert.assertArrayEquals(removeTargetUsingSinglePass(input,target), new int[]{3,4,6});
	  }
	  @Test
	  public void test3()
	  {
		   int[] input = {2,3,4,6};
		   int target = 5;
		   Assert.assertArrayEquals(removeTargetUsingTwoPass(input,target), input);
		   Assert.assertArrayEquals(removeTargetUsingList(input,target), input);
		   Assert.assertArrayEquals(removeTargetUsingSinglePass(input,target), input);
	  }
	  @Test
	  public void test4()
	  {
		   int[] input = {2,2,2,2};
		   int target = 2;
		   Assert.assertArrayEquals(removeTargetUsingTwoPass(input,target), new int[] {});
		   Assert.assertArrayEquals(removeTargetUsingList(input,target), new int[] {});
		   Assert.assertArrayEquals(removeTargetUsingSinglePass(input,target), new int[] {});
	  }
	  
  
	 /*  Pseudo code
	  *  Create a array list
	  *  Iterate the input array
	  *  If current element in the array not matches the target
	  *  Add to the list
	  *  Create a new array and push the items in list to new array
	  *  Return the created array
	  */ 
	  
  	private int[] removeTargetUsingList(int[] input, int target) {
      List<Integer> data = new ArrayList<>();
      for (int i = 0; i < input.length; i++) 
      {
          if(input[i] != target) 
        	  data.add(input[i]);
      }
      
      int[] returnData = new int[data.size()];
      for (int i = 0; i < data.size(); i++) 
    	  returnData[i] = data.get(i);    
      return returnData;
  	}
  	
  	/*
  	 * Pseudo code
  	 * Initialize an count with array length
  	 * Traverse through the array 
  	 * If the current element equals the target, then decrement count
  	 * If the count equals to array length, return the array
  	 * Initialize the array with count size
  	 * Initialize count as 0 for created array traversal
  	 * Traverse through the input array
  	 * If the element at the current index not matches the target
  	 * Add the element to the created array
  	 * Return the output array
  	 */
  	
  	private int[] removeTargetUsingTwoPass(int[] num, int target) {
  		
  		int count = num.length;
  		
  		for(int j = 0; j < num.length; j++)
  		{
  			if(num[j] == target)
  				count--;
  		}
  		if(count == num.length)
  			return num;
  		if(count == 0)
  			return new int[] {};
  		int[] output = new int[count];
  		count = 0;
  		for(int i = 0; i < num.length; i++)
  		{
  			if(num[i] != target)
  				output[count++] = num[i];
  		}
  		return output;
  	}
  	
  	/*
  	 * Pseudo code
  	 * Initialize an iterator with 0
  	 * Traverse through the array 
  	 * If the current element not matches the target
  	 * Add the current value to the array in iterator's index
  	 * Increment iterator index
  	 * Return the sub array from 0 to i to which will remove duplicates
  	 */
  	/*
  	 * Input: 2,3,4,5,6
  	 * Target: 5
  	 * i = 0 & j = 0 num[j] != 5
  	 * num[i] = 2
  	 * i = 1 & j = 1; num[j] != 5
  	 * num[i] = 3
  	 * i = 2 & j = 2; num[j] != 5
  	 * num[i] = 4
  	 * i = 3 & j = 3; num[j] == 5
  	 * i = 3 & j = 4; num[j] != 5
  	 * num[i] = 6
  	 * 
  	 * Also num[4] = 6 -> In order to remove this index
  	 * 
  	 * Returning from 0 to i(3)
  	 */
  	
private int[] removeTargetUsingSinglePass(int[] num, int target) {
  		
  		int i = 0;
  		
  		for(int j = 0; j < num.length; j++)
  		{
  			if(num[j] != target)
  			{
  				num[i] = num[j];
  				System.out.println(num[i]);
  				i++;
  			}
  		}
  		System.out.println(Arrays.toString(num));
  		return Arrays.copyOfRange(num, 0, i);
  	}
  	
/*
 *  1,2,2,1,1,3
 
	[i][j] -> [1][3]
			 [2][2]
			[3][1]
*/


  	
}
