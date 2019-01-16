package no.hvl.dat110.threading;

public class DisplayDevice extends Thread {

    private static final int COUNT = 10;
    private TemperatureMeasurement tm;

    public DisplayDevice(TemperatureMeasurement tm) {

        this.tm = tm;

    }

    public synchronized void run() {


        for (int i = 0; i < COUNT; i++) {
            synchronized (tm) {
                try {
                    tm.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int temp = tm.getTemperature();

            System.out.println("DISPLAY: " + temp);


            try {

                //Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        System.out.println("Display stopping ... ");

    }
}
