package prja.leetcode.challange.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FirstNonRepeatingChar {
	public static void main() {
		String str = "zzzzzbbbccccddehhhhiii";
		int[] countingArray = new int[128];
		str.chars().forEach(value -> {
			System.out.println(value);
			countingArray[value]++;
			System.out.println();
		});
		int nonRepeatingCharAsInt = 0;
		for (int i = 0; i < countingArray.length; i++) {
			if (countingArray[i] == 1) {
				nonRepeatingCharAsInt = i;
				break;
			}
		}
		System.out.println("character = " + Character.valueOf((char) nonRepeatingCharAsInt));
		
		
		List<Integer> numbers = Arrays.asList(8,1,2,3,4,5,9);
		int result = numbers.stream().reduce(1, (a, b) -> a * b);
		System.out.println("Result: " + result);
		
		
		int result2 = numbers.stream()
                .max(Comparator.reverseOrder())
                .orElse(0);
		System.out.println(result2);
	}

}
