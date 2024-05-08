package models;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
	private List<Pieza> piezasinventario;

	public Inventario() {
		
		this.piezasinventario = new ArrayList<Pieza>();
	}

	protected void agregarpieza(Pieza pieza) {
		this.piezasinventario.add(pieza);
	}
}
