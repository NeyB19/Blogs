package logica;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Blog {
    private int codigo;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaDeCreacion;
    private static int consecutivo = 1;
    private Map<Integer, Publicacion> publicaciones;

    public Blog(String nombre, String descripcion) {
    	codigo = consecutivo++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        fechaDeCreacion = LocalDateTime.now();
        publicaciones = new TreeMap<Integer, Publicacion>();
    }

    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void actualizarDescripcion(String nuevaDescrip) {
        this.descripcion = nuevaDescrip;
    }


    public void crearPublicacion(String titulo, String texto, String autor) {
    	Publicacion nueva = new Publicacion(titulo, texto, autor);
        publicaciones.put(nueva.getCodigo(), nueva);
    }

    public Map<Integer, String> obtenerTitulos() {
        Map<Integer, String> titulos = new TreeMap<Integer, String>();
        for (Publicacion p : publicaciones.values()) {
            titulos.put(p.getCodigo(), p.getTitulo());
        }
        return titulos;
    }

    public String mostrarPublicacion(int codigo) throws Exception {
    	if (publicaciones.containsKey(codigo)) {
        Publicacion p = publicaciones.get(codigo);
        return p.toString();
        }
        throw new Exception("Error: No existe una publicación con ese código.");
    }
    
    public void agregarComentario(int codigoPub, String email, String ip, String texto) throws Exception {
    	if (publicaciones.containsKey(codigoPub)) {
            Publicacion p = publicaciones.get(codigoPub);
            p.agregarComentario(email, ip, texto);
            return;
        }
        throw new Exception("Error: No se pudo agregar comentario, publicación no encontrada.");
    }

    public void borrarComentario(int codigoPub, int posicion) throws Exception {
    	if (publicaciones.containsKey(codigoPub)) {
            Publicacion p = publicaciones.get(codigoPub);
            p.borrarComentario(posicion);
            return;
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