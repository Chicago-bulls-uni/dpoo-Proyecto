package models;

import java.sql.Date;
import java.util.ArrayList;


public class Escultura extends Pieza{
	
	private Dimensiones dimension;
	private ArrayList<String> materiales;  
	private String peso;
	private boolean necesitaelectricidad;

	public Escultura(int idPiezaP, String nombre, boolean bloqueadaP, Autor autorP,  int anioP, String lugarCreacionP,
			String tipoPiezaP, Dimensiones dimencionesP,Date fechaing, int pesoP, ArrayList<String> materialesP) {
		super(idPiezaP,nombre,tipoPiezaP, bloqueadaP, autorP, anioP, lugarCreacionP,fechaing );
		this.dimension=dimencionesP;
		this.setMateriales(materialesP);
		this.setPeso(pesoP);
		
	}

	
	

	
	public Dimensiones getDimension() {
		return dimension;
	}





	public ArrayList<String> getMateriales() {
		return materiales;
	}

	public void setMateriales(ArrayList<String> materiales) {
		this.materiales = materiales;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	

}
