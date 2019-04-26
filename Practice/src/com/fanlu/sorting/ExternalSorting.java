package com.fanlu.sorting;

/**
 * 外部排序法
 * 数据量太大无法一次完全加载内存，
 * 可以使用外部辅助内存来处理排序数据，
 * 主要应用在文件排序
 * 合并排列法（Merge sort）是外部排序最常使用的排序方法。
 * 方法： 将欲排序的数据存放在数个文件夹大小可以加载内存的文件中，
 * 在针对各个文件分别使用“内部排序法”将文件中的数据排好写回文件。
 * 再对所有已排好的文件进行两两合并，直到所有文件合并成一个文件，
 * 则数据排序完成。
 */

public class ExternalSorting {

    /**
     * @param args none
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

