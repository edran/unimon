package com.unimongame.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HelpGUI extends JPanel implements ActionListener{

	JTextArea help;
	String helpString;
	JButton back;
	GameWindow window;
	
	public HelpGUI(GameWindow window) {
		this.window = window;
		
		setLayout(null);
		setSize(500,500);
		setLocation(0,23);
		
		helpString = "Sometext...";
		
		help = new JTextArea(helpString);
		help.setLineWrap(true);
		help.setWrapStyleWord(true);
		help.setEditable(false);
		help.setSize(400,350);
		help.setLocation(50, 50);
		add(help);
		
		back = new JButton("Back");
		back.setSize(100, 30);
		back.setLocation(200, 435);
		back.addActionListener(this);
		add(back);
		
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back){
			window.showStartScreen();
		}
		
	}

	
}
