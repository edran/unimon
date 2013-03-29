package com.unimongame.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import com.unimongame.Player;

@SuppressWarnings("serial")
public class CombatPanel extends JPanel {
	private Image backgroundImage;
	private PlayerPanel selfPanel;
	private PlayerPanel enemyPanel;
	private JSeparator sep1;
	private static final int NUM_BACKGROUNDS = 4;
	public static final boolean DEBUG = true;

	enum UnimonPosition {
		// TOP is the enemey's unimon
		// BOTTOM is the user's unimon
		TOP, BOTTOM;
	}

	public CombatPanel(Player self, Player enemy, int backgroundNumSeed) {

		backgroundImage = new ImageIcon("Background" + backgroundNumSeed%NUM_BACKGROUNDS + ".png").getImage();
		setLayout(null);
		setSize(500, 400);
		setLocation(0, 0);
		System.out.println("cp constructor");

		// setup separator
		sep1 = new JSeparator();
		sep1.setBackground(Color.BLACK);
		sep1.setForeground(Color.BLACK);
		sep1.setSize(500, 2);
		sep1.setLocation(0, 200);
		add(sep1);

		// setup panels
		selfPanel = new PlayerPanel(self);
		enemyPanel = new EnemyPlayerPanel(enemy);
		add(selfPanel);
		add(enemyPanel);
		add(new JTextArea("hello from cp"));

	}

	public void changeUnimon(UnimonPosition uniPos) {
		if (uniPos == UnimonPosition.TOP) {
			enemyPanel.changeUnimon();
		} else {
			selfPanel.changeUnimon();
		}
	}

	public void updateStats() {
		enemyPanel.updateStats();
		selfPanel.updateStats();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, null);
	}



}
