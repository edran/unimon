package com.unimongame.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import com.unimongame.Battle;
import com.unimongame.Player;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FightGUI implements ActionListener {

	// Declaring a few variables

	private static final int NUM_BACKGROUND_IMAGES = 4;
	private JFrame mainFrame = new JFrame("Unimon Game");
	private JPanel totalGUI, enemyPanel, playerPanel, menuPanel, textPanel,
			attackPanel, bagPanel, unimonsPanel, abandonPanel;
	private ChooseUnimon chooseUnimon;
	private JLabel enemyUniName, playerUniName, textLabel, givenUp;
	private JButton attack1, attack2, attack3, attack4, givingUp, attack, bag,
			unimons, abandon;
	private ImagePanel backgroundPanel, enemyImagePanel, playerImagePanel, waitingImagePanel;
	private Image backgroundImage;
	private JSeparator sep1, sep2;
	private Battle battle;
	private Player self;
	private Player enemy;	
	private LifeBar lifeEnemy;
	private LifeBar lifePlayer;
	private int rnd;
	static{
		JFrame.setDefaultLookAndFeelDecorated(true);
	}

	public FightGUI(Battle battle,Player self, Player enemy, double d) {
		
		this.self = self;
		this.enemy = enemy;
		this.battle = battle;
		rnd = ((int) d) % NUM_BACKGROUND_IMAGES;
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(510, 533);
		mainFrame.setResizable(false); // Only one size!
		mainFrame.setVisible(true);
		
	}

	public void waitOnPlayer() {
		menuPanel.setVisible(false);
		attackPanel.setVisible(false);
		System.out.println("waiting on player");
		textLabel.setText("Waiting on the other player...");
		textPanel.setVisible(true);
//		makes if freeze
//		waitingImagePanel.setVisible(true);
//		do {waitingImagePanel.repaint();}
//		while (true);
	
	}

	public void turn() {
		menuPanel.setVisible(true);
		textLabel.setText("Your turn!");
		//waitingImagePanel.setVisible(false);
		
	}
	
	public void update(){
		
	}

	public JPanel createFightPanel() {

		// Bottom JPanel to place everything on.
		totalGUI = new JPanel();
		totalGUI.setLocation(0, 0);
		totalGUI.setSize(500, 500);
		totalGUI.setLayout(null);

		// Separators
		sep1 = new JSeparator();
		sep1.setBackground(Color.BLACK);
		sep1.setForeground(Color.BLACK);
		sep1.setSize(500, 2);
		sep1.setLocation(0, 200);
		sep1.setVisible(true);
		totalGUI.add(sep1);

		sep2 = new JSeparator();
		sep2.setSize(500, 2);
		sep2.setLocation(0, 400);
		totalGUI.add(sep2);

		// Background
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
		backgroundPanel.setLocation(0, 0);
		totalGUI.add(backgroundPanel);

		chooseUnimon = new ChooseUnimon(self);
	
		// Panels
		enemyPanel = new JPanel();
		enemyPanel.setLayout(null);
		enemyPanel.setLocation(0, 0);
		enemyPanel.setSize(500, 200);
		enemyPanel.setBackground(new Color(0, 0, 0, 64));
		backgroundPanel.add(enemyPanel);

		playerPanel = new JPanel();
		playerPanel.setLayout(null);
		playerPanel.setLocation(0, 200);
		playerPanel.setSize(500, 200);
		playerPanel.setBackground(new Color(0, 0, 0, 64));
		backgroundPanel.add(playerPanel);

		menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuPanel.setLocation(300, 400);
		menuPanel.setSize(200, 100);
		totalGUI.add(menuPanel);

		// Players images

		enemyImagePanel = new ImagePanel(new ImageIcon("don.png").getImage());
		enemyImagePanel.setSize(152, 200);
		enemyImagePanel.setLocation(348, 0);
		enemyImagePanel.setBackground(new Color(0, 0, 0, 64));
		enemyPanel.add(enemyImagePanel);

		playerImagePanel = new ImagePanel(
				new ImageIcon("Player.png").getImage());
		playerImagePanel.setSize(200, 200);
		playerImagePanel.setLocation(0, 0);
		playerImagePanel.setBackground(new Color(0, 0, 0, 64));
		playerPanel.add(playerImagePanel);
		
		//Waiting image
//		waitingImagePanel = new ImagePanel(new ImageIcon("pageload.gif").getImage());
//		waitingImagePanel.setSize(100, 100);
//		waitingImagePanel.setLocation(350, 400);
//		waitingImagePanel.setVisible(false);
//		totalGUI.add(waitingImagePanel);

		// The changing Panel
		textPanel = new JPanel();
		textPanel.setLayout(null);
		textPanel.setLocation(0, 400);
		textPanel.setSize(300, 100);
		textPanel.setVisible(true);
		totalGUI.add(textPanel);

		attackPanel = new JPanel();
		attackPanel.setLayout(null);
		attackPanel.setLocation(0, 400);
		attackPanel.setSize(300, 100);
		attackPanel.setVisible(false);
		totalGUI.add(attackPanel);

		// LifeBar
		lifeEnemy = new LifeBar(enemy.getActiveUnimon().getMaxHp(),
				enemy.getActiveUnimon().getHp());
		InfoPanel infoEnemy = new InfoPanel(enemy.getActiveUnimon().getName(),
				"type", enemy.getActiveUnimon().getMaxHp(), lifeEnemy);
		infoEnemy.setLocation(20, 20);
		enemyPanel.add(infoEnemy);

		 lifePlayer = new LifeBar(self.getActiveUnimon().getMaxHp(),
				self.getActiveUnimon().getHp());
		InfoPanel infoPlayer = new InfoPanel(self.getActiveUnimon().getName(),
				"type", self.getActiveUnimon().getMaxHp(), lifePlayer);
		infoPlayer.setLocation(280, 20);
		playerPanel.add(infoPlayer);

		// Labels
		textLabel = new JLabel("");
		textLabel.setHorizontalAlignment(0);
		textLabel.setLocation(0, 0);
		textLabel.setSize(300, 100);
		textPanel.add(textLabel);

		// Buttons
		attack1 = new JButton(self.getActiveUnimon().getAttacks().get(0)
				.getName());
		attack1.setLocation(0, 0);
		attack1.setSize(150, 50);
		attack1.setToolTipText(self.getActiveUnimon().getAttacks().get(0)
				.getDescription());
		attack1.addActionListener(this);
		attackPanel.add(attack1);

		attack2 = new JButton(self.getActiveUnimon().getAttacks().get(1)
				.getName());
		attack2.setLocation(150, 0);
		attack2.setSize(150, 50);
		attack2.setToolTipText(self.getActiveUnimon().getAttacks().get(1)
				.getDescription());
		attack2.addActionListener(this);
		attackPanel.add(attack2);

		attack3 = new JButton(self.getActiveUnimon().getAttacks().get(2)
				.getName());
		attack3.setLocation(0, 50);
		attack3.setSize(150, 50);
		attack3.setToolTipText(self.getActiveUnimon().getAttacks().get(2)
				.getDescription());
		attack3.addActionListener(this);
		attackPanel.add(attack3);

		attack4 = new JButton(self.getActiveUnimon().getAttacks().get(3)
				.getName());
		attack4.setLocation(150, 50);
		attack4.setSize(150, 50);
		attack4.setToolTipText(self.getActiveUnimon().getAttacks().get(3)
				.getDescription());
		attack4.addActionListener(this);
		attackPanel.add(attack4);

		givingUp = new JButton("Yes! I'm scared...");
		givingUp.setSize(150, 20);
		givingUp.setHorizontalAlignment(0);
		givingUp.setLocation(75, 70);
		givingUp.setVisible(false);
		textPanel.add(givingUp);

		attack = new JButton("Attack");
		attack.setLocation(0, 0);
		attack.setSize(100, 50);
		attack.setBackground(Color.lightGray);
		attack.setForeground(Color.darkGray);
		attack.addActionListener(this);
		menuPanel.add(attack);

		bag = new JButton("Bag");
		bag.setLocation(100, 0);
		bag.setSize(100, 50);
		bag.setBackground(Color.lightGray);
		bag.setForeground(Color.darkGray);
		bag.addActionListener(this);
		menuPanel.add(bag);

		unimons = new JButton("Unimons");
		unimons.setLocation(0, 50);
		unimons.setSize(100, 50);
		unimons.setBackground(Color.lightGray);
		unimons.setForeground(Color.darkGray);
		unimons.addActionListener(this);
		menuPanel.add(unimons);

		abandon = new JButton("Give up!");
		abandon.setLocation(100, 50);
		abandon.setSize(100, 50);
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
			chooseUnimon.setVisible(false);
			chooseUnimon.destroy();
			backgroundPanel.setVisible(true);
			sep1.setVisible(true);
			givingUp.setVisible(false);

		} else if (e.getSource() == bag) {

			textPanel.setVisible(true);
			textLabel.setText("Take an item.");
			attackPanel.setVisible(false);
			chooseUnimon.setVisible(false);
			chooseUnimon.destroy();
			backgroundPanel.setVisible(true);
			sep1.setVisible(true);
			givingUp.setVisible(false);

		} else if (e.getSource() == unimons) {

			totalGUI.add(chooseUnimon);
			textPanel.setVisible(true);
			textLabel.setText("Choose your Unimon.");
			attackPanel.setVisible(false);
			chooseUnimon.destroy();
			chooseUnimon.init();
			chooseUnimon.setVisible(true);
			backgroundPanel.setVisible(false);
			sep1.setVisible(false);
			givingUp.setVisible(false);

		} else if (e.getSource() == abandon) {

			textPanel.setVisible(true);
			textLabel.setText("Are you really giving up?");
			givingUp.setVisible(true);
			attackPanel.setVisible(false);
			chooseUnimon.setVisible(false);
			chooseUnimon.destroy();
			backgroundPanel.setVisible(true);

		} else if (e.getSource() == attack1) {
			battle.doAttack(self, enemy, 0);
			//Effects.runEffect(enemyPanel,"horizontal","moderate",1000);

		} else if (e.getSource() == attack2) {
			battle.doAttack(self, enemy, 1);

		} else if (e.getSource() == attack3) {
			battle.doAttack(self, enemy, 2);

		} else if (e.getSource() == attack4) {
			battle.doAttack(self, enemy, 3);
		}
	}

	public void createAndShowGUI() {
		// Create and set up the content pane.
		mainFrame.setContentPane(this.createFightPanel());
		
	}

}
