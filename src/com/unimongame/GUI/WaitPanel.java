package com.unimongame.GUI;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.*;

public class WaitPanel extends JPanel {

	JLabel wait;
	String waitString;
	GameWindow window;
	
	public WaitPanel(GameWindow window) {
		this.window = window;
		
		setLayout(null);
		setSize(500,500);
		setLocation(0,23);
		
		waitString = "<html style=\"text-align: center;\">Please wait while other player selects their Unimon.<br>If they take too long throw stuff at them ;)</html>";
		
		wait = new JLabel(waitString);
		wait.setHorizontalAlignment(0);
		wait.setSize(500,500);
		wait.setLocation(0, 0);
		add(wait);
	}

	
}