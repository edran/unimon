package com.unimongame.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import com.unimongame.Battle;
import com.unimongame.Player;
import com.unimongame.Unimon;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FightGUI extends JPanel {

	// Declaring a few variables

	private static final int NUM_BACKGROUND_IMAGES = 4;
	private CombatPanel cbPanel;
	private ChooseUnimonPanel chPanel;
	private JButton attack1, attack2, attack3, attack4, givingUp;
	private JSeparator sep;
	private MenuPanel menu = new MenuPanel(this);
	private Player self;
	private Player enemy;
	private int seed = (int)Math.random()*1000;

	public FightGUI(Player self, Player enemy) {
		//init variables
		this.self = self;
		this.enemy = enemy;
		cbPanel = new CombatPanel(self, enemy, seed);
		chPanel = new ChooseUnimonPanel(enemy, this);
		//look and feel
		setSize(500,500);
		setLocation(0,0);
		setLayout(null);
		
		//add seperator
		sep = new JSeparator();
		sep.setSize(500,40);
		sep.setLocation(0, 500);
		add(sep);
		showCombatPanel();
		showMenu();
		
	}
	
	private void showCombatPanel(){
		remove(cbPanel);
		remove(chPanel);
		add(cbPanel);
		cbPanel.setVisible(true);
		System.out.println("adding cbPanel");
	}

	public void waitOnPlayer() {
	
	}

	public void turn() {
	
	}
	
	public void updateInfo(boolean newUnimon){
		
	}



	

		



//	
//		chooseUnimon = new ChooseUnimonPanel(self,battle);
//
//		menuPanel = new JPanel();
//		menuPanel.setLayout(null);
//		menuPanel.setLocation(300, 400);
//		menuPanel.setSize(200, 100);
//		totalGUI.add(menuPanel);
//		
//		

		
		
//
//
//
//		// Labels
//		textLabel = new JLabel("");
//		textLabel.setHorizontalAlignment(0);
//		textLabel.setLocation(0, 0);
//		textLabel.setSize(300, 100);
//		textPanel.add(textLabel);

//		// Buttons
//		attack1 = new JButton(self.getActiveUnimon().getAttacks().get(0)
//				.getName());
//		attack1.setLocation(0, 0);
//		attack1.setSize(150, 50);
//		attack1.setToolTipText(self.getActiveUnimon().getAttacks().get(0)
//				.getDescription());
//		attack1.addActionListener(this);
//		attackPanel.add(attack1);
//
//		attack2 = new JButton(self.getActiveUnimon().getAttacks().get(1)
//				.getName());
//		attack2.setLocation(150, 0);
//		attack2.setSize(150, 50);
//		attack2.setToolTipText(self.getActiveUnimon().getAttacks().get(1)
//				.getDescription());
//		attack2.addActionListener(this);
//		attackPanel.add(attack2);
//
//		attack3 = new JButton(self.getActiveUnimon().getAttacks().get(2)
//				.getName());
//		attack3.setLocation(0, 50);
//		attack3.setSize(150, 50);
//		attack3.setToolTipText(self.getActiveUnimon().getAttacks().get(2)
//				.getDescription());
//		attack3.addActionListener(this);
//		attackPanel.add(attack3);
//
//		attack4 = new JButton(self.getActiveUnimon().getAttacks().get(3)
//				.getName());
//		attack4.setLocation(150, 50);
//		attack4.setSize(150, 50);
//		attack4.setToolTipText(self.getActiveUnimon().getAttacks().get(3)
//				.getDescription());
//		attack4.addActionListener(this);
//		attackPanel.add(attack4);
//
//		givingUp = new JButton("Yes! I'm scared...");
//		givingUp.setSize(150, 20);
//		givingUp.setHorizontalAlignment(0);
//		givingUp.setLocation(75, 70);
//		givingUp.setVisible(false);
//		textPanel.add(givingUp);
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		 if (e.getSource() == attack1) {
//			battle.doAttack(self, enemy, 0);
//			//Effects.runEffect(enemyPanel,"horizontal","moderate",1000);
//
//		} else if (e.getSource() == attack2) {
//			battle.doAttack(self, enemy, 1);
//
//		} else if (e.getSource() == attack3) {
//			battle.doAttack(self, enemy, 2);
//
//		} else if (e.getSource() == attack4) {
//			battle.doAttack(self, enemy, 3);
//		}
//	}


	public void showMenu(){
		remove(menu);
		add(menu);
		menu.setVisible(true);
	}


	public void abandon() {
		// TODO Auto-generated method stub
		
	}

	public void chooseUnimon() {
		// TODO Auto-generated method stub
		
	}

	public void showBag() {
		// TODO Auto-generated method stub
		
	}

	public void showAttacks() {
		// TODO Auto-generated method stub
		
	}

	public void unimonSelected(Unimon selected) {
		// TODO Auto-generated method stub
		
	}

}
