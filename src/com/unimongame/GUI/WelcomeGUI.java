package com.unimongame.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.*;

public class WelcomeGUI extends JPanel implements ActionListener {

	private ImagePanel unimon;
	private JLabel welcome, credits, date;
	private JButton local, host, join, help;
	private JLabel enterName;
	private JTextField name, hostPort, joinIP, joinPort;
	private JComboBox hostIP;
	private GameWindow window;
	private Image img;
	private ArrayList<String> myIP = new ArrayList<String>();
	private String username;
	private HelpGUI helpGUI;

	public WelcomeGUI(GameWindow window) {
		setLayout(null);
		setSize(500, 500);
		setLocation(0, 23);
		setVisible(true);
		this.window = window;

		this.requestFocus();

		
		// My IP
//		try {
//			myIP = Inet4Address.getLocalHost().getHostAddress();
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		Enumeration e = null;
		try {
			e = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        while(e.hasMoreElements())
        {
            NetworkInterface n=(NetworkInterface) e.nextElement();
            Enumeration ee = n.getInetAddresses();
            while(ee.hasMoreElements())
            {
                InetAddress i = (InetAddress) ee.nextElement();
                if (i instanceof Inet4Address) myIP.add(i.getHostAddress());
                
            }
        }

		// ImagePanel
		img = new ImageIcon("resources/img/UnimonLogo2.png").getImage();
		unimon = new ImagePanel(img);
		unimon.setSize(450, 156);
		unimon.setLocation(25, 20);
		add(unimon);

		// JTextArea
		welcome = new JLabel("Welcome to the unimon game !");
		welcome.setSize(400, 20);
		welcome.setLocation(50, 190);
		welcome.setHorizontalAlignment(0);
		add(welcome);

		// Name of the player
		enterName = new JLabel("Name:");
		enterName.setSize(50, 30);
		enterName.setLocation(100, 220);
		add(enterName);

		name = new JTextField("");
		name.setSize(240, 30);
		name.setLocation(160, 220);
		name.setHorizontalAlignment(SwingConstants.LEFT);
		add(name);

		// Buttons
		local = new JButton("Play on one computer");
		local.setSize(300, 30);
		local.setLocation(100, 260);
		local.addActionListener(this);
		add(local);

		host = new JButton("Host");
		host.setSize(90, 30);
		host.setLocation(100, 300);
		host.addActionListener(this);
		add(host);

		join = new JButton("Join");
		join.setSize(90, 30);
		join.setLocation(100, 340);
		join.addActionListener(this);
		add(join);

		help = new JButton("Help");
		help.setSize(300, 30);
		help.setLocation(100, 380);
		help.addActionListener(this);
		add(help);

		// JTextField
		hostIP = new JComboBox(myIP.toArray());
		hostIP.setSize(150, 30);
		hostIP.setLocation(200, 300);
		hostIP.setEditable(false);
		add(hostIP);

		hostPort = new JTextField("1234", 5);
		hostPort.setSize(40, 30);
		hostPort.setLocation(360, 300);
		hostPort.setHorizontalAlignment(0);
		hostPort.setEditable(true);
		add(hostPort);

		joinIP = new JTextField("", 15);
		joinIP.setSize(150, 30);
		joinIP.setLocation(200, 340);
		joinIP.setHorizontalAlignment(0);
		joinIP.setEditable(true);
		add(joinIP);

		joinPort = new JTextField("1234", 5);
		joinPort.setSize(40, 30);
		joinPort.setLocation(360, 340);
		joinPort.setHorizontalAlignment(0);
		joinPort.setEditable(true);
		add(joinPort);

		credits = new JLabel(
				"<html><div style=\"text-align:center;\">By Caterina Brandani, Basile Henry, "
						+ "Joseph Kennelly,<br>Nantas Nardelli and Luke McAuley</div><html>");
		credits.setSize(500, 50);
		credits.setLocation(0, 430);
		credits.setHorizontalAlignment(0);
		add(credits);

		date = new JLabel("Inf1-OOP - 2013., GPLv2");
		date.setLocation(200, 480);
		date.setSize(100, 20);
		add(date);

	}

	public String getUsername() {
		if (name.getText().trim().equals("")) {
			username = "Anonymous";
		} else {
			username = name.getText().trim();
		}
		return username;
	}

	public int getHostPort() {

		int x = 1234;

		try {
			x = Integer.parseInt(hostPort.getText().trim());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Port not a valid number. Using port " + x);
		}
		return x;
	}
	
	public int getJoinPort() {

		int x = 1234;

		try {
			x = Integer.parseInt(joinPort.getText().trim());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Port not a valid number. Using port " + x);
		}
		return x;
	}
		
	public String getJoinIP() {
		
		return joinIP.getText().trim();		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==local){
			
			//window.startClicked(getUsername());

		} else if(e.getSource()==host){
		
			window.hostClicked(getUsername(), getHostPort());

		} else if(e.getSource()==join){
		
			window.joinClicked(getUsername(), getJoinIP(), getJoinPort());
			
		} else if(e.getSource()==help){
			window.helpClicked();
		}
	}

	public void setMessage(String msg) {
		welcome.setText(msg);
		welcome.repaint();
		
	}

}