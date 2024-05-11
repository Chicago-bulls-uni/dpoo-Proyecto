package models;

//import enums.RolEmpleado;
import seguridad.Usuario;

public class Empleado {
	
	private Usuario idEmpleado;
	
	public Empleado ( 
			 Usuario idEmpleadoP) {
		this.idEmpleado = idEmpleadoP;
		
		
	}

	public Usuario getIdEmpleado() {
		return idEmpleado;
	}

	
	public void setIdEmpleado(Usuario idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	
	
	//TODO
	//+ gestionarPiezas(): void
	//+ gestionarCompras(): void
	//+ gestionarPropietarios(): void 
	// Esto ^^^^ creo que ya el propio admin, o operador podría gestionarlo si necesidad de volver a hacer las funciones
}
