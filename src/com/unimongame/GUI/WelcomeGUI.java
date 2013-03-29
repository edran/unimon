package com.unimongame.GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WelcomeGUI extends JPanel implements ActionListener{
	
	private ImagePanel unimon;
	private JLabel welcome ,credits, date;
	private JButton oneComputer, lan ,button;
	private GameWindow window;
	
	public WelcomeGUI(GameWindow window){
		setLayout(null);
		setSize(500,500);
		this.window = window;
		
		//ImagePanel
		unimon = new ImagePanel("UnimonLogo.png");
		unimon.setBackground(Color.black);
		unimon.setSize(unimon.getImgSize());
		unimon.setLocation((getWidth()/2-unimon.getWidth()/2),30);
		add(unimon);
		
		//JTextArea
		welcome = new JLabel("Welcome to the unimon game !");
		welcome.setSize(400, 20);
		welcome.setLocation(50,unimon.getLocation().y+unimon.getHeight()+10);
		welcome.setHorizontalAlignment(0);
		add(welcome);
		
		 button = new JButton("Start");
		button.setSize(100,30);
		button.setLocation(200,300);
		button.addActionListener(this);
		add(button);
		
		credits = new JLabel("<html><div style=\"width:400px;text-align:center;\">By Caterina Brandani, Basile Henry," +
				"Joseph Kennelly<br>Nantas Nardelli and Luke McAuley</div><html>"
				);
		credits.setSize(500,50);
		credits.setLocation(0,430);
		add(credits);
		date = new JLabel("Inf1-OOP 2013");
		date.setLocation(200,480);
		date.setSize(100,20);
		add(date);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button){
			window.startClicked();
		}
		
	}
}