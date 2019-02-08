package no.hvl.dat110.tempsensor;


import no.hvl.dat110.Backend.ServerImpl;
import no.hvl.dat110.Backend.ServerInterface;

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
            ServerInterface SI = (ServerImpl) registry.lookup("SI");


            while (true) {
                int temp = sn.read();

                ((ServerImpl) SI).saveTemp(temp);


                System.out.println("Server relaxing...");
                Thread.sleep(1000);
            }
        }catch (Exception e){
            System.out.println("Error in TemperatureDevice" + e.getMessage());
            e.printStackTrace();
        }


    }
}
