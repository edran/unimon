package com.unimongame.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import com.unimongame.Battle;
import com.unimongame.Player;
import com.unimongame.Unimon;
import com.unimongame.attack.Attack;

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
	private JTextField textArea;
	private JButton attack1, attack2, attack3, attack4, givingUp;
	private JSeparator sep;
	private MenuPanel menu = new MenuPanel(this);
	private Player self;
	private Player enemy;
	private int seed = (int) Math.random() * 1000;

	public FightGUI(Player self, Player enemy) {
		// init variables
		this.self = self;
		this.enemy = enemy;
		cbPanel = new CombatPanel(self, enemy, seed);
		chPanel = new ChooseUnimonPanel(enemy, this);

		// look and feel
		setSize(500, 500);
		setLocation(0, 0);
		setLayout(null);

		// add separator
		sep = new JSeparator();
		sep.setSize(500, 2);
		sep.setLocation(0, 400);
		sep.setBackground(Color.BLACK);
		sep.setForeground(Color.BLACK);
		sep.setVisible(true);
		add(sep);

		// add TextArea
		textArea = new JTextField();
		textArea.setHorizontalAlignment(JTextField.CENTER);
		textArea.setText("Get Ready to Battle!");
		textArea.setEditable(false);
		textArea.setLayout(null);
		textArea.setLocation(0, 400);
		textArea.setSize(300, 100);
		textArea.setVisible(true);
		add(textArea);

		// add
		showCombatPanel();
		showMenu();

	}

	private void showCombatPanel() {
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

	public void updateInfo(boolean newUnimon) {

	}


	public void showMenu() {
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

	public void doAttack(Attack attack) {
		// TODO Auto-generated method stub

	}

}
