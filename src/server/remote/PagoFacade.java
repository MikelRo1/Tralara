package server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PagoFacade extends UnicastRemoteObject implements IPagoF{

	protected PagoFacade() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void gastos() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkPayment() throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
