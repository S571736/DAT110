package no.hvl.dat110.udpexample;

import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EchoClient {

	public static void main(String[] args) throws SocketException, UnknownHostException {

		String server = Configuration.SERVER;
		int serverport = Configuration.SERVERPORT;
		int N = Configuration.N;
		
		if (args.length > 0) {
			
			// TODO: more checking on command line arguments preferred
			server = args[0];
			serverport = Integer.parseInt(args[1]);
			N = Integer.parseInt(args[2]);
		}

		UDPEchoClient udpclient = new UDPEchoClient(server, serverport);

		System.out.println("UDP client started");
		
		for (int i = 0; i < N; i++) {

			JFrame frame = new JFrame("Converter");

			String text = JOptionPane.showInputDialog(frame, "Message to transform");

			if (text != null) {
				
				text = udpclient.convert(text);
				JOptionPane.showMessageDialog(frame, text);
			}
			
		}
		
		udpclient.stop();
		
		System.out.println("UDP client stopped");

		System.exit(0);
	}
}
