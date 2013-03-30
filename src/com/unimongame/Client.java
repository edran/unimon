package com.unimongame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
	public  boolean isConnected = false;
	public boolean socketSetup = false;
	
	Client(String server, int port) {
		this.server = server;
		this.port = port;
	}
	
	public void run(){
		try {
			socket = new Socket(server, port);
			socketSetup = true;
			System.out.println("socket setup");
		} 
		// if it failed not much I can so
		catch(Exception ec) {
			System.out.println("Error connectiong to server:" + ec);
		}
		
		/* Creating both Data Stream */
		try
		{
			System.out.println("client try before streams");
			sInput  = new ObjectInputStream(socket.getInputStream());
			System.out.println("client try after InputStream");
			sOutput = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("client - streams setup");
		}
		catch (IOException eIO) {
			System.out.println("Exception creating new Input/output Streams: " + eIO);
		}
		
		try {
			System.out.print("trying to read, socket is connect?"+socket.isConnected());
			Object obj = sInput.readObject();
			System.out.println("message =" +obj.toString());
			//gameWindow.setTitle(msg.getMessageType().toString());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error in read()");
		}
		
		
	}
	
	public void sendPlayer(){
		
	}

	public void doAttack(Player playerSelf, Player playerEnemy, int i) {
		// TODO Auto-generated method stub
		
	}

	public void selectUnimon(Player playerSelf, Unimon uni, boolean b) {
		// TODO Auto-generated method stub
		
	}

}
