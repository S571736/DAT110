package no.hvl.dat110.threading;

public class DisplayDevice extends Thread {

	private TemperatureMeasurement tm;
	
	private static final int COUNT = 10;
	
	public DisplayDevice (TemperatureMeasurement tm) {
	
		this.tm = tm;
		
	}	
	
	public void run() {
		
		System.out.println("Display started");	
		
		for (int i = 0; i<COUNT;i++) {
			
			int temp = tm.getTemperature();
			
			System.out.println("DISPLAY: " + temp);
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Display stopping ... ");
		
	}
}
