package server.data.data;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable="true")
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Comun extends Pago
{

	public Comun(String fecha, int cantidad) {
		super(fecha, cantidad);
		// TODO Auto-generated constructor stub
	}
	

}
