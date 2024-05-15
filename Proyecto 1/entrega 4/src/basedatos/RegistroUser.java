package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistroUser {

    private static final String DB_URL = "jdbc:mysql://localhost/bd_subasta";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void agregarUsuario(String usuario, String password, int nivel) {
        String query = "INSERT INTO users (user, password, level) VALUES (?, ?, ?)";

        try (Connection connector = getConnection();
             PreparedStatement pst = connector.prepareStatement(query)) {

            pst.setString(1, usuario.trim());
            pst.setString(2, password.trim());
            pst.setInt(3, nivel);
            pst.executeUpdate();

            System.out.println("Usuario agregado exitosamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Object> buscarUsuario(String usuario) {
        List<Object> userInfo = new ArrayList<>();
        String query = "SELECT * FROM users WHERE user = ?";

        try (Connection connector = getConnection();
             PreparedStatement pst = connector.prepareStatement(query)) {

            pst.setString(1, usuario.trim());

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    userInfo.add(rs.getString("user"));
                    userInfo.add(rs.getString("password"));
                    userInfo.add(rs.getInt("level"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userInfo;
    }

    public void modificarUsuario(String usuario, String password, int nivel) {
        String query = "UPDATE users SET password = ?, level = ? WHERE user = ?";

        try (Connection connector = getConnection();
             PreparedStatement pst = connector.prepareStatement(query)) {

            pst.setString(1, password.trim());
            pst.setInt(2, nivel);
            pst.setString(3, usuario.trim());
            pst.executeUpdate();

            System.out.println("Usuario modificado exitosamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(String usuario) {
        String query = "DELETE FROM users WHERE user = ?";

        try (Connection connector = getConnection();
             PreparedStatement pst = connector.prepareStatement(query)) {

            pst.setString(1, usuario.trim());
            pst.executeUpdate();

            System.out.println("Usuario eliminado exitosamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verificarUsuario(String usuario) {
        String query = "SELECT * FROM users WHERE user = ?";

        try (Connection connector = getConnection();
             PreparedStatement pst = connector.prepareStatement(query)) {

            pst.setString(1, usuario.trim());

            try (ResultSet rs = pst.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}