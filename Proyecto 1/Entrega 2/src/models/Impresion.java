package models;

import enums.ProcesoImpresion;
import enums.TipoPapel;

public class Impresion extends Pieza {
	
	private ProcesoImpresion procesoImpresion;
	private TipoPapel tipoPapel;

	public Impresion(int idPiezaP, boolean bloqueadaP, Autor autorP, String tituloP, int anioP, String lugarCreacionP,
			String tipoPiezaP, ProcesoImpresion procesoImpresionP, TipoPapel tipoPapelP) {
		super(idPiezaP, bloqueadaP, autorP, tituloP, anioP, lugarCreacionP, tipoPiezaP);
		// TODO Auto-generated constructor stub
		this.setProcesoImpresion(procesoImpresionP);
		this.setTipoPapel(tipoPapelP);
		
	}

	public ProcesoImpresion getProcesoImpresion() {
		return procesoImpresion;
	}

	public void setProcesoImpresion(ProcesoImpresion procesoImpresion) {
		this.procesoImpresion = procesoImpresion;
	}

	public TipoPapel getTipoPapel() {
		return tipoPapel;
	}

	public void setTipoPapel(TipoPapel tipoPapel) {
		this.tipoPapel = tipoPapel;
	}
	
	

}
