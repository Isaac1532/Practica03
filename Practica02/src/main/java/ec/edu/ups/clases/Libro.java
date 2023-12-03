package ec.edu.ups.clases;

import ec.edu.ups.interfaces.Prestable;
public class Libro implements Prestable{
	//ATRIBUTOS
	private String titulo;
	private String autor;
	private int año;
	private String disp="Si";
	private boolean disponible;
	//Constructor 
	public Libro(String titulo, String autor, int año) {
		this.titulo=titulo;
		this.autor=autor;
		this.año=año;
		this.disponible=true;
	}
	@Override
	//Sobreescritura del metodo de la interface
	public void mostrarInformacion() {
		System.out.println(titulo);
		if(disponible==true) {
			disp="Si";
		}
			else {
				disp="No";
			}
		System.out.println("[Autor: "+autor+" Año: "+año+" Disponible: "+disp+"]");
	}
	//Getters y Setters
	public void setDisponibilidad(boolean disp) {
		this.disponible=disp;
	}
	public boolean isDisponible(){
		return disponible;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {

		return autor;
	}
	public int getAño() {
		return año;
	}
}
