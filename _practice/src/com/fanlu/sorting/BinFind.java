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
		//�����ҵ��м����
		int midIndex=(rightIndex+leftIndex)/2;
		int midVal=arr[midIndex];
		
		if(rightIndex>leftIndex){
			//����ҵ�����midVal��
			if(midVal>val){
				//��midVal���������
				find(leftIndex,midIndex-1,val,arr);
			}else if (midVal<val){
				//��midVal�ұߵ�����
				find(midIndex+1,rightIndex,val,arr);			
			}else if(midVal==val){
				System.out.print("�ҵ��±�"+midIndex);
			}
		}
	}
}