package server.data.data;


public class Lista 
{
	int idLista;
	String nombreLista;
	
	public Lista(int idLista, String nombreLista) {
		super();
		this.idLista = idLista;
		this.nombreLista = nombreLista;
	}

	public int getIdLista() {
		return idLista;
	}

	public void setIdLista(int idLista) {
		this.idLista = idLista;
	}

	public String getNombreLista() {
		return nombreLista;
	}

	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}
	
	
	
	

}
