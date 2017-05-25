package server.data.data;

//import javax.jdo.annotations.PersistenceCapable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

/*
 * Part 2 (RMI) Remember that in order to transfer objects they must have a special feature
 */


@PersistenceCapable(detachable="true")
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Pago
{
	String fecha;
	int cantidad;
	
	
	public Pago(String fecha, int cantidad) {
		super();
		this.fecha = fecha;
		this.cantidad = cantidad;
	}

	
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	

}
