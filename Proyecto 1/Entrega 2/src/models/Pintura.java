package models;

import enums.TecnicaPintura;

public class Pintura extends Pieza{
	
	private TecnicaPintura tecnicaPintura;
	

	public Pintura(int idPiezaP, boolean bloqueadaP, Autor autorP, String tituloP, int anioP, String lugarCreacionP,
			String tipoPiezaP, TecnicaPintura tecnicaPinturaP) {
		super(idPiezaP, bloqueadaP, autorP, tituloP, anioP, lugarCreacionP, tipoPiezaP);
		this.tecnicaPintura= tecnicaPinturaP;
		// TODO Auto-generated constructor stub
		
	}


	public TecnicaPintura getTecnicaPintura() {
		return tecnicaPintura;
	}


	public void setTecnicaPintura(TecnicaPintura tecnicaPintura) {
		this.tecnicaPintura = tecnicaPintura;
	}
	
	
}
