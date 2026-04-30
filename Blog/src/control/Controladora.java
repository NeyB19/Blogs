package control;

import logica.Blog; 
import java.util.Map;
import java.util.TreeMap;

public class Controladora {
    private Map<Integer, Blog> blogs;

    public Controladora() {
        blogs = new TreeMap<Integer, Blog>();
        
        // Blogs por defecto
        
        crearBlog("Mundo Canino", "Todo sobre razas de perros"); 
        crearBlog("Jardín Floral", "Guía de flores y cuidados");

        try {
            crearPublicacion(1, "El Golden Retriever", "Es un perro muy amigable.", "Administrador");
            crearPublicacion(1, "Cuidado del Bulldog", "Necesita limpieza de pliegues.", "Veterinario"); 

            agregarComentario(1, 0, "ana12l@gmail.com", "192.168.0.1", "Me encantan los Goldens");
            agregarComentario(1, 0, "andyb@gmail.com", "192.168.0.2", "Son los mejores perros");

            agregarComentario(1, 1, "lucasmartin@gmail.com", "192.168.0.3", "Es vital la higiene");
            agregarComentario(1, 1, "neyblear@gmail.com", "192.168.0.4", "Buen consejo médico");            

            crearPublicacion(2, "Las Rosas", "Requieren sol y poda constante.", "Jardinero");
            crearPublicacion(2, "Girasoles", "Siguen la luz del sol.", "Florista");

            agregarComentario(2, 2, "enriquevldez@gmail.com", "10.0.0.1", "Que hermosas son las rosas!");
            agregarComentario(2, 2, "lupe099@gmail.com", "10.0.0.2", "Que interesante.");  
            
            agregarComentario(2, 3, "luciacos1@gmail.com", "10.0.0.3", "Me encantan sus colores");
            agregarComentario(2, 3, "paola242@gmail.com", "10.0.0.4", "Dan mucha vida al jardín");  
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void crearBlog(String nombre, String descripcion) {
        Blog nuevoBlog = new Blog(nombre, descripcion);
        blogs.put(nuevoBlog.getCodigo(), nuevoBlog);
    }

    public void borrarBlog(int codigoBlog) throws Exception {
        if (blogs.containsKey(codigoBlog)) {
            blogs.remove(codigoBlog);
            return;
        }
        throw new Exception("Error: No se encontró el blog");
    }

    public Map<Integer, String> obtenerBlogs() {
        Map<Integer, String> resultadoBlogs = new TreeMap<Integer, String>();
        for (Blog b : blogs.values()) {
            resultadoBlogs.put(b.getCodigo(), b.getNombre());
        }
        return resultadoBlogs;
    }

    private Blog buscarBlog(int codigoBlog) throws Exception {
        if (blogs.containsKey(codigoBlog)) {
            return blogs.get(codigoBlog);
        }
        throw new Exception("Error: Ese blog no existe");
    }
    
    public void crearPublicacion(int codigoBlog, String titulo, String texto, String nombreCreador) throws Exception {
        Blog b = buscarBlog(codigoBlog);
        b.crearPublicacion(titulo, texto, nombreCreador);
    }

    public Map<Integer, String> obtenerPublicaciones(int codigoBlog) throws Exception {
        Blog b = buscarBlog(codigoBlog);
        return b.obtenerTitulos();
    }

    public String obtenerPublicacion(int codigoBlog, int codigoPublicacion) throws Exception {
        Blog b = buscarBlog(codigoBlog);
        return b.mostrarPublicacion(codigoPublicacion);
    }


    public void agregarComentario(int codigoBlog, int codigoPublicacion, String email, String ip, String texto) throws Exception {
        Blog b = buscarBlog(codigoBlog);
        b.agregarComentario(codigoPublicacion, email, ip, texto);
    }

    public void borrarComentario(int codigoBlog, int codigoPublicacion, int posicion) throws Exception {
        Blog b = buscarBlog(codigoBlog);
        b.borrarComentario(codigoPublicacion, posicion);
    }

}
