package ec.edu.ups.clases;

import java.time.LocalDate;

public class Prestamo {
	private Libro libro;
	private Usuario usuario;
	private LocalDate fechaprestamo;
	private LocalDate fechaDevolucion;
	//Constructores
	public Prestamo() {
		
	}
	public Prestamo(Libro libro, Usuario usuario, LocalDate fechaprestamo, LocalDate fechaDevolucion) {
		this.libro = libro;
		this.usuario = usuario;
		this.fechaprestamo = fechaprestamo;
		this.fechaDevolucion = fechaDevolucion;
	}
	//Getters y Setters
 	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public LocalDate getFechaprestamo() {
		return fechaprestamo;
	}
	public void setFechaprestamo(LocalDate fechaprestamo) {
		this.fechaprestamo = fechaprestamo;
	}
	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}	
	//Metodo que comprueba la vigencia del prestamo 
	public boolean esPrestamoVigente(Usuario usuario, Libro libro, Biblioteca biblioteca) {
		boolean val=false;
		//Se crea una nueva variable, que es la fecha en la que fue devuelto
		LocalDate fechaDevuelto=LocalDate.now();
		//Se compara la fecha anterior con la fecha de devolucion del libro
		if(fechaDevuelto.getDayOfMonth()<fechaDevolucion.getDayOfMonth()) {
			val=true;
		}
		return val;
	}
	//Metodo toString
	@Override
	public String toString() {
		return "Libro=" + libro.getTitulo() + "fechaprestamo=" + fechaprestamo
				+ ", fechaDevolucion=" + fechaDevolucion;
	}
	
}

