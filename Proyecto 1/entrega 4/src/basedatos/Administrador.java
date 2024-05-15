package basedatos;

import seguridad.Usuario;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.Inventario;
import models.Compra;
import models.Comprador;
import models.Empleado;
import models.Galeria;
import models.Pieza;
import models.Subasta;


public class Administrador extends Empleado{

    private RegistroSubasta registroSubasta;
    private static final double LIMITE_ESTANDAR = 1000.0; 
    
    

    public Administrador(String Usuario,String Contrasena, int nivel,Galeria galeria1) {
        super(Usuario, Contrasena,nivel,galeria1);
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
            pieza.getFechaVenta() // ESTA ES LA FECHA HASTA LA QUE ESTARÁ EN LA GALERIA ?
        );
    }

    
    public void registrarIngresoPieza(String pieza, String descripcion, int cantidad) {
    	Galeria galeria = Usuario.getGaleria();
        if (galeria.getInventary.containsKey(pieza)) {
            Pieza existingPieza = this.inventario.get(pieza);
            existingPieza.setCantidad(existingPieza.getCantidad() + cantidad);
        } else {
            Pieza nuevaPieza = new Pieza(pieza, descripcion, cantidad);
            this.inventario.put(pieza, nuevaPieza); //Inventario no está definido
        }
        System.out.println("Pieza registrada exitosamente");
    }

    public void confirmarVentaPieza(String pieza, int cantidad) {
        if (this.inventario.containsKey(pieza)) {
            Pieza existingPieza = this.inventario.get(pieza);
            if (existingPieza.getCantidad() >= cantidad) {
                existingPieza.setCantidad(existingPieza.getCantidad() - cantidad);
                System.out.println("Venta confirmada exitosamente");
            } else {
                System.out.println("No hay suficiente cantidad de la pieza en el inventario");
            }
        } else {
            System.out.println("La pieza no existe en el inventario");
        }
    }

    public void confirmarDevolucionPieza(String pieza, int cantidad) {
        if (this.inventario.containsKey(pieza)) {
            Pieza existingPieza = this.inventario.get(pieza);
            existingPieza.setCantidad(existingPieza.getCantidad() + cantidad);
            System.out.println("Devolución confirmada exitosamente");
        } else {
            System.out.println("La pieza no existe en el inventario");
        }
    }

    private static class Pieza {
        private String pieza;
        private String descripcion;
        private int cantidad;

        public Pieza(String pieza, String descripcion, int cantidad) {
            this.pieza = pieza;
            this.descripcion = descripcion;
            this.cantidad = cantidad;
        }

        public String getPieza() {
            return pieza;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }
}
    public void retiroPiezaInventario(int idPieza) {
        registroSubasta.dataBaseEliminar(idPieza);
        Usuario.getGaleria();
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

	public void verificarCompradorVerificar(String nombreComprador) {
        Map<String, Comprador> mapaCompradores = galeria.getMapaCompradores();

        if (mapaCompradores.containsKey(nombreComprador)) { // Verificar si el comprador está en el mapa

        	Comprador comprador = mapaCompradores.get(nombreComprador);
            comprador.setVerificado(true); 
            System.out.println("Verificación exitosa para " + nombreComprador);
        } else {
            
            System.out.println("El comprador " + nombreComprador + " no está registrado en la galería.");
        }
    }
	



	public void setLimiteCompra(Comprador comprador) {
	    Map<Date, Compra> compras = comprador.getComprasRealizadas();
	    if (compras.isEmpty()) {
	        comprador.setLimiteCompra(LIMITE_ESTANDAR);
	    } else {
	        double limite = obtenerCompraMasCara(compras);
	        comprador.setLimiteCompra(limite);
	    }
	}

	private double obtenerCompraMasCara(Map<Date, Compra> comprasRealizadas) {
	    double maxCompra = 0.0;
	    for (Compra compra : comprasRealizadas.values()) {
	        if (compra.getMonto() > maxCompra) {
	            maxCompra = compra.getMonto();
	        }
	    }
	    return maxCompra;
	}
	
	
	
	public void actualizarLimiteCompras(Comprador comprador, double montoAPagar) {
	    if (comprador.getLimiteCompra() < montoAPagar) {
	        double aumentoLimite = calcularAumentoLimite(comprador);
	        double nuevoLimite = comprador.getLimiteCompra() + aumentoLimite;
	        
	        // Verificar que el aumento no exceda el 20% del límite actual
	        double limiteMaximo = comprador.getLimiteCompra() * 1.2;
	        if (nuevoLimite > limiteMaximo) {
	            System.out.println("El aumento del límite no es apto");
	            return;
	        }
	        
	        comprador.setLimiteCompra(nuevoLimite);
	        System.out.println("El límite de compra del comprador ha sido aumentado a " + nuevoLimite);
	    } else {
	        System.out.println("El límite de compra del comprador es suficiente para efectuar esta compra");
	    }
    
	private double calcularAumentoLimite(Comprador comprador) {
        List<Compra> comprasRealizadas = new ArrayList<>(comprador.getComprasRealizadas().values());
        if (comprasRealizadas.isEmpty()) {
            return LIMITE_ESTANDAR; 
        }
        
        double totalCompras = comprasRealizadas.stream().mapToDouble(Compra::getMonto).sum();

        
        // el aumento será un 20% de las compras realizadas
        return 0.2 * totalCompras;
    }
}
  
	public void verificarSubastasVencidas() {
        List<Pieza> piezasEnSubasta = inventario.obtenerPiezasSubasta(); 

        for (Pieza pieza : piezasEnSubasta) {
            Date fechaFinSubasta = pieza.getFechaFin(); // aquí no sé bien si este metodo si funciona
            Date fechaActual = new Date(); 

           
            if (fechaActual.after(fechaFinSubasta)) {
            	pieza.finalizarSubasta();

                registroSubasta.eliminarSubasta(pieza.getIdPieza());
                pieza.eliminarPiezaListSubasta();
                
            }
        }
    }
	
	
	//REVISAR
    public void registrarExhibicion (Pieza pieza, Date fechaFinExhibicion) {
    	
    	pieza.setFechaVenta(fechaFinExhibicion);
    	registroPiezaInventario(pieza);
    	}
    
    public void verificarExhibicionesVencidas() {
        List<Pieza> piezasEnExhibicion = inventario.obtenerPiezasExhibicion(); 

        for (Pieza pieza : piezasEnExhibicion) {
            Date fechaFinExhibicion = pieza.obtenerFechaVenta(); // aquí no sé bien si este metodo si funciona
            Date fechaActual = new Date(); 

           
            if (fechaActual.after(fechaFinExhibicion)) {
            
                pieza.retiroPiezaInventario();
                pieza.eliminarPiezaListExhibicion();

            }
        }
    }
    
    
    
}
	

	
	


	
	
	
	
	
	
	
	
	
