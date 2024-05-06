package models;

import enums.TipoVideo;

public class Video extends Pieza{
	
	private int duracionMinutos;
	private TipoVideo tipo;
	private boolean necesitaElectricidad;
	
	public Video(int idPiezaP, boolean bloqueadaP, Autor autorP, String tituloP, int anioP, String lugarCreacionP,
			String tipoPiezaP, int duracionMinutosP, TipoVideo tipoP) {
		super(idPiezaP, bloqueadaP, autorP, tituloP, anioP, lugarCreacionP, tipoPiezaP);
		this.duracionMinutos = duracionMinutosP;
		this.tipo = tipoP;
		this.setNecesitaElectricidad(true);
	}

	public int getDuracionMinutos() {
		return duracionMinutos;
	}


	public TipoVideo getTipo() {
		return tipo;
	}


	public void setDuracionMinutos(int duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}


	public void setTipo(TipoVideo tipo) {
		this.tipo = tipo;
	}


	
	
	public static String convertirAHora(int duracionMinutos) {
        int horas = duracionMinutos / 60;
        int minutos = duracionMinutos % 60;
        String horaFormateada = String.format("%02d%02d", horas, minutos);
        
        return horaFormateada;
    }

	public boolean isNecesitaElectricidad() {
		return necesitaElectricidad;
	}

	public void setNecesitaElectricidad(boolean necesitaElectricidad) {
		this.necesitaElectricidad = necesitaElectricidad;
	}
		
		
}


