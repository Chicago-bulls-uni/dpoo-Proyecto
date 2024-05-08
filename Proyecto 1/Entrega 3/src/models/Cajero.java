package models;

import seguridad.Usuario;

/**
 * Represents a cashier in the system.
 */
public class Cajero extends Empleado {
	
    public Cajero(int idEmpleadoP, String nombreP, Usuario usuarioP) {
        super(idEmpleadoP, nombreP, usuarioP);
    }

   
    public boolean registrarPago(int cPago) {
        if (cPago != 0) {
            return true;
        } else {
            return false;
        }
    }
	//+ Cajero ()
	//+ registrarPago()

}
