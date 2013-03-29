package com.unimongame.GUI;

import javax.swing.JFrame;

import com.unimongame.Battle;
import com.unimongame.Player;


@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	private FightGUI fightGUI;
	private WelcomeGUI welcome = new WelcomeGUI(this);
	private Player playerSelf;
	private Player playerEnemy;
	private Battle battle;
	static{
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
	
	
	public GameWindow(Battle battle){
		super("Unimon Game");
		this.battle = battle;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		showStartScreen();
		setSize(510, 533);
		
		setResizable(false); // Only one size!
		setVisible(true);
		
	}
	
	public void setPlayers(Player self, Player enemy){
		fightGUI = new FightGUI(self, enemy); 
		playerSelf = self;
		playerEnemy = enemy;
		
	}
	
	public void showStartScreen(){
		setContentPane(welcome);
		welcome.setVisible(true);
	}
	
	public void startClicked(){
		battle.start();
	}
	
	public void showFightGUI(){
		setContentPane(fightGUI);
		this.getContentPane().setSize(500,500);
		System.out.println("show Fight Gui");
		welcome.setVisible(false);
		fightGUI.setVisible(true);
		repaint();
	}
}
