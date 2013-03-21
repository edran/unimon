package com.unimongame.GUI;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

public class FightGUI  implements ActionListener {

	//Declaring a few variables

	public JPanel totalGUI, enemyPanel, playerPanel, menuPanel, textPanel, attackPanel, bagPanel, unimonsPanel, abandonPanel;
	public JLabel enemyUniName, playerUniName, textLabel, givenUp;
	public JButton attack1, attack2, attack3, attack4, attack, bag, unimons, abandon;

	String story = "<html>Welcome to the game.<br>Prepare for battle!</html>";


	public JPanel createFightPanel() {

	//Bottom JPanel to place everything on.
	totalGUI = new JPanel();
	totalGUI.setLayout(null);

	//Panels and separators
	enemyPanel = new JPanel();
	enemyPanel.setLayout(null);
	enemyPanel.setLocation(0,0);
	enemyPanel.setSize(500,200);
	totalGUI.add(enemyPanel);

	JSeparator sep1 = new JSeparator();
	totalGUI.add(sep1);
	sep1.setSize(500,2);
	sep1.setLocation(0, 200);
	
	playerPanel = new JPanel();
	playerPanel.setLayout(null);
	playerPanel.setLocation(0,200);
	playerPanel.setSize(500,200);
	totalGUI.add(playerPanel);
	
	JSeparator sep2 = new JSeparator();
	totalGUI.add(sep2);
	sep2.setSize(500,2);
	sep2.setLocation(0, 400);

	menuPanel = new JPanel();
	menuPanel.setLayout(null);
	menuPanel.setLocation(300,400);
	menuPanel.setSize(200,100);
	totalGUI.add(menuPanel);

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
	LifeBar lifeEnemy = new LifeBar(150,140);
	lifeEnemy.setLocation(330,20);
	enemyPanel.add(lifeEnemy);
	
	LifeBar lifePlayer = new LifeBar(150,30);
	lifePlayer.setLocation(50,20);
	playerPanel.add(lifePlayer);

	//Labels
	enemyUniName = new JLabel("<insert Unimon name for enemy>");
	enemyUniName.setLocation(0,0);
	enemyUniName.setSize(250,30);
	enemyUniName.setHorizontalAlignment(0);
	enemyPanel.add(enemyUniName);

	playerUniName = new JLabel("<insert Unimon name for player>");
	playerUniName.setLocation(250,0);
	playerUniName.setSize(250,30);
	playerUniName.setHorizontalAlignment(0);
	playerPanel.add(playerUniName);

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

	public static void createAndShowGUI() {

	JFrame.setDefaultLookAndFeelDecorated(true); //Unified look, independent of the OS.
	JFrame frame= new JFrame("Unimon Game");

	//Create and set up the content pane.
	FightGUI setup = new FightGUI();
	frame.setContentPane(setup.createFightPanel());

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(500, 530);
	frame.setResizable(false); //Only one size!
	frame.setVisible(true);
	}

	public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable(){
		public void run() {
			createAndShowGUI();
		}
	});
	}

}
