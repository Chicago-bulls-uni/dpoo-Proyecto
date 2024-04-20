package models;

import java.util.ArrayList;


public class Escultura extends Pieza{
	
	private Dimensiones dimenciones;
	private ArrayList<String> materiales;  
	private int peso;

	public Escultura(int idPiezaP, boolean bloqueadaP, Autor autorP, String tituloP, int anioP, String lugarCreacionP,
			String tipoPiezaP, Dimensiones dimencionesP, int pesoP, ArrayList<String> materialesP) {
		super(idPiezaP, bloqueadaP, autorP, tituloP, anioP, lugarCreacionP, tipoPiezaP );
		this.dimenciones= dimencionesP;
		this.setMateriales(materialesP);
		this.setPeso(pesoP);
		
	}

	public Dimensiones getDimenciones() {
		return dimenciones;
	}

	public void setDimenciones(Dimensiones dimenciones) {
		this.dimenciones = dimenciones;
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
