package com.unimongame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;
	private int port;
	private Battle battle;
	private int numConnect =0;
	private Socket[] sockets = new Socket[2];
	private InputStream[] inputStreams = new InputStream[2];
	private OutputStream[] outputStreams = new OutputStream[2];
	
	public Server(int port){
		
	try {
		serverSocket = new ServerSocket(port);
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println("couldnt connect to port");
	}	
	}
	public void start(){
	while(numConnect <2){
		try {
			 Socket socket  = serverSocket.accept();
			 sockets[numConnect] = socket;
			 inputStreams[numConnect] = socket.getInputStream();
			 outputStreams[numConnect] =socket.getOutputStream();
		} 
		catch (IOException e) {
			System.out.println("Accept failed: on"+port);
		}
	}
	
	
	}
}
