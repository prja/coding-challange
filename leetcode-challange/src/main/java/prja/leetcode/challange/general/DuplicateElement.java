package prja.leetcode.challange.general;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * Find duplicate  using Stream
 * @author prabhun
 *
 */
public class DuplicateElement {

	public static Set<Integer> findDuplicate() {
		Integer[] array = new Integer[]{5,6,7,8,9,5,6,7};
		
		Set<Integer> duplicateItems = new HashSet<>();
		return Arrays.stream(array).filter(n -> !duplicateItems.add(n)).collect(Collectors.toSet());
		 
	}

	public static void main(String[] args) {
		System.out.println(findDuplicate() );
	}

}
