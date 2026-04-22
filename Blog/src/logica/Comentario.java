package logica;

import java.time.LocalDateTime;

public class Comentario {
    private LocalDateTime fechaCreacion;
    private String emailAutor;
    private String direccionIP;
    private String texto;

    public Comentario(String emailAutor, String direccionIP, String texto) {
        this.emailAutor = emailAutor;
        this.direccionIP = direccionIP;
        this.texto = texto;
        fechaCreacion = LocalDateTime.now(); 
    }

    // GETTERS

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public String getEmailAutor() {
		return emailAutor;
	}

	public String getDireccionIP() {
		return direccionIP;
	}

	public String getTexto() {
		return texto;
	}
	
	
	public String toString() {
        return "\nEmail del Autor: " + emailAutor +
               "\nDirección IP: " + direccionIP +
               "\nFecha: " + fechaCreacion +
               "\nComentario: " + texto +
               "\n-------------------------";
    }
}