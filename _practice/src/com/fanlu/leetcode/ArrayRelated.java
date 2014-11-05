package com.fanlu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayRelated {
	/**
	 * remove element from an array.
	 * 
	 * @param A
	 * @param elem
	 * @return
	 */
	public int removeElement(int[] A, int elem) {
		int k = A.length - 1;
		for (int i = 0; i <= k;)
			if (A[i] == elem)
				A[i] = A[k--];
			else
				i++;// key here
		return k + 1;
	}

	/**
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length. Do not allocate extra
	 * space for another array, you must do this in place with constant memory.
	 * 
	 * @param args
	 */
	public int removeDuplicates(int[] A) {
		int dupNum = 0;
		int left = 0;
		boolean flag = true;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] == A[i + 1]) {
				if (flag) {
					left = i + 1;
					flag = false;
				}
				dupNum++;
			} else if (A[i] < A[i + 1]) {
				if (!flag) {
					A[left] = A[i + 1];
					left++;
				}
			}
		}
		return A.length - dupNum;
	}
	/**
	 * Given a non-negative number represented as an array of digits, plus one to the number.
	 * The digits are stored such that the most significant digit is at the head of the list.
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {
		int carry = 1;// the one pulsed at the first time or the carry from the
						// previous digit.
		int[] result = new int[digits.length + 1];
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] = digits[i] + carry;
			if (digits[i] > 9) {
				digits[i] -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
		}
		if (carry == 1) {
			result[0] = 1;
			for (int i : digits) {
				int index = 1;
				result[index] = i;
				index++;
			}
			return result;
		}
		return digits;
	}

	public static void main(String[] args) {
		ArrayRelated ar = new ArrayRelated();
		System.out.println(ar.removeDuplicates(new int[] { 1, 2, 3, 3, 4, 4, 5,
				5, 6, 6, 7, 7 }));
	}
}
