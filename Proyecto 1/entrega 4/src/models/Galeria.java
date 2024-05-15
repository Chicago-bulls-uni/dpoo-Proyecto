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
	
	
	
	public void realizarCompraDirecta(Comprador comprador, Pieza pieza, MetodoPago metodoDePago) {
	    Administrador admin = this.getAdministrador();
	    admin.verificarCompradorVerificar(comprador.getNombre());
	    
	    if (!pieza.isBloqueada()) {
	        if (comprador.isVerificado()) {
	            double montoAPagar = pieza.getPrecio();
	            
	            if (comprador.getLimiteCompra() < montoAPagar) {
	                System.out.println("El límite de compra del comprador no es suficiente para pagar esta pieza.");
	                admin.actualizarLimiteCompras(comprador, montoAPagar);
	            }
	            
	            Compra compra = new Compra(pieza.getIdPieza(), pieza, comprador, new Date(), metodoDePago, montoAPagar);
	            
	            // Realizar el pago antes de registrar la compra
	            if (comprador.realizarPago(metodoDePago, montoAPagar, pieza)) {
	                cajero.registrarCompra(compra);
	                pieza.setEstadoPieza(EstadoPieza.VENDIDO);
	                pieza.setBloqueada(true);
	                // Llamar al método venderPieza del propietario de la pieza
	                pieza.getPropietario().venderPieza(pieza, monto); // COMO OBTENER EL PROPIETARIO?
	                registrarCompraEnHistorial(comprador, compra);
	                System.out.println("Compra realizada con éxito.");
	            } else {
	                System.out.println("La compra no pudo ser procesada debido a un problema con el pago.");
	            }
	        } else {
	            System.out.println("El comprador no está autorizado para realizar compras.");
	        }
	    } else {
	        System.out.println("La pieza seleccionada ya ha sido vendida.");
	    }
	}

    
	private void registrarCompraEnHistorial(Comprador comprador, Compra compra) {
	    Date fechaActual = new Date(ContadorSub);
	   //FECHA ACTUAL TIENE QUE SER INT
	    comprador.getComprasRealizadas().add(fechaActual, compra);
	}
	public  void anadiraOfertasTransitorias(Oferta offer) {
        this.HistorialofertasTransitorias.add(offer);
	}

	public Map<Integer, Subasta> getMapaSubastas() {
		
		return mapaSubastas;
	}

}
