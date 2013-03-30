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
				System.out.println("wait message sent to"+socket.getInetAddress());
			} catch (IOException e) {
				System.out.println("Accept failed: on" + port);
			}
		}
		for(ObjectOutputStream out : outputStreams){
			try {
				out.writeObject(new Message(MessageType.DO_TURN));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void run() {
		getConnections();
	}


}
