package com.fanlu.sorting;

public class BinFind {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={1,2,3,4,5,6,7,8,9};
		BinaryFind bf=new BinaryFind();
		bf.find(0, arr.length-1, 0, arr);
	}

}

class BinaryFind{
	public void find(int leftIndex,int rightIndex,int val,int arr[]){
		//首先找到中间的数
		int midIndex=(rightIndex+leftIndex)/2;
		int midVal=arr[midIndex];
		
		if(rightIndex>leftIndex){
			//如果找的数比midVal大
			if(midVal>val){
				//在midVal左边数中找
				find(leftIndex,midIndex-1,val,arr);
			}else if (midVal<val){
				//在midVal右边的数找
				find(midIndex+1,rightIndex,val,arr);			
			}else if(midVal==val){
				System.out.print("找到下标"+midIndex);
			}
		}
	}
}