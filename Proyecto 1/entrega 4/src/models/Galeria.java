package models;


import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import basedatos.Administrador;
import basedatos.Inventario;
import basedatos.RegistroSubasta;
import enums.EstadoPieza;
import seguridad.Usuario; 
import enums.MetodoPago;


public class Galeria {
	
	
	private List<Empleado> empleados;
	private List<Integer> historialPiezas; 
	private  Map<Integer, Subasta> mapaSubastas;
	private Map<String, Comprador> mapaCompradores;
	private List<Autor> autores; //MODIFICACION AQUI
	
	private  int ContadorSub=0;
    private Queue<Oferta> HistorialofertasTransitorias;
	private Inventario inventary;
	private List<Compra> historialVentasDirectas;
    
	
	public Galeria (List<Empleado> empleadosP ,List<Integer> historialPiezasP) {
		
		this.empleados= empleadosP;
		this.historialPiezas=historialPiezasP;
		mapaSubastas=new HashMap<Integer, Subasta>( );
		this.BeginInventary();
		this.HistorialofertasTransitorias= new LinkedList<Oferta> ();
		
	}
	

	public List<Compra> getHistorialVentasDirectas() {
        return historialVentasDirectas;
    }
	public Queue<Oferta> getHistorialofertasTransitorias() {
		return HistorialofertasTransitorias;
	}
	public Map<String, Comprador> getMapaCompradores() {
        return mapaCompradores;
    }


	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public List<Integer> getHistorialPiezas() {
		return historialPiezas;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	public void BeginInventary() {
		this.inventary= new Inventario();
	};

	public void setHistorialPiezas(List<Integer> historialPiezas) {
		this.historialPiezas = historialPiezas;
	}


	public Inventario getInventary() {
		return inventary;
	}

	public   void setSubasta( double valorminimo,String NombrePiezas) {
        List<Pieza> Piezas= new ArrayList<Pieza>();
        String[] DI= NombrePiezas.split(",");
         for (int i = 0; i < DI.length; i++) {
             
             Piezas.add(this.getInventary().getPiezasinventario().get(DI[i]));
             
         }
        
        
        Subasta newsub= new Subasta(this.ContadorSub,valorminimo);
        newsub.AgregarpiezasSubasta(Piezas);
        
        this.mapaSubastas.put(this.ContadorSub, newsub);
        this.ContadorSub ++;
        
        
    }

	

	public void  AgregarpiezasSubasta(List<Pieza> piezas1){
        for (int i = 0; i < piezas1.size(); i++) {
            Pieza b =piezas1.get(i);
               this.piezas.add(b);
           }
       
   }

	public void retirarPieza(int idPieza) {
		RegistroSubasta registroSubasta = new RegistroSubasta();
		registroSubasta.dataBaseEliminar(idPieza);
	}

	

	public void confirmarVenta() {
		// TODO
    }
	
	public List<Pieza> verPiezasEnVenta() {
        return inventary.obtenerPiezasEnVenta();
    }
	
	
	
	public void realizarCompraDirecta(Comprador comprador, int idPieza, MetodoPago metodoDePago) {
	    Pieza pieza = null;
	    List<Pieza> piezasEnVenta = inventary.obtenerPiezasEnVenta();
	    for (Pieza p : piezasEnVenta) {
	        if (p.getIdPieza() == idPieza) {
	            pieza = p;
	            break;
	        }
	    }

	    if (pieza != null) {
	        if (!pieza.isBloqueada()) {
	            if (comprador.isVerificado()) {
	                double montoAPagar = pieza.getPrecio();
	                if (comprador.getLimiteCompra() < montoAPagar) {
	                    System.out.println("El límite de compra del comprador no es suficiente para pagar esta pieza.");
	                } else {
	                    Compra compra = new Compra(List.of(pieza), comprador.getNombre(), new Date(), metodoDePago, montoAPagar);
	                    if (comprador.realizarPago(metodoDePago, montoAPagar, pieza)) {
	                        controllerCompras(compra);
	                        comprador.registrarCompraEnHistorial(comprador, compra);
	                        pieza.setEstadoPieza(EstadoPieza.VENDIDO);
	                        pieza.setBloqueada(true);
	                        String propietario = pieza.getPropietario();
	                        mapaCompradores.get(propietario).getbilletera().agregarSaldo(montoAPagar);//Se le consigna el dinero al propietario
	                        historialVentasDirectas.add(compra); // Se añade al historial de la Galería
	                        System.out.println("Compra realizada con éxito.");
	                    } else {
	                        System.out.println("La compra no pudo ser procesada debido a un problema con el pago.");
	                    }
	                }
	            } else {
	                System.out.println("El comprador no está autorizado para realizar compras.");
	            }
	        } else {
	            System.out.println("La pieza seleccionada ya ha sido vendida.");
	        }
	    } else {
	        System.out.println("La pieza con el ID especificado no se encontró o no está disponible para la venta.");
	    }
	}

    
	
	public  void anadiraOfertasTransitorias(Oferta offer) {
        this.HistorialofertasTransitorias.add(offer);
	}

	public Map<Integer, Subasta> getMapaSubastas() {
		
		return mapaSubastas;
	}

}
