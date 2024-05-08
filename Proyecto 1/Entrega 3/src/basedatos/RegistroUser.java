package basedatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class RegistroUser {
	
	public void dataBaseAgregar(String txt_user, String txt_password, int txt_level) {
		try {
			Connection connector = DriverManager.getConnection("jdbc:mysql://localhost/bd_subasta", "root", ""); // "rutaBase", "nombreBase", "passwordBase"
			PreparedStatement pst = connector.prepareStatement("INSERT INTO users (user, password, level) VALUES (?, ?, ?)");
			
			pst.setString(1, txt_user.trim());
			pst.setString(2, txt_password.trim());
			pst.setInt(3, txt_level);
			pst.executeUpdate();	
			pst.close();
            connector.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			}
		}
	public ArrayList<Object> dataBaseBuscar(String txt_user) {
	    ArrayList<Object> userInfo = new ArrayList<>();
	    
	    try {
	        Connection connector = DriverManager.getConnection("jdbc:mysql://localhost/bd_subasta", "root", "");
	        PreparedStatement pst = connector.prepareStatement("SELECT * FROM users WHERE user = ?");

	        pst.setString(1, txt_user);

	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            userInfo.add( txt_user);
	            userInfo.add(rs.getString("password"));
	            userInfo.add(rs.getInt("level"));
	        }

	        rs.close();
	        pst.close();
	        connector.close();

	    } catch(SQLException e) {
	        e.printStackTrace();
	    }

	    return userInfo;
	}
	public void dataBaseModificiar(String txt_user, String txt_password, int txt_level ) {
		try {

			Connection connector = DriverManager.getConnection("jdbc:mysql://localhost/bd_subasta", "root", ""); // "rutaBase", "nombreBase", "passwordBase"
			PreparedStatement pst = connector.prepareStatement("UPDATE users SET password = ?, level = ? WHERE user = " + txt_user.trim());
			
			pst.setString(1, txt_password.trim());
			pst.setInt(2, txt_level);
			
			pst.executeUpdate();
			pst.close();
			connector.close();
				
			System.out.println("modificación exitosa");
			
			
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
		
	}
	public void dataBaseEliminar(String txt_user) {
		
		try {
			Connection connector = DriverManager.getConnection("jdbc:mysql://localhost/bd_subasta", "root", ""); // "rutaBase", "nombreBase", "passwordBase"
			PreparedStatement pst = connector.prepareStatement("DELETE FROM users WHERE user = ?");
			
			pst.setString(1, txt_user.trim());
			pst.executeUpdate();
			pst.close();
			connector.close();
			
			System.out.println("Eliminado exitosamente");
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	public static void main(String[] args) {
		RegistroUser us = new RegistroUser();
		us.dataBaseAgregar("seb", "0a7p0", 1);
		us.dataBaseBuscar("seb");
		us.dataBaseModificiar("seb", "paco", 0);
		us.dataBaseBuscar("seb");
	}
	

}
