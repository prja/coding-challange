package prja.leetcode.challange.general;

public class FirstNonRepeatingChar2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "zzzzzbbbccccddehhhhiii";
		int[] countingArray = new int[128];
		str.chars().forEach(value -> {
			System.out.println(value);
			int cc = countingArray[value]++;
			System.out.println("cc="+cc);
		});
		int nonRepeatingCharAsInt = 0;
		for (int i = 0; i < countingArray.length; i++) {
			System.out.println("i="+i);
			System.out.println("countingArray[i]="+countingArray[i]);
			if (countingArray[i] == 1) {
				nonRepeatingCharAsInt = i;
				break;
			}
		}
		System.out.println("character = " + Character.valueOf((char) nonRepeatingCharAsInt));
	}

}
