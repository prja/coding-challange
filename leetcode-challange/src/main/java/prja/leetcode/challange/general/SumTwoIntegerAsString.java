package prja.leetcode.challange.general;

public class SumTwoIntegerAsString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addStrings("12","33"));

	}


    public static  String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            if (i >= 0) {
            	//System.out.println("---->"+(num1.charAt(i--) -'0'));
                sum += num1.charAt(i--) - '0';
                System.out.println(sum);
            }
            if (j >= 0) {
                sum += num2.charAt(j--) - '0';
                System.out.println(sum);
            }
            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }
}