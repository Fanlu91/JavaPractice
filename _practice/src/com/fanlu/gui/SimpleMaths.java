package com.fanlu.gui;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleMaths implements ActionListener {
	JFrame window;
	JTextField tf1;
	JTextField tf2;
	String text1;
	String text2;
	JLabel lb1;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	

	private SimpleMaths() {
		text1="";
		text2="";		
		setupGUI();
	}

	public void setupGUI() {
		window = new JFrame("SimpleMaths");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		window.setContentPane(panel);

		JLabel label = new JLabel("Enter two numbers: ");
		window.add(label);

		tf1 = new JTextField(10);
		tf2 = new JTextField(10);
		window.add(tf1);
		window.add(tf2);

		b1 = new JButton("Add");
		b2 = new JButton("Subtract");
		b3 = new JButton("Multiply");
		b4 = new JButton("Integer Divide");
		b5 = new JButton("Real Divide");
		b6 = new JButton("Modulo");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		
		window.add(b1);
		window.add(b2);
		window.add(b3);		
		window.add(b5);
		window.add(b6);
		window.add(b4);
	
		lb1=new JLabel("");
		window.add(lb1);

		window.setSize(150, 400);
		// window.pack(); //resize window to fit with the preferred minimum size
		// of its subcomponents
		window.setVisible(true);
	}

	public static void main(String[] args) {
		SimpleMaths sm=new SimpleMaths();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b1)
		{	
			lb1.setText(tf1.getText()+" + "+tf2.getText()+" = "+(Integer.parseInt(tf1.getText())+Integer.parseInt(tf2.getText())));
		}else if(e.getSource()==b2)
		{	
			lb1.setText(tf1.getText()+" - "+tf2.getText()+" = "+(Integer.parseInt(tf1.getText())-Integer.parseInt(tf2.getText())));
		}else if(e.getSource()==b3)
		{	
			lb1.setText(tf1.getText()+" x "+tf2.getText()+" = "+(Integer.parseInt(tf1.getText())*Integer.parseInt(tf2.getText())));
		}else if(e.getSource()==b4)
		{	
			lb1.setText(tf1.getText()+" / "+tf2.getText()+" = "+(Integer.parseInt(tf1.getText())/Integer.parseInt(tf2.getText())));
		}else if(e.getSource()==b5)
		{	
			lb1.setText(tf1.getText()+" / "+tf2.getText()+" = "+(Float.parseFloat(tf1.getText())/Float.parseFloat(tf2.getText())));
		}else if(e.getSource()==b6)
		{	
			lb1.setText(tf1.getText()+" % "+tf2.getText()+" = "+(Integer.parseInt(tf1.getText())%Integer.parseInt(tf2.getText())));
		}
	}

}
