package models;

import java.util.Date;

import enums.TecnicaPintura;

public class Pintura extends Pieza{
	
	private TecnicaPintura tecnicaPintura;
	private Dimensiones dimension;
	

	public Pintura(int idPiezaP, String nombre, boolean bloqueadaP, Autor autorP,  int anioP, String lugarCreacionP,
			String tipoPiezaP,Dimensiones dimensiones,Date fechaing, TecnicaPintura tecnicaPinturaP) {
		super(idPiezaP,nombre,tipoPiezaP, bloqueadaP, autorP,  anioP, lugarCreacionP,fechaing);
		this.tecnicaPintura= tecnicaPinturaP;
		this.dimension= dimensiones;
		// TODO Auto-generated constructor stub
		
	}
	
	public TecnicaPintura getTecnicaPintura() {
		return tecnicaPintura;
	}


	public Dimensiones getDimension() {
		return dimension;
	}

	public void setTecnicaPintura(TecnicaPintura tecnicaPintura) {
		this.tecnicaPintura = tecnicaPintura;
	}
	
	
}
