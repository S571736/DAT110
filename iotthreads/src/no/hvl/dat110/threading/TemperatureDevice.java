package no.hvl.dat110.threading;

public class TemperatureDevice extends Thread {

    private static final int COUNT = 10;
    private TemperatureMeasurement tm;
    private TemperatureSensor sn;

    public TemperatureDevice(TemperatureMeasurement tm) {
        this.tm = tm;
        this.sn = new TemperatureSensor();
    }

    public synchronized void run() {

        System.out.println("temperature device started");

        for (int i = 0; i < COUNT; i++) {

            int temp = sn.read();

            System.out.println("READING: " + temp);

            tm.setTemperature(temp);
            synchronized (tm) {
                tm.notify();
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        System.out.println("Temperature device stopping ... ");

    }
}
