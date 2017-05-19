package server.data.dto;

import java.io.Serializable;

public class PagoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	private String fecha;
	private float importe;
	
	public float getImporte() {
		return importe;
	}
	
	public void setImporte(float importe) {
		this.importe = importe;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {

		this.fecha = fecha;
	}
	
	
}


