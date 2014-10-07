package com.fanlu.gui;

import java.util.ArrayList;

public class Playlists {
	private int id;
	private String name;
	private ArrayList<Integer> list;
	static private int ids=0;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Integer> getList() {
		return list;
	}

	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}
	public Playlists(String n){
		this.id=ids;
		this.name=n;
		this.list=new ArrayList<Integer>();
		ids+=1;
	}
	public String toString(){
		return name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
