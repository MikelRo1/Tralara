package server.data.data;


public class Artista 
{
	int idArtista;
	String nombreArtista;
	String paisArtista;
	int edadArtista;
	
	public Artista(int idArtista, String nombreArtista, String paisArtista,
			int edadArtista) {
		super();
		this.idArtista = idArtista;
		this.nombreArtista = nombreArtista;
		this.paisArtista = paisArtista;
		this.edadArtista = edadArtista;
	}

	public int getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}

	public String getNombreArtista() {
		return nombreArtista;
	}

	public void setNombreArtista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
	}

	public String getPaisArtista() {
		return paisArtista;
	}

	public void setPaisArtista(String paisArtista) {
		this.paisArtista = paisArtista;
	}

	public int getEdadArtista() {
		return edadArtista;
	}

	public void setEdadArtista(int edadArtista) {
		this.edadArtista = edadArtista;
	}
	
	
	
	
	
}
