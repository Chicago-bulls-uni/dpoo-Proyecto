package models;

import java.sql.Date;
import java.time.Duration;

import enums.TipoVideo;

public class Video extends Pieza {

    private Duration duracion;
    private TipoVideo tipo;
    private static final boolean NECESITA_ELECTRICIDAD = true;

    public Video(int idPiezaP, String nombre, boolean bloqueadaP, Autor autorP, int anioP, String lugarCreacionP,
            String tipoPiezaP, Date fechaing, Duration duracionP, TipoVideo tipoP) {
        super(idPiezaP, nombre, tipoPiezaP, bloqueadaP, autorP, anioP, lugarCreacionP, fechaing);
        this.duracion = duracionP;
        this.tipo = tipoP;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public TipoVideo getTipo() {
        return tipo;
    }

    public void setDuracion(Duration duracion) {
        this.duracion = duracion;
    }

    public void setTipo(TipoVideo tipo) {
        this.tipo = tipo;
    }

    public static String convertirAHora(Duration duracion) {
        long horas = duracion.toHours();
        int minutos = duracion.toMinutesPart();
        String horaFormateada = String.format("%02d:%02d", horas, minutos);
        return horaFormateada;
    }

    public boolean isNecesitaElectricidad() {
        return NECESITA_ELECTRICIDAD;
    }
}