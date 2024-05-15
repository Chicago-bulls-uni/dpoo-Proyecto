package models;

import seguridad.Usuario;

public class Cajero extends Empleado{

	public Cajero(int idEmpleadoP, String nombreP, Usuario usuarioP) {
		super(idEmpleadoP, nombreP, usuarioP);
		// TODO Auto-generated constructor stub
	}
	
	
	public void registrarCompra(Compra compra) {
        // Guarda en historialVentasDirectas en Galeria la compra
        galeria.getHistorialVentasDirectas().add(compra);
    }

}
