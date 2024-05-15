package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Propietario extends Comprador {
	
	
	
	private String contacto;
	private double limiteCompra;
	private Map<Date, List<Pieza>> HistorialPieza;
	private List<Pieza> Piezasadquiridad;
	private double saldo;
	
	
	public Propietario (String Usuario,String Contrasena, int nivel,int idPropietarioP, String nombreP, String contactoP,  Compra compraP , double limiteCompraP, boolean verificadoP,Galeria galeria1) {
		super(Usuario, Contrasena,nivel,idPropietarioP,nombreP,contactoP,limiteCompraP,verificadoP,galeria1);
		
		
		this.Piezasadquiridad= new ArrayList<Pieza>();
		this.HistorialPieza= new TreeMap<Date, List<Pieza>>();
		this.limiteCompra=limiteCompraP;
		this.saldo=0;
		
		
	}
	

	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldoP) {
		this.saldo= saldoP;
	}

	public String getContacto() {
		return contacto;
	}



	public double getLimiteCompra() {
		return limiteCompra;
	}
	//nombre corregido
	public void anadirPiezasPropietario(Pieza piece, Date Fechaing) {
		this.Piezasadquiridad.add(piece);
	    
	    
	    if (!this.HistorialPieza.containsKey(Fechaing)) {
	        this.HistorialPieza.put(Fechaing, new ArrayList<Pieza>());}
	    List<Pieza> piecesList = this.HistorialPieza.get(Fechaing);
	    
	    
	    piecesList.add(piece);
	}
	public void EliminarPiezasDisponibles(Pieza piece) {
		if(this.Piezasadquiridad.contains(piece)){
			this.Piezasadquiridad.remove(piece);
		}
		else System.out.println("No se pudo eliminar la pieza");
		
	}
	



	


	public Map<Date, List<Pieza>> getHistorialPieza() {
		return HistorialPieza;
	}
	
	






	public List<Pieza> getPiezasadquiridad() {
		return Piezasadquiridad;
		
	}
	public Pieza getPiearequerida( int id ) {
		Pieza founded= null;
		
		
		for (Pieza Piece : this.Piezasadquiridad) {
			
		    
			if (Piece.getIdPieza()== id){
				 founded= Piece;
				
			}
			else {
				founded= null;
			}
		
		}
		
		return founded;
		    
		
		
	}




	public void setContacto(String contacto) {
		this.contacto = contacto;
	}



	public void setLimiteCompra(double limiteCompra) {
		this.limiteCompra = limiteCompra;
	}



	public void setHistorialCompras(List<Pieza> historialCompras) {
		this.historialCompras = historialCompras;
	}

	//TODO
	public void actualizarPropietario () {
		
	}
	
	public void ponerEnVenta(Pieza pieza, double precio) {
	    
	    Administrador admin = this.getGaleria().getAdministrador();
	    pieza.setPrecio(precio);
	    pieza.setEstado(EstadoPieza.ENVENTA);
	
	    admin.registroPiezaInventario(pieza);
	   
	    this.anadirPiezasPropietario(pieza, new Date());
	}
	
	
	//REVISAR AL IMPLEMENTAR BIEN ADMIN RESGITROPIEZASUBASTA
	public void ponerEnSubasta(Pieza pieza, double valorMinimo, Date fechaLimite) {
	    
	    Administrador admin = this.getGaleria().getAdministrador();
	    pieza.setEstado(EstadoPieza.ENSUBASTA);
	    
	    admin.registroSubasta(pieza, valorMinimo, fechaLimite);
	    
	    this.anadirPiezasPropietario(pieza, new Date());
	}
	
	
	//REVISAR
	public void ponerEnExhibicion(Pieza pieza,Date fechaLimite) {
	    
	    Administrador admin = this.getGaleria().getAdministrador();
	    pieza.setEstado(EstadoPieza.EXHIBICION);
		
	    admin.registrarExhibicion(pieza, fechaLimite);
	    
	    this.anadirPiezasPropietario(pieza, new Date());
	}
	
	public void realizarPago(Pieza pieza, MetodoPago metodoPago) {
        super.realizarPago(pieza, metodoPago);
    }
	
	public void venderPieza(Pieza pieza, double monto) {
        // Cambiar el estado de la pieza a VENDIDO en el mapa historialPieza
        if (historialPieza.containsKey(pieza)) {
            List<Pieza> listaPiezas = historialPieza.get(pieza);
            for (Pieza p : listaPiezas) {
                if (p.getIdPieza() == pieza.getIdPieza()) {
                    p.setEstadoPieza(EstadoPieza.VENDIDO);
                    break;
                }
               
            }    
        }
        
        billetera.agregarSaldo(monto);
        billetera.agregarTransaccionExitosa(monto, pieza );
    }

    public void piezaDevolucion(Pieza pieza) {
        // Cambiar el estado de la pieza a DEVUELTA en Piezasadquiridad
        // Eliminar la pieza del mapa historialPieza
        if (Piezasadquiridad.contains(pieza)) {
            Piezasadquiridad.pieza.setEstadoPieza(DEVUELTA);
            historialPieza.remove(pieza);
            System.out.println("La pieza ha sido devuelta y eliminada del historial.");
        } else {
            System.out.println("La pieza no está en la lista de piezas adquiridas.");
        }
    }
	
}
