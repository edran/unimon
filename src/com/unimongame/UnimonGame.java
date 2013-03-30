package com.unimongame;
import com.unimongame.GUI.GameWindow;


public class UnimonGame {
	private Server server;
	private Thread serverThread;
	private Client client;
	private Thread clientThread;
	private GameWindow window;

	public void run(){
		window = new GameWindow(this);
		
	}

	public void host(int port) {
	
		server = new Server(port);
		serverThread = new Thread(server);
		serverThread.start();
		
		System.out.println("starting server");
		
		join("localhost",port);
	}

	public void join(String iP, int port) {
		client = new Client(iP, port,window);
		clientThread = new Thread(client);
		clientThread.start();
	}
	
	
	
	
}
