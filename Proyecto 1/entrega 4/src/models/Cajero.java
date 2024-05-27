package models;

import seguridad.Usuario;

public class Cajero extends Empleado{

	public Cajero(String usuario, String contrasena, Galeria galeria) {
		super(usuario, contrasena, 1, galeria ); //AJUSTAR CON EL NIVEL
		
	}
	
	
	public void registrarCompra(Compra compra) {
        // Guarda en historialVentasDirectas en Galeria la compra
        galeria.getHistorialVentasDirectas().add(compra);
    }

}
