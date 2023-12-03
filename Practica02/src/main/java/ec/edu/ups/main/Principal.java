package ec.edu.ups.main;

import java.util.ArrayList;
import java.util.Scanner;

import ec.edu.ups.clases.*;
public class Principal {
	public static void main(String args[]) {
		int valm=1;	
		//Se instancian algunos atributos
		ArrayList listaLibros=new ArrayList<Libro>();
		ArrayList listaUsuarios=new ArrayList<Usuario>();
		Biblioteca biblioteca=new Biblioteca("Biblioteca de la CCE Azuay","Calle Luis Cordero",listaLibros,listaUsuarios);
		//While para implementar un menu
		while(valm==1) {
			//Creacion de scanners para introducir las opciones
			Scanner scan=new Scanner(System.in);
			Scanner scanl=new Scanner(System.in);
			//Impresion del menu
			System.out.println("|---------------------Menu----------------------|");
			System.out.println("| 1. Agregar un nuevo libro a la biblioteca     |");
			System.out.println("| 2. Registrar nuevo usuario                    |");
			System.out.println("| 3. Buscar libros disponibles                  |");
			System.out.println("| 4. Prestar libro a un usuario                 |");
			System.out.println("| 5. Devolver un libro                          |");
			System.out.println("| 6. Salir                                      |");
			System.out.println("|-----------------------------------------------|");
			System.out.println();
			//Pedida de entrada
			System.out.print("Ingrese la opcion a realizar:");
			int ent=scan.nextInt();
			if(ent==1) {
				//Se piden los atributos del libro a agregar
				System.out.println("Titulo del Libro:");
				String titulo=scanl.nextLine();
				System.out.println("Autor:");
				String autor=scanl.nextLine();
				System.out.println("Año:");
				int ano=scanl.nextInt();
				//Se instancia un nuevo libro con los atributos pedidos anteriormente
				Libro libro=new Libro(titulo,autor,ano);
				//Se agrega el libro a la lista de libros de la biblioteca
				biblioteca.agregarLibro(libro);
			}
			if(ent==2) {
				//Se piden los atributos del usuario a registrar
				System.out.println("Nombre:");
				String nombre=scanl.nextLine();
				System.out.println("Correo:");
				String correo=scanl.nextLine();
				System.out.println("Identificacion");
				String id=scanl.nextLine();
				//Se instancia un nuevo usuario 
				Usuario usuario=new Usuario(nombre,correo,id);
				//Se muestran los detalles del usuario
				usuario.mostrarInformacion();
				//Se agrega el usuario a la lista de usuarios de la biblioteca
				biblioteca.registrarUsuario(usuario);
			}
			if(ent==3) {
				int valm1=1;
				//Se crea un nuevo menu para diferentes tipos de busqueda
				while(valm1==1) {
					Scanner scanm=new Scanner(System.in);
					System.out.println("|------------------------------|");
					System.out.println("|1. Buscar por titulo y año    |");
					System.out.println("|2. Buscar por autor y año     |");
					System.out.println("|3. Buscar por titulo y autor  |");
					System.out.println("|4. Ver todos los disponibles  |");
					System.out.println("|5. Salir                      |");
					System.out.println("|------------------------------|");
					//Se pide la opcion al usuario
					System.out.print("Ingrese la opcion a realizar:");
					int entr=scanm.nextInt();
					System.out.println();
					//Se piden los atributos para cada opcion 
					//En cada opcion, despues de obtener los detalles del libro, se llama al metodo que busca el iibro en la biblioteca
					if(entr==1) {
						Scanner scanta=new Scanner(System.in);
						System.out.print("Titulo:");
						String titulob=scanta.nextLine();
						System.out.println();
						System.out.print("Año:");
						int añob=scanta.nextInt();
						System.out.println();
						biblioteca.buscarLibro(titulob, añob);
						Scanner scanes=new Scanner(System.in);
						System.out.println("Presione Enter para continuar");
						scanes.nextLine();
					}
					if(entr==2) {
						Scanner scanta=new Scanner(System.in);
						System.out.print("Autor:");
						String autorb=scanta.nextLine();
						System.out.println();
						System.out.print("Año:");
						int añob=scanta.nextInt();
						System.out.println();
						biblioteca.buscarLibro( añob,autorb);
						Scanner scanes=new Scanner(System.in);
						System.out.println("Presione Enter para continuar");
						scanes.nextLine();
					}
					if(entr==3) {
						Scanner scanta=new Scanner(System.in);
						System.out.print("Titulo:");
						String titulob=scanta.nextLine();
						System.out.println();
						System.out.print("Autor:");
						String autorb=scanta.nextLine();
						System.out.println();
						biblioteca.buscarLibro(titulob, autorb);
						Scanner scanes=new Scanner(System.in);
						System.out.println("Presione Enter para continuar");
						scanes.nextLine();
					}
					if(entr==4) {
						//En esta opcion muestra todos los libros que estan disponibles
						Scanner scanm4=new Scanner(System.in);
						biblioteca.buscarLibrosDisponibles();
						System.out.println();
						System.out.println("Presione Enter para continuar");
						scanm4.nextLine();
					}
					if(entr==5) {
						break;
					}	
				}
			}
			
			while(ent==4) {
				int pos=-1;
				int vallib=1;
				//Se abre un while que no se cerrara hasta que el libro que se quiere pedir prestado sea encontrado en la biblioteca
				while(vallib==1) {
				Scanner scanus=new Scanner(System.in);
				System.out.println("Titulo del libro que se solicita:");
				String tit=scanus.nextLine();
				System.out.println("Autor de libro que se solicita:");
				String aut=scanus.nextLine();
				if(biblioteca.verLibro(aut, tit)>-1) {
					pos=biblioteca.verLibro(aut,tit);
					break;
				}
				else {
					System.out.println("Libro no encontrado");
					System.out.println("Digite 1 para continuar o 0 para salir");
					int val=scanus.nextInt();
					if(val>1||val<0) {
						System.out.println("Entrada invalida");
					}
					if(val==0) {
						vallib=0;
						break;
					}
				}
				}
				//Una vez encontrado el libro, se pide el usuario a darle el prestamo
				while(vallib==1) {
				Scanner scanus1=new Scanner(System.in);
				System.out.print("Ingrese el usuario al cual se hara el prestamo:");
				String usr=scanus1.nextLine();
				//Si es que el libro y el usuario son encontrados en biblioteca se procede con el prestamo
				if((biblioteca.comprobarUsuario(usr)==true)&&pos>-1) {
					System.out.println();
					//Se llama a los metodos correspondientes para el prestamo 
					biblioteca.verUsuario(usr).solicitarPrestamo(biblioteca.verUsuario(usr),biblioteca.getLibro(pos));
					biblioteca.prestarLibro(biblioteca.getLibro(pos), pos);
					break;
				}
				else {
					//En caso de no encontrar el usuario
					System.out.println("Usuario no encontrado");
					System.out.println("Digite 1 para continuar o 0 para salir");
					int val=scanus1.nextInt();
					if(val>1||val<0) {
						System.out.println("Entrada invalida");
					}
					if(val==0) {
						break;
					}
				}
				}
			break;	
			}
			if(ent==5) {
				int vallib=1;
				int pos=-1;
				boolean libenc=false;
				while(vallib==1) {
					//Se pide los detalles del libro que se devolvera
					Scanner scandev=new Scanner(System.in);
					System.out.println("Titulo del libro a devolver:");
					String tit=scandev.nextLine();
					System.out.println("Autor de libro a devolver:");
					String aut=scandev.nextLine();
					//Se comprueba si el libro fue registrado en la biblioteca
					if(biblioteca.verLibroPrestado(tit, aut)>-1) {
						pos=biblioteca.verLibroPrestado(tit,aut);
						libenc=true;
						break;
					}
					else {
						System.out.println("Libro no encontrado en la biblioteca");
						System.out.println("Digite 1 para continuar o 0 para salir");
						int val=scandev.nextInt();
						if(val>1||val<0) {
							System.out.println("Entrada invalida");
						}
						if(val==0) {
							vallib=0;
							break;
						}
					}
					}
				//En caso de si encontrar el libro se procede
				while(vallib==1) {
					//Se pide el usuario que devolvera el libro
					Scanner scandev=new Scanner(System.in);
					System.out.print("Ingrese el usuario que devolvera el libro:");
					String usr=scandev.nextLine();
					//Se obtiene la posicion de prestamo de ese libro
					int pospres=biblioteca.verUsuario(usr).getPrestamo(biblioteca.getLibro(pos));
					//Se comprueba si el prestamo aun esta vigente 
					boolean valpres=biblioteca.verUsuario(usr).getPrestamo(pospres).esPrestamoVigente(biblioteca.verUsuario(usr), biblioteca.getLibro(pos), biblioteca);
					if(valpres==true) {
					if((biblioteca.comprobarUsuario(usr)==true)&&pos>-1) {
						System.out.println();
						biblioteca.verUsuario(usr).devolverLibro(biblioteca.getLibro(pos),biblioteca,biblioteca.verUsuario(usr), pos);
						break;
					}
					}
					else {
						if((biblioteca.comprobarUsuario(usr)==true)&&pos>-1) {
						System.out.println("La fecha de devolucion del libro ya fue superada, obtendra una multa.");
						System.out.println();
						biblioteca.verUsuario(usr).devolverLibro(biblioteca.getLibro(pos),biblioteca,biblioteca.verUsuario(usr), pos);
						break;
						}
					}
				}
					
			}
			if(ent==6) {
				break;
			}
			if(ent<1||ent>6) {
				System.out.println("Opcion invalida. Presione Enter para Continuar");
				Scanner scan1=new Scanner(System.in);
				String enin=scan1.nextLine();
			}
		}
	}
}
