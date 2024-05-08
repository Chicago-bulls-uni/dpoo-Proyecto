package models;

import java.sql.Date;

import enums.ProcesoImpresion;
import enums.TipoPapel;

public class Impresion extends Pieza {
	
	private ProcesoImpresion procesoImpresion;
	private TipoPapel tipoPapel;

	public Impresion(int idPiezaP,String nombre, boolean bloqueadaP, Autor autorP,  int anioP, String lugarCreacionP,
			String tipoPiezaP,Date fechaing, ProcesoImpresion procesoImpresionP, TipoPapel tipoPapelP) {
		super(idPiezaP,nombre, tipoPiezaP, bloqueadaP, autorP,  anioP, lugarCreacionP,fechaing);
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
