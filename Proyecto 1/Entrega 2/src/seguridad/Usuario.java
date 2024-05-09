package seguridad;

import basedatos.RegistroUser;

public class Usuario {
    private String nombreUsuario;
    private String contrasena;
    private int nivel;

    public Usuario(String nombreUsuario, String contrasena, int nivel) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nivel = nivel;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getNivel() {
        return nivel;
    }

    public void crearUsuario() {
        RegistroUser registroUser = new RegistroUser();
        registroUser.dataBaseAgregar(nombreUsuario, contrasena, nivel);
    }

    public void eliminarUsuario() {
        RegistroUser registroUser = new RegistroUser();
        registroUser.dataBaseEliminar(nombreUsuario);
    }

    public void modificarNivel(int nuevoNivel) {
        RegistroUser registroUser = new RegistroUser();
        registroUser.dataBaseModificiar(nombreUsuario, contrasena, nuevoNivel);
    }

    public void autenticar() {
        RegistroUser registroUser = new RegistroUser();
        registroUser.dataBaseBuscar(nombreUsuario);
        registroUser.autenticar(nombreUsuario, contrasena);
    }
}