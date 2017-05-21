package server.data.data;

import java.io.Serializable;

public class Cancion implements Serializable
{
	int idCancion;
	String tituloCancion;
	float duracionCancion;
	String fechalanzamientoCancion;
	int preciodiaCancion;
	String letraCancion;
	
	public Cancion(int idCancion, String tituloCancion, float duracionCancion,
			String fechalanzamientoCancion, int preciodiaCancion,
			String letraCancion) {
		super();
		this.idCancion = idCancion;
		this.tituloCancion = tituloCancion;
		this.duracionCancion = duracionCancion;
		this.fechalanzamientoCancion = fechalanzamientoCancion;
		this.preciodiaCancion = preciodiaCancion;
		this.letraCancion = letraCancion;
	}

	public int getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}

	public String getTituloCancion() {
		return tituloCancion;
	}

	public void setTituloCancion(String tituloCancion) {
		this.tituloCancion = tituloCancion;
	}

	public float getDuracionCancion() {
		return duracionCancion;
	}

	public void setDuracionCancion(float duracionCancion) {
		this.duracionCancion = duracionCancion;
	}

	public String getFechalanzamientoCancion() {
		return fechalanzamientoCancion;
	}

	public void setFechalanzamientoCancion(String fechalanzamientoCancion) {
		this.fechalanzamientoCancion = fechalanzamientoCancion;
	}

	public int getPreciodiaCancion() {
		return preciodiaCancion;
	}

	public void setPreciodiaCancion(int preciodiaCancion) {
		this.preciodiaCancion = preciodiaCancion;
	}

	public String getLetraCancion() {
		return letraCancion;
	}

	public void setLetraCancion(String letraCancion) {
		this.letraCancion = letraCancion;
	}
	
	
	
	

}
