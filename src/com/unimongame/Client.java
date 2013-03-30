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
	private Player enemy;
	private GameWindow gameWindow;
	private ObjectInputStream sInput;
	private ObjectOutputStream sOutput;
	private ListenFromServer listener;
	public boolean isConnected = false;
	public boolean socketSetup = false;

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
			gameWindow.setTitle("Unimon Game - Hosted On"+socket.getInetAddress());
			socketSetup = true;
			System.out.println("socket setup");
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

		// try {
		// System.out.print("trying to read, socket is connect?"+socket.isConnected());
		// Object obj = sInput.readObject();
		// System.out.println("message =" +obj.toString());
		// //gameWindow.setTitle(msg.getMessageType().toString());
		// } catch (IOException | ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// System.out.println("error in read()");
		// }

	}

	public void sendPlayer() {
		while(!gameWindow.isTeamPicked){
			//wait till team is picked
		}
		Message msg = new Message(MessageType.SENDING_PLAYERS);
		ArrayList<Player> list = new ArrayList<Player>();
		list.add(self);
		msg.setPlayers(list);
		try {
			sOutput.writeObject(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
					System.out.println(msg.getMessageType());
					switch (msg.getMessageType()) {
					case WAITING_FOR_CONNECTION:
						gameWindow.setMessage("wait for an opponet to connect! ");
						break;
					case CONNECTED_SEND_PLAYERS:
						System.out.println("send player");
						sendPlayer();
						break;
					default:
						break;
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