package models;

import seguridad.Usuario;
import basedatos.RegistroSubasta;
import java.util.List;

public class Administrador extends Empleado{

    private RegistroSubasta registroSubasta;

    public Administrador(int idEmpleadoP, String nombreP, Usuario usuarioP) {
        super(idEmpleadoP, nombreP, usuarioP);
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
            pieza.getNecesitaElectricidad(),
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
        registroSubasta.dataBaseModificar(
            pieza.getIdPieza(),
            pieza.getFechaCreacion(),
            pieza.getLugarCreacion(),
            pieza.getAutor(),
            pieza.getTipo(),
            pieza.getEstado(),
            pieza.getDimensiones(),
            pieza.getMateriales(),
            pieza.getNecesitaElectricidad(),
            pieza.getFechaIngresa(),
            pieza.getFechaVenta()
        );
    }
    
    public void verificarCompradorYOferta() {
    	// Verificar si el usario esta dentro de la base de datos
    	
    }
    
    public void verificarCompradorSubasta() {
    	// Verificar historial
    	// If comprador historial == 0 && piezaValor > alto {no puede comprar} 
    	
    }
    
   
    

}
	
	
	
	
	
	
	
	//+ setLimiteCompras()
	//+ actualizarLimiteCompras()



