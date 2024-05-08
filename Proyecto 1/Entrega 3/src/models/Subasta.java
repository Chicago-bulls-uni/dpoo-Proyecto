package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Subasta {
	  
	 private int idSubasta; 
	 private List<Pieza> piezas;
	 private double valorMinimo;
	 private List<Oferta> ofertas;
	 private LocalDate fechaInicio;
	 private LocalDate fechaFin;
	 private boolean activo;
	 
	 
	 public Subasta (int idSubastaP, double valorMinimoP) {
		 this.idSubasta=idSubastaP;
		 this.piezas= new ArrayList<Pieza>();
		 this.valorMinimo=valorMinimoP;
		 this.ofertas= new ArrayList<Oferta>();
		 this.fechaInicio = LocalDate.now();
		 this.activo = false;
	 }


	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public int getIdSubasta() {
		return idSubasta;
	}


	public List<Pieza> getPiezas() {
		return piezas;
	}


	public double getValorMinimo() {
		return valorMinimo;
	}


	public void setIdSubasta(int idSubasta) {
		this.idSubasta = idSubasta;
	}


	public void setPiezas(List<Pieza> piezas) {
		this.piezas = piezas;
	}


	public void setValorMinimo(double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}


	public List<Oferta> getOfertas() {
		return ofertas;
	}


	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	 
	 
	public void iniciarSubasta() {
        this.activo = true;
    }

    public void finalizarSubasta() {
        this.activo = false;
    }

    public boolean isActivo() {
        return this.activo;
    }

    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
	
