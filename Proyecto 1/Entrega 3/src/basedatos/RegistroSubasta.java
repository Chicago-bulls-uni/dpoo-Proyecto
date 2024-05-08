package basedatos;

import java.io.Reader;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import enums.TecnicaPintura;
import models.Autor;
import models.Dimensiones;
import models.Pieza;
import models.Pintura;

public class RegistroSubasta {
	
	
	
	public void dataBaseAgregar(int idPieza, String nombre, int date, String lugarCreacion, String autor, String tipo, String string, String dimensiones, String materiales, boolean necesitaElectricidad, Date date2, Date date3,String aditionalInfo) {
		try {
			Connection connector = DriverManager.getConnection("jdbc:mysql://localhost/bd_subasta", "root", ""); 
			PreparedStatement pst = connector.prepareStatement("INSERT INTO objects (idPieza,nombre, fechaCreacion, lugarCreacion, autor, tipo, estado, dimensiones, materiales, necesitaElectricidad, fechaIngresa, tecnicapintura,peso,duracion,tipovideo,generofoto,tipoImpresion,Tipopapel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			
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
	        String[] listainfo=aditionalInfo.split(",");
	        
	        if (tipo.equals("Pintura")) {
	        	pst.setString(12, listainfo[0]);
	        	pst.setString(13,null);
	        	pst.setString(14, null);
	        	pst.setString(15,null);
	        	pst.setString(16, null);
	        	pst.setString(17,null);
	        	pst.setString(18, null);
	        	pst.setBoolean(10, false);
	        	Autor author= new Autor(autor,false);
	        	String[] DI= dimensiones.split(",");
	        	
	        	Dimensiones D = new Dimensiones(Double.parseDouble(DI[0]),Double.parseDouble(DI[1]),Double.parseDouble(DI[2]));
	            Pintura p=new Pintura(idPieza, nombre, false,author,date, lugarCreacion, tipo,D, date2, TecnicaPintura.valueOf(listainfo[0]));
	        	
	        	
		        
	        }
	        else if (tipo.equals("Escultura")) {
	        	String[] Materials = materiales.split(",");
	        	
	        	pst.setString(9, materiales);
	        	pst.setString(12, null);
	        	pst.setString(13,listainfo[0]);
	        	pst.setString(14, null);
	        	pst.setString(15,null);
	        	pst.setString(16, null);
	        	pst.setString(17,null);
	        	pst.setString(18, null);
	        	pst.setBoolean(10, necesitaElectricidad);
	        	
		        
	        }
	        else if (tipo.equals("Video")) {
	        	String[] Materials = materiales.split(",");
	        	
	        	pst.setString(9, null);
	        	pst.setString(12, null);
	        	pst.setString(13,null);
	        	pst.setString(14,listainfo[0]);
	        	pst.setString(15,listainfo[1]);
	        	pst.setString(16, null);
	        	pst.setString(17,null);
	        	pst.setString(18, null);
	        	pst.setBoolean(10, necesitaElectricidad);
	        	
		        
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
	        	
		        
	        }
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
	        	
		        
	        }
	        

		
	        
			
			pst.executeUpdate();	
			pst.close();
            connector.close();
			System.out.println("Registro completado: " + idPieza);
			
           
            
		}catch(SQLException e) {
			e.printStackTrace();
			}
		}
	
	


public List<Pieza> dataBaseBuscar(int idPieza) {
    List<Pieza> resultados = new ArrayList<>();

    try {
        Connection connector = DriverManager.getConnection("jdbc:mysql://localhost/bd_subasta", "root", "");
        PreparedStatement pst = connector.prepareStatement("SELECT * FROM objects WHERE idPieza = ?");

        pst.setInt(1, idPieza);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            

        	Autor autor = null; 
        	Pieza objeto = new Pieza(idPieza, null, null, false, autor, 0, null, null);
            objeto.setIdPieza(rs.getInt("idPieza"));
            objeto.setFechaCreacion(rs.getDate("fechaCreacion"));
            objeto.setLugarCreacion(rs.getString("lugarCreacion"));
            objeto.setAutor(new Autor(rs.getString("autor"), false)); 
            objeto.setTipo(rs.getString("tipo"));
            objeto.setEstado(rs.getString("estado")); 
            objeto.setDimensiones(rs.getString("dimensiones"));
            objeto.setMateriales(new ArrayList<>(Arrays.asList(rs.getString("materiales").split(",")))); 
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
    } finally {
        return resultados;
    		}
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
	        Autor author= new Autor(autor,false);
            if (tipo.equals("Pintura")) {
                TecnicaPintura tec= TecnicaPintura.(tipo);
                Pintura BB= new Pintura(idPieza,false, author,  Nombre, fechaCreacion,  lugarCreacion, tipo);
            } else if (tipo.equals("Video")) {
                // Code for Type2
            } else if (tipo.equals("Impresion")) {
                // Code for Type3
            } else if (tipo.equals("Fotorgrafia")) {
                // Code for Type4
            } else if (tipo.equals("Escultura")) {
                // Code for Type5
            } else {
                // Code for unknown type
            }
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
	
	/*
	 * public static void main(String[] args) { RegistroSubasta sub = new
	 * RegistroSubasta(); sub.dataBaseModificar(10, 20240610, "bogota", "diego",
	 * "escultura", 4, "200x200", "madera,papel,tierra", false, "20230414", "N/A");
	 * sub.dataBaseBuscar(10); }
	 */
		

}
