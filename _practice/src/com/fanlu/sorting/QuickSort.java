package com.fanlu.sorting;

/**
 * ����ʽ����-�������� ��������Quicksort���Ƕ�ð�������һ�ָĽ�
 * 
 * ����˼�룺 �ݹ� ͨ��һ������Ҫ��������ݷָ�ɶ����������� ����һ���ֱ���һ�����������ݶ�ҪС�� Ȼ���ٰ��˷��������������ݷֱ���п�������
 * ����������̿��Եݹ���У�����ʹ�������ݱ������
 */

public class QuickSort {
	// ����� ���ұ� ���� ���ݽ�ȥ
	public void sort(int left, int right, int[] array) {
		int l = left;
		int r = right;
		// �м����
		int pivot = array[(left + right) / 2];
		int temp = 0;

		// �ֱ����������ȡ�����һ��ȡ���м����pivot���д�С�Ƚϣ�
		// ÿ��Ѱ��һ����p��ߵ�����p���� ��p�ұ�С��p�������н���
		// �������ɴν���������ʹp��ߵ�����С��p��p�ұߵ���������p
		while (l < r) {
			while (array[l] < pivot)
				l++;
			while (array[r] > pivot)
				r--;
			if (l >= r)
				break;
			temp = array[l];
			array[l] = array[r];
			array[r] = temp;

			if (array[l] == pivot)
				--r;
			if (array[r] == pivot)
				++l;
		}
		if (l == r) {
			l++;
			r--;
		}
		// �ݹ��˼�룬������ұߵ�������ֱ���д���sort
		// �Դ����ƣ�����ȫ��������ȷ
		if (left < r)
			sort(left, r, array);
		if (right < l)
			sort(l, right, array);
	}
	
	public static void quickSort(int[] a, int l, int r) {

        if (l < r) {
            int i,j,x;

            i = l;//start from left
            j = r;//start from right
            x = a[i];
            while (i < j) {
                while(i < j && a[j] > x)
                    j--; // ���������ҵ�һ��С��x����
                if(i < j)
                    a[i++] = a[j];
                while(i < j && a[i] < x) 
                    i++; // ���������ҵ�һ������x����
                if(i < j)
                    a[j--] = a[i];
            }
            a[i] = x;
            quickSort(a, l, i-1); /* �ݹ���� */
            quickSort(a, i+1, r); /* �ݹ���� */
        }
    }
	
	public void quickSort2(int array[], int start, int end)
	{
	        int i = start;                          // index of left-to-right scan
	        int k = end;                            // index of right-to-left scan

	        if (end - start >= 1)                   // check that there are at least two elements to sort
	        {
	                int pivot = array[start];       // set the pivot as the first element in the partition

	                while (k > i)                   // while the scan indices from left and right have not met,
	                {
	                        while (array[i] <= pivot && i <= end && k > i)  // from the left, look for the first
	                                i++;                                    // element greater than the pivot
	                        while (array[k] > pivot && k >= start && k >= i) // from the right, look for the first
	                            k--;                                        // element not greater than the pivot
	                        if (k > i)                                       // if the left seekindex is still smaller than
	                                swap(array, i, k);                      // the right index, swap the corresponding elements
	                }
	                swap(array, start, k);          // after the indices have crossed, swap the last element in
	                                                // the left partition with the pivot 
	                quickSort(array, start, k - 1); // quicksort the left partition
	                quickSort(array, k + 1, end);   // quicksort the right partition
	        }
	        else    // if there is only one element in the partition, do not do any sorting
	        {
	                return;                     // the array is sorted, so exit
	        }
	}

	public void swap(int array[], int index1, int index2) 
	// pre: array is full and index1, index2 < array.length
	// post: the values at indices 1 and 2 have been swapped
	{
		int temp = array[index1];           // store the first value in a temp
		array[index1] = array[index2];      // copy the value of the second into the first
		array[index2] = temp;               // copy the value of the temp into the second
	}
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		
	}
}
