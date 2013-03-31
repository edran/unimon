package com.unimongame.GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.unimongame.*;
import com.unimongame.attack.Attack;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {

	private FightGUI fightGUI;
	private WelcomeGUI welcome = new WelcomeGUI(this);
	private WaitPanel wait = new WaitPanel(this);
	private Player playerSelf;
	private Player playerEnemy;
	private Client client;
	private PickTeamPanel pickTeamPanel;
	private HelpGUI helpGUI = new HelpGUI(this);
	private UnimonGame main;
	public boolean isTeamPicked = false;

	static {
		JFrame.setDefaultLookAndFeelDecorated(true);
	}

	public GameWindow(UnimonGame main) {
		super("Unimon Game");
		this.main = main;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		showStartScreen();
		setSize(510, 533);

		setResizable(false); // Only one size!
		setVisible(true);
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setPlayers(Player self, Player enemy) {
		fightGUI = new FightGUI(self, enemy, this);
		this.setTitle("Unimon Game: " + self.getName());
		System.out.println("fightGui created");

	}

	public void showTeamPicker() {
		setContentPane(pickTeamPanel);
	}

	public void setMessage(String msg) {
		welcome.setMessage(msg);
	}

	public void showStartScreen() {
		System.out.println("in showStartScreen");
		setContentPane(welcome);
		welcome.setVisible(true);
		helpGUI.setVisible(false);
	}

	public void helpClicked() {
		setContentPane(helpGUI);
		helpGUI.setVisible(true);
		welcome.setVisible(false);
	}

	public void hostClicked(String name, int port) {
		playerSelf = new Player(name);
		pickTeamPanel = new PickTeamPanel(this, playerSelf);
		main.host(port);
	}

	public void joinClicked(String name, String IP, int port) {
		playerSelf = new Player(name);
		pickTeamPanel = new PickTeamPanel(this, playerSelf);
		main.join(IP, port);
	}

	public void doAttack(int i) {
		client.doAttack(playerSelf, playerEnemy, i);
	}

	public void changeUnimon(int uni) {
		client.selectUnimon(playerSelf, uni, true);
	}
	
	public void applyItem(int item) {
		client.applyItem(playerSelf, item);
	}

	public void updateInfo(Player self, Player enemy, String infoString) {
		fightGUI.updateInfo(self, enemy, infoString);
		System.out.println("Game window - updateInfo - unimon = "
				+ self.getActiveUnimon().getName() + ", enemy ="
				+ enemy.getActiveUnimon().getName());
	}

	public void showFightGUI() {
		setContentPane(fightGUI);
		System.out.println("show Fight Gui");
		wait.setVisible(false);
		fightGUI.setVisible(true);
		repaint();
	}

	public void turn() {
		fightGUI.turn();
	}

	public void waitOnPlayer() {
		fightGUI.waitOnPlayer();
	}

	public void teamPicked(Player p) {
		playerSelf = p;
		welcome.setVisible(false);
		setContentPane(wait);
		wait.setVisible(true);
		repaint();
		isTeamPicked = true;
		client.SetPlayer(p);
	}
}
