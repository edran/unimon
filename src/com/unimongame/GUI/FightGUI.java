package com.unimongame.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import com.unimongame.Player;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FightGUI  implements ActionListener {

	//Declaring a few variables

	private JPanel totalGUI, enemyPanel, playerPanel, menuPanel, textPanel, attackPanel, bagPanel, unimonsPanel, abandonPanel;
	private JLabel enemyUniName, playerUniName, textLabel, givenUp;
	private JButton attack1, attack2, attack3, attack4, attack, bag, unimons, abandon;
	private ImagePanel backgroundPanel, enemyImagePanel, playerImagePanel;
	private Image backgroundImage;
	
	private Player self;
	private Player enemy;
	
	
	
	
	private int rnd = 1 + (int)(Math.random() * 4);

	String story = "<html>Welcome to the game.<br>Prepare for battle!</html>";


	public JPanel createFightPanel(Player self, Player enemy) {

	//Bottom JPanel to place everything on.
	totalGUI = new JPanel();
	totalGUI.setLocation(0, 0);
	totalGUI.setSize(500, 500);
	totalGUI.setLayout(null);
	
	//Separators
	JSeparator sep1 = new JSeparator();
	totalGUI.add(sep1);
	sep1.setBackground(Color.BLACK);
	sep1.setForeground(Color.BLACK);
	sep1.setSize(500,2);
	sep1.setLocation(0, 200);
	
	JSeparator sep2 = new JSeparator();
	totalGUI.add(sep2);
	sep2.setSize(500,2);
	sep2.setLocation(0, 400);

	//Background
	if (rnd == 1) {
		backgroundImage = new ImageIcon("Background1.png").getImage();
	} else if (rnd == 2) {
		backgroundImage = new ImageIcon("Background2.png").getImage();
	} else if (rnd == 3) {
		backgroundImage = new ImageIcon("Background3.png").getImage();
	} else {
		backgroundImage = new ImageIcon("Background4.png").getImage();
	}
	
	backgroundPanel = new ImagePanel(backgroundImage);
	backgroundPanel.setSize(500, 400);
	backgroundPanel.setLocation(0,0);
	totalGUI.add(backgroundPanel);

	//Panels and separators
	enemyPanel = new JPanel();
	enemyPanel.setLayout(null);
	enemyPanel.setLocation(0,0);
	enemyPanel.setSize(500,200);
	enemyPanel.setBackground(new Color(0,0,0,64));
	backgroundPanel.add(enemyPanel);
	
	playerPanel = new JPanel();
	playerPanel.setLayout(null);
	playerPanel.setLocation(0,200);
	playerPanel.setSize(500,200);
	playerPanel.setBackground(new Color(0,0,0,64));
	backgroundPanel.add(playerPanel);

	menuPanel = new JPanel();
	menuPanel.setLayout(null);
	menuPanel.setLocation(300,400);
	menuPanel.setSize(200,100);
	totalGUI.add(menuPanel);

	//Players images
	
	enemyImagePanel = new ImagePanel(new ImageIcon("don.png").getImage());
	enemyImagePanel.setSize(152,200);
	enemyImagePanel.setLocation(348,0);
	enemyImagePanel.setBackground(new Color(0,0,0,64));
	enemyPanel.add(enemyImagePanel);
	
	playerImagePanel = new ImagePanel(new ImageIcon("Player.png").getImage());
	playerImagePanel.setSize(200,200);
	playerImagePanel.setLocation(0,0);
	playerImagePanel.setBackground(new Color(0,0,0,64));
	playerPanel.add(playerImagePanel);
	
	//The changing Panel
	textPanel = new JPanel();
	textPanel.setLayout(null);
	textPanel.setLocation(0,400);
	textPanel.setSize(300,100);
	textPanel.setVisible(true);
	totalGUI.add(textPanel);

	attackPanel = new JPanel();
	attackPanel.setLayout(null);
	attackPanel.setLocation(0,400);
	attackPanel.setSize(300,100);
	attackPanel.setVisible(false);
	totalGUI.add(attackPanel);

	bagPanel = new JPanel();
	bagPanel.setLayout(null);
	bagPanel.setLocation(0,400);
	bagPanel.setSize(300,100);
	bagPanel.setVisible(false);
	totalGUI.add(bagPanel);

	unimonsPanel = new JPanel();
	unimonsPanel.setLayout(null);
	unimonsPanel.setLocation(0,400);
	unimonsPanel.setSize(300,100);
	unimonsPanel.setVisible(false);
	totalGUI.add(unimonsPanel);

	abandonPanel = new JPanel();
	abandonPanel.setLayout(null);
	abandonPanel.setLocation(0,400);
	abandonPanel.setSize(300,100);
	abandonPanel.setVisible(false);
	totalGUI.add(abandonPanel);

	//LifeBar
	LifeBar lifeEnemy = new LifeBar(enemy.getActiveUnimon().getMaxHp(),enemy.getActiveUnimon().getHp());
	InfoPanel infoEnemy = new InfoPanel(enemy.getActiveUnimon().getName(),enemy.getActiveUnimon().getType().toString(),enemy.getActiveUnimon().getMaxHp() , lifeEnemy);
	infoEnemy.setLocation(20, 20);
	enemyPanel.add(infoEnemy);
	
	LifeBar lifePlayer = new LifeBar(self.getActiveUnimon().getMaxHp(),self.getActiveUnimon().getHp());
	InfoPanel infoPlayer = new InfoPanel(self.getActiveUnimon().getName(), self.getActiveUnimon().getType().toString(),self.getActiveUnimon().getMaxHp() , lifePlayer);
	infoPlayer.setLocation(280, 20);
	playerPanel.add(infoPlayer);

	//Labels
	textLabel = new JLabel(story);
	textLabel.setHorizontalAlignment(0);
	textLabel.setLocation(0,0);
	textLabel.setSize(300,100);
	textPanel.add(textLabel);

	givenUp = new JLabel("You've given up! You're weak...");
	givenUp.setHorizontalAlignment(0);
	givenUp.setLocation(0,0);
	givenUp.setSize(300,100);
	abandonPanel.add(givenUp);

	//Buttons
	attack1 = new JButton("attack 1");
	attack1.setLocation(0,0);
	attack1.setSize(150,50);
	attackPanel.add(attack1);

	attack2 = new JButton("attack 2");
	attack2.setLocation(150,0);
	attack2.setSize(150,50);
	attackPanel.add(attack2);

	attack3 = new JButton("attack 3");
	attack3.setLocation(0,50);
	attack3.setSize(150,50);
	attackPanel.add(attack3);

	attack4 = new JButton("attack 4");
	attack4.setLocation(150,50);
	attack4.setSize(150,50);
	attackPanel.add(attack4);

	attack = new JButton("Attack");
	attack.setLocation(0,0);
	attack.setSize(100,50);
	attack.setBackground(Color.lightGray);
	attack.setForeground(Color.darkGray);
	attack.addActionListener(this);
	menuPanel.add(attack);

	bag = new JButton("Bag");
	bag.setLocation(100,0);
	bag.setSize(100,50);
	bag.setBackground(Color.lightGray);
	bag.setForeground(Color.darkGray);
	bag.addActionListener(this);
	menuPanel.add(bag);

	unimons = new JButton("Unimons");
	unimons.setLocation(0,50);
	unimons.setSize(100,50);
	unimons.setBackground(Color.lightGray);
	unimons.setForeground(Color.darkGray);
	unimons.addActionListener(this);
	menuPanel.add(unimons);

	abandon = new JButton("Abandon");
	abandon.setLocation(100,50);
	abandon.setSize(100,50);
	abandon.setBackground(Color.lightGray);
	abandon.setForeground(Color.darkGray);
	abandon.addActionListener(this);
	menuPanel.add(abandon);
	

	return totalGUI;
	
	}
	
	public void setSelf(Player p){
		this.self = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == attack) {

		textPanel.setVisible(false);
		attackPanel.setVisible(true);
		bagPanel.setVisible(false);
		unimonsPanel.setVisible(false);
		abandonPanel.setVisible(false);

		} else if (e.getSource() == bag) {

		textPanel.setVisible(false);
		attackPanel.setVisible(false);
		bagPanel.setVisible(true);
		unimonsPanel.setVisible(false);
		abandonPanel.setVisible(false);

		} else if (e.getSource() == unimons) {

		textPanel.setVisible(false);
		attackPanel.setVisible(false);
		bagPanel.setVisible(false);
		unimonsPanel.setVisible(true);
		abandonPanel.setVisible(false);

		} else if (e.getSource() == abandon) {

		textPanel.setVisible(false);
		attackPanel.setVisible(false);
		bagPanel.setVisible(false);
		unimonsPanel.setVisible(false);
		abandonPanel.setVisible(true);

		}
	}

	public void createAndShowGUI(Player s, Player e) {

	JFrame.setDefaultLookAndFeelDecorated(true); //Unified look, independent of the OS.
	JFrame frame= new JFrame("Unimon Game");

	//Create and set up the content pane.
	
	frame.setContentPane(this.createFightPanel(s,e));

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(510, 533);
	frame.setResizable(false); //Only one size!
	frame.setVisible(true);
	}



}
