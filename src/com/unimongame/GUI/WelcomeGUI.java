package com.unimongame.GUI;

import java.awt.Image;
import javax.swing.*;

public class WelcomeGUI extends JPanel{
	
	private ImagePanel unimon;
	private JLabel welcome, credits;
	private JButton oneComputer, lan;
	private Image logo;
	
	public WelcomeGUI(){
		setLayout(null);
		setSize(500,500);
		
		//ImagePanel
		unimon = new ImagePanel(logo);
		unimon.setLocation(185, 20);
		unimon.setSize(130,43);
		add(unimon);
		
		//JTextArea
		welcome = new JLabel("Welcome to the unimon game !");
		welcome.setSize(130, 20);
		welcome.setLocation(185, 80);
		welcome.setHorizontalAlignment(0);
		add(welcome);
		
		credits =  new JLabel("whatevs");
		credits.setSize(200,20);
		credits.setLocation(150,460);
		credits.setHorizontalAlignment(0);
		
	}
}