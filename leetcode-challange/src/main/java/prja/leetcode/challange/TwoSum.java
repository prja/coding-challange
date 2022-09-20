package prja.leetcode.challange;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class TwoSum {

	 public int[] twoSum(int[] nums, int target) {
		 int [] output= new int[2];
		 Map<Integer, Integer> map= new HashMap<>();
		 for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				output[0]=map.get(nums[i]);
				output[1]=i;
			}else {
				map.put(target-nums[i], i);
			}
		}
	        return output;
	  }
	 
	 public static void  main(String[] args) {
		 int [] nums= {2,7, 6, 0,1};
		System.out.println( Arrays.toString(new TwoSum().twoSum(nums, 9)));
	 }
}
