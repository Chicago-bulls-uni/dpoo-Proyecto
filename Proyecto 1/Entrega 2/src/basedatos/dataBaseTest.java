package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;


public class dataBaseTest {
	

	public Hashtable<Integer, Hashtable<String, Object>> dataBaseBuscar(String txt_user) throws SQLException 
	{
		Connection connector = DriverManager.getConnection("jdbc:mysql://localhost/bd_subasta", "root", "");
		
	    Hashtable<Integer, Hashtable<String, Object>> result = new Hashtable<>();

	    try {
	        PreparedStatement pst = connector.prepareStatement("SELECT * FROM users WHERE user = ?");

	        pst.setString(1, txt_user);

	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	            Hashtable<String, Object> userDetails = new Hashtable<>();
	            userDetails.put("password", rs.getString("password"));
	            userDetails.put("level", rs.getInt("level"));
	            result.put(rs.getInt("id"), userDetails);
	        }

	        rs.close();
	        pst.close();
	        connector.close();

	    } catch(SQLException e) {
	        e.printStackTrace();
	    }

	    return result;
	}

}
