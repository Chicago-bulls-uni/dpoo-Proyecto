package models;

import seguridad.Usuario;
import basedatos.Administrador;
import basedatos.RegistroSubasta;

public class Main {
	public static void main(String[] args) {
		
		// Pre-configuración
		RegistroSubasta registroSubasta = new RegistroSubasta();
		Galeria galeria = new Galeria();
		Usuario usuario = new Usuario("juan", "1234", 4);
		Empleado empleado = new Empleado(2, "Juan", usuario);
		Oferta oferta = new Oferta(1, 1, 1, 1000);
		Cajero cajero = new Cajero(3, "Juan", usuario);
		Administrador admin = new Administrador(4, "Juan", usuario);
		// Crear un una pieza (Dia antes de la subasta)
		admin.registroPiezaInventario(1, 1, "Bogota", "Juan", "Pintura", 1, "20x20", "Pintura", false, "2021-06-01", "2021-06-01");
		galeria.setSubasta(0, 0); // Fecha inicio de subasta y fecha fin de subasta
		// Registrar usarios //TODO
		galeria.setSubasta(0, 0);; // Obtiene las subasta o subastas que se han registrado
		
		// Inicio de la subasta
		// Los usarios pueden ofertar por la pieza si estan registrados (verficardos) //TODO
		oferta.getComprador();
		oferta.getMontoOfrecido();
		// El operador revisa lo ofrecido y si es mayor a al precio mminimo de la pieza añade //TODO
		// Pago //TODO
		
		cajero.registrarPago(1); // Dentro de registrar pago confirmar esta venta al administrador TODO
		admin.retiroPiezaInventario(0);
		
		// Fin de la subasta //TODO
		
		
		
		}

}
