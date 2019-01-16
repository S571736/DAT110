package no.hvl.dat110.threading;

public class IoTSystem {
    //Temperaturen kommer fra sensoren sin måling og via TD lagt inn i målingen
    //DD henter og temperaturen fra målingen
    //
    public static void main(String[] args) {

        System.out.println("System starting ... ");

        /*
        ArrayList<DisplayDevice> displays = new ArrayList<DisplayDevice>();
        ArrayList<TemperatureDevice> tempDevices = new ArrayList<TemperatureDevice>();
        */
        TemperatureMeasurement tm = new TemperatureMeasurement();

        TemperatureDevice tempdevice = new TemperatureDevice(tm);
        DisplayDevice disdevice = new DisplayDevice(tm);

        /*
        for (int i = 0; i < 3; i++) {
            DisplayDevice dd = new DisplayDevice(tm);
            displays.add(dd);
        }

        for (int i = 0; i < 3; i++) {
            TemperatureDevice td = new TemperatureDevice(tm);
            tempDevices.add(td);
        }
        */

        tempdevice.start();
        disdevice.start();


        /*
        for (DisplayDevice d : displays) {
            d.start();
        }
        for (TemperatureDevice t : tempDevices) {
            t.start();
        }
        */

        try {


            tempdevice.join();

            disdevice.join();

            /*
            for (TemperatureDevice t : tempDevices) {
                t.join();
            }
            for (DisplayDevice d : displays) {
                d.join();
            }
            */

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("System shutting ... ");

    }

}
