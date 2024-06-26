package basedatos;

import seguridad.Usuario;

import java.util.List;

import models.Empleado;
import models.Pieza;

public class Administrador extends Empleado{

    private RegistroSubasta registroSubasta;
    private RegistroUser registroUsuario;

    public Administrador(int idEmpleadoP, String nombreP, Usuario usuarioP) {
        super(idEmpleadoP, nombreP, usuarioP);
        this.registroSubasta = new RegistroSubasta();
        this.registroUsuario = new RegistroUser();
    }

    // TODO Agregar get y setters de Pieza
    public void registroPiezaInventario(Pieza pieza) {
        registroSubasta.dataBaseAgregar(
            pieza.getIdPieza(),
            pieza.getFechaCreacion(),
            pieza.getLugarCreacion(),
            pieza.getAutor(),
            pieza.getTipo(),
            pieza.getEstado(),
            pieza.getDimensiones(),
            pieza.getMateriales(),
            pieza.isNecesitaElectricidad(),
            pieza.getFechaIngresa(),
            pieza.getFechaVenta()
        );
    }

    
    public void retiroPiezaInventario(int idPieza) {
        registroSubasta.dataBaseEliminar(idPieza);
    }


    public List<Pieza> buscarPiezaPorId(int idPieza) {
        return registroSubasta.dataBaseBuscar(idPieza);
    }

   
    public void actualizarPiezaInventario(Pieza pieza) {
        registroSubasta.dataBaseAgregar(
            pieza.getIdPieza(),
            pieza.getFechaCreacion(),
            pieza.getLugarCreacion(),
            pieza.getAutor(),
            pieza.getTipo(),
            pieza.getEstado(),
            pieza.getDimensiones(),
            pieza.getMateriales(),
            pieza.isNecesitaElectricidad(),
            pieza.getFechaIngresa(),
            pieza.getFechaVenta()
        );
    }
    
    public void verificarCompradorYOferta(String usario, int oferta, int ofertaMin) {
    	if (getNombre().equals(usario) && oferta > ofertaMin) {  
    		System.out.println("Usuario encontrado");	
    	}else {
			System.out.println("Usuario no encontrado");
    	}
    	
    }
    
    public void verificarCompradorSubasta(String usuario) {
    	// Verificar si el usuario esta dentro de la base de datos
		if (getNombre().equals(usuario)) {
			System.out.println("Usuario encontrado");
		} else {
			System.out.println("Usuario no encontrado");
		}

	}

	public void verificarCompradorOferta(String usuario) {
		// Verificar si el usuario esta dentro de la base de datos
		if (getNombre().equals(usuario)) {
			System.out.println("Usuario encontrado");
		} else {
			System.out.println("Usuario no encontrado");
		}

	}

	public void verificarCompradorPago(String usuario) {
		// Verificar si el usuario esta dentro de la base de datos
		if (getNombre().equals(usuario)) {
			System.out.println("Usuario encontrado");
		} else {
			System.out.println("Usuario no encontrado");
		}

	}

	public void verificarCompradorRetiro() {
		// Verificar si el usuario esta dentro de la base de datos

	}

	public void verificarCompradorRegistro() {
		// Verificar si el usuario esta dentro de la base de datos

	}

	public void verificarCompradorActualizar() {
		// Verificar si el usuario esta dentro de la base de datos

	}

	public void verificarCompradorEliminar() {
		// Verificar si el usuario esta dentro de la base de datos

	}

	public void verificarCompradorBuscar() {
		// Verificar si el usuario esta dentro de la base de datos

	}

	public void verificarCompradorVerificar() {
		// Verificar si el usuario esta dentro de la base de datos

	}

	public void verificarCompradorLimite(String idUsuario) {
		registroUsuario.dataBaseBuscar(idUsuario);

	}

	public void verificarCompradorLimiteCompras() {
		// Verificar si el usuario esta dentro de la base de datos

	}

	public void verificarCompradorActualizarLimiteCompras() {
		// Verificar si el usuario esta dentro de la base de datos

	}

	public void setComprador() {
		// TODO
	}

	public void setLimiteCompras() {
		// TODO
	}
	
	public void actualizarLimiteCompras() {
        // TODO
		
	}
   
    

}
	
	
	
	
	
	
	
	
