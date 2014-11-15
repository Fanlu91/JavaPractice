package com.fanlu.sorting;
import java.util.Calendar;

public class InternalSorting {
	
	public static void main(String[] args){
		
		int len=1000000;
//		int len=8;
		int []arr=new int [len];
		for (int i=0;i<len;i++){
			//�ó����������1-10000����
			//Math.random()���������һ��0~1����
			arr[i]=(int)(Math.random()*10000);
		}
		
//		int arr1[]={1,6,0,-1,9,11,99,88,77,66,55,44,33,22,13,4};
		
//		Bubble bubble=new Bubble();
//		//������ǰ��ӡϵͳʱ��
//		Calendar cal=Calendar.getInstance();
//		System.out.println("��ʼ����"+cal.getTime());
//		bubble.sort(arr);
//		//��������ӡϵͳʱ��
//		Calendar cal2=Calendar.getInstance();//���µõ�ʵ��
//		System.out.println("�������"+cal2.getTime());
		
//		Select select=new Select();
//		//������ǰ��ӡϵͳʱ��
//		Calendar cal=Calendar.getInstance();
//		System.out.println("��ʼ����"+cal.getTime());
//		select.sort(arr);
//		//��������ӡϵͳʱ��
//		Calendar cal2=Calendar.getInstance();//���µõ�ʵ��
//		System.out.println("�������"+cal2.getTime());
	
//		Insert insert=new Insert();
//		//������ǰ��ӡϵͳʱ��
//		Calendar cal=Calendar.getInstance();
//		System.out.println("��ʼ����"+cal.getTime());
//		insert.sort(arr);
//		//��������ӡϵͳʱ��
//		Calendar cal2=Calendar.getInstance();//���µõ�ʵ��
//		System.out.println("�������"+cal2.getTime());
		
		QuickSort qs=new QuickSort();
		//������ǰ��ӡϵͳʱ��
		Calendar cal=Calendar.getInstance();
		System.out.println("��ʼ����"+cal.getTime());
		qs.sort(0,arr.length-1,arr);
		//��������ӡϵͳʱ��
		Calendar cal2=Calendar.getInstance();//���µõ�ʵ��
		System.out.println("�������"+cal2.getTime());
		
//		//��������
//		for(int i=0;i<arr.length;i++){
//			System.out.print(arr[i]+" ");
//		}
	}
}

/**
 * ð������Ļ���˼���ǣ�ͨ���Դ��������дӺ���ǰ�����±�ϴ��Ԫ�ؿ�ʼ����
 * ���αȽ�����Ԫ�ص������룬�����������򽻻���
 * ʹ�������С��Ԫ���𽥴Ӻ�����ǰ�������±�ϴ�ĵ�Ԫ�����±��С�ĵ�Ԫ��
 * ����ˮ���µ�����һ��������ð��
 * 
 * ��Ϊ����Ĺ����У�Ԫ�ز��Ͻӽ��Լ���λ�ã�
 * ���һ�˱Ƚ�����û�н��й���������˵���������򣬡�
 * ���Ҫ���������������һ����־flag�ж�Ԫ���Ƿ���й�������
 * �Ӷ����ٲ���Ҫ�ıȽ�
 */
class Bubble{
	public void sort(int arr[]){
		int temp=0;
		//����
		
		//���ѭ���������Ծ���һ���߼���
		for(int i=1;i<arr.length-1;i++ ){
			//�ڲ�ѭ������ʼ׷���Ƚ�
			//����ǰһ�����Ⱥ�һ�������򽻻�
			//ע�������-i ÿ�αȽ�֮�� ���Ķ���ĩβ ���Կ����ٱȽ�һ��
			for(int j=0;j<arr.length-i;j++){
				if(arr[j]>arr[j+1]){
					//��λ
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}

	}
	
}

/***
 * ѡ������
 * ѡ������Ҳ�����ڲ����򷨣�
 * �Ǵ�������������У���ָ���Ĺ�������ĳһԪ�أ�
 * ����������Ԫ������������ԭ�򽻻�λ�ú�ﵽ�����Ŀ��
 * 
 * ѡ�������ַ�����
 * 1.ѡ�����򷨣�Selection Sort��
 * 2.�����򷨣�Heap Sort��
 * 
 * ѡ������Select sorting��Ҳ��һ�ּ򵥵����򷽷������Ļ���˼���ǣ�
 * ��һ�δ�R[0]--R[n-1]��ѡ����Сֵ����R[0]����
 * �ڶ��δ�R[1]--R[n-1]��ѡ����Сֵ����R[1]����
 * �����δ�R[2]--R[n-1]��ѡ����Сֵ����R[2]����
 * ��i �δ�R[i-1]--R[n-1]��ѡ����Сֵ����R[i-1]����
 * ��n-1�δ�R[n-2]--R[n-1]��ѡ����Сֵ����R[n-2]����
 * �ܹ�ͨ��n-1�Σ��õ�һ�����������С�������е���������
 * 
 */

class Select{
	public void sort(int arr[]){
		int temp=0;
		//����Ϊ��һ����������С
		for(int j=1;j<arr.length-1;j++){

			int min=arr[j];
			//��¼��С�����±�
			int minIndex=j;
			
			for(int k=j+1;k<arr.length;k++){
				if(min>arr[k]){
					//�޸���С
					min=arr[k];
					minIndex=k;
				}
			}
			//���˳�forѭ��ʱ�����ҵ�������Сֵ
			temp=arr[j];
			arr[j]=arr[minIndex];
			arr[minIndex]=temp;
		}
	}
}


/**
 * ����ʽ����-��������
 * 
 * ��������Quicksort���Ƕ�ð�������һ�ָĽ�
 * 
 * ����˼�룺 �ݹ�
 * ͨ��һ������Ҫ��������ݷָ�ɶ�����������
 * ����һ���ֱ���һ�����������ݶ�ҪС��
 * Ȼ���ٰ��˷��������������ݷֱ���п�������
 * ����������̿��Եݹ���У�����ʹ�������ݱ������
 */

class QuickSort{
	//����� ���ұ� ���� ���ݽ�ȥ
	public void sort(int left,int right,int []array){
		int l=left;
		int r=right;
		//�м����
		int pivot=array[(left+right)/2];
		int temp=0;
		
		//�ֱ����������ȡ�����һ��ȡ���м����pivot���д�С�Ƚϣ�
		//ÿ��Ѱ��һ����p��ߵ�����p���� ��p�ұ�С��p�������н���
		//�������ɴν���������ʹp��ߵ�����С��p��p�ұߵ���������p
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
		//�ݹ��˼�룬������ұߵ�������ֱ���д���sort
		//�Դ����ƣ�����ȫ��������ȷ
		if(left<r)  sort(left,r,array);
		if(right<l) sort(l,right,array);
		
	}
}