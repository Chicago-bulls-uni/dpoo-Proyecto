package models;

import java.sql.Date;
import enums.MetodoPago;

public class Compra {

	private int idCompra; 
	private Pieza pieza;
	private Comprador comprador;
	private Date fecha;
	private MetodoPago metodoPago;
	private double monto;
	
	public Compra (int idCompraP, Pieza piezaP, Comprador compradorP, Date fechaP, MetodoPago metodoPagoP, double montoP) {
		
		this.idCompra=idCompraP;
		this.pieza=piezaP;
		this.comprador=compradorP;
		this.fecha= fechaP;
		this.metodoPago=metodoPagoP;
		this.monto= montoP;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public Date getFecha() {
		return fecha;
	}

	public MetodoPago getMetodoPago() {
		return metodoPago;
	}

	public double getMonto() {
		return monto;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
		
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	
}
