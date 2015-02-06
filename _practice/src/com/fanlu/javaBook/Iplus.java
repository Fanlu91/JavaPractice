package com.fanlu.javaBook;

public class Iplus {
	int m=0;
	public static void main(String[] args) {
		int i=0,j=0;
		i= ++i + i++ +i++ +i++;
		// 1+1+2+3
		System.out.println(i);
		j=j++ +j++ +j++ + ++j;
		//0+1+2+4
		System.out.println(j);
	}
}
