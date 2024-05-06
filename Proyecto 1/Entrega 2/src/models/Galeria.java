package models;

import java.util.ArrayList;
import java.util.List;

public class Galeria {
	
	
	private List<Empleado> empleados;
	private List<Integer> historialPiezas; 
	private List<Subasta> subasta;
	
	public Galeria (List<Empleado> empleadosP ,List<Integer> historialPiezasP, List<Subasta> subastaP) {
		
		this.empleados= empleadosP;
		this.historialPiezas=historialPiezasP;
		subasta=new ArrayList<Subasta>();
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

	public void setHistorialPiezas(List<Integer> historialPiezas) {
		this.historialPiezas = historialPiezas;
	}

	public List<Subasta> getSubasta() {
		return subasta;
	}

	public void setSubasta(int id, double valorminimo) {
		Subasta newsub= new Subasta(id,valorminimo);
		this.getSubasta().add(newsub);
		
		
	}
	
	//registrarPieza()
	// confirmarVenta()
	//devolverPieza()
	
}
