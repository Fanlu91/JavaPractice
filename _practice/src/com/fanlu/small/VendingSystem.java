package com.fanlu.small;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VendingSystem implements ActionListener {
	private VendingItem chocolate;
	private VendingItem cola;
	private VendingItem crisps;
	private VendingItem curryPot;
	ArrayList<VendingItem> ar;
	private int MONEY;
	private int change;
	private int cost;
	static String receipt;
	private JButton jb1,jb2,jb3,jb4,jb31,jb32,jb33;
	private JTextArea textArea;
	private final static String newline = "\n";
     

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingSystem v = new VendingSystem();
	}

	private VendingSystem() {
		MONEY=500;
		change = MONEY;
		cost=0;
		receipt="\n";
		chocolate = new VendingItem("chocolate", 57, 3);
		cola = new VendingItem("cola", 71, 3);
		crisps = new VendingItem("crisps", 34, 3);
		curryPot = new VendingItem("curryPot", 149, 3);
		ar=new ArrayList<VendingItem>();
		ar.add(chocolate);
		ar.add(cola);
		ar.add(crisps);
		ar.add(curryPot);
		setupGUI();
	}
	
	public void setupGUI()
	{
		JFrame window = new JFrame("VendingSystem");		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		window.add(panel1);
		window.add(panel2);
		window.add(panel3);
		
		jb1=new JButton("Buy  Chocolate");
		jb2=new JButton("Buy  Cola");		
		jb3=new JButton("Buy  Crisps");
		jb4=new JButton("Buy  Curry Pot");
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		panel1.add(jb1);
		panel1.add(jb2);
		panel1.add(jb3);
		panel1.add(jb4);		
		
		textArea = new JTextArea(7, 22);
	    textArea.setEditable(false);
	    JScrollPane scrollPane = new JScrollPane(textArea);
		panel2.add(scrollPane);	
		
		jb31=new JButton("Complete sale");
		jb31.addActionListener(this);
		panel3.add(jb31);
		
		jb32=new JButton("No sale");
		jb32.addActionListener(this);
		panel3.add(jb32);
		
		jb33=new JButton("Insert one pound");
		jb33.addActionListener(this);
		panel3.add(jb33);
		
		window.setLayout(new GridLayout(3, 1));
		window.setSize(300, 400);
		window.setResizable(false);
		window.pack();       //resize window to fit with the preferred minimum size of its subcomponents
		window.setVisible(true);	
	}

	private void buyItem(VendingItem vi) {
		this.cost+=vi.getPrice();
		if (vi.stockLeft()) {
			if (this.cost <= this.change) {
				vi.setI(vi.getI()+1);
			} else {
				this.cost -= vi.getPrice();
				textArea.append(newline+"you need to input more coins!(press 9 to insert,any other key to stop)");
			}
		} else {
			textArea.append(newline+"sorry," + vi.getName() + " is sold out");
		}
	}

	private void displayReceipt() {
		textArea.append(newline+"ITEM COST Total");
		textArea.append(newline+this.receipt);
	}

	private void completeSale() {
		chocolate.buyItem();
		cola.buyItem();
		crisps.buyItem();
		curryPot.buyItem();
		this.displayReceipt();
		this.getLowestCoins(this.change - this.cost);	
	}

	private void getLowestCoins(int a) {
		int d = a;
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
		textArea.append(newline+"total cost is "+this.cost+"p. change is "+(this.change-this.cost)+"p.");
		textArea.append(newline+"======Here is your coins:======");
		textArea.append(newline+"  f2: " + coins[7]);
		textArea.append(newline+"  f1: " + coins[0]);
		textArea.append(newline+" 50p: " + coins[1]);
		textArea.append(newline+" 20p: " + coins[2]);
		textArea.append(newline+" 10p: " + coins[3]);
		textArea.append(newline+"  5p: " + coins[4]);
		textArea.append(newline+"  2p: " + coins[5]);
		textArea.append(newline+"  1p: " + coins[6]);
	}

	private void noSale() {
		textArea.append(newline+"You bought nothing");
		this.getLowestCoins(this.change);	
	}

	private void insertPound() {
		this.change+=100;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){	
			this.buyItem(chocolate);
			textArea.append(chocolate.toString()+newline);
		}else if(e.getSource()==jb2){	
			this.buyItem(cola);
			textArea.append(cola.toString()+newline);
		}else if(e.getSource()==jb3){	
			this.buyItem(crisps);
			textArea.append(crisps.toString()+newline);
		}else if(e.getSource()==jb4){	
			this.buyItem(curryPot);
			textArea.append(curryPot.toString()+newline);
		}else if(e.getSource()==jb31){	
			this.completeSale();
		}else if(e.getSource()==jb32){	
			this.noSale();
		}else if(e.getSource()==jb33){	
			this.insertPound();
			textArea.append("one pound!"+"your change is "+(this.change-this.cost)+newline);
		}		
	}
}
