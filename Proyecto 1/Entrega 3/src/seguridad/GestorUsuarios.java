package seguridad;

import basedatos.RegistroUser;

public class GestorUsuarios {

    private static final String ADMINISTRADOR = "administrador";
    private static final String OPERADOR = "operador";
    private static final String CAJERO = "cajero";
    private static final String COMPRADOR = "comprador";

    private RegistroUser registroUser;

    public GestorUsuarios() {
        this.registroUser = new RegistroUser();
    }

    public void crearUsuario(String nombreUsuario, String contrasena, int nivel) {
        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            throw new IllegalArgumentException("Nombre de usuario no puede ser nulo o vacío");
        }
        registroUser.dataBaseAgregar(nombreUsuario, contrasena, nivel);
    }

    public void asignarNivel(String nombreUsuario, String rol) {
        if (nombreUsuario == null || nombreUsuario.isEmpty() || rol == null || rol.isEmpty()) {
            throw new IllegalArgumentException("Nombre de usuario y rol no pueden ser nulos o vacíos");
        }
        int nivel = obtenerNivelPorRol(rol);
        registroUser.dataBaseModificiar(nombreUsuario, null, nivel);
    }

    public void eliminarUsuario(String nombreUsuario) {
        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            throw new IllegalArgumentException("Nombre de usuario no puede ser nulo o vacío");
        }
        registroUser.dataBaseEliminar(nombreUsuario);
    }

    private int obtenerNivelPorRol(String rol) {
        switch (rol.toLowerCase()) {
            case ADMINISTRADOR:
                return 3;
            case OPERADOR:
                return 2;
            case CAJERO:
                return 1;
            case COMPRADOR:
                return 0;
            default:
                throw new IllegalArgumentException("Rol desconocido: " + rol);
        }
    }
}