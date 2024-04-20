package models;

import java.util.List;

public class Galeria {
	
	
	private List<Empleado> empleados;
	private List<Integer> historialPiezas; 
	private List<Subasta> subasta;
	
	public Galeria (List<Empleado> empleadosP ,List<Integer> historialPiezasP, List<Subasta> subastaP) {
		
		this.empleados= empleadosP;
		this.historialPiezas=historialPiezasP;
		this.setSubasta(subastaP);
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

	public void setSubasta(List<Subasta> subastaP) {
		this.subasta = subastaP;
	}
	
	//registrarPieza()
	// confirmarVenta()
	//devolverPieza()
	
}
