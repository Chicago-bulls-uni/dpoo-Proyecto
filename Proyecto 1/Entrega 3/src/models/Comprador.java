package models;

import java.util.Date;
import java.util.TreeMap;
public class Comprador {
    
    private int idComprador;
    private String nombre;
    private String contacto;
    
    private TreeMap<Date, Pieza> comprasRealizadas;
    private double limiteCompra;
    private boolean verificado;
    
    public Comprador (int idCompradorP, String nombreP, String contactoP,  double limiteCompraP, boolean verificadoP) {
        this.setIdComprador(idCompradorP);
        this.setNombre(nombreP);
        this.comprasRealizadas= new TreeMap<Date, Pieza>();
        this.setContacto(contactoP);
        this.verificado=false;
        this.setLimiteCompra(limiteCompraP);
        this.setVerificado(verificadoP);
    
    }

    public int getIdComprador() {
        return idComprador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public TreeMap<Date, Pieza> getComprasRealizadas() {
        return comprasRealizadas;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    

    

    public double getLimiteCompra() {
        return limiteCompra;
    }

    protected void setLimiteCompra(double limiteCompra) {
        this.limiteCompra = limiteCompra;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }
}
