package no.hvl.dat110.tempsensor;


import no.hvl.dat110.simulation.IoTSystem;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TemperatureDevice extends Thread {

	private TemperatureSensor sn;
	
	public TemperatureDevice() {
		this.sn = new TemperatureSensor();
	}
	
	public void run() {
		
		System.out.println("temperature device started");
		try {
			Registry registry = LocateRegistry.getRegistry(9091);
			sn = (TemperatureSensor) registry.lookup("TemperatureSensor");


		} catch (Exception e) {
			System.err.println("Error in TemperatureDevice " + e.getMessage());
			e.getStackTrace();
		}


		throw new RuntimeException("RPC TemperatureDevice Client not yet implemented...");
		
	}
}
