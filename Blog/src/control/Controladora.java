package control;

import logica.Blog; 
import java.util.Map;
import java.util.TreeMap;

public class Controladora {
    private Map<Integer, Blog> blogs;

    public Controladora() {
        blogs = new TreeMap<Integer, Blog>();
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
