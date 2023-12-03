package ec.edu.ups.clases;
import ec.edu.ups.interfaces.Prestable;

import java.time.LocalDate;
import java.util.ArrayList;
public class Usuario extends Persona implements Prestable {
	//Atributos
    private String correo;
    private String id;
    private ArrayList<Prestamo> listaPrestamos;
    //Constructor
    public Usuario(String nombre, String correo, String identificacion) {
        this.nombre = nombre;
        this.correo = correo;
        this.id=identificacion;
        this.listaPrestamos = new ArrayList<>();
    }
    //Sobreescritura del metodo de la clase Persona 
    @Override
    public void mostrarInformacion() {
        System.out.println("Usuario: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Identificacion: "+ id);
        System.out.println("Prestamos: " + listaPrestamos);
    }
    //Metodo que envia la fecha en la que se solicito el prestamo a la interface
    public void solicitarPrestamo( Usuario usuario, Libro libro) {  	
    	LocalDate fechaprestamo= LocalDate.now();
    	Prestable.prestar(usuario, libro, fechaprestamo);
    }
    //Metodo que llama a la interface, ademas recibe un validador, en caso de que el libro no haya sido prestado al usuario
    public void devolverLibro(Libro libro, Biblioteca biblioteca, Usuario usuario,int pos) {
		int val=Prestable.devolver(usuario, libro, listaPrestamos);
		//Se usa el validador para devolver el libro
		if(val==1) {
    	biblioteca.devolverLibro(libro,usuario, pos);
		}
    }
    //Metodo que obtiene la posicion del prestamo en la lista de Prestamos segun un libro recibido
    public int getPrestamo(Libro libro) {
    	int pos=-1;
    	for(int i=0;i<listaPrestamos.size();i++) {
    		//Se compara el libro de Prestamo con el libro recibido
    		if(listaPrestamos.get(i).getLibro().equals(libro)) {
    			pos=i;
    			break;
    		}
    	}
    	return pos;
    }
    //Metodo que retorna el prestamo segun la posicion recibida
    public Prestamo getPrestamo(int pos) {
    	return listaPrestamos.get(pos);
    }
    //Metodo que obtiene la posicion de prestamo segun un prestamo recibido
    public int getPrestamo(Prestamo p) {
    	int pos=0;
    	for(int i=0;i<listaPrestamos.size();i++) {
    		if(listaPrestamos.get(i).equals(p)) {
    			pos=i;
    			break;
    		}
    	}
    	return pos;
    }  
    public String getNombre(){
    	return nombre;
    }
    //Setters, uno agrega un prestamo y el otro remueve un prestamo
    public void setListaPrestamos(Prestamo p) {
    	this.listaPrestamos.add(p);
    }
    public void setListaPrestamos(int pos) {
    	listaPrestamos.remove(pos);
    }
}
