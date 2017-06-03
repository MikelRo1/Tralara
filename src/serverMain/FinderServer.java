package serverMain;

import java.rmi.Naming;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.List;

import server.jdo.dao.ClaseDAO;
import server.jdo.dao.IClaseDAO;
import server.remote.CancionFacade;
import server.remote.ICancionF;
import server.remote.IPagoF;
import server.remote.IUsuarioF;
import server.remote.PagoFacade;
import server.remote.UsuarioFacade;
import server.data.data.Cancion;
import server.data.data.Usuario;


public class FinderServer implements IFinder{

	private IClaseDAO daoC;

	private static final long serialVersionUID = 1L;
	public FinderServer()throws RemoteException {
		super();
		
		daoC = new ClaseDAO();
		Usuario usu = new Usuario ("ainhoa", "ainhoa", "elola", 222);
		daoC.storeUsuario(usu);
		daoC.getUsuarios();
		
		Cancion can = new Cancion (1, "kaixo", 3, "01/01/2016", 10, "aaaaaaaaaa");
		daoC.storeCancion(can);
		daoC.getCancion("kaixo");

	}
	
	@Override
	public List<Usuario> getUsuarios() throws RemoteException {
		// TODO Auto-generated method stub
		List<Usuario> usus = daoC.getUsuarios();
		System.out.println("Returning Usuarios to client ....");
		return usus;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		if (args.length != 5) {
			System.exit(0);
		}
	
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
	
		String nameCancion = "//" + args[0] + ":" + args[1] + "/" + args[3];
		String nameUsuario = "//" + args[0] + ":" + args[1] + "/" + args[2];
		String namePago = "//" + args[0] + ":" + args[1] + "/" + args[4];
	
		try {
			System.out.println("Servidor en marcha!");
			
			IFinder server = new FinderServer();
			
			ICancionF cancionService = new CancionFacade();			
			Naming.rebind(nameCancion, cancionService);
			System.out.println("* Cancion Facade '" + nameCancion + "' active and waiting...");
			
			IPagoF pagoService = new PagoFacade();			
			Naming.rebind(namePago, pagoService);
			System.out.println("* Pago Facade '" + namePago + "' active and waiting...");
			
			IUsuarioF usuService = new UsuarioFacade();	
			Naming.rebind(nameUsuario, usuService);
			System.out.println("* Usuario Facade '" + nameUsuario + "' active and waiting...");
			
			
			
		} catch (Exception e) {
			System.err.println("$ FinderServer exception: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
