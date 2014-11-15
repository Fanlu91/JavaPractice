package com.fanlu.sorting;

import java.util.Arrays;

/**
 * http://www.zutopedia.com/ms_vs_qs.html Merge sort generally performs less
 * comparisons than quick sort both worst case and on average. If performing a
 * comparison is costly, merge sort will definitely have the upper hand in terms
 * of speed. Merge sort requires more memory: As shown in the video, merge sort
 * uses the whole upper shelf. Quick sort on the other hand puts only one ball
 * at a time on the upper shelf. Quick sort is generally believed to faster in
 * common real-life settings. This is mainly due to its lower memory consumption
 * which usually affects time performance as well.
 * 
 * @author Administrator
 * 
 */
public class MergeSort {

	public static void printArray(int[] array) {
		System.out.print("{");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}

	public void mergeSort(int l, int r, int[] array) {
		if (l >= r)
			return;
		int mid = (l + r) / 2;
		mergeSort(l, mid, array);
		mergeSort(mid + 1, r, array);

		int leftEnd = mid;
		int rightStart = mid + 1;

		int[] tempArray = Arrays.copyOfRange(array, rightStart, r + 1);

		int rightSize = tempArray.length;
		int leftSize = leftEnd - l+1;
		System.out.println("l and r size:"+ leftSize+" "+rightSize);
		while (rightSize + leftSize > 0) {			
			if (rightSize < 1) {
				return;
			}
			if (leftSize < 1) {
				array[l + leftSize + rightSize - 1] = tempArray[rightSize - 1];
				rightSize--;
			} else {
				if (array[l + leftSize - 1] >= tempArray[rightSize - 1]) {
					array[l + leftSize + rightSize-1] = array[l + leftSize - 1];
					leftSize--;
				} else {
					array[l + leftSize + rightSize-1] = array[rightSize - 1];
					rightSize--;
				}
			}
			printArray(array);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort m = new MergeSort();
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };
		m.mergeSort(0, array.length - 1, array);
		m.printArray(array);
	}

}
