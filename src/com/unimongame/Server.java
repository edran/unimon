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
	private ObjectOutputStream[] outputStreams = new ObjectOutputStream[2];
	private ListenerFromClient[] listeners = new ListenerFromClient[2]; 

	public Server(int port) {

		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("couldnt connect to port");
		}
	}

	private void getConnections(){
		while (numConnect < 2) {
			try {
				System.out.println("in numConnected <2 loop: numconnected = "
						+ numConnect);
				Socket socket = serverSocket.accept();
				numConnect++;
				sockets[numConnect-1] = socket;
				outputStreams[numConnect-1] = new ObjectOutputStream(socket.getOutputStream());
				if(numConnect == 1){
					outputStreams[numConnect-1].writeObject(new Message(MessageType.WAITING_FOR_CONNECTION));
				}
				inputStreams[numConnect-1] = new ObjectInputStream(socket.getInputStream());
				listeners[numConnect-1] = new ListenerFromClient(numConnect-1);
				new Thread(listeners[numConnect-1]).start();
				System.out.println("wait message sent to"+socket.getInetAddress());
			} catch (IOException e) {
				System.out.println("Accept failed: on" + port);
			}
		}
		for(ObjectOutputStream out : outputStreams){
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
	
	class ListenerFromClient extends Thread {

		public int clientNumber;
		ListenerFromClient(int num){
			this.clientNumber = num;
		}
		public void run() {
			while (true) {
				try {
					Message msg = (Message) inputStreams[clientNumber].readObject();
					switch(msg.getMessageType()){
					case ATTACK_SELECTED:
						
						break;
					case DO_TURN:
						break;
					case ITEM_USED:
						break;
					case LEAVING_GAME:
						break;
					case SENDING_PLAYERS:
						setPlayers(msg.getPlayers().get(0),clientNumber);
						break;
					case UNIMON_CHANGED:
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
		System.out.println("setting"+player.getName());
		if(players[0]!=null&&players[1]!=null){
		battle = new Battle(players[0],players[1],this);
		}
		
	}

	


}
