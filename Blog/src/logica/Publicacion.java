package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Publicacion {
    private static int consecutivo = 0 ;
    private String titulo;
    private String nombreCreador;
    private LocalDateTime fechaPublicacion;
    private int codigo;
    private String texto;
    private ArrayList<Comentario> comentarios;

    public Publicacion(String titulo, String texto, String nombreCreador) {
        codigo = consecutivo++;
        this.titulo = titulo;
        this.texto = texto;
        this.nombreCreador = nombreCreador;
        fechaPublicacion = LocalDateTime.now();
        comentarios = new ArrayList<Comentario>();
    }

    public void agregarComentario(String email, String ip, String texto) {
        comentarios.add(new Comentario(email, ip, texto));
    }

    public void borrarComentario(int posicion) throws Exception {
        if (posicion < 0 || posicion >= comentarios.size()) {
            throw new Exception("Error: Posición de comentario inválida.");
        }
        comentarios.remove(posicion);
    }

    // GETTERS
    
	public String getTitulo() {
		return titulo;
	}

	public String getNombreCreador() {
		return nombreCreador;
	}

	public LocalDateTime getFechaPublicacion() {
		return fechaPublicacion;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTexto() {
		return texto;
	}

	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}
	

    public String toString() {
        String resultado = "\nCódigo Publicación: " + codigo +
                           "\nTítulo: " + titulo +
                           "\nAutor: " + nombreCreador +
                           "\nFecha: " + fechaPublicacion +
                           "\nContenido: " + texto +
                           "\n-------------------------";
        
        resultado += "\nComentarios:";
        if (comentarios.isEmpty()) {
            resultado += "\nNo hay comentarios todavía.";
        } else {
            for (Comentario c : comentarios) {
                resultado += c.toString(); 
            }
        }
        return resultado;
    }
}
