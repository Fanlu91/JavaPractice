package com.fanlu.sorting;

import java.util.Calendar;

public class InternalSorting {

    public static void main(String[] args) {

        int len = 1000000;
// 		int len=8;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            //让程序随机产生1-10000的数
            // Math.random()会随机产生一个0~1的数
            arr[i] = (int) (Math.random() * 10000);
        }

// 		int arr1[]={1,6,0,-1,9,11,99,88,77,66,55,44,33,22,13,4};

// 		Bubble bubble=new Bubble();
// 		//在排序前打印系统时间
// 		Calendar cal=Calendar.getInstance();
// 		System.out.println("开始排序"+cal.getTime());
// 		bubble.sort(arr);
// 		//在排序后打印系统时间
// 		Calendar cal2=Calendar.getInstance();//重新得到实例
// 		System.out.println("排序完成"+cal2.getTime());
// 		Select select=new Select();
// 		//在排序前打印系统时间
// 		Calendar cal=Calendar.getInstance();
// 		System.out.println("开始排序"+cal.getTime());
// 		select.sort(arr);
// 		//在排序后打印系统时间
// 		Calendar cal2=Calendar.getInstance();//重新得到实例
// 		System.out.println("排序完成"+cal2.getTime());
// 		Insert insert=new Insert();
// 		//在排序前打印系统时间
// 		Calendar cal=Calendar.getInstance();
// 		System.out.println("开始排序"+cal.getTime());
// 		insert.sort(arr);
// 		//在排序后打印系统时间
// 		Calendar cal2=Calendar.getInstance();//重新得到实例
// 		System.out.println("排序完成"+cal2.getTime());

        QuickSort qs = new QuickSort();
        //在排序前打印系统时间
        Calendar cal = Calendar.getInstance();
        System.out.println("开始排序" + cal.getTime());
        qs.sort(0, arr.length - 1, arr);
        //在排序后打印系统时间
        Calendar cal2 = Calendar.getInstance(); //重新得到实例
        System.out.println("排序完成" + cal2.getTime());

    }
}