package no.hvl.dat110.threading;

public class IoTSystem {

	public static void main(String[] args) {
		
		System.out.println("System starting ... ");
		
		TemperatureMeasurement tm = new TemperatureMeasurement();
		
		TemperatureDevice tempdevice = new TemperatureDevice(tm);
		DisplayDevice disdevice = new DisplayDevice(tm);
		
		tempdevice.start();
		disdevice.start();
		
		try {
			tempdevice.join();
			disdevice.join();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("System shutting ... ");	
		
	}

}
