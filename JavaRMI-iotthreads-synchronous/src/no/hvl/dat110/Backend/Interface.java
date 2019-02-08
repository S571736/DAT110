package no.hvl.dat110.Backend;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
    int readTemp() throws RemoteException;
    void sendTemp() throws RemoteException;
}
