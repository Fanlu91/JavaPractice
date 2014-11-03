package com.fanlu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberRelated {

	public int reverseInt(int x) {
		String str = "" + x;
		int result = 0;
		String value = str;
		if (str.contains("+") || str.contains("-")) {
			value = str.substring(1);
		}
		for (int i = 0; i < value.length(); i++) {
			result += (value.charAt(i) - '0') * Math.pow(10, i);
		}
		if (str.contains("-")) {
			return 0 - result;
		}
		return result;
	}

	/**
	 * generate Pascal's Triangle.
	 * 
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 1; i <= numRows; i++) {
			List<Integer> theList = new ArrayList<Integer>();
			for (int j = 1; j <= i; j++) {
				theList.add((int) (factorial(i - 1) / factorial(i - j) / factorial(j - 1)));
			}
			list.add(theList);
		}
		return list;
	}

	// factorial(1-20, 21 will cause overflow)
	private long factorial(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}

	//factorial, using int array to store the result
	public int[] FactorialLargeNumber(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("x must be>=0");
		}
		if (n == 0 || n == 1) {
			return new int[] { 1 };
		}
		int MAXLENGTH = 100000;
		int[] array = new int[MAXLENGTH];
		// number of digits;
		int digits = 1;
		// start each Multiplication from 2 to n
		long carry = 0;
		Arrays.fill(array, 1);
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < digits; j++) {
				long multipleResult = array[j] * i + carry;
//				System.out.println(multipleResult);
				array[j] = (int) (multipleResult % 10);
				carry = multipleResult / 10;
//				System.out.println("carry Ϊ"+carry);
			}
			while (carry !=0) {
				array[digits++] = (int) (carry % 10);
				carry /= 10;
			}
		}
		int[] result = new int[digits];
		result=Arrays.copyOf(array, digits);
		return result;
	}

	public static void main(String[] args) {
		NumberRelated n = new NumberRelated();
		System.out.println("here"+n.factorial(20));
		System.out.println(Arrays.toString(n.FactorialLargeNumber(10000)));
	}

}
