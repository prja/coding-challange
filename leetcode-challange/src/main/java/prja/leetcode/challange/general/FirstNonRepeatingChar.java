package prja.leetcode.challange.general;

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
	}

}
