package com.fanlu.small;

public class VendingItem {

	private String name;
	private int price;
	private int stock;
	private int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public VendingItem(String s, int a, int b) {
		this.name=s;
		this.price=a;
		this.stock=b;
		this.i=0;
	}
	public boolean stockLeft(){
		if(stock-i>0){
			return true;
		}else{
			return false;
		}
	}
	public void buyItem(){
		VendingSystem.receipt += this.getName() + " " + this.getPrice() + " "
				+ this.getPrice() * this.getI() + "\n";
			setStock(getStock()-i);
			
	}
	public String toString(){
		return name+": the price is "+price+"p"+" and the stock is "+ (stock-i);
	}

}