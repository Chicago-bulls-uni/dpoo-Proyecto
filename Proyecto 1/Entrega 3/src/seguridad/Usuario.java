package seguridad;


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
}
// No tiene sentido crear metodos aqui por que ya estan en gestorUsuarios

   