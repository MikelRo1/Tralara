package server.servers;

public class GatewayPayPal implements IPago{

	@Override
	public void pay(long accountNumber, double amount) {
		// TODO Auto-generated method stub
		
		//comprobar en el servidor externo que el nº de cuenta es correcto
		//guardar en la BD el nº de cuenta junto con el importe
	}

}
