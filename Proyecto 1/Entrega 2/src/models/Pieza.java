package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.EstadoPieza;

public class Pieza {

	private int idPieza;
	private boolean bloqueada;
	private Autor autor;
	private String titulo;
	private int anio;
	private String lugarCreacion;
	private EstadoPieza estadoPieza;
	
	private Date fechaCreacion;
	private String tipo;
    private String estado;
    private String dimensiones;
    
    
public Pieza(int idPiezaP, boolean bloqueadaP, Autor autorP, String tituloP, int anioP, String lugarCreacionP, String tipoPiezaP, Date fechaCreacion, String tipo, String dimensiones) {
		
		this.idPieza= idPiezaP;
        this.bloqueada=bloqueadaP;
        this.autor= autorP;
        this.titulo= tituloP;
        this.anio= anioP;
        
        this.fechaCreacion = fechaCreacion;
        this.tipo = tipo;
        this.dimensiones = dimensiones;
        
		
	}
    public int getIdPieza() {
		return idPieza;
	}


	public void setIdPieza(int idPieza) {
		this.idPieza = idPieza;
	}


	public boolean isBloqueada() {
		return bloqueada;
	}


	public void setBloqueada(boolean bloqueada) {
		this.bloqueada = bloqueada;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getAnio() {
		return anio;
	}


	public void setAnio(int anio) {
		this.anio = anio;
	}


	public String getLugarCreacion() {
		return lugarCreacion;
	}


	public void setLugarCreacion(String lugarCreacion) {
		this.lugarCreacion = lugarCreacion;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getDimensiones() {
		return dimensiones;
	}


	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}


	public Date getFechaIngresa() {
		return fechaIngresa;
	}


	public void setFechaIngresa(Date fechaIngresa) {
		this.fechaIngresa = fechaIngresa;
	}


	public Date getFechaVenta() {
		return fechaVenta;
	}


	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	private Date fechaIngresa;
    private Date fechaVenta;

    
	
	
	
	
	
	// faltan atrib TODO
	
	


	//TODO
	 public List<Pieza> obtenerPiezasExhibidas(){
		return null;
		 
	 }
	 
	 
	 public List<Pieza>obtenerPiezasBodega(){
		return null;
		 
	 }
	 
	
	 public List<Pieza> obtenerPiezasExhibidas(List<Pieza> listaPiezas) {
	        List<Pieza> piezasExhibidas = new ArrayList<>();
	        for (Pieza pieza : listaPiezas) {
	            if (pieza.getEstadoPieza() == EstadoPieza.EXHIBIDA) {
	                piezasExhibidas.add(pieza);
	            }
	        }
	        return piezasExhibidas;
	    }

	    public List<Pieza> obtenerPiezasBodega(List<Pieza> listaPiezas) {
	        List<Pieza> piezasBodega = new ArrayList<>();
	        for (Pieza pieza : listaPiezas) {
	            if (pieza.getEstadoPieza() == EstadoPieza.BODEGA) {
	                piezasBodega.add(pieza);
	            }
	        }
	        return piezasBodega;
	    }


		public EstadoPieza getEstadoPieza() {
			return estadoPieza;
		}


		public void setEstadoPieza(EstadoPieza estadoPieza) {
			this.estadoPieza = estadoPieza;
		}
		
		public void agregarPieza(List<Pieza> listaPiezas, Pieza pieza) {
	        listaPiezas.add(pieza);
	    }

	    public void venderPieza(Pieza pieza) {
	        pieza.setEstadoPieza(EstadoPieza.VENDIDA);
	    }

	    public void devolverPieza(Pieza pieza) {
	        pieza.setEstadoPieza(EstadoPieza.DEVUELTA);
	    }
}
