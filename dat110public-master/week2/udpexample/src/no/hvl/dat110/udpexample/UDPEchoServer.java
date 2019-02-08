package no.hvl.dat110.udpexample;

import java.io.*;
import java.net.*;

public class UDPEchoServer {

	private DatagramSocket serverSocket;

	public UDPEchoServer(int serverport) throws SocketException {

		serverSocket = new DatagramSocket(serverport);
	}

	public void process() {

		byte[] recvbuf = new byte[Configuration.MAXTEXTLEN];

		DatagramPacket request = new DatagramPacket(recvbuf, recvbuf.length);

		try {

			serverSocket.receive(request);
			String text = new String(request.getData());
			
			System.out.println("SERVER RECEIVED: " + text);

			String outtext = text.toUpperCase();
			
			byte[] sendmessage = outtext.getBytes();
		
			InetAddress ipaddress = request.getAddress();
			int port = request.getPort();

			DatagramPacket response = new DatagramPacket(sendmessage, sendmessage.length, ipaddress, port);

			System.out.println("SERVER SENDING:  " + outtext);

			serverSocket.send(response);

		} catch (IOException ex) {
			
			System.out.println("UDPServer: " + ex.getMessage());
			ex.printStackTrace();
			
		} 
	}

	public void stop() {

		if (serverSocket != null) {
			serverSocket.close();
		}

	}
}
