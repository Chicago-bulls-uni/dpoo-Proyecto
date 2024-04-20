package models;

import java.util.List;

public class Propietario {
	
	private int idPropietario;
	private String nombre;
	private String contacto;
	private double limiteCompra;
	private List<Pieza> historialCompras;

	
	
	public Propietario (int idPropietarioP, String nombreP, String contactoP, double limiteCompraP, List<Pieza> historialComprasP) {
		this.idPropietario= idPropietarioP;
		this.nombre= nombreP;
		this.contacto= contactoP;
		this.limiteCompra=limiteCompraP;
		this.historialCompras= historialComprasP;
		
	}



	public int getIdPropietario() {
		return idPropietario;
	}



	public String getNombre() {
		return nombre;
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



	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
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
