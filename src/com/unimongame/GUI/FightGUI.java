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

	private CombatPanel cbPanel;
	private ChooseUnimonPanel chPanel;
	private JTextField textArea;
	private JButton attack1, attack2, attack3, attack4, givingUp;
	private JSeparator sep;
	private Player self;
	private GameWindow window;
	private Player enemy;
	private MenuPanel menu = new MenuPanel(this);
	private AttackMenuPanel attackMenu;
	private int seed = (int) (Math.random() * 1000);

	public FightGUI(Player self, Player enemy,GameWindow window) {
		// init variables
		//System.out.println("self : "+self.getName());
		assert(enemy != null);
		assert(enemy.getName() != null);
		System.out.println("enemy : "+enemy.getName());
		this.self = self;
		this.enemy = enemy;
		cbPanel = new CombatPanel(self, enemy, seed);
		chPanel = new ChooseUnimonPanel(self, this);
		attackMenu  = new AttackMenuPanel(this, self);
		this.window = window;
		// look and feel
		setSize(500, 500);
		setLocation(0,23);
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
		//showMenu();

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
		textArea.setText("waiting for opponent to make a move");
		hideMenu();
	}

	public void turn() {
		textArea.setText("its your turn ! make a move..");
		showMenu();
	}

	public void updateInfo(Player self,Player enemy) {
		cbPanel.updateStats(self,enemy);
		this.self = self;
		this.enemy = enemy;
	}


	public void showMenu() {
		remove(menu);
		add(menu);
		menu.setVisible(true);
	}
	public void hideMenu(){
		menu.setVisible(false);
	}
	
	public void showAttacksMenu(){
		remove(attackMenu);
		add(attackMenu);
		attackMenu.setVisible(true);
		textArea.setVisible(false);
		
	}
	public void hideAttacksMenu(){
		attackMenu.setVisible(false);
		textArea.setVisible(true);
	}

	public void abandonClicked() {
		showCombatPanel();
		chPanel.reset();
		textArea.setText("Are you sure you want to leave?");
		hideAttacksMenu();
	}

	public void chooseUnimonClicked() {
		chPanel.reset();
		showChoosePanel();
		textArea.setText("Choose a Unimon, this will end your turn!");
		hideAttacksMenu();
	}

	public void showBagClicked() {
		showCombatPanel();
		chPanel.reset();
		textArea.setText("Choose an Item to use!");
		hideAttacksMenu();
	}

	public void showAttacksClicked() {
		showCombatPanel();
		chPanel.reset();
		showAttacksMenu();
	}

	
	
	public void unimonSelected(Unimon selected) {
		window.changeUnimon(selected);
		showCombatPanel();
	}

	public void doAttack(int i) {
		window.doAttack(i);
		hideAttacksMenu();
	}

}
