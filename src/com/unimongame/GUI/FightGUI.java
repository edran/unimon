package com.unimongame.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.unimongame.Player;
import com.unimongame.Unimon;
import com.unimongame.attack.Attack;

public class FightGUI extends JPanel implements ActionListener {

	// Declaring a few variables

	private CombatPanel cbPanel;
	private ChooseUnimonPanel chPanel;
	private ItemPanel itPanel;
	private JTextArea textArea;
	JScrollPane textAreaScroll;
	private JButton nextUni;
	private JSeparator sep;
	private Player self;
	private GameWindow window;
	private Player enemy;
	private MenuPanel menu = new MenuPanel(this);
	private AttackMenuPanel attackMenu;
	

	public FightGUI(Player self, Player enemy,GameWindow window,int background) {
		// init variables
		//System.out.println("self : "+self.getName());
		assert(enemy != null);
		assert(enemy.getName() != null);
		System.out.println("enemy : "+enemy.getName());
		this.self = self;
		this.enemy = enemy;
		cbPanel = new CombatPanel(self, enemy, background);
		chPanel = new ChooseUnimonPanel(self, this);
		itPanel = new ItemPanel(self, this);
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
		textArea = new JTextArea();
		textArea.append("Get ready to battle!\n");
		textArea.setEditable(false);
		textArea.setSize(300, 100);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textAreaScroll = new JScrollPane(textArea,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		textAreaScroll.setSize(300,100);
		textAreaScroll.setLocation(0, 400);
		textAreaScroll.setVisible(true);
		add(textAreaScroll);
		
		nextUni = new JButton("Next Unimon");
		nextUni.setSize(160, 50);
		nextUni.setLocation(320, 425);
		nextUni.addActionListener(this);
		nextUni.setVisible(false);
		
		// add
		showCombatPanel();
		showMenu();

	}
	
	public void appendMessage(String msg) {
		textArea.append(msg + "\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

	private void showCombatPanel() {
		remove(chPanel);
		remove(itPanel);
		add(cbPanel);
		cbPanel.setVisible(true);
		System.out.println("adding cbPanel");
		repaint();
	}
	
	private void showChoosePanel(){
		remove(cbPanel);
		remove(itPanel);
		chPanel.updateValues(self);
		add(chPanel);
		chPanel.setVisible(true);
		System.out.println("adding chPanel");
		repaint();
	}
	
	private void showItemPanel(){
		remove(cbPanel);
		remove(chPanel);
		itPanel.updateValues(self);
		add(itPanel);
		itPanel.setVisible(true);
		System.out.println("adding itPanel");
		repaint();
	}

	public void waitOnPlayer() {
		appendMessage("\nWaiting for opponent to make a move...");
		hideMenu();
	}

	public void turn() {
		if(self.getActiveUnimon().isAlive()){
			appendMessage("\nIt's your turn ! Make a move.");
			showMenu();
		}
	}

	public void updateInfo(Player self,Player enemy,String infoString) {
		cbPanel.updateStats(self,enemy);
		chPanel.updateValues(self);
		attackMenu = new AttackMenuPanel(this,self);
		textArea.append(infoString);
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
		textAreaScroll.setVisible(false);
		
	}
	public void hideAttacksMenu(){
		attackMenu.setVisible(false);
		textAreaScroll.setVisible(true);
	}

	public void abandonClicked() {
		showCombatPanel();
		chPanel.reset();
		appendMessage("Are you sure you want to leave?");
		hideAttacksMenu();
	}

	public void chooseUnimonClicked() {
		chPanel.reset();
		showChoosePanel();
		appendMessage("Choose a Unimon.");
		hideAttacksMenu();
	}

	public void showBagClicked() {
		showItemPanel();
		chPanel.reset();
		appendMessage("Choose an Item to use!");
		hideAttacksMenu();
	}

	public void showAttacksClicked() {
		showCombatPanel();
		chPanel.reset();
		showAttacksMenu();
	}

	
	
	public void unimonSelected(int selected) {
		window.changeUnimon(selected);
		showCombatPanel();
	}

	public void itemSelected(int selected) {
		window.applyItem(selected);
		showCombatPanel();
	}
	
	public void doAttack(int i) {
		hideMenu();
		hideAttacksMenu();
		window.doAttack(i);
	}

	public void unimonDied(String infoString) {
		appendMessage(infoString);
		hideMenu();
		add(nextUni);
		nextUni.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nextUni) {
			chooseUnimonClicked();
			nextUni.setVisible(false);
			remove(nextUni);
		}
		
	}

}
