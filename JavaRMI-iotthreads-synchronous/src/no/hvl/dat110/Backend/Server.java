package no.hvl.dat110.Backend;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(9091);
            ServerInterface IT = new ServerImpl();

            registry.bind("SI", IT);
            System.out.println("Server is up and running...");
        } catch (RemoteException e) {
            System.out.println("RemoteException" + e.getMessage());
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
