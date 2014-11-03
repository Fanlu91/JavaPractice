package com.fanlu.sorting;
import java.util.ArrayList;
import java.util.Collections;


public class ArraysDemo {
	
	public ArraysDemo() {
		ArrayList<Driver> myDriverList = new ArrayList<Driver>();
		this.setupData(myDriverList);
		this.printArrayList(myDriverList);
		System.out.print("\n\nSorted values");		
		//Use one of the sorting algorithms
		//this.insertionSort(myDriverList); //Do an Insertion Sort
		//this.bubbleSort(myDriverList); //Do a Bubble Sort
		//this.selectionSort(myDriverList); //Do a Selection Sort
		Collections.sort(myDriverList); //Use inbuilt sort using CompareTo
		this.printArrayList(myDriverList);
		
	}
	
	public void bubbleSort(ArrayList<Driver> myList) {
		boolean swap;
		
		do {
			swap=false;
			for(int intCounter=0;intCounter<(myList.size()-1);intCounter++) {
				Driver driver1=myList.get(intCounter);
				Driver driver2=myList.get(intCounter+1);
				
				if(driver1.getPoints().intValue()<driver2.getPoints().intValue()) {
					swap=true;
					myList.set(intCounter, driver2);
					myList.set(intCounter+1,driver1);
				}
				
			}
			
		} while(swap);
	}
	
	public void insertionSort(ArrayList<Driver> myList) {
		int in, out;
		for(out=1; out<myList.size(); out++) {
			Driver tempDriver=myList.get(out);
			in = out;           
			while(in>0 && myList.get(in-1).getPoints().intValue() <= tempDriver.getPoints().intValue()) {
				myList.set(in, myList.get(in-1));
				--in;            
			}
			myList.set(in, tempDriver); 
		}
	}
	
	
	public void selectionSort(ArrayList<Driver> myList) {
		for(int x=0; x<myList.size(); x++){
			int minimum_value_index = x;
			for(int y=x; y<myList.size(); y++){
				if(myList.get(minimum_value_index).getPoints().intValue()<myList.get(y).getPoints().intValue()) {
					minimum_value_index = y;
				}
			}
			Driver tempDriver=myList.get(x);
			myList.set(x, myList.get(minimum_value_index));
			myList.set(minimum_value_index, tempDriver);
		}
	}
	
	public static void main(String[] args) {
		ArraysDemo newInstance = new ArraysDemo();
	}
	
	private void setupData(ArrayList<Driver> myArrayList) {
		Driver myDriver=new Driver("Scuderia Toro Rosso", "Toro Rosso-Ferrari", "Jean-Eric Vergne", "Fra", 12,17);
		myArrayList.add(myDriver);
		myDriver=new Driver("Caterham F1 Team", "Caterham-Renault", "Heikki Kovalainen", "Fin", 0,20);
		myArrayList.add(myDriver);
		myDriver=new Driver("Red Bull Racing", "Red Bull-Renault", "Sebastian Vettel", "Ger", 215,1);
		myArrayList.add(myDriver);
		myDriver=new Driver("Marussia F1 Team", "Marussia-Cosworth", "Charles Pic", "Fra", 0,25);
		myArrayList.add(myDriver);
		myDriver=new Driver("Scuderia Toro Rosso", "Toro Rosso-Ferrari", "Daniel Ricciardo", "Aus", 9,16);
		myArrayList.add(myDriver);
		myDriver=new Driver("Vodafone McLaren Mercedes", "McLaren-Mercedes", "Jenson Button", "GB", 131,3);
		myArrayList.add(myDriver);
		myDriver=new Driver("Williams F1 Team", "Williams-Renault", "Pastor Maldonado", "Ven", 33,18);
		myArrayList.add(myDriver);
		myDriver=new Driver("Mercedes AMG Petronas F1 Team", "Mercedes", "Michael Schumacher", "Ger", 43,7);
		myArrayList.add(myDriver);
		myDriver=new Driver("Scuderia Ferrari", "Ferrari", "Fernando Alonso", "Spa", 209,5);
		myArrayList.add(myDriver);
		myDriver=new Driver("Mercedes AMG Petronas F1 Team", "Mercedes", "Nico Rosberg", "Ger", 93,8);
		myArrayList.add(myDriver);
		myDriver=new Driver("Lotus F1", "Lotus-Renault", "Jerome d'Ambrosio", "Bel", 0,10);
		myArrayList.add(myDriver);
		myDriver=new Driver("Sahara Force India F1 Team", "Force India-Mercedes", "Paul Di Resta", "GB", 44,11);
		myArrayList.add(myDriver);
		myDriver=new Driver("Sauber F1 Team", "Sauber-Ferrari", "Sergio Perez", "Mex", 66,15);
		myArrayList.add(myDriver);
		myDriver=new Driver("Lotus F1", "Lotus-Renault", "Romain Grosjean", "Fra", 88,10);
		myArrayList.add(myDriver);
		myDriver=new Driver("Caterham F1 Team", "Caterham-Renault", "Vitaly Petrov", "Rus", 0,21);
		myArrayList.add(myDriver);
		myDriver=new Driver("Sauber F1 Team", "Sauber-Ferrari", "Kamui Kobayashi", "Jap", 50,14);
		myArrayList.add(myDriver);
		myDriver=new Driver("HRT F1 Team", "HRT-Cosworth", "Pedro de la Rosa", "Spa", 0,22);
		myArrayList.add(myDriver);
		myDriver=new Driver("Scuderia Ferrari", "Ferrari", "Felipe Massa", "Brz", 81,6);
		myArrayList.add(myDriver);
		myDriver=new Driver("Williams F1 Team", "Williams-Renault", "Bruno Senna", "Brz", 25,19);
		myArrayList.add(myDriver);
		myDriver=new Driver("Vodafone McLaren Mercedes", "McLaren-Mercedes", "Lewis Hamilton", "GB", 153,4);
		myArrayList.add(myDriver);
		myDriver=new Driver("Lotus F1", "Lotus-Renault", "Kimi Raikkonen", "Fin", 167,9);
		myArrayList.add(myDriver);
		myDriver=new Driver("HRT F1 Team", "HRT-Cosworth", "Narain Karthikeyan", "Ind", 0,23);
		myArrayList.add(myDriver);
		myDriver=new Driver("Marussia F1 Team", "Marussia-Cosworth", "Timo Glock", "Ger", 0,24);
		myArrayList.add(myDriver);
		myDriver=new Driver("Red Bull Racing", "Red Bull-Renault", "Mark Webber", "Aus", 152,2);
		myArrayList.add(myDriver);
		myDriver=new Driver("Sahara Force India F1 Team", "Force India-Mercedes", "Nico Hulkenberg", "Ger", 45,12);
		myArrayList.add(myDriver);
	}
	
	private void printArrayList(ArrayList<Driver> toPrint) {
		System.out.printf("\n%20.20s\t%3.3s\t%30.30s\t%20.20s\t%s\t%s", "Name", "Nationality", "Team", "Constructor", "Points", "Number");
		
		for(int intCounter=0;intCounter<toPrint.size();intCounter++) {
			
			//System.out.println(toPrint.get(intCounter).getName()+"\t\t "+toPrint.get(intCounter).getNationality()+"\t "+toPrint.get(intCounter).getTeam()+"\t "+toPrint.get(intCounter).getConstructor()+"\t "+toPrint.get(intCounter).getPoints()+"\t "+toPrint.get(intCounter).getNumber());
			System.out.printf("\n%20.20s\t%3.3s\t%30.30s\t%20.20s\t%d\t%d", toPrint.get(intCounter).getName(), toPrint.get(intCounter).getNationality(),toPrint.get(intCounter).getTeam(),toPrint.get(intCounter).getConstructor(),toPrint.get(intCounter).getPoints(),toPrint.get(intCounter).getNumber());
			
		}
	}
	
}
