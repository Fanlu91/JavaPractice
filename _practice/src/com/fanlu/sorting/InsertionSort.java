package com.fanlu.sorting;
/***
 * 插入排序法 
 * 
 * 插入排序法属于内部排序法,
 * 是对于欲排序的元素以插入的方式找寻该元素的适应位置,
 * 以达到排序的目的。
 * 
 * 插入排序又分3种
 * 1插入排序法（Insert sort）
 * 2谢尔排序法 （shell sort）
 * 3二叉树排序法（Binary-tree sort）
 * 
 * 基本思想：把n个待排序的元素看成一个有序表和无序表
 * 开始时有序表只包含一个元素，无序表包含n-1个元素
 * 排序过程中每次从无序表中取出第一个元素，
 * 把它的排序码依次与有序表的排序元素进行比较，
 * 它插入到有序表中的适当位置，使之成为新的有序表
 */ 

public class InsertionSort{
	public void sort(int arr[]){
		for(int i=1;i<arr.length;i++){
			int insertVal=arr[i];
			//insertVal准备和前一个数比较
			int index=i-1;
			
			while(index>=0&&insertVal<arr[index]){
				//把arr[index]向后移动
				arr[index+1]=arr[index];
				//让index向前移动
				index--;
			}
			//将insertVal插入适当位置
			arr[index+1]=insertVal;
		}
	}
}
