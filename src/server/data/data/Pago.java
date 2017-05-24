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
public class Pago implements Serializable
{
	String fecha;
	int cantidad;
	private List<Reproduccion> observers = new ArrayList<Reproduccion>();
	private int state;
	
	public Pago(String fecha, int cantidad) {
		super();
		this.fecha = fecha;
		this.cantidad = cantidad;
	}

	

	   public int getState() {
	      return state;
	   }

	   public void setState(int state) {
	      this.state = state;
	      notifyAllObservers();
	   }

	   public void attach(Reproduccion observer){
	      observers.add(observer);		
	   }

	   public void notifyAllObservers(){
	      for (Reproduccion observer : observers) {
	         observer.update();
	      }
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
