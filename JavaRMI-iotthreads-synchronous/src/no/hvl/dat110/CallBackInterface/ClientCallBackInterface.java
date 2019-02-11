package no.hvl.dat110.CallBackInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBackInterface extends Remote {

    public void notify(String result) throws RemoteException;

    public boolean isNotified() throws RemoteException;

    public void acknowledge(String msg) throws RemoteException;

}
