package prja.leetcode.challange.general;

import java.util.Map;
import java.util.TreeMap;

public class Swap {
	public static void main(String[] args) {
		Integer x = 10;
		Integer y = 20;
		swap(x, y);
		System.out.println("x = " + x + ", y = " + y);
		Map<String, String> m= new TreeMap<>();
	}

	static void swap(Integer a, Integer b) {
		Integer tmp = a;
		a = b;
		b = tmp;
	}
}