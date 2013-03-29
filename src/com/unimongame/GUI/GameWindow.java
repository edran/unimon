package com.unimongame.GUI;

import javax.swing.JFrame;

import com.unimongame.Battle;
import com.unimongame.Player;
import com.unimongame.Unimon;
import com.unimongame.attack.Attack;


@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	private FightGUI fightGUI;
	private WelcomeGUI welcome = new WelcomeGUI(this);
	private Player playerSelf;
	private Player playerEnemy;
	private Battle battle;
	private HelpGUI helpGUI = new HelpGUI(this);
	
	static{
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
	
	
	public GameWindow(Battle battle){
		super("Unimon Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setBattle(battle);
		showStartScreen();
		setSize(510, 533);
		
		setResizable(false); // Only one size!
		setVisible(true);
		
	}
	
	public void setBattle(Battle battle){
		this.battle = battle;
	}
	
	public void setPlayers(Player self, Player enemy){
		fightGUI = new FightGUI(self, enemy, this); 
		playerSelf = self;
		playerEnemy = enemy;
		this.setTitle("Unimon Game: " + self.getName());
		
	}
	
	public void showStartScreen(){
		System.out.println("in showStartScreen");
		setContentPane(welcome);
		welcome.setVisible(true);
		helpGUI.setVisible(false);
	}
	
	public void helpClicked(){
		setContentPane(helpGUI);
		helpGUI.setVisible(true);
		welcome.setVisible(false);
	}
	
	public void startClicked(String name){
		battle.start();
	}
	
	public void hostClicked(String name, int port){
		
		
	}
	
	public void joinClicked(String name, String IP, int port){
		
		
	}
	
	public void doAttack(int i){
		battle.doAttack(playerSelf,playerEnemy,i);
	}
	
	public void changeUnimon(Unimon uni){
		battle.selectUnimon(playerSelf, uni, true);
	}
	
	public void updateInfo(Player self, Player enemy){
		fightGUI.updateInfo(self, enemy);
	}
	
	public void showFightGUI(){
		setContentPane(fightGUI);
		this.getContentPane().setSize(500,500);
		System.out.println("show Fight Gui");
		welcome.setVisible(false);
		fightGUI.setVisible(true);
		repaint();
	}

	public void turn() {
		fightGUI.turn();
	}
	
	public void waitOnPlayer(){
		fightGUI.waitOnPlayer();
	}
}
