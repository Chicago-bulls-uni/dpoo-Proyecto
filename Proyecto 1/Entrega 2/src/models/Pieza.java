package models;

import java.util.ArrayList;
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
	
	public Pieza(int idPiezaP, boolean bloqueadaP, Autor autorP, String tituloP, int anioP, String lugarCreacionP, String tipoPiezaP) {
		
		this.idPieza= idPiezaP;
		this.bloqueada=bloqueadaP;
		this.autor= autorP;
		this.titulo= tituloP;
		this.anio= anioP;
		this.lugarCreacion=lugarCreacionP;
		
	}


	public int getIdPieza() {
		return idPieza;
	}


	public boolean isBloqueada() {
		return bloqueada;
	}


	public Autor getAutor() {
		return autor;
	}


	public String getTitulo() {
		return titulo;
	}


	public int getAnio() {
		return anio;
	}


	public String getLugarCreacion() {
		return lugarCreacion;
	}


	


	public void setIdPieza(int idPieza) {
		this.idPieza = idPieza;
	}


	public void setBloqueada(boolean bloqueada) {
		this.bloqueada = bloqueada;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public void setAnio(int anio) {
		this.anio = anio;
	}


	public void setLugarCreacion(String lugarCreacion) {
		this.lugarCreacion = lugarCreacion;
	}

	
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
