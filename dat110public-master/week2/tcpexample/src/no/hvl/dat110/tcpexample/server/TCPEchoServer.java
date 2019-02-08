package no.hvl.dat110.tcpexample.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer {

	private ServerSocket welcomeSocket;
	
	public TCPEchoServer(ServerSocket welcomeSocket) {
		this.welcomeSocket = welcomeSocket;
	}
	
	public void process() {
		
		try {
		
			System.out.println("SERVER ACCEPTING");
			
			Socket connectionSocket = welcomeSocket.accept();

			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream()));
			
			DataOutputStream outToClient = 
					new DataOutputStream(connectionSocket.getOutputStream());

			String text = inFromClient.readLine();
			
			System.out.println("SERVER RECEIVED: " + text);
			
			String outtext = text.toUpperCase(); 
			
			System.out.println("SERVER SENDING: " + outtext);
			
			outToClient.write(outtext.getBytes());
			outToClient.flush();
			
			outToClient.close();
			inFromClient.close();
			
			connectionSocket.close();
			
		} catch (IOException ex) {
			
			System.out.println("TCPServer: " + ex.getMessage());
			ex.printStackTrace();
			System.exit(1);
			
		}
	}
}
