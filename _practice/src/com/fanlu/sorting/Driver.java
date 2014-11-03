package com.fanlu.sorting;


public class Driver implements Comparable<Driver>{

	private String stringName;
	private String stringTeam;
	private String stringConstructor;
	private String stringNationality;
	private Integer integerPoints;
	private Integer integerNumber;
	
	public Driver(String team, String constructor, String name, String nationality, int intPoints, int intNumber) {
		this.stringName=name;
		this.stringTeam=team;
		this.stringConstructor=constructor;
		this.stringNationality=nationality;
		this.integerPoints=new Integer(intPoints);
		this.integerNumber=new Integer(intNumber);
	}
	
	public String getName() {
		return this.stringName;
	}
	
	public String getTeam() {
		return this.stringTeam;
	}
	
	public String getConstructor() {
		return this.stringConstructor;
	}
	
	public String getNationality() {
		return this.stringNationality;
	}
	
	public Integer getPoints() {
		return this.integerPoints;
	}
	
	public Integer getNumber() {
		return this.integerNumber;
	}

	public int compareTo(Driver otherDriver) {
		if(this.integerPoints.intValue()<otherDriver.integerPoints.intValue()) {
			return 1;
		}
		else if(this.integerPoints.intValue()>otherDriver.integerPoints.intValue()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
}
