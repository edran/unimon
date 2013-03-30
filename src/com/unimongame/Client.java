package com.unimongame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.unimongame.GUI.GameWindow;

public class Client {
	private String server;
	private int port;
	private Socket socket;
	private Player self;
	private Player enemy;
	private GameWindow gameWindow;
	private ObjectInputStream sInput;
	private ObjectOutputStream sOutput;
	
	Client(String server, int port) {
		this.server = server;
		this.port = port;
	}
	
	public void start(){
		try {
			socket = new Socket(server, port);
		} 
		// if it failed not much I can so
		catch(Exception ec) {
			System.out.println("Error connectiong to server:" + ec);
		}
		
		/* Creating both Data Stream */
		try
		{
			sInput  = new ObjectInputStream(socket.getInputStream());
			sOutput = new ObjectOutputStream(socket.getOutputStream());
		}
		catch (IOException eIO) {
			System.out.println("Exception creating new Input/output Streams: " + eIO);
		}
		
		
	}
	
	public void sendPlayer(){
		//gameWindow.;
	}

}
