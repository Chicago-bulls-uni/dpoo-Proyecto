package models;

public class Oferta {
	
	
	private Subasta subasta;
	private Comprador comprador;
	private double montoOfrecido;
	
	public Oferta ( Subasta subastaP, Comprador compradorP, double montoOfrecidoP) {
		
		this.subasta= subastaP;
		this.comprador=compradorP;
		this.montoOfrecido=montoOfrecidoP;
	}

	

	public Subasta getSubasta() {
		return subasta;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public double getMontoOfrecido() {
		return montoOfrecido;
	}

	

	public void setSubasta(Subasta subasta) {
		this.subasta = subasta;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public void setMontoOfrecido(double montoOfrecido) {
		this.montoOfrecido = montoOfrecido;
	}
	
	//TODO
	public boolean validarOferta () {
		return true;
	}
}
