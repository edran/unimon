package com.unimongame.GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EndGamePanel extends JPanel implements ActionListener{

	JLabel endGame;
	String endString;
	JButton restart;
	GameWindow window;
	
	private ImagePanel unimon;
	private Image img;

	public EndGamePanel(GameWindow window, boolean winner) {
		this.window = window;
		
		setLayout(null);
		setSize(500,500);
		setLocation(0,23);
		
		// ImagePanel
				img = new ImageIcon("resources/img/UnimonLogo2.png").getImage();
				unimon = new ImagePanel(img);
				unimon.setSize(450, 156);
				unimon.setLocation(25, 20);
				add(unimon);

		// Result message		
				if (winner == true) {
					endString = "<HTML><body><center><font size= 7><h1><strong>YOU ARE THE<br>WINNER!!!!!!</strong></h1></font><sub>well done :)</sub></center></body></HTML>";
				} else {
					endString = "<HTML><body><center><font size= 7><h1><strong>YOU ARE THE<br>WINN...</strong></h1></font><sub>...nah, you lost. Oh well :)</sub></center></body></HTML>";
				}

		endGame = new JLabel(endString);
		endGame.setHorizontalAlignment(0);
		endGame.setSize(400,350);
		endGame.setLocation(50, 190);
		add(endGame);

		restart = new JButton("Close");
		restart.setSize(100, 30);
		restart.setLocation(200, 435);
		restart.addActionListener(this);
		add(restart);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==restart){
			//window.showStartScreen();
			System.exit(0);
		}

	}


}