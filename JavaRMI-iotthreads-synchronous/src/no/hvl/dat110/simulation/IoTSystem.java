package no.hvl.dat110.simulation;

import no.hvl.dat110.display.DisplayDevice;
import no.hvl.dat110.tempsensor.TemperatureDevice;

public class IoTSystem {

	public static void main(String[] args) {
		
		System.out.println("System starting ... ");
		
		TemperatureDevice tempdevice = new TemperatureDevice();
		DisplayDevice display = new DisplayDevice();
		
		tempdevice.start();
		display.start();
		try {
			tempdevice.join();
			display.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("System shutting ... ");	
		
	}

}
