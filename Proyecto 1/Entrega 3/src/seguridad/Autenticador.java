package seguridad;

import java.util.ArrayList;
import basedatos.RegistroUser;

public class Autenticador {

    private RegistroUser registroUser;

    public Autenticador() {
        this.registroUser = new RegistroUser();
    }

    public  boolean autenticar(String nombreUsuario, String contrasena) {
        if (nombreUsuario == null || nombreUsuario.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            throw new IllegalArgumentException("Nombre de usuario y contraseña no pueden ser nulos o vacíos");
        }
        try {
            ArrayList<Object> password = registroUser.dataBaseBuscar(nombreUsuario);
            if (password != null && password.size() > 1 && password.get(1).equals(contrasena)) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al autenticar: " + e.getMessage());
        }
        return false;
    }
}