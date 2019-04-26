package com.fanlu.sorting;

/* **
 * 选择排序法
 * 选择排序法也属于内部排序法，
 * 是从欲排序的数据中，按指定的规则选出某一元素，
 * 经过和其他元素重整，再依原则交换位置后达到排序的目的
 *
 * 选择排序又分两种
 * 1.选择排序法（Selection Sort）
 * 2.堆排序法（Heap Sort）
 *
 * 选择排序（Select sorting）也是一种简单的排序方法。它的基本思想是：
 * 第一次从R[0]--R[n-1]中选出最小值，与R[0]交换
 * 第二次从R[1]--R[n-1]中选出最小值，与R[1]交换
 * 第三次从R[2]--R[n-1]中选出最小值，与R[2]交换
 * 第i 次从R[i-1]--R[n-1]中选出最小值，与R[i-1]交换
 * 第n-1次从R[n-2]--R[n-1]中选出最小值，与R[n-2]交换
 * 总共通过n-1次，得到一个按排序码从小到大排列的有序序列
 *
 */

public class SelectionSort {
    public void sort(int arr[]) {
        int temp = 0;
        //我认为第一个数就是最小
        for (int j = 1; j < arr.length - 1; j++) {

            int min = arr[j];
            //记录最小数的下标
            int minIndex = j;

            for (int k = j + 1; k < arr.length; k++) {
                if (min > arr[k]) {
                    //修改最小
                    min = arr[k];
                    minIndex = k;
                }
            }
            //当退出for循环时，就找到本次最小值
            temp = arr[j];
            arr[j] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
