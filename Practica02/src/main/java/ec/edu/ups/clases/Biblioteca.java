package ec.edu.ups.clases;

import java.util.ArrayList;
import java.util.Scanner;

import ec.edu.ups.interfaces.Prestable;

public class Biblioteca implements Prestable{
	//Definicion de atributos
	private String nombre;
	private String direccion;
	private ArrayList<Libro> listaLibros;
	private ArrayList<Usuario> listaUsuarios;
	
	//Constructor 
	public Biblioteca(String nombre, String direccion,ArrayList<Libro> listaLibros,ArrayList<Usuario> listaUsuarios) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.listaLibros=listaLibros;
		this.listaUsuarios=listaUsuarios;
	}
	//Metodos que agregan usuarios y libros
	public void agregarLibro(Libro libro) {
		this.listaLibros.add(libro);
	}
	public void registrarUsuario(Usuario usuario) {
		this.listaUsuarios.add(usuario);
	}
	//Metodo que comprueba si el usuario esta registrado en la biblioteca
	public boolean comprobarUsuario(String usuario) {
		boolean v=false;
		//Un for que compara el nombre de objeto actual con el nombre de usuario recibido
		for(int i=0;i<listaUsuarios.size();i++) {
			if(this.listaUsuarios.get(i).getNombre().equals(usuario)) {
				v=true;
				break;
			}
		}
		return v;
	}
	//Metodo que retorna un usuario
	public Usuario verUsuario(String usuario) {
		int pos=0;
		//For que compara el nombre de objeto actual con el nombre de usuario recibido
		//Este tipo de estructura se repite en los metodos posteriores
		for(int i=0;i<listaUsuarios.size();i++) {
			if(this.listaUsuarios.get(i).getNombre().equals(usuario)) {
				pos=i;
				break;
			}
		}
		return listaUsuarios.get(pos);
	}
	//Metodo que retorna la posicion del libro, sin importar su disposicion
	public int verLibroPrestado(String titulo, String autor) {
		int pos=-1;
		for(int i=0;i<listaLibros.size();i++) {
			if(listaLibros.get(i).getAutor().equals(autor)&&listaLibros.get(i).getTitulo().equals(titulo)){
				pos=i;
				break;
			}
			else{
				System.out.println("Libro no disponible");
				break;
			}
		}
		return pos;
	}
	//Metodo que busca el libro en la lista de libros y muestra su informacion
	//Sobrecarga de metodos, 3 metodos que buscan un libro segun diferentes detalles del mismo
		public void buscarLibro(String titulo, int año) {
		boolean v=false;
		for(int i=0;i<listaLibros.size();i++) {
			if(listaLibros.get(i).getTitulo().equals(titulo)&&listaLibros.get(i).getAño()==año){
				listaLibros.get(i).mostrarInformacion();
				v=true;
				break;
			}
		}
		if(v==false) {
			System.out.println("Libro no encontrado");
		}
		}
	public void buscarLibro(int año,String autor) {
		boolean v=false;
		for(int i=0;i<listaLibros.size();i++) {
			if(listaLibros.get(i).getAutor().equals(autor)&&listaLibros.get(i).getAño()==año){
				listaLibros.get(i).mostrarInformacion();
				v=true;
				break;
			}
		}
		if(v==false) {
			System.out.println("Libro no encontrado");
		}
		
	}
	public void buscarLibro(String titulo, String autor) {
		boolean v=false;
		for(int i=0;i<listaLibros.size();i++) {
			if(listaLibros.get(i).getAutor().equals(autor)&&listaLibros.get(i).getTitulo().equals(titulo)){
				listaLibros.get(i).mostrarInformacion();
				v=true;
				break;
			}
		}
		if(v==false) {
			System.out.println("Libro no encontrado");
		}
	}
	//Metodo que retorna la posicion del libro, esta vez si importa su disponibilidad
	public int verLibro(String autor, String titulo) {
		int pos=-1;
		for(int i=0;i<listaLibros.size();i++) {
			if(listaLibros.get(i).getAutor().equals(autor)&&listaLibros.get(i).getTitulo().equals(titulo)){
				if(listaLibros.get(i).isDisponible()==true) {
				pos=i;
				break;
				}
				else{
					System.out.println("Libro no disponible");
					break;
				}
			}
		}
		return pos;
	}
	public Libro getLibro(int pos) {
		return this.listaLibros.get(pos);
	}
	//Metodo que muestra todos los libros disponibles
	public void buscarLibrosDisponibles() {
		for(int i=0;i<listaLibros.size();i++) {
			if(listaLibros.get(i).isDisponible()==true) {
				listaLibros.get(i).mostrarInformacion();
			}
		}
	}
	//Metodo para prestar un libro
	public void prestarLibro(Libro libro, int pos) {
		//Cambia la disponiblidad del libro
		libro.setDisponibilidad(false);
		System.out.println("---------------------------------------------");
		System.out.println("Libro prestado y retirado de la biblioteca!");
		System.out.println("Presione Enter para continuar");
		System.out.println("---------------------------------------------");
		Scanner esp=new Scanner(System.in);
		String es=esp.nextLine();
	}
	//Metodo para devolver un libro
	public void devolverLibro(Libro libro, Usuario usuario, int pos) {
		//Cambia la disponibilidad del libro
		libro.setDisponibilidad(true);
		System.out.println("---------------------------------------------");
		System.out.println("Libro devuelto a la biblioteca!");
		System.out.println("Presione Enter para continuar");
		System.out.println("---------------------------------------------");
		Scanner esp=new Scanner(System.in);
		String es=esp.nextLine();
	}

	@Override
	public void mostrarInformacion() {}
}
