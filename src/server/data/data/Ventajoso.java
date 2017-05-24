package server.data.data;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable="true")
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Ventajoso extends Pago{

	public Ventajoso(String fecha, int cantidad) {
		super(fecha, cantidad);
		// TODO Auto-generated constructor stub
	}

}
