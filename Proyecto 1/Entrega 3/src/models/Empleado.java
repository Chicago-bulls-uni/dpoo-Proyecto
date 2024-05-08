package models;

//import enums.RolEmpleado;
import seguridad.Usuario;

public class Empleado {
	
	private int idEmpleado;
	private String nombre;
	//private RolEmpleado rol;
	private Usuario usuario;
	
	public Empleado (int idEmpleadoP, String nombreP, //RolEmpleado rolP
			 Usuario usuarioP) {
		this.idEmpleado = idEmpleadoP;
		this.nombre = nombreP;
		//this.rol= rolP;
		this.usuario = usuarioP;
		
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	//public RolEmpleado getRol() {
		//return rol;
	//}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//public void setRol(RolEmpleado rol) {
		//this.rol = rol;
	//}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	//TODO
	//+ gestionarPiezas(): void
	//+ gestionarCompras(): void
	//+ gestionarPropietarios(): void 
	// Esto ^^^^ creo que ya el propio admin, o operador podría gestionarlo si necesidad de volver a hacer las funciones
}
