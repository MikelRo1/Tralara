package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPagoF {
	
	public void gastos() throws RemoteException;
	public boolean checkPayment() throws RemoteException;

}
