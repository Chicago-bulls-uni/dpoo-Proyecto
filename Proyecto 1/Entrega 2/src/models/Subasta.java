package models;

import java.util.List;

public class Subasta {
	  
	 private int idSubasta; //quizá quitarla
	 private List<Pieza> piezas;
	 private double valorMinimo;
	 private List<Oferta> ofertas;
	 
	 
	 public Subasta (int idSubastaP, List<Pieza> piezasP , double valorMinimoP, List<Oferta> ofertasP) {
		 this.idSubasta=idSubastaP;
		 this.piezas=piezasP;
		 this.valorMinimo=valorMinimoP;
		 this.ofertas= ofertasP;
	 }


	public int getIdSubasta() {
		return idSubasta;
	}


	public List<Pieza> getPiezas() {
		return piezas;
	}


	public double getValorMinimo() {
		return valorMinimo;
	}


	public void setIdSubasta(int idSubasta) {
		this.idSubasta = idSubasta;
	}


	public void setPiezas(List<Pieza> piezas) {
		this.piezas = piezas;
	}


	public void setValorMinimo(double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}


	public List<Oferta> getOfertas() {
		return ofertas;
	}


	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	 
	 
	 
	 //TODO
	 //+iniciarSubasta():void
	 //+ registrarOferta(): void
	 //+ finalizarSubasta(): void
}
