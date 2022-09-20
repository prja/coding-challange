package prja.leetcode.challange;

import java.util.Stack;

public class LongestValidParantheses {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")("));
	}
	public static int longestValidParentheses(String s) {
        if(s==null){
            return 0;
        }
        Stack<Character> stk = new Stack<>();
        int result = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                stk.push('(');
            }else if(!stk.isEmpty() && (s.charAt(i)==')' && stk.peek()=='(')) {            	
                	stk.pop();
                	result=result+2;
            }
           
        }
        return result;
    }

}
