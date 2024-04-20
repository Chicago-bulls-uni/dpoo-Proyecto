//Para autenticar que el usuario coincide con su contraseña 
package Seguridad;

import basedatos.RegistroUser;

public class Autenticador {
    private RegistroUser registroUser;

    public Autenticador() {
        this.registroUser = new RegistroUser();
    }

    public boolean autenticar(String nombreUsuario, String contrasena) {
        try {
            String password = registroUser.obtenerContrasenaUsuario(nombreUsuario);
            return password.equals(contrasena);
        } catch (Exception e) {
            System.out.println("Error al autenticar: " + e.getMessage());
            return false;
        }
    }
}