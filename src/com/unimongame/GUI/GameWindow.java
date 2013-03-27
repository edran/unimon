package com.unimongame.GUI;

import javax.swing.JFrame;

import com.unimongame.Player;


@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	private FightGUI fightGUI;
	private WelcomeGUI welcome = new WelcomeGUI();
	private Player playerSelf;
	private Player playerEnemy;
	static{
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
	
	
	//dont pass in players here!!!! only for testing!
	public GameWindow(Player self, Player enemy){
		super("Unimon Game");
		fightGUI = new FightGUI(self, enemy); 
		showFightGUI();
		//showStartScreen();
		setVisible(true);
		setSize(510, 533);
		setResizable(false); // Only one size!
		setVisible(true);
		
		// for testing
		
		
	}
	
	public void showStartScreen(){
		setContentPane(welcome);
		welcome.setVisible(true);
	}
	
	public void showFightGUI(){
		setContentPane(fightGUI);
		System.out.println("show Fight Gui");
		fightGUI.setVisible(true);
	}
}
