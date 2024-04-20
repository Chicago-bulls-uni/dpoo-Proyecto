public class GestorUsuarios {
    private RegistroUser registroUser;

    public GestorUsuarios() {
        this.registroUser = new RegistroUser();
    }

    public void crearUsuario(String nombreUsuario, String contrasena, int nivel) {
        registroUser.dataBaseAgregar(nombreUsuario, contrasena, nivel);
    }

    public boolean autenticarUsuario(String nombreUsuario, String contrasena) {
        return registroUser.autenticarUsuario(nombreUsuario, contrasena);
    }

    public boolean asignarNivel(String nombreUsuario, String rol) {
        int nivel = obtenerNivelPorRol(rol);
        return registroUser.dataBaseModificiar(nombreUsuario, null, nivel);
    }

    public boolean eliminarUsuario(String nombreUsuario) {
        return registroUser.dataBaseEliminar(nombreUsuario);
    }

    private int obtenerNivelPorRol(String rol) {
        switch (rol.toLowerCase()) {
            case "administrador":
                return 3;
            case "operador":
                return 2;
            case "cajero":
                return 1;
            case "comprador":
                return 0;
            default:
                return -1; 
        }
    }
}