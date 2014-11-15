package com.fanlu.sorting;

/***
 * ��������
 * 
 * �������������ڲ�����, �Ƕ����������Ԫ���Բ���ķ�ʽ��Ѱ��Ԫ�ص���Ӧλ��, �Դﵽ�����Ŀ�ġ�
 * 
 * ���������ַ�3�� 1�������򷨣�Insert sort�� 2л������ ��shell sort�� 3���������򷨣�Binary-tree sort��
 * 
 * ����˼�룺��n���������Ԫ�ؿ���һ������������� ��ʼʱ�����ֻ����һ��Ԫ�أ���������n-1��Ԫ�� ���������ÿ�δ��������ȡ����һ��Ԫ�أ�
 * ����������������������������Ԫ�ؽ��бȽϣ� �����뵽������е��ʵ�λ�ã�ʹ֮��Ϊ�µ������
 */

public class InsertionSort {
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

	public void Insertsort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int insertVal = arr[i];
			// insertVal׼����ǰһ�����Ƚ�
			int index = i - 1;

			// move all the element ahead which is bigger than the insertVal
			while (index >= 0 && insertVal < arr[index]) {
				// ��arr[index]����ƶ�
				arr[index + 1] = arr[index];
				// ��index��ǰ�ƶ�
				index--;
			}
			// ��insertVal�����ʵ�λ��
			// then put insertVal to the right place.
			arr[index + 1] = insertVal;
		}
	}

	/**
	 * The shell sort partially sorts the array by sorting elements that are a
	 * certain number of spaces apart called the interval or gap
	 * 
	 * @param array
	 */
	public void ShellSort(int[] array) {
		// set size/2 as the gap

		for (int gap = array.length / 2; gap > 1; gap /= 2) {
			System.out.println(gap);
			for (int i = 0; i < array.length-gap; i++) {
				if(array[i]>array[i+gap]){
					int temp = array[i];
					array[i] = array[i+gap];
					array[i+gap] = temp;
				}
			}
		}
		for(int i=1;i<array.length;i++){
			int index = i - 1;
			int insertVal = array[i];
			while(index >= 0&&insertVal<array[index]){
				array[index+1]=array[index];
				index--;
			}
			array[index+1]=insertVal;
		}
		
	}

	public static void shellSort1(int[] a, int n) {

		// gapΪ������ÿ�μ�Ϊԭ����һ�롣
		for (int gap = n / 2; gap > 0; gap /= 2) {

			// ��gap���飬��ÿһ�鶼ִ��ֱ�Ӳ�������
			for (int i = 0; i < gap; i++) {

				for (int j = i + gap; j < n; j += gap) {

					// ���a[j] < a[j-gap]����Ѱ��a[j]λ�ã������������ݵ�λ�ö����ơ�
					if (a[j] < a[j - gap]) {

						int tmp = a[j];
						int k = j - gap;
						while (k >= 0 && a[k] > tmp) {
							a[k + gap] = a[k];
							k -= gap;
							printArray(a);
						}
						a[k + gap] = tmp;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };
		InsertionSort is = new InsertionSort();
		is.ShellSort(array);
		
	}
}
