package no.hvl.dat110.tempsensor;

import java.util.Random;

public class TemperatureSensor {

	private static final int RANGE = 20;

	public int read() {

		/*
		 * long seconds = System.currentTimeMillis();
		 * //System.out.println("Time: "+seconds);
		 * 
		 * double temp = RANGE * Math.sin(seconds / 1000);
		 * 
		 * return (int) Math.ceil(temp);
		 */
		Random ran = new Random();
		
		return ran.nextInt(40);
	}
}
