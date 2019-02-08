package no.hvl.dat110.tcpexample.client;

import no.hvl.dat110.tcpexample.system.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EchoClient {

	public static void main(String[] args) {

		String server = Configuration.SERVER;
		int serverport = Configuration.SERVERPORT;
		int N = Configuration.N;
		
		if (args.length > 0) {
			
			// TODO: more checking on command line arguments preferred
			server = args[0];
			serverport = Integer.parseInt(args[1]);
			N = Integer.parseInt(args[2]);
		}
			
		TCPEchoClient tcpclient = new TCPEchoClient(server,serverport);

		System.out.println("TCP client started: " + server + " #" + " - " + N);
		
		for (int i = 0; i < N; i++) {

			JFrame frame = new JFrame("Converter");

			String text = JOptionPane.showInputDialog(frame, "Message to transform");

			if (text != null) {
				
				text = tcpclient.convert(text);
				JOptionPane.showMessageDialog(frame, text);
			}
			
		}
			
		System.out.println("TCP client stopped");
		
		System.exit(0);

	}
}
