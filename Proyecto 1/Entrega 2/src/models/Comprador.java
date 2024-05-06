package models;

import java.util.List;

public class Comprador {
	
	private int idComprador;
	private String nombre;
	private String contacto;
	
	private Compra compra;
	private double limiteCompra;
	private boolean verificado;
	
	public Comprador (int idCompradorP, String nombreP, String contactoP, Compra compraP , double limiteCompraP, boolean verificadoP) {
		this.setIdComprador(idCompradorP);
		this.setNombre(nombreP);
		
		this.setContacto(contactoP);
		this.setCompra(compraP);
		this.setLimiteCompra(limiteCompraP);
		this.setVerificado(verificadoP);
	
	}

	public int getIdComprador() {
		return idComprador;
	}

	public String getNombre() {
		return nombre;
	}

	public String getContacto() {
		return contacto;
	}

	public List<Compra> getComprasRealizadas() {
		return comprasRealizadas;
	}

	public void setIdComprador(int idComprador) {
		this.idComprador = idComprador;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public void setComprasRealizadas(List<Compra> comprasRealizadas) {
		this.comprasRealizadas = comprasRealizadas;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public double getLimiteCompra() {
		return limiteCompra;
	}

	public void setLimiteCompra(double limiteCompra) {
		this.limiteCompra = limiteCompra;
	}

	public boolean isVerificado() {
		return verificado;
	}

	public void setVerificado(boolean verificado) {
		this.verificado = verificado;
	}
	
	
}
