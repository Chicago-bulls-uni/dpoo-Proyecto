package models;

import basedatos.Administrador;
import seguridad.Autenticador;
import seguridad.Usuario;
import java.util.Scanner;

public class testLogin {
	Usuario user = new Usuario("admin", "paco", 3);
	Administrador admin = new Administrador(user);
	static Autenticador autenticador = new Autenticador();
	public static final int MAX_INTENTOS = 3;
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		int intentos = 0;
        boolean logeado = false;

        while (intentos < MAX_INTENTOS && !logeado) {
            logeado = loginUser(scanner);
            if (!logeado) {
                intentos++;
                if (intentos < MAX_INTENTOS) {
                    System.out.println("Por favor, intenta de nuevo.");
                }
            }
        }

        if (logeado) {
            System.out.println("Usuario logeado exitosamente.");
            // ahora dependiedno del nivel debe ir a diferentes pantallas/menus o ejecutar diferentes acciones
            // por ahora solo imprimimos el mensaje
            
            
        } else {
            System.out.println("Usuario no logeado. Número máximo de intentos alcanzado.");
            scanner.close();
        }
    
		}
		
	
		
		
		public static boolean loginUser(Scanner scanner) { //Esto debe ponerse en autenticador
			
			System.out.println("Introduce el nombre de usuario: ");
			String nombreUsuario = scanner.nextLine();
			System.out.println("Introduce la contraseña: ");
			String contrasena = scanner.nextLine();
			
            if (autenticador.autenticar(nombreUsuario, contrasena)) {
                return true;
            } else {
                return false;
            }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
