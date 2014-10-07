package com.fanlu.gui;

public class IndividualMP3s {
	
	private int id;
	private String title;
	private String artist;
	
	static private int ids=0;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public IndividualMP3s(String t,String a){
		this.id=ids;
		this.artist=a;
		this.title=t;
		ids+=1;
	}
	public String toString(){
		return this.title;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
