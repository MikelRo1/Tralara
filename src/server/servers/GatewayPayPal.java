package server.servers;

public class GatewayPayPal implements IPago{

	@Override
	public void pay(long accountNumber, double amount) {
		// TODO Auto-generated method stub
		
		//comprobar en el servidor externo que el n� de cuenta es correcto
		//guardar en la BD el n� de cuenta junto con el importe
	}

}
