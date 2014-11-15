package com.fanlu.sorting;
/***
 * �������� 
 * 
 * �������������ڲ�����,
 * �Ƕ����������Ԫ���Բ���ķ�ʽ��Ѱ��Ԫ�ص���Ӧλ��,
 * �Դﵽ�����Ŀ�ġ�
 * 
 * ���������ַ�3��
 * 1�������򷨣�Insert sort��
 * 2л������ ��shell sort��
 * 3���������򷨣�Binary-tree sort��
 * 
 * ����˼�룺��n���������Ԫ�ؿ���һ�������������
 * ��ʼʱ�����ֻ����һ��Ԫ�أ���������n-1��Ԫ��
 * ���������ÿ�δ��������ȡ����һ��Ԫ�أ�
 * ����������������������������Ԫ�ؽ��бȽϣ�
 * �����뵽������е��ʵ�λ�ã�ʹ֮��Ϊ�µ������
 */ 

public class InsertionSort{
	public void sort(int arr[]){
		for(int i=1;i<arr.length;i++){
			int insertVal=arr[i];
			//insertVal׼����ǰһ�����Ƚ�
			int index=i-1;
			
			while(index>=0&&insertVal<arr[index]){
				//��arr[index]����ƶ�
				arr[index+1]=arr[index];
				//��index��ǰ�ƶ�
				index--;
			}
			//��insertVal�����ʵ�λ��
			arr[index+1]=insertVal;
		}
	}
}
