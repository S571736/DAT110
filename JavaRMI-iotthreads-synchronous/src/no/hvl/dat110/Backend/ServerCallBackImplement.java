package no.hvl.dat110.Backend;

import no.hvl.dat110.CallBackInterface.ClientCallBackInterface;
import no.hvl.dat110.CallBackInterface.ServerCallBackInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerCallBackImplement extends UnicastRemoteObject implements ServerCallBackInterface {

    private static final long serialVersionUID = 1L;
    private ClientCallBackInterface clientCallBackObj;
    private static int temp;

    protected ServerCallBackImplement() throws RemoteException {
        super();
    }


    @Override
    public void registerClientCallbackObject(ClientCallBackInterface clientCallBackObj) throws RemoteException {
        this.clientCallBackObj = clientCallBackObj;

        clientCallBackObj.acknowledge("From server: Message recieved!");
    }


}
