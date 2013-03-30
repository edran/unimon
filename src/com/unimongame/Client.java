package com.unimongame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.unimongame.GUI.GameWindow;

public class Client implements Runnable {
	private String server;
	private int port;
	private Socket socket;
	private Player self;
	private GameWindow gameWindow;
	private ObjectInputStream sInput;
	private ObjectOutputStream sOutput;
	private ListenFromServer listener;
	public boolean isConnected = false;


	Client(String server, int port, GameWindow window) {
		this.gameWindow = window;
		this.server = server;
		this.port = port;
	}
	
	public void SetPlayer(Player p){
		self = p;
	}

	public void run() {
		try {
			socket = new Socket(server, port);
		}
		// if it failed not much I can so
		catch (Exception ec) {
			System.out.println("Error connectiong to server:" + ec);
		}

		/* Creating both Data Stream */
		try {
			System.out.println("client try before streams");
			sInput = new ObjectInputStream(socket.getInputStream());
			System.out.println("client try after InputStream");
			sOutput = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("client - streams setup");
		} catch (IOException eIO) {
			System.out.println("Exception creating new Input/output Streams: "
					+ eIO);
		}

		listener = new ListenFromServer();
		new Thread(listener).start();


	}

	public void setUpFightGUI(Player[] players){
		System.out.println("**************"+players[0].getName());
		System.out.println("**************"+players[1].getName());
		gameWindow.setPlayers(players[0],players[1]);
		gameWindow.showFightGUI();
	}
	
	public void sendPlayer() {
		while(!gameWindow.isTeamPicked){
			System.out.println("waiting");
		}
		System.out.println("client - sendPlayer : waiting is over");
		Message msg = new Message(MessageType.SENDING_PLAYERS);
		
		Player[]players = new Player[2];
		players[0] = self;
		players[1] = null;
		msg.setPlayers(players);
		System.out.println("client sendPlayer method- message before send"+msg.getPlayers()[0].getActiveUnimon());
		try {
			sOutput.writeObject(msg);
			System.out.println("client - sendPlayer() : "+msg.getMessageType()+" Sent");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("send player failed : in client");
		}
	}

	public void doAttack(Player playerSelf, Player playerEnemy, int i) {
		// TODO Auto-generated method stub

	}

	public void selectUnimon(Player playerSelf, Unimon uni, boolean b) {
		// TODO Auto-generated method stub

	}

	class ListenFromServer extends Thread {

		public void run() {
			while (true) {
				try {
					Message msg = (Message) sInput.readObject();
					System.out.println("client - run : msg type = "+msg.getMessageType());
					switch (msg.getMessageType()) {
					case WAITING_FOR_CONNECTION:
						gameWindow.setMessage("wait for an opponet to connect! ");
						break;
					case CONNECTED_SEND_PLAYERS:
						System.out.println("client - run() : CONNECTED_SEND_PLAYERS ");
						sendPlayer();
						break;
					case SENDING_PLAYERS:
						System.out.println("client - run : players recieved");
						System.out.println("client - run : msg "+msg.getTurnMessage());
						System.out.println("client - run : msg .getPlayers(0)"+msg.getPlayers()[0].getName());
						System.out.println("client - run : msg.getPlayers(0) "+msg.getPlayers()[1].getName());
						setUpFightGUI(msg.getPlayers());
					default:
						break;//starts chain which launch fightGUI
					}
					
				} catch (IOException e) {
					System.out.println("Server has close the connection: " + e);
					break;
				}
				// can't happen with a String object but need the catch anyhow
				catch (ClassNotFoundException e2) {
				}
			}
		}
	}

}
