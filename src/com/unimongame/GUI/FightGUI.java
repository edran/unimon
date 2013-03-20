import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

public class FightGUI  implements ActionListener {

	//Declaring a few variables

	JPanel enemyPanel, playerPanel, menuPanel, textPanel, attackPanel, bagPanel, unimonsPanel;

	JPanel tempPanel = new JPanel();

	JLabel enemyUniName, playerUniName, textLabel;
	JButton attack1, attack2, attack3, attack4, attack, bag, unimons, abandon;

	String story = "Welcome to the game.\nPrepare for battle!";


	public JPanel createFightPanel() {

	//Bottom JPanel to place everything on.
	JPanel totalGUI = new JPanel();
	totalGUI.setLayout(null);

	//Panels
	enemyPanel = new JPanel();
	enemyPanel.setLayout(null);
	enemyPanel.setLocation(0,0);
	enemyPanel.setSize(500,200);
	enemyPanel.setBackground(Color.RED);
	totalGUI.add(enemyPanel);

	playerPanel = new JPanel();
	playerPanel.setLayout(null);
	playerPanel.setLocation(0,200);
	playerPanel.setSize(500,200);
	playerPanel.setBackground(Color.BLUE);
	totalGUI.add(playerPanel);

	menuPanel = new JPanel();
	menuPanel.setLayout(null);
	menuPanel.setLocation(300,400);
	menuPanel.setSize(200,100);
	totalGUI.add(menuPanel);

	totalGUI.add(tempPanel);

	textPanel = new JPanel();
	textPanel.setLayout(null);
	textPanel.setLocation(0,400);
	textPanel.setSize(300,100);

	attackPanel = new JPanel();
	attackPanel.setLayout(null);
	attackPanel.setLocation(0,400);
	attackPanel.setSize(300,100);

	bagPanel = new JPanel();
	bagPanel.setLayout(null);
	bagPanel.setLocation(0,400);
	bagPanel.setSize(300,100);

	unimonsPanel = new JPanel();
	unimonsPanel.setLayout(null);
	unimonsPanel.setLocation(0,400);
	unimonsPanel.setSize(300,100);

	//Labels
	enemyUniName = new JLabel("<insert Unimon name for enemy>");
	enemyUniName.setLocation(0,0);
	enemyUniName.setSize(250,30);
	enemyUniName.setHorizontalAlignment(0);
	enemyPanel.add(enemyUniName);

	playerUniName = new JLabel("<insert Unimon name for player>");
	playerUniName.setLocation(250,0);
	playerUniName.setSize(250,30);
	playerUniName.setHorizontalAlignment(0);
	playerPanel.add(playerUniName);

	textLabel = new JLabel(story);
	textLabel.setHorizontalAlignment(0);
	textLabel.setLocation(0,0);
	textLabel.setSize(300,100);
	textPanel.add(textLabel);

	//Buttons
	attack1 = new JButton("attack 1");
	attack1.setLocation(0,0);
	attack1.setSize(150,50);
	attackPanel.add(attack1);

	attack2 = new JButton("attack 2");
	attack2.setLocation(150,0);
	attack2.setSize(150,50);
	attackPanel.add(attack2);

	attack3 = new JButton("attack 3");
	attack3.setLocation(0,50);
	attack3.setSize(150,50);
	attackPanel.add(attack3);

	attack4 = new JButton("attack 4");
	attack4.setLocation(150,50);
	attack4.setSize(150,50);
	attackPanel.add(attack4);

	attack = new JButton("Attack");
	attack.setLocation(0,0);
	attack.setSize(100,50);
	attack.setBackground(Color.lightGray);
	attack.setForeground(Color.darkGray);
	attack.addActionListener(this);
	menuPanel.add(attack);

	bag = new JButton("Bag");
	bag.setLocation(100,0);
	bag.setSize(100,50);
	bag.setBackground(Color.lightGray);
	bag.setForeground(Color.darkGray);
	bag.addActionListener(this);
	menuPanel.add(bag);

	unimons = new JButton("Unimons");
	unimons.setLocation(0,50);
	unimons.setSize(100,50);
	unimons.setBackground(Color.lightGray);
	unimons.setForeground(Color.darkGray);
	unimons.addActionListener(this);
	menuPanel.add(unimons);

	abandon = new JButton("Abandon");
	abandon.setLocation(100,50);
	abandon.setSize(100,50);
	abandon.setBackground(Color.lightGray);
	abandon.setForeground(Color.darkGray);
	abandon.addActionListener(this);
	menuPanel.add(abandon);
	

	return totalGUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == attack) {
		tempPanel = attackPanel;
		} else if (e.getSource() == bag) {
		tempPanel = bagPanel;
		} else if (e.getSource() == unimons) {
		tempPanel = unimonsPanel;
		}
	}

	public static void createAndShowGUI() {

	JFrame.setDefaultLookAndFeelDecorated(true); //Unified look, independent of the OS.
	JFrame frame= new JFrame("Unimon Game");

	//Create and set up the content pane.
	FightGUI setup = new FightGUI();
	frame.setContentPane(setup.createFightPanel());

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(500, 530);
	frame.setResizable(false); //Only one size!
	frame.setVisible(true);
	}

	public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable(){
		public void run() {
			createAndShowGUI();
		}
	});
	}

}
