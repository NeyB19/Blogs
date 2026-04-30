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

    private static void menuBlogs() throws Exception {
        System.out.println("\n___ LISTA DE BLOGS ___");
        System.out.println(control.obtenerBlogs());
        System.out.print("Seleccione el código del blog para trabajar: ");
        int codBlogActual = Integer.parseInt(teclado.nextLine());

        int op = 0;
        while (op != 3) {
            System.out.println("\n___ MENÚ BLOG ___");
            System.out.println("1. Crear publicación");
            System.out.println("2. Ver publicación y comentarios");
            System.out.println("3. Regresar al menú principal");
            System.out.print("Seleccione: ");
            op = Integer.parseInt(teclado.nextLine());

            if (op == 1) {
                System.out.print("Título: "); String titulo = teclado.nextLine();
                System.out.print("Texto: "); String texto = teclado.nextLine();
                System.out.print("Autor: "); String autor = teclado.nextLine();
                control.crearPublicacion(codBlogActual, titulo, texto, autor);
                System.out.println("Publicación agregada");
            } 
            else if (op == 2) {
                menuPublicaciones(codBlogActual);
            }
        }
    }

    private static void menuPublicaciones(int codBlogActual) throws Exception {
        System.out.println("\n___ LISTA DE PUBLICACIONES ___");
        System.out.println(control.obtenerPublicaciones(codBlogActual));
        System.out.print("Seleccione el código de la publicación: ");
        int codPubActual = Integer.parseInt(teclado.nextLine());

        int op = 0;
        while (op != 3) {
            System.out.println("\n" + control.obtenerPublicacion(codBlogActual, codPubActual));
            System.out.println("\n-- MENÚ DE PUBLICACIÓN --");
            System.out.println("1. Crear comentario");
            System.out.println("2. Borrar comentario");
            System.out.println("3. Regresar al menú de blogs");
            System.out.print("Seleccione: ");
            op = Integer.parseInt(teclado.nextLine());

            if (op == 1) {
                System.out.print("Email: "); String email = teclado.nextLine();
                System.out.print("IP: "); String ip = teclado.nextLine();
                System.out.print("Comentario: "); String comentario = teclado.nextLine();
                control.agregarComentario(codBlogActual, codPubActual, email, ip, comentario);
                System.out.println("Comentario añadido.");
            } 
            else if (op == 2) {
                System.out.print("Posición del comentario a borrar: ");
                int posicion = Integer.parseInt(teclado.nextLine());
                control.borrarComentario(codBlogActual, codPubActual, posicion);
                System.out.println("Comentario borrado");
            }
        }
    }
}