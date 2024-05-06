package models;

public interface IMain {

	public void registrarPago();

	public boolean validarOferta();

	public void setMateriales(ArrayList<String> materiales);

	public void setPeso(int peso);

	public void setDimenciones(Dimensiones dimenciones);

	public void setSubasta(Subasta subasta);

	public void setComprador(Comprador comprador);

	public void setMontoOfrecido(double montoOfrecido);

	public void setNombre(String nombre);

	public void setEsColectivo(boolean esColectivo);

	public void setUsuario(Usuario usuario);

	public void setNombreP(String nombreP);

	public void setEsColectivoP(boolean esColectivoP);

	public void setUsuarioP(Usuario usuarioP);

	public void setAutor(Autor autor);

	public void setTitulo(String titulo);

	public void setAnio(int anio);

	public void setLugarCreacion(String lugarCreacion);

	public void setTipoPieza(String tipoPieza);

	public void setIdPieza(int idPieza);

	public void setBloqueada(boolean bloqueada);

	public void setAutorP(Autor autorP);

	public void setTituloP(String tituloP);

	public void setAnioP(int anioP);

	public void setLugarCreacionP(String lugarCreacionP);

	public void setTipoPiezaP(String tipoPiezaP);

	public void setIdPiezaP(int idPiezaP);

	public void setBloqueadaP(boolean bloqueada

}
