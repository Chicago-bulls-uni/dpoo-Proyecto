package models;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import basedatos.RegistroSubasta;

public class Galeria {
    
    
    private List<Empleado> empleados;
    private List<Integer> historialPiezas; 
    private  Map<Integer, Subasta> mapaSubastas;
    private Inventario inventary;
    
    public Galeria (List<Empleado> empleadosP ,List<Integer> historialPiezasP) {
        
        this.empleados= empleadosP;
        this.historialPiezas=historialPiezasP;
        mapaSubastas=new HashMap<Integer, Subasta>( );
        this.BeginInventary();
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


    public void setSubasta(int id, double valorminimo) {
        
        Subasta newsub= new Subasta(id,valorminimo);
        
        this.mapaSubastas.put(id, newsub);
        
        
    }
    

    public void registrarPieza() {
        //TODO
        
        
        
        
    }

    public void retirarPieza(int idPieza) {
        RegistroSubasta registroSubasta = new RegistroSubasta();
        registroSubasta.dataBaseEliminar(idPieza);
    }

    

    public void confirmarVenta() {
        // TODO
    }
}