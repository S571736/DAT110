package no.hvl.dat110.Backend;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface{
    private static final long serialVersionUID = 1L;
    private static int temp;

    public ServerImpl() throws RemoteException{
        super();
        temp = 0;

    }

    @Override
    public int readTemp()throws RemoteException{

        return temp;
    }

    @Override
    public void saveTemp(int temp) throws RemoteException {
        ServerImpl.temp = temp;
    }


}
