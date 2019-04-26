package com.fanlu.sorting.RealDemo;


public class Driver implements Comparable<Driver> {

    private String stringName;
    private String stringTeam;
    private String stringConstructor;
    private String stringNationality;
    private Integer integerPoints;
    private Integer integerNumber;

    public Driver(String team, String constructor, String name, String nationality, int intPoints, int intNumber) {
        this.stringName = name;
        this.stringTeam = team;
        this.stringConstructor = constructor;
        this.stringNationality = nationality;
        this.integerPoints = intPoints;
        this.integerNumber = intNumber;
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
        return Integer.compare(otherDriver.integerPoints, this.integerPoints.intValue());
    }

    public boolean isBiggerThan(Driver otherDriver) {
        return (this.integerPoints.intValue() > otherDriver.integerPoints.intValue());
    }
}
