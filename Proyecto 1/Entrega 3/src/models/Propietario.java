package models;

import java.util.ArrayList;
import java.util.List;

public class Propietario extends Comprador {
	
	
	
	private String contacto;
	private double limiteCompra;
	private List<Pieza> historialCompras;
	private List<Pieza> Piezasadquiridad;

	
	
	public Propietario ( String nombreP, String contactoP,  Compra compraP , double limiteCompraP, boolean verificadoP, int idPropietarioP, List<Pieza> historialComprasP) {
		super(idPropietarioP,nombreP,contactoP, compraP,limiteCompraP,verificadoP);
		
		
		this.Piezasadquiridad= new ArrayList<Pieza>();
		this.historialCompras= new ArrayList<Pieza>();
		this.limiteCompra=limiteCompraP;
		this.historialCompras= historialComprasP;
		
	}
	

	
	


	public String getContacto() {
		return contacto;
	}



	public double getLimiteCompra() {
		return limiteCompra;
	}



	public List<Pieza> getHistorialCompras() {
		return historialCompras;
	}


	public List<Pieza> getPiezasadquiridad() {
		return Piezasadquiridad;
	}




	public void setContacto(String contacto) {
		this.contacto = contacto;
	}



	public void setLimiteCompra(double limiteCompra) {
		this.limiteCompra = limiteCompra;
	}



	public void setHistorialCompras(List<Pieza> historialCompras) {
		this.historialCompras = historialCompras;
	}

	//TODO
	public void actualizarPropietario () {
		
	}
	
}
