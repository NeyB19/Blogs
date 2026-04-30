package interfaz;

import java.util.Scanner;
import control.Controladora;

public class EjemploBlog {
    private static Controladora control = new Controladora();
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        while (opcion != 4) {
            try {
                System.out.println("\n____ MENÚ PRINCIPAL ____");
                System.out.println("1. Crear blog nuevo");
                System.out.println("2. Trabajar con blog");
                System.out.println("3. Borrar blog");
                System.out.println("4. Salir");
                System.out.print("Seleccione: ");
                opcion = Integer.parseInt(teclado.nextLine());

                if (opcion == 1) {
                    System.out.print("Nombre: "); String nombre = teclado.nextLine();
                    System.out.print("Descripción: "); String descrip = teclado.nextLine();
                    control.crearBlog(nombre, descrip);
                    System.out.println("Blog creado...");
                } 
                else if (opcion == 2) {
                    menuBlogs();
                } 
                else if (opcion == 3) {
                    System.out.print("Código del blog a borrar: ");
                    int codigoBlog = Integer.parseInt(teclado.nextLine());
                    control.borrarBlog(codigoBlog);
                    System.out.println("Blog eliminado");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}