package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Blog {
    private int codigo;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaDeCreacion;
    private static int consecutivo = 1;
    private ArrayList<Publicacion> publicaciones;

    public Blog(String nombre, String descripcion) {
    	codigo = consecutivo++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        fechaDeCreacion = LocalDateTime.now();
        publicaciones = new ArrayList<Publicacion>();
    }

    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void actualizarDescripcion(String nuevaDescrip) {
        this.descripcion = nuevaDescrip;
    }

    public void crearPublicacion(String titulo, String texto, String autor) {
        publicaciones.add(new Publicacion(titulo, texto, autor));
    }

    public ArrayList<String> obtenerTitulos() {
        ArrayList<String> titulos = new ArrayList<>();
        for (Publicacion p : publicaciones) {
            titulos.add(p.getTitulo());
        }
        return titulos;
    }

    public String mostrarPublicacion(int codigo) throws Exception {
        for (Publicacion p : publicaciones) {
            if (p.getCodigo() == codigo) {
                return p.toString();
            }
        }
        throw new Exception("Error: No existe una publicación con ese código.");
    }
    
    public void agregarComentario(int codigoPub, String email, String ip, String texto) throws Exception {
        for (Publicacion p : publicaciones) {
            if (p.getCodigo() == codigoPub) {
                p.agregarComentario(email, ip, texto);
                return;
            }
        }
        throw new Exception("Error: No se pudo agregar comentario, publicación no encontrada.");
    }

    public void borrarComentario(int codigoPub, int posicion) throws Exception {
        for (Publicacion p : publicaciones) {
            if (p.getCodigo() == codigoPub) {
                p.borrarComentario(posicion);
                return;
            }
        }
        throw new Exception("Error: No se pudo borrar comentario, publicación no encontrada.");
    }

    
    // GETTERS

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public LocalDateTime getFechaDeCreacion() {
		return fechaDeCreacion;
	}
    
	
    public String toString() {
        return "\n  DATOS DEL BLOG " +
               "\nNombre: " + nombre +
               "\nDescripción: " + descripcion +
               "\nFecha de Creación: " + fechaDeCreacion +
               "\nPublicaciones: " + publicaciones.size() +
               "\n----------------------------";
    }
}