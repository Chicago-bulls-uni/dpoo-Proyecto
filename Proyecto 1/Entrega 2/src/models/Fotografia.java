package models;

import enums.GeneroFotografico;

public class Fotografia extends Pieza{
	
	private GeneroFotografico generoFotografico;
	
	public Fotografia(int idPiezaP, boolean bloqueadaP, Autor autorP, String tituloP, int anioP, String lugarCreacionP,
			String tipoPiezaP, GeneroFotografico generoFotograficoP) {
		super(idPiezaP, bloqueadaP, autorP, tituloP, anioP, lugarCreacionP, tipoPiezaP);
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
