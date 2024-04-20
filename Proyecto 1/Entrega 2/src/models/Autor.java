package models;

public class Autor {
	
	private int idAutor;
	private String nombre;
	private boolean esColectivo;
	
	public Autor (int id , String nombreP, boolean esColectivoP) {
		
		this.idAutor= id;
		this.nombre= nombreP;
		this.esColectivo= esColectivoP;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isEsColectivo() {
		return esColectivo;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEsColectivo(boolean esColectivo) {
		this.esColectivo = esColectivo;
	}
	
	
	
}