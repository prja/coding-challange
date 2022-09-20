package prja.leetcode.challange;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/contains-duplicate/
public class Duplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}
		}
		return false;
	}
}
