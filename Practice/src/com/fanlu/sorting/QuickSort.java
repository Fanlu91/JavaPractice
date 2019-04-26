package com.fanlu.sorting;

/**
 * 交换式排序法-快速排序法 快速排序（Quicksort）是对冒泡排序的一种改进
 * 基本思想： 递归 通过一趟排序将要排序的数据分割成独立的两部分
 * 其中一部分比另一部分搜有数据都要小， 然后再按此方法对两部分数据分别进行快速排序
 * 整个排序过程可以递归进行，最终使整个数据变成有序
 */

public class QuickSort {
    // 最左边 最右边 数组 传递进去
    public void sort(int left, int right, int[] array) {
        int l = left;
        int r = right;
        // 中间变量
        int pivot = array[(left + right) / 2];
        int temp = 0;

        // 分别从最左最右取数与第一次取的中间变量pivot进行大小比较，
        // 每次寻找一个在p左边但大于p的数 与p右边小于p的数进行交换
        // 经过若干次交换，最终使p左边的数都小于p，p右边的数都大于p
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
        // 递归的思想，对左边右边的两个组分别进行此种sort
        // 以此类推，最终全部排列正确
        if (left < r)
            sort(left, r, array);
        if (right < l)
            sort(l, right, array);
    }

    public static void quickSort(int[] a, int l, int r) {

        if (l < r) {
            int i, j, x;

            i = l;//start from left
            j = r;//start from right
            x = a[i];
            while (i < j) {
                while (i < j && a[j] > x)
                    j--; // 从右向左找第一个小于x的数
                if (i < j)
                    a[i++] = a[j];
                while (i < j && a[i] < x)
                    i++; // 从左向右找第一个大于x的数
                if (i < j)
                    a[j--] = a[i];
            }
            a[i] = x;
            quickSort(a, l, i - 1); /* 递归调用 */
            quickSort(a, i + 1, r); /* 递归调用 */
        }
    }

    public void quickSort2(int array[], int start, int end) {
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
            quickSort2(array, start, k - 1); // quicksort the left partition
            quickSort2(array, k + 1, end);   // quicksort the right partition
        }
        // if there is only one element in the partition, do not do any sorting
        // the array is sorted, so exit
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