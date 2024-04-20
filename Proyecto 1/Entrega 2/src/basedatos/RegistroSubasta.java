package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroSubasta {
	public void dataBaseAgregar(int idPieza, int fechaCreacion, String lugarCreacion, String autor, String tipo, int estado, String dimensiones, String materiales, boolean necesitaElectricidad, String fechaIngresa, String fechaVenta) {
		try {
			Connection connector = DriverManager.getConnection("jdbc:mysql://localhost/bd_subasta", "root", ""); 
			PreparedStatement pst = connector.prepareStatement("INSERT INTO objects (idPieza, fechaCreacion, lugarCreacion, autor, tipo, estado, dimensiones, materiales, necesitaElectricidad, fechaIngresa, fechaVenta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			
			pst.setInt(1, idPieza);
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
		}catch(SQLException e) {
			e.printStackTrace();
			}
		}
	public void dataBaseBuscar(int idPieza) {
		
		try {
			Connection connector = DriverManager.getConnection("jdbc:mysql://localhost/bd_subasta", "root", ""); // "rutaBase", "nombreBase", "passwordBase"
			PreparedStatement pst = connector.prepareStatement("SELECT * FROM objects WHERE idPieza = ?");
			
			pst.setInt(1, idPieza);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				System.out.println("fechaCreacion: " + rs.getInt("fechaCreacion"));
			    System.out.println("lugarCreacion: " + rs.getString("lugarCreacion"));
			    System.out.println("autor: " + rs.getString("autor"));
			    System.out.println("tipo: " + rs.getString("tipo"));
			    System.out.println("estado: " + rs.getInt("estado"));
			    System.out.println("dimensiones: " + rs.getString("dimensiones"));
			    System.out.println("materiales: " + rs.getString("materiales"));
			    System.out.println("necesitaElectricidad: " + rs.getBoolean("necesitaElectricidad"));
			    System.out.println("fechaIngresa: " + rs.getString("fechaIngresa"));
			    System.out.println("fechaVenta: " + rs.getString("fechaVenta"));
			}else {
				System.out.println("Error registro no encontrado");
			}
			
		rs.close();
		pst.close();
		connector.close();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		
		
		
		
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
