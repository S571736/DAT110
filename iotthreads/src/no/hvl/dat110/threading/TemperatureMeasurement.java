package no.hvl.dat110.threading;

public class TemperatureMeasurement {

    private int temp = 0;

    public synchronized int getTemperature() {

        return temp;
    }

    public synchronized void setTemperature(int temp) {
        this.temp = temp;
        //notifyAll();
    }


}
