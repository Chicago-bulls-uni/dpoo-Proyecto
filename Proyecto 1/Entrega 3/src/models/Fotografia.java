package models;

import java.sql.Date;

import enums.GeneroFotografico;

public class Fotografia extends Pieza{
	
	private GeneroFotografico generoFotografico;
	
	public Fotografia(int idPiezaP,String nombreP, boolean bloqueadaP, Autor autorP,  int anioP, String lugarCreacionP,
			String tipoPiezaP,Date fechaing, GeneroFotografico generoFotograficoP) {
		super(idPiezaP,nombreP,tipoPiezaP, bloqueadaP, autorP,  anioP, lugarCreacionP, fechaing);
		// TODO Auto-generated constructor stub
		this.setGeneroFotografico(generoFotograficoP);
	}

	public GeneroFotografico getGeneroFotografico() {
		return generoFotografico;
	}

	public void setGeneroFotografico(GeneroFotografico generoFotografico) {
		this.generoFotografico = generoFotografico;
	}
	
}
