package com.unimongame.GUI;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.unimongame.Player;
import com.unimongame.Unimon;
import com.unimongame.attack.Attack;

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
		chPanel = new ChooseUnimonPanel(self, this);

		// look and feel
		setSize(500, 500);
		setLocation(0, 0);
		setLayout(null);
		setVisible(true);

		// add separator
		sep = new JSeparator();
		sep.setSize(500, 2);
		sep.setLocation(0, 400);
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
		remove(chPanel);
		add(cbPanel);
		cbPanel.setVisible(true);
		System.out.println("adding cbPanel");
		repaint();
	}
	
	private void showChoosePanel(){
		remove(cbPanel);
		chPanel.updateValues();
		add(chPanel);
		chPanel.setVisible(true);
		System.out.println("adding chPanel");
		repaint();
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

	public void abandonClicked() {
		showCombatPanel();
		chPanel.reset();
	}

	public void chooseUnimonClicked() {
		chPanel.reset();
		showChoosePanel();
	}

	public void showBagClicked() {
		showCombatPanel();
		chPanel.reset();
	}

	public void showAttacksClicked() {
		showCombatPanel();
		chPanel.reset();
	}

	public void unimonSelected(Unimon selected) {
		System.out.println(selected);
	}

	public void doAttack(Attack attack) {
		

	}

}
