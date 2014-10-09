package com.fanlu.sorting;
import java.util.Calendar;

public class InternalSorting {
	
	public static void main(String[] args){
		
		int len=1000000;
//		int len=8;
		int []arr=new int [len];
		for (int i=0;i<len;i++){
			//让程序随机产生1-10000的数
			//Math.random()会随机产生一个0~1的数
			arr[i]=(int)(Math.random()*10000);
		}
		
//		int arr1[]={1,6,0,-1,9,11,99,88,77,66,55,44,33,22,13,4};
		
//		Bubble bubble=new Bubble();
//		//在排序前打印系统时间
//		Calendar cal=Calendar.getInstance();
//		System.out.println("开始排序"+cal.getTime());
//		bubble.sort(arr);
//		//在排序后打印系统时间
//		Calendar cal2=Calendar.getInstance();//重新得到实例
//		System.out.println("排序完成"+cal2.getTime());
		
//		Select select=new Select();
//		//在排序前打印系统时间
//		Calendar cal=Calendar.getInstance();
//		System.out.println("开始排序"+cal.getTime());
//		select.sort(arr);
//		//在排序后打印系统时间
//		Calendar cal2=Calendar.getInstance();//重新得到实例
//		System.out.println("排序完成"+cal2.getTime());
	
//		Insert insert=new Insert();
//		//在排序前打印系统时间
//		Calendar cal=Calendar.getInstance();
//		System.out.println("开始排序"+cal.getTime());
//		insert.sort(arr);
//		//在排序后打印系统时间
//		Calendar cal2=Calendar.getInstance();//重新得到实例
//		System.out.println("排序完成"+cal2.getTime());
		
		QuickSort qs=new QuickSort();
		//在排序前打印系统时间
		Calendar cal=Calendar.getInstance();
		System.out.println("开始排序"+cal.getTime());
		qs.sort(0,arr.length-1,arr);
		//在排序后打印系统时间
		Calendar cal2=Calendar.getInstance();//重新得到实例
		System.out.println("排序完成"+cal2.getTime());
		
//		//输出最后结果
//		for(int i=0;i<arr.length;i++){
//			System.out.print(arr[i]+" ");
//		}
	}
}

/**
 * 冒泡排序的基本思想是：通过对待排序序列从后向前（从下表较大的元素开始），
 * 依次比较相邻元素的排序码，若发现逆序则交换，
 * 使排序码较小的元素逐渐从后部移向前部（从下表较大的单元移向下标较小的单元）
 * 就像水底下的气泡一样逐渐向上冒。
 * 
 * 因为排序的过程中，元素不断接近自己的位置，
 * 如果一趟比较下来没有进行过交换，就说明序列有序，、
 * 因此要在排序过程中设置一个标志flag判断元素是否进行过交换，
 * 从而减少不必要的比较
 */
class Bubble{
	public void sort(int arr[]){
		int temp=0;
		//排序
		
		//外层循环，它可以决定一共走几趟
		for(int i=1;i<arr.length-1;i++ ){
			//内层循环，开始追个比较
			//发现前一个数比后一个数大，则交换
			//注意下面的-i 每次比较之后 最大的都在末尾 所以可以少比较一个
			for(int j=0;j<arr.length-i;j++){
				if(arr[j]>arr[j+1]){
					//换位
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}

	}
	
}

/***
 * 选择排序法
 * 选择排序法也属于内部排序法，
 * 是从欲排序的数据中，按指定的规则悬殊某一元素，
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

class Select{
	public void sort(int arr[]){
		int temp=0;
		//我认为第一个数就是最小
		for(int j=1;j<arr.length-1;j++){

			int min=arr[j];
			//记录最小数的下标
			int minIndex=j;
			
			for(int k=j+1;k<arr.length;k++){
				if(min>arr[k]){
					//修改最小
					min=arr[k];
					minIndex=k;
				}
			}
			//当退出for循环时，就找到本次最小值
			temp=arr[j];
			arr[j]=arr[minIndex];
			arr[minIndex]=temp;
		}
	}
}
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

class Insert{
	//插入排序法
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

/**
 * 交换式排序法-快速排序法
 * 
 * 快速排序（Quicksort）是对冒泡排序的一种改进
 * 
 * 基本思想： 递归
 * 通过一趟排序将要排序的数据分割成独立的两部分
 * 其中一部分比另一部分搜有数据都要小，
 * 然后再按此方法对两部分数据分别进行快速排序
 * 整个排序过程可以递归进行，最终使整个数据变成有序
 */

class QuickSort{
	//最左边 最右边 数组 传递进去
	public void sort(int left,int right,int []array){
		int l=left;
		int r=right;
		//中间变量
		int pivot=array[(left+right)/2];
		int temp=0;
		
		//分别从最左最右取数与第一次取的中间变量pivot进行大小比较，
		//每次寻找一个在p左边但大于p的数 与p右边小于p的数进行交换
		//经过若干次交换，最终使p左边的数都小于p，p右边的数都大于p
		while(l<r){
			while(array[l]<pivot)l++;
			while(array[r]>pivot)r--;
			
			if(l>=r)break;
			
			temp=array[l];
			array[l]=array[r];
			array[r]=temp;
			
			if(array[l]==pivot) --r;
			if(array[r]==pivot) ++l;
		}
			
		if(l==r){
			l++;
			r--;	
		}
		//递归的思想，对左边右边的两个组分别进行此种sort
		//以此类推，最终全部排列正确
		if(left<r)  sort(left,r,array);
		if(right<l) sort(l,right,array);
		
	}
}