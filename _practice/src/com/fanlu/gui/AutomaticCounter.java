package com.fanlu.gui;

import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AutomaticCounter {

	Timer timer;
	static int i;
	static JLabel label;

	private AutomaticCounter() {
		i = 0;

		JFrame window = new JFrame("AutomaticCounter");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel1 = new JPanel();
		window.setContentPane(panel1);

		JButton btnNewButton = new JButton("Start");
		btnNewButton.setBounds(121, 5, 57, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timer = new Timer();
				timer.schedule(new TimerTaskTest(), 0, 1000);
			}
		});
		panel1.add(btnNewButton);

		JButton button = new JButton("Stop");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timer.cancel();
			}
		});

		panel1.add(button);

		JLabel lblNewLabel = new JLabel("The number");
		panel1.add(lblNewLabel);

		label = new JLabel("0");
		panel1.add(label);

		window.setSize(300, 200);
		window.setVisible(true);
	}

	public static void main(String[] args) {
		AutomaticCounter a = new AutomaticCounter();
	}

	class TimerTaskTest extends java.util.TimerTask {
		
		public void run() {
			// TODO Auto-generated method stub
			// System.out.println(AutomaticCounter.i);

			AutomaticCounter.i++;
			AutomaticCounter.label
					.setText(Integer.toString(AutomaticCounter.i));
		}
	}
}
