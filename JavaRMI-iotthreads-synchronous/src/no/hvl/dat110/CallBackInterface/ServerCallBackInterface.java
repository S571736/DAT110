package no.hvl.dat110.CallBackInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerCallBackInterface extends Remote {

    public static final String SERVER_INAME = "ServerCallbackInterface";

    public void registerClientCallbackObject(ClientCallBackInterface clientCallBackObj) throws RemoteException;

    /*
    public void doOperation() throws RemoteException;
    */
}
