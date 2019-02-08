package no.hvl.dat110.Backend;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
    int readTemp() throws RemoteException;
    void saveTemp(int temp) throws RemoteException;
}
