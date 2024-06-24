package prja.leetcode.challange.general;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FactorialJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(factorialStreams(5));
	}
	public static long factorialStreams( int n )
	{
	    return IntStream.rangeClosed( 1, n )
	                     .reduce(1, ( int a, int b ) -> a * b);
	}
	
	
	private static void printFactorial(int val)
	{
		int fact= 1;
		if(val==0 || val==1)
			System.out.println(fact);
		
		for (int i = 1; i <=val; i++) {
			fact*=i;
			
			
		}
		System.out.println(fact);
		
	}
}
