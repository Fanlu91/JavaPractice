package com.fanlu.sorting;

/***
 * 插入排序法
 *插入排序法属于内部排序法, 是对于欲排序的元素以插入的方式找寻该元素的适应位置, 以达到排序的目的。
 *
 * 插入排序又分3种
 * 1插入排序法（Insert sort）
 * 2谢尔排序法 （shell sort）
 * 3二叉树排序法（Binary-tree sort）
 *
 * 基本思想：把n个待排序的元素看成一个有序表和无序表 开始时有序表只包含一个元素，无序表包含n-1个元素 排序过程中每次从无序表中取出第一个元素，
 * 把它的排序码依次与有序表的排序元素进行比较， 它插入到有序表中的适当位置，使之成为新的有序表
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
            // insertVal准备和前一个数比较
            int index = i - 1;

            // move all the element ahead which is bigger than the insertVal
            while (index >= 0 && insertVal < arr[index]) {
                // 把arr[index]向后移动
                arr[index + 1] = arr[index];
                // 让index向前移动
                index--;
            }
            // 将insertVal插入适当位置
            // then put insertVal to the right place.
            arr[index + 1] = insertVal;
        }
    }

    /**
     * The shell sort partially sorts the array by sorting elements that are a
     * certain number of spaces apart called the interval or gap
     *
     * @param array hh
     */
    public void ShellSort(int[] array) {
        // set size/2 as the gap

        for (int gap = array.length / 2; gap > 1; gap /= 2) {
            System.out.println(gap);
            for (int i = 0; i < array.length - gap; i++) {
                if (array[i] > array[i + gap]) {
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                }
            }
        }
        for (int i = 1; i < array.length; i++) {
            int index = i - 1;
            int insertVal = array[i];
            while (index >= 0 && insertVal < array[index]) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = insertVal;
        }

    }

    public static void shellSort1(int[] a, int n) {

        // gap为步长，每次减为原来的一半。
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // 共gap个组，对每一组都执行直接插入排序
            for (int i = 0; i < gap; i++) {

                for (int j = i + gap; j < n; j += gap) {

                    // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
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
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3};
        InsertionSort is = new InsertionSort();
        is.ShellSort(array);

    }
}

