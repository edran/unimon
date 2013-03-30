package com.unimongame;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private ServerSocket serverSocket;
	private int port;
	private Battle battle;
	private Player[] players = new Player[2];
	private int numConnect =0;
	private Socket[] sockets = new Socket[2];
	private ObjectInputStream[] inputStreams = new ObjectInputStream[2];
	private ObjectOutputStream[] outputStreams = new ObjectOutputStream[2];
	
	public Server(int port){
		
	try {
		serverSocket = new ServerSocket(port);
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println("couldnt connect to port");
	}	
	}
	@SuppressWarnings("unchecked")
	public void start(){
	while(numConnect <2){
		try {
			 Socket socket  = serverSocket.accept();
			 sockets[numConnect] = socket;
			 inputStreams[numConnect] = new ObjectInputStream(socket.getInputStream());
			 outputStreams[numConnect] = new ObjectOutputStream(socket.getOutputStream());
			 outputStreams[numConnect].writeObject(new Message(MessageType.WAITING_FOR_CONNECTION));
		} 
		catch (IOException e) {
			System.out.println("Accept failed: on"+port);
		}
	}
		
	
		try {
			players[0] = ((ArrayList<Player>)inputStreams[0].readObject()).get(0);
			players[1] = ((ArrayList<Player>)inputStreams[1].readObject()).get(0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Player p:players){
			System.out.println("player = "+p.getName());
		}
	
	
	}
}
