package ec.edu.ups.interfaces;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import ec.edu.ups.clases.*;
public interface Prestable {
	//Metodo usado para prestar un libro
	public static void prestar(Usuario usuario, Libro libro, LocalDate fechaprestamo) {
		int v=1;
		//Se crea una variable que es la fecha actual
		LocalDate fechadevolucion=LocalDate.now();
		while(v==1) {
			//Se solicita los dias que se pedira prestado el libro
		System.out.println("-----------------------------------------------------------");
		System.out.println("Ingrese la cantidad de dias que usara el libro (max 14):");
		Scanner scandias=new Scanner(System.in);
		int dias=scandias.nextInt();
		//Si la entrada es correcta
		//A la variable creada anteriormente se le suman los dias solicitados
		//Obteniendo una fecha en la que debera ser devuelto el libro
		if(dias<14&&dias>1) {
			fechadevolucion=fechadevolucion.plusDays(dias);
			break;
		}
		else {
			System.out.println("Entrada invalida");
		}
		}
		//Se instancia un prestamo, y se llama al metodo de la clase usuario
		Prestamo p=new Prestamo(libro,usuario,fechaprestamo,fechadevolucion);
		usuario.setListaPrestamos(p);

		System.out.println("---------------------------------------------");
		System.out.println("Solicitud aceptada");
		System.out.println("Dia de salida del libro:"+fechaprestamo.getDayOfWeek()+"  "+fechaprestamo.getDayOfMonth()+"/"+fechaprestamo.getMonth());
		System.out.println("---------------------------------------------");
		System.out.println();
		System.out.println("Fecha max de entrega:"+fechadevolucion);
		
	}
	//Metodo para devolver un libro
	public static int devolver(Usuario usuario,Libro libro,ArrayList<Prestamo> listaPrestamos) {
        // Encuentra el préstamo correspondiente al libro en la lista de préstamos
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getLibro().equals(libro)) {
                // Realiza la devolución
                usuario.setListaPrestamos(usuario.getPrestamo(prestamo));
                return 1;
            }
        }
        // Si llega aquí, significa que el libro no estaba en préstamo
        System.out.println("Este libro no estaba en préstamo por este usuario.");
        return 0;
	}
	//Metodo abstracto
	public abstract void mostrarInformacion();
	}
