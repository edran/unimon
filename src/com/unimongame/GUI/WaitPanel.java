package com.unimongame.GUI;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.*;

public class WaitPanel extends JPanel {

	JTextArea wait;
	String waitString;
	GameWindow window;
	
	public WaitPanel(GameWindow window) {
		this.window = window;
		
		setLayout(null);
		setSize(500,500);
		setLocation(0,23);
		
		waitString = "Please wait while other player selects their Unimon. If they take too long throw stuff at them ;)";
		
		wait = new JTextArea(waitString);
		wait.setLineWrap(true);
		wait.setWrapStyleWord(true);
		wait.setEditable(false);
		wait.setSize(400,350);
		wait.setLocation(50, 50);
		add(wait);
	}

	
}