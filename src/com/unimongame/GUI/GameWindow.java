package com.unimongame.GUI;

import javax.swing.JFrame;

import com.unimongame.*;
import com.unimongame.Client;
import com.unimongame.Player;
import com.unimongame.Unimon;
import com.unimongame.attack.Attack;


@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	
	private FightGUI fightGUI;
	private WelcomeGUI welcome = new WelcomeGUI(this);
	private Player playerSelf;
	private Player playerEnemy;
	private Client client;
	private HelpGUI helpGUI = new HelpGUI(this);
	private UnimonGame main;
	
	static{
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
	
	
	public GameWindow(UnimonGame main){
		super("Unimon Game");
		this.main = main;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		showStartScreen();
		setSize(510, 533);
		
		setResizable(false); // Only one size!
		setVisible(true);
	}
	
	public void setClient(Client client){
		this.client = client;
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
	
	
	
	public void hostClicked(String name, int port){

		main.host(new Player(name),port);
	}
	
	public void joinClicked(String name, String IP, int port){
		main.join(new Player(name),IP,port);

		
	}
	
	public void doAttack(int i){
		client.doAttack(playerSelf,playerEnemy,i);
	}
	
	public void changeUnimon(Unimon uni){
		client.selectUnimon(playerSelf, uni, true);
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
