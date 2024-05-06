package Seguridad;

import basedatos.RegistroUser;

//0 = comprador
//1 = cajero 
//2 = operador 
//3 = administrador

public class Autorizador {
    private RegistroUser registroUser;

    public Autorizador() {
        this.registroUser = new RegistroUser();
    }

    public boolean tienePermiso(String nombreUsuario, String permiso) {
        try {
            int nivel = registroUser.obtenerNivelUsuario(nombreUsuario);
            
            switch (permiso) {
                case "registrarIngreso":
                case "confirmarVenta":
                case "confirmarDevolucion":
                    return nivel >= 3; 
                case "registrarOferta":
                    return nivel >= 2; 
                case "verificarComprador":
                case "establecerMaximoCompra":
                    return nivel >= 3; 
                default:
                    return true; 
            }
        } catch (Exception e) {
            System.out.println("Error al verificar permiso: " + e.getMessage());
            return false;
        }
    }
}