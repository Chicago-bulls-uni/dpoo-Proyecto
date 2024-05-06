package models;

import seguridad.Usuario;

public class Operador extends Empleado{

	public Operador(int idEmpleadoP, String nombreP, Usuario usuarioP) {
		super(idEmpleadoP, nombreP, usuarioP);
		
		this.setIdEmpleado(idEmpleadoP);
		this.setNombre(nombreP);
		this.setUsuario(usuarioP);
	}
	
	public void registrarMovimientosSubasta() {
		//TODO

	}
	
		

}
