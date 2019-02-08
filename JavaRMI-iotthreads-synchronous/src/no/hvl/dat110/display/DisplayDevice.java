package no.hvl.dat110.display;


import no.hvl.dat110.Backend.ServerImpl;
import no.hvl.dat110.Backend.ServerInterface;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DisplayDevice extends Thread {


    public void run() {

        System.out.println("Display started");
        try {
            Registry registry = LocateRegistry.getRegistry(9091);
            ServerInterface SI = (ServerInterface) registry.lookup("SI");

            while (true) {
                System.out.println("Current temperature is: " + SI.readTemp());

                System.out.println("DisplayDevice sleeping, be quiet please...");
                Thread.sleep(1000);
            }

        } catch (AccessException e) {
            System.out.println("AccessException in DisplayDevice");
            e.printStackTrace();
        } catch (RemoteException e) {
            System.out.println("RemoteException in DisplayDevice");
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.out.println("NotBoundException in DisplayDevice");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException in DisplayDevice");
            e.printStackTrace();
        }
    }
}
