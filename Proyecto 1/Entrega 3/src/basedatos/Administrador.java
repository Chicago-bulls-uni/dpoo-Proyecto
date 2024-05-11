package basedatos;

import seguridad.Usuario;

import java.util.List;

import models.Empleado;
import models.Pieza;

public class Administrador extends Empleado{

    private RegistroSubasta registroSubasta;

    public Administrador(Usuario usuarioP) {
        super(usuarioP);
        this.registroSubasta = new RegistroSubasta();
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
    
    public void verificarCompradorYOferta() {
    	// Verificar si el usario esta dentro de la base de datos
    	
    	
    }
    
    public void verificarCompradorSubasta() {
		// Verificar si el usuario esta dentro de la base de datos
    	

	}

	public void verificarCompradorOferta() {
		// Verificar si el usuario esta dentro de la base de datos

	}

	public void verificarCompradorPago() {
		// Verificar si el usuario esta dentro de la base de datos

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

	public void verificarCompradorLimite() {
		// Verificar si el usuario esta dentro de la base de datos

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
	
	
	
	
	
	
	
	
