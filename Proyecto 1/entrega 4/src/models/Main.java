package models;

import basedatos.Inventario;
import basedatos.Inventario1;
import models.Galeria;
import models.Pieza;
import seguridad.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Inventario inventario = new Inventario();
        Galeria galeria = new Galeria(null, null); 
        Usuario.inicializarGaleria(galeria);
        
        
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("Menú:");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Mostrar Piezas Exhibidas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    
                    System.out.print("Ingrese nombre de usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese contraseña: ");
                    String contrasena = scanner.nextLine();
                    System.out.print("Ingrese nivel (0 - Comprador, 1 - Cajero, 2 - Operador, 3 - Administrador): ");
                    int nivel = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    gestorUsuarios.crearUsuario(nombreUsuario, contrasena, nivel);
                    System.out.println("Usuario registrado exitosamente.");
                    break;

                case 2:
                   
                    System.out.print("Ingrese nombre de usuario: ");
                    String loginUsuario = scanner.nextLine();
                    System.out.print("Ingrese contraseña: ");
                    String loginContrasena = scanner.nextLine();
                    
                    Usuario usuario = gestorUsuarios.iniciarSesion(loginUsuario, loginContrasena);
                    
                    if (usuario != null) {
                        System.out.println("Bienvenido " + usuario.getNombreUsuario() + " con nivel " + usuario.getNivel());
                    } else {
                        System.out.println("Autenticación fallida");
                    }
                    break;

                case 3:
                    
                    Inventario piezasExhibidas = new Inventario();
                    piezasExhibidas.getAllPiezas();
                    Map<String, Pieza> piezasExhibidas1 = piezasExhibidas.getPiezasinventario();
                    System.out.println("Piezas Exhibidas:");
                    Iterator<String> it = piezasExhibidas1.keySet().iterator();
                    while(it.hasNext()){
                      String key = it.next();
                      System.out.println("Clave: " + key + " -> Valor: " + piezasExhibidas.get(key));
                    }
                    break;

                case 4:
                    
                    running = false;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
        
        scanner.close();
    }
}