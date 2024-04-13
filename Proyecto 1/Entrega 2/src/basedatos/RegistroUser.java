package basedatos;
import java.sql.*;



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
	public void dataBaseBuscar(String txt_user) {
		
		try {
			Connection connector = DriverManager.getConnection("jdbc:mysql://localhost/bd_subasta", "root", ""); // "rutaBase", "nombreBase", "passwordBase"
			PreparedStatement pst = connector.prepareStatement("SELECT * FROM users WHERE user = ?");
			
			pst.setString(1, txt_user);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				System.out.println("Password: " + rs.getString("password"));
                System.out.println("Level: " + rs.getInt("level"));
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
	public static void main(String[] args) {
        RegistroUser registro = new RegistroUser();
        
        // Datos del usuario de ejemplo
        String username = "witrecx";
        //String password = "12345";
        // int level = 0;
        
        // Agregar el usuario a la base de datos
        //registro.dataBaseAgregar(username, password, level);
        
        // Buscar el usuario para verificar que se haya agregado correctamente
        registro.dataBaseBuscar(username);
	}
	

}
