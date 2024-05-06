package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enums.TecnicaPintura;
import models.Autor;
import models.Pieza;
import models.Pintura;

public class RegistroSubasta {
	
	
	
	public void dataBaseAgregar(int idPieza, int fechaCreacion,String Nombre , String lugarCreacion, String autor, String tipo, int estado, String dimensiones, String materiales, boolean necesitaElectricidad, String fechaIngresa, String fechaVenta) {
		try {
			Connection connector = DriverManager.getConnection("jdbc:mysql://localhost/bd_subasta", "root", ""); 
			PreparedStatement pst = connector.prepareStatement("INSERT INTO objects (idPieza, fechaCreacion, lugarCreacion, autor, tipo, estado, dimensiones, materiales, necesitaElectricidad, fechaIngresa, fechaVenta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			
			pst.setInt(1, idPieza);
			pst.setString(2, Nombre);
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
            
			System.out.println("Registro completado: " + idPieza);
			Autor author= new Autor(autor,false);
			if (tipo.equals("Pintura")) {
				TecnicaPintura tec= TecnicaPintura.(tipo)
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
			 
			Pintura BB= new Pieza(idPieza,false, author,  Nombre, fechaCreacion,  lugarCreacion, String tipoPieza)}
		}catch(SQLException e) {
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
            	Pieza objeto = new Pieza();
                objeto.setIdPieza(rs.getInt("idPieza"));
                objeto.setFechaCreacion(rs.getInt("fechaCreacion"));
                objeto.setLugarCreacion(rs.getString("lugarCreacion"));
                objeto.setAutor(rs.getString("autor"));
                objeto.setTipo(rs.getString("tipo"));
                objeto.setEstado(rs.getInt("estado"));
                objeto.setDimensiones(rs.getString("dimensiones"));
                objeto.setMateriales(rs.getString("materiales"));
                objeto.setNecesitaElectricidad(rs.getBoolean("necesitaElectricidad"));
                objeto.setFechaIngresa(rs.getString("fechaIngresa"));
                objeto.setFechaVenta(rs.getString("fechaVenta"));
                
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

	        pst.setInt(1, fechaCreacion);
	        pst.setString(2, lugarCreacion);
	        pst.setString(3, autor);
	        pst.setString(4, tipo);
	        pst.setInt(5, estado);
	        pst.setString(6, dimensiones);
	        pst.setString(7, materiales);
	        pst.setBoolean(8, necesitaElectricidad);
	        pst.setString(9, fechaIngresa);
	        pst.setString(10, fechaVenta);
	       

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
	
	public static void main(String[] args) {
		RegistroSubasta sub = new RegistroSubasta();
		sub.dataBaseModificar(10, 20240610, "bogota", "diego", "escultura", 4, "200x200", "madera,papel,tierra", false, "20230414", "N/A");
		sub.dataBaseBuscar(10);
	}
	
		

}
