package com.unimongame;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {
	private ServerSocket serverSocket;
	private int port;
	private Battle battle;
	private Player[] players = new Player[2];
	private int numConnect = 0;
	private Socket[] sockets = new Socket[2];
	private ObjectInputStream[] inputStreams = new ObjectInputStream[2];
	private int playersReceived = 0;
	private ObjectOutputStream[] outputStreams = new ObjectOutputStream[2];
	private ListenerFromClient[] listeners = new ListenerFromClient[2];
	private int backgroundNumber;
	private int seed = (int) (Math.random() * 1000);
	private boolean endTurn = false;

	public Server(int port) {
		players[0] = null;
		players[1] = null;
		backgroundNumber = seed%4;
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("server - Server :couldnt connect to port");
		}
	}

	private void getConnections() {
		while (numConnect < 2) {
			try {

				Socket socket = serverSocket.accept();
				numConnect++;
				sockets[numConnect - 1] = socket;
				outputStreams[numConnect - 1] = new ObjectOutputStream(
						socket.getOutputStream());
				if (numConnect == 1) {
					outputStreams[numConnect - 1].writeObject(new Message(
							MessageType.WAITING_FOR_CONNECTION));
				}
				inputStreams[numConnect - 1] = new ObjectInputStream(
						socket.getInputStream());
				listeners[numConnect - 1] = new ListenerFromClient(
						numConnect - 1);
				new Thread(listeners[numConnect - 1]).start();

			} catch (IOException e) {
				System.out.println("Accept failed: on" + port);
			}
		}
		for (ObjectOutputStream out : outputStreams) {
			try {
				out.writeObject(new Message(MessageType.CONNECTED_SEND_PLAYERS));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void run() {
		getConnections();
	}

	public void sendBothPlayers() {
//		System.out.println("server : sendBothPlayers()");
		// for connection 0;

		Message msg = new Message(MessageType.SENDING_PLAYERS);
		//players[0].getActiveUnimon().modifyHp(-50);
		msg.setPlayers(setupPlayerArray(0));
		msg.setBackgroundNumber(backgroundNumber);
		try {
			outputStreams[0].writeObject(msg);
			outputStreams[0].flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg = new Message(MessageType.SENDING_PLAYERS);
		msg.setPlayers(setupPlayerArray(1));
		msg.setBackgroundNumber(backgroundNumber);
		try {
			outputStreams[1].writeObject(msg);
			outputStreams[1].flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private Player[] setupPlayerArray(int num){
		Player[] tempArr = new Player[2];
		tempArr[0] = players[num];
		tempArr[1] = players[(num+1)%2];
		return tempArr;
	}
	
	private void useItem(int item, int clientNumber) {
		battle.userItem(clientNumber,item);
	}

	public void doAttack(int attackNumber, int clientNumber){
		battle.doAttack(clientNumber,(clientNumber+1)%2,attackNumber);
//		System.out.println("Server doAttack - target Hp"+players[(clientNumber+1)%2].getActiveUnimon().getHp());
	}
	
	class ListenerFromClient extends Thread {

		public int clientNumber;

		ListenerFromClient(int num) {
			this.clientNumber = num;
		}

		public void run() {
			while (true) {
				try {
					Message msg = (Message) inputStreams[clientNumber]
							.readObject();
					switch (msg.getMessageType()) {
					case ATTACK_SELECTED:
						System.out.println("server - attack received");
						doAttack(msg.getAttack(),clientNumber);
						break;
					case ITEM_USED:
						useItem(msg.getItem(),clientNumber);
						break;
					case LEAVING_GAME:
						break;
					case SENDING_PLAYERS:
						System.out.println("server : clientNumber"
								+ clientNumber);
						setPlayers(msg.getPlayers()[0], clientNumber);
						break;
					case UNIMON_CHANGED:
						System.out.println("Unimon changed - msg endturn = "+msg.getEndTurn());
						battle.selectUnimon(players[clientNumber], msg.getSelectedUnimon(),msg.getEndTurn());
						break;
					default:
						break;
					}
				} catch (IOException e) {
					System.out.println("Client has close the connection: " + e);
					break;
				}
				// can't happen with a String object but need the catch anyhow
				catch (ClassNotFoundException e2) {
				}
			}
		}

	
	}

	private void setPlayers(Player player, int num) {
		players[num] = player;
//		System.out.println("setting" + player.getName());
		if (playersReceived++ == 1) {
			System.out.println("players in setPlayers server"
					+ players[0].getName() + "  " + players[1].getName());
			battle = new Battle(players[0], players[1], this);
			System.out.println("battle created");
			sendBothPlayers();
			battle.start();
		}
	}

	public void update(Player a, Player b,String infoString) {
		/*
		for(int i =0; i<2;i++){
			Message msg = new Message(MessageType.UPDATE);
			msg.setPlayers(setupPlayerArray(i));
			System.out.println("server msg.getPlayers...getHp() = "+msg.getPlayers()[0].getActiveUnimon().getHp());
			System.out.println("server msg.getPlayers...getHp() = "+msg.getPlayers()[1].getActiveUnimon().getHp());
			msg.setTurnMessage(infoString);
			try {
				outputStreams[i].writeObject(msg);
				System.out.println("after sending msg : "+msg.getPlayers()[0].getActiveUnimon().getHp());
				System.out.println("after sending msg : "+msg.getPlayers()[1].getActiveUnimon().getHp());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		Message msg = new Message(MessageType.UPDATE);
		Player[] arr = {a,b};
		msg.setPlayers(arr);
	
		msg.setTurnMessage(infoString);
		try {
			outputStreams[0].reset();
			outputStreams[0].writeObject(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Player[] arr2 ={b,a};
		msg.setPlayers(arr2);
		msg.setTurnMessage(infoString);
		try {
			outputStreams[1].reset();
			outputStreams[1].writeObject(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void startTurn(int playerNumber) {
//		System.out.println("server : startTurn()");
		// for connection 0;

		Message msg = new Message(MessageType.DO_TURN);
		try {
			outputStreams[playerNumber].writeObject(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg = new Message(MessageType.WAIT);
		try {
			outputStreams[(playerNumber + 1) % 2].writeObject(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void winner(int winner) {
		Message msg = new Message(MessageType.WINNER);
		try {
			outputStreams[winner].writeObject(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Message msg2 = new Message(MessageType.LOSER);
		try {
			outputStreams[(winner+1)%2].writeObject(msg2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void unimonDied(int playerNumber, String infoString){
		Message msg = new Message(MessageType.UNIMON_DIED);
		msg.setTurnMessage(infoString);
		try {
			outputStreams[playerNumber].writeObject(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
