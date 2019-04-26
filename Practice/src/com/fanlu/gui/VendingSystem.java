package com.fanlu.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VendingSystem implements ActionListener {
	private VendingItem chocolate;
	private VendingItem cola;
	private VendingItem crisps;
	private VendingItem curryPot;
	private int MONEY;
	private int change;
	private int cost;
	static String receipt;
	
	private JButton jb1,jb31,jb32,jb33;
	private JTextArea textArea;
	private final static String newline = "\n";
	
    private JList jlstItems;
    private JScrollPane spItems;
    private JScrollPane spOut;
    private DefaultListModel itemsModel;
    private JScrollPane scrollPane;
    private JPanel panel0;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JFrame window; 

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
		setupGUI();
	}
	public void setupGUI()
	{
		//instantiate containers
		window = new JFrame("VendingSystem");		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel0 = new JPanel();
		
		//add container to window
		window.getContentPane().add(panel0);
		//add sub panels to main panel
		panel0.setLayout(new GridLayout(3,1));	
		panel1.setLayout(new GridLayout());
		panel3.setLayout(new GridLayout(4,1));
		
		window.add(panel1,BorderLayout.WEST);
		window.add(panel2,BorderLayout.CENTER);
		window.add(panel3,BorderLayout.EAST);
    
		
		addComponents();
		populateList();
        reset();
       
        jb1=new JButton("Buy item");
		jb1.addActionListener(this);
		panel3.add(jb1);
		
		jb31=new JButton("Complete sale");
		jb31.addActionListener(this);
		panel3.add(jb31);
		
		jb32=new JButton("No sale");
		jb32.addActionListener(this);
		panel3.add(jb32);
		
		jb33=new JButton("Insert one pound");
		jb33.addActionListener(this);
		panel3.add(jb33);
		
	    //window properties
        window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
	}
	
    public void addComponents(){
    	//instantiate controls
    	jb1=new JButton("Buy Item");		
		textArea = new JTextArea(10, 50);
	    textArea.setEditable(false);
	    JScrollPane scrollPane = new JScrollPane(textArea);
	    	
		spItems = new javax.swing.JScrollPane();
        jlstItems = new javax.swing.JList();
        
        //create the items models and set list to it
    	itemsModel = new DefaultListModel();
        jlstItems.setModel(itemsModel);
        
        ///add list to scroll pane
        spItems.setName("jlstItems");
        spItems.setViewportView(jlstItems);
        
        //add actions listeners
        jb1.addActionListener(this);		
		//add controls to containers
		panel1.add(spItems);
		panel2.add(scrollPane);	
		
    }

    public void reset(){}	

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
	
	private void populateList() {
		//clear list
		itemsModel.clear();		
		//add string method result from each item
		itemsModel.addElement(chocolate.toString());
		itemsModel.addElement(cola.toString());
		itemsModel.addElement(crisps.toString());
		itemsModel.addElement(curryPot.toString());
	}
	private VendingItem getItem(int index){
		//return item based on selected index of list
		switch (index){
			case 0:	return chocolate;
			case 1:	return cola;
			case 2: return crisps;
			case 3: return curryPot;
			default: return null;
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){	
			this.buyItem();
		}
//		else if(e.getSource()==jb2){	
//			this.buyItem(cola);
//			textArea.append(cola.toString()+newline);
//		}else if(e.getSource()==jb3){	
//			this.buyItem(crisps);
//			textArea.append(crisps.toString()+newline);
//		}else if(e.getSource()==jb4){	
//			this.buyItem(curryPot);
//			textArea.append(curryPot.toString()+newline);
//		}
		else if(e.getSource()==jb31){	
			this.completeSale();
		}else if(e.getSource()==jb32){	
			this.noSale();
		}else if(e.getSource()==jb33){	
			this.insertPound();
			textArea.append("one pound!"+"your change is "+(this.change-this.cost)+newline);
		}		
	}
	public void buyItem(){
		//local variables
		int index;
		VendingItem item;		
		index=jlstItems.getSelectedIndex();

		item = getItem(index);
		this.buyItem(item);
		textArea.append(item.toString()+newline);
	}
}
