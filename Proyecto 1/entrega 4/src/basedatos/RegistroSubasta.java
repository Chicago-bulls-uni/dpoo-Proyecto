package basedatos;

import java.io.Reader;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.EstadoPieza;
import enums.GeneroFotografico;
import enums.ProcesoImpresion;
import enums.TecnicaPintura;
import enums.TipoPapel;
import enums.TipoVideo;
import models.Autor;
import models.Dimensiones;
import models.Escultura;
import models.Fotografia;
import models.Galeria;
import models.Impresion;
import models.Pieza;
import models.Pintura;
import models.Video;

public class RegistroSubasta {
	
	private static Galeria galeria; ///NOT USED???
	 
	
	
	
	public void dataBaseAgregar(int idPieza, String nombre, int date, String lugarCreacion, String autor, String tipo, String string, String dimensiones, String materiales, boolean necesitaElectricidad,String estadopiece,java.sql.Date date2,String aditionalInfo) {
		try {
			Connection connector = DriverManager.getConnection("jdbc:mysql://localhost/bd_subasta", "root", ""); 
			PreparedStatement pst = connector.prepareStatement("INSERT INTO objects (idPieza,nombre, fechaCreacion, lugarCreacion, autor, tipo, estado, dimensiones, materiales, necesitaElectricidad, fechaIngresa,Estado_Pieza, tecnicapintura,peso,duracion,tipovideo,generofoto,tipoImpresion,Tipopapel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			
			pst.setInt(1, idPieza);
			pst.setString(2, nombre);
	        pst.setInt(3, date);
	        pst.setString(4, lugarCreacion);
	        pst.setString(5, autor);
	        pst.setString(6, tipo);
	        pst.setString(7, string);
	        pst.setString(8, dimensiones);
	        pst.setString(9, null);
	        
	        pst.setDate(11, (java.sql.Date) date2);
	        
	        pst.setString(12, estadopiece);
	        String[] listainfo=aditionalInfo.split(",");
	        Autor author= new Autor(autor,false);
	        if (tipo.equals("Pintura")) {
	        	
	        	pst.setString(14, listainfo[0]);
	        	pst.setString(15,null);
	        	pst.setString(16, null);
	        	pst.setString(17,null);
	        	pst.setString(18, null);
	        	pst.setString(19,null);
	        	pst.setString(20, null);
	        	pst.setBoolean(10, false);
	        	
	        	String[] DI= dimensiones.split(",");
	        	
	        	Dimensiones D = new Dimensiones(Double.parseDouble(DI[0]),Double.parseDouble(DI[1]),Double.parseDouble(DI[2]));
	            Pintura p=new Pintura(idPieza, nombre, false,author,date, lugarCreacion, tipo,D, date2, EstadoPieza.valueOf(estadopiece),TecnicaPintura.valueOf(listainfo[0]));
	        	
	        	
		        
	        }
	        else if (tipo.equals("Escultura")) {
	        	
	        	
	        	
	        	pst.setString(9, materiales);
	        	pst.setString(12, null);
	        	pst.setString(13,listainfo[0]);
	        	pst.setString(14, null);
	        	pst.setString(15,null);
	        	pst.setString(16, null);
	        	pst.setString(17,null);
	        	pst.setString(18, null);
	        	pst.setBoolean(10, necesitaElectricidad);
	        	String[] DI= dimensiones.split(",");
	        	Dimensiones D = new Dimensiones(Double.parseDouble(DI[0]),Double.parseDouble(DI[1]),Double.parseDouble(DI[2]));
	        	Escultura p=new Escultura(idPieza, nombre, false,author,date, lugarCreacion,tipo,D,date2,listainfo[0],materiales, EstadoPieza.valueOf(estadopiece));
		        
	        	
	        }
	        else if (tipo.equals("Video")) {
	        	
	        	
	        	pst.setString(9, null);
	        	pst.setString(12, null);
	        	pst.setString(13,null);
	        	pst.setString(14,listainfo[0]);
	        	pst.setString(15,listainfo[1]);
	        	pst.setString(16, null);
	        	pst.setString(17,null);
	        	pst.setString(18, null);
	        	pst.setBoolean(10, necesitaElectricidad);
	        	Video p = new Video(idPieza, nombre, false,author,date, lugarCreacion,tipo,date2,listainfo[0],TipoVideo.valueOf(listainfo[1]), EstadoPieza.valueOf(estadopiece));
	        	
		        
	        }
	        else if (tipo.equals("Fotografia")) {
	        	String[] Materials = materiales.split(",");
	        	
	        	pst.setString(9, null);
	        	pst.setString(12, null);
	        	pst.setString(13,null);
	        	pst.setString(14,null);
	        	pst.setString(15,null);
	        	pst.setString(16, listainfo[0]);
	        	pst.setString(17,null);
	        	pst.setString(18, null);
	        	pst.setBoolean(10, necesitaElectricidad);
	        	Fotografia p = new Fotografia(idPieza, nombre, false,author,date, lugarCreacion,tipo,date2,GeneroFotografico.valueOf(listainfo[0]), EstadoPieza.valueOf(estadopiece));}
	        	
	        
	        else if (tipo.equals("Impresion")) {
	        	String[] Materials = materiales.split(",");
	        	
	        	pst.setString(9, null);
	        	pst.setString(12, null);
	        	pst.setString(13,null);
	        	pst.setString(14,null);
	        	pst.setString(15,null);
	        	pst.setString(16, null);
	        	pst.setString(17,listainfo[0]);
	        	pst.setString(18, listainfo[1]);
	        	pst.setBoolean(10, false);
	        	Impresion p = new Impresion(idPieza, nombre, false,author,date, lugarCreacion,tipo,date2,ProcesoImpresion.valueOf(listainfo[0]),TipoPapel.valueOf(listainfo[0]), EstadoPieza.valueOf(estadopiece));}
	        	
	        	
	       
	        

		
	        
			
			pst.executeUpdate();	
			pst.close();
            connector.close();
			System.out.println("Registro completado: " + idPieza);
			
           
            }
		catch(SQLException e) {
			e.printStackTrace();
			}
		}
	public List<Pieza> dataBaseBuscar(int idPieza) {
        List<Pieza> resultados = new ArrayList<>();

        try {
            Connection connector = DriverManager.getConnection("jdbc:mysql://localhost/bd_subasta", "root", ""); // "rutaBase", "nombreBase", "passwordBase"
            PreparedStatement pst = connector.prepareStatement("SELECT * FROM objects WHERE idPieza = ?");

            pst.setInt(1, idPieza);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
            	Pieza objeto = new Pieza(idPieza, false, null, null, idPieza, null, null);
                objeto.setIdPieza(rs.getInt("idPieza"));
                objeto.setFechaCreacion(rs.getDate("fechaCreacion"));
                objeto.setLugarCreacion(rs.getString("lugarCreacion"));
                objeto.setAutor(rs.getString("autor"));
                objeto.setTipo(rs.getString("tipo"));
                objeto.setEstado(rs.getInt("estado")); //?
                objeto.setDimensiones(rs.getString("dimensiones"));
                objeto.setMateriales(rs.getString("materiales"));
                objeto.setNecesitaElectricidad(rs.getBoolean("necesitaElectricidad"));
                objeto.setFechaIngresa(rs.getDate("fechaIngresa"));
                objeto.setFechaVenta(rs.getDate("fechaVenta"));
                
                resultados.add(objeto);
            }

            rs.close();
            pst.close();
            connector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultados;
    }
	
	public void dataBaseModificar(int idPieza, int fechaCreacion, String lugarCreacion, String autor, String tipo, int estado, String dimensiones, String materiales, boolean necesitaElectricidad, String fechaIngresa, String fechaVenta) {
	    try {
	        Connection connector = DriverManager.getConnection("jdbc:mysql://localhost/bd_subasta", "root", ""); 
	        PreparedStatement pst = connector.prepareStatement("UPDATE objects SET fechaCreacion = ?, lugarCreacion = ?, autor = ?, tipo = ?, estado = ?, dimensiones = ?, materiales = ?, necesitaElectricidad = ?, fechaIngresa = ?, fechaVenta = ? WHERE idPieza = " + idPieza);
            pst.setInt(1,idPieza);
	        pst.setInt(2, fechaCreacion);
	        pst.setString(3, lugarCreacion);
	        pst.setString(4, autor);
	        pst.setString(5, tipo);
	        pst.setInt(6, estado);
	        pst.setString(7, dimensiones);
	        pst.setString(8, materiales);
	        pst.setBoolean(9, necesitaElectricidad);
	        pst.setString(10, fechaIngresa);
	        pst.setString(11, fechaVenta);
	       

	        pst.executeUpdate();
	        pst.close();
	        connector.close();
	        System.out.println("Elemento modificado con exito: " + idPieza);
	        
	    } catch(SQLException e) {
	        e.printStackTrace();
	    }
	}
		
	
	public void dataBaseEliminar(int idPieza) {
	    try {
	        Connection connector = DriverManager.getConnection("jdbc:mysql://localhost/bd_subasta", "root", ""); 
	        PreparedStatement pst = connector.prepareStatement("DELETE FROM objects WHERE idPieza = ?");

	        pst.setInt(1, idPieza);
	        
	        pst.executeUpdate();
	       
	        pst.close();
	        connector.close();
	        System.out.println("Elemento" + idPieza + "eliminado" );
	    } catch(SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	  
	  public static void main(String[] args) { RegistroSubasta sub = new
	  RegistroSubasta(); sub.dataBaseModificar(10, 20240610, "bogota", "diego",
	  "escultura", 4, "200x200", "madera,papel,tierra", false, "20230414", "N/A");
	  sub.dataBaseBuscar(10); }
	 
		

}
