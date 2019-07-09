package com.fanlu.small;

import java.util.Scanner;

public class VendingMachineText {
	private float balance;
	private float cost;
	int a, b, c;
	static boolean running = true;

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float d) {
		this.cost = d;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public VendingMachineText() {
		// TODO Auto-generated constructor stub
		balance = (float) 5.00;
		cost = (float) 0.00;
		a = 0;
		b = 0;
		c = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VendingMachineText v = new VendingMachineText();

		do {
			System.out.println("please choose the item you want: ");
			System.out.println("1  Chocolate £0.57");
			System.out.println("2  Cola £0.71");
			System.out.println("3  Crisps £0.34");
			System.out.println("0  That's all");
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				int op = sc.nextInt();
				switch (op) {
				case 0:
					System.out.println("goodbye!");
					System.out.println("total of change left is £"
							+ (v.getBalance() - v.getCost()));
					CoinsReturning(v.getBalance() - v.getCost(), v.getA(),
							v.getB(), v.getC(),v.getCost());
					break;
				case 1:
					v.setCost(v.getCost() + (float) 0.57);
					if (v.getBalance() - v.getCost() < 0) {
						
						System.out
								.println("please input more coins!");
						v.setCost(v.getCost() - (float) 0.57);
						break;
					} else {
						System.out
								.println("here is your Chocolate! the toatal cost is fillBag"
										+ v.getCost()
										+ " and total of change left is fillBag"
										+ (v.getBalance() - v.getCost()));
						v.setA(v.getA() + 1);
						break;
					}
				case 2:
					v.setCost(v.getCost() + (float) 0.71);
					if (v.getBalance() - v.getCost() < 0) {
						
						System.out
								.println("please input more coins!");
						v.setCost(v.getCost() - (float) 0.71);
						break;
					} else {
						System.out
								.println("here is your Cola! the toatal cost is £"
										+ v.getCost()
										+ " and total of change left is £"
										+ (v.getBalance() - v.getCost()));
						v.setB(v.getB() + 1);
						break;
					}
				case 3:
					v.setCost(v.getCost() + (float) 0.34);
					if (v.getBalance() - v.getCost() < 0) {
						
						System.out
								.println("please input more coins!");
						v.setCost(v.getCost() - (float) 0.34);
						break;
					} else {
						System.out
								.println("here is your Crisps! the toatal cost is £"
										+ v.getCost()
										+ " and total of change left is £"
										+ (v.getBalance() - v.getCost()));
						v.setC(v.getC() + 1);
						break;
					}
				default:
					System.out.println("There is no such item,sorry");
					break;
				}
			}

		} while (running);

	}

	static void CoinsReturning(float bal, int a, int b, int c,float cost) {
		int d = (int) (bal * 100);
		int[] coins = new int[8];
		for (int i : coins) {
			coins[i] = 0;
		}
		while (d != 0) {
			if (d >= 200) {
				coins[7]++;
				d -= 200;
			}
			if (d >= 100) {
				coins[0]++;
				d -= 100;
			}
			if (d >= 50 && d < 100) {
				coins[1]++;
				d -= 50;
			}
			if (d < 50 && d >= 20) {
				coins[2]++;
				d -= 20;
			}
			if (d < 20 && d >= 10) {
				coins[3]++;
				d -= 10;
			}
			if (d < 10 && d >= 5) {
				coins[4]++;
				d -= 5;
			}
			if (d < 5 && d >= 2) {
				coins[5]++;
				d -= 2;
			}
			if (d < 2 && d > 0) {
				coins[6]++;
				d -= 1;
			}
		}
		System.out.println("======Here is yout reciept======");
		System.out.println(a + "  Chocolate £0.57");
		System.out.println(b + "  Cola £0.71");
		System.out.println(c + "  Crisps £0.34");
		System.out.println("the total cost is £"+cost);
		System.out.println("the total change left is £"+bal);
		System.out.println("================================");
		System.out.println("");
		System.out.println("======Here is yout coins:======");
		System.out.println(" £2: " + coins[7]);
		System.out.println(" £1: " + coins[0]);
		System.out.println(" 50p: " + coins[1]);
		System.out.println(" 20p: " + coins[2]);
		System.out.println(" 10p: " + coins[3]);
		System.out.println(" 5p: " + coins[4]);
		System.out.println(" 2p: " + coins[5]);
		System.out.println(" 1p: " + coins[6]);
		running = false;
	}
}
