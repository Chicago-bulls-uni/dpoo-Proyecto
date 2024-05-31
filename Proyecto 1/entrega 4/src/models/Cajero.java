package models;

import enums.MetodoPago;
import seguridad.Usuario;
import models.Compra;

public class Cajero extends Empleado{

	public Cajero(String nombreUsuario, String contrasena, Galeria galeria1) {
		super(nombreUsuario, contrasena, 1, galeria1);
		
	}
	
	public List<Compra> getHistorialVentasDirectasCajero() {
		List<Compra> listaVentasHistorialGaleria = Usuario.getGaleria().getHistorialVentasDirectas();
        return listaVentasHistorialGaleria;
    }
	
	public void registrarCompra(Compra compra) {
        Galeria galeria = Usuario.getGaleria();
        galeria.getHistorialVentasDirectas().add(compra);
    }
	public void regitrarcompraPieza(String piezaLlave,String metodoPago) {
		Compra compra= Usuario.getGaleria().getCompras().getMapaCompras().get(piezaLlave);
		if (compra.isCompraverificada()==false) {
	      System.out.println("La compra aun no ha sido aprobada por el Administrador");
		}
		else {
			this.QuitarArgent(compra.getComprador(), compra.getMonto(),MetodoPago.valueOf(metodoPago) );
			this.AnadirArgent(compra.getComprador(), compra.getMonto(), compra);
			
		}
	}
		
	public void QuitarArgent(String nombreUsuario,double Montoaretirar,MetodoPago metodopago) {
		try {
		Usuario.getGaleria().getMapaCompradores().get(nombreUsuario).getbilletera().finPagoPieza(Montoaretirar, metodopago);
		}catch (Exception e) {
			// TODO: Algun random en un caso hipotetico se cambie el nombre de usuario
		}
		
	}
	public void AnadirArgent(String nombreUsuario,double MOntoanadir,Compra compra) {
		String Expropietario=compra.getPiezas().get(0).getPropietario();
		if(Expropietario.equals("Galeria")) {
			
		}
		else {
		Usuario.getGaleria().getMapaCompradores().get(Expropietario).getbilletera().agregarSaldo(MOntoanadir);
		
	}

}}
