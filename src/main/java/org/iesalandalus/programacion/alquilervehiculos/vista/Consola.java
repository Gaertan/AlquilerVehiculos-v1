package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	protected static final String PATRON_FECHA = "dd/LL/yyyy" ;
	protected static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);
	
	
	private void Consola() {}
	
	public void mostrarCabecera(String mensaje){System.out.println(mensaje);
	for(int i = 0;i==mensaje.length();i++) {System.out.print("-");}}
	
	public void mostrarMenu(){
		mostrarCabecera("Gestión de reservas de vehiculos");
	for (Opcion opcion: Opcion.values()) {
		System.out.println(opcion);
	}}
	
	private String leerCadena(String mensaje){
		System.out.println(mensaje);
		String cadena="";
		while(cadena ==""||cadena==null||cadena==" "||cadena.trim().isEmpty()) {cadena = Entrada.cadena();}
		return cadena;
	}
	
	private Integer leerEntero(String mensaje){
		System.out.println(mensaje);
		Integer entero = -1;
		while(entero<0) {entero=Entrada.entero();}
		return entero;
	}
	
	private LocalDate leerFecha(String mensaje){
		System.out.println(mensaje);
		LocalDate fecha = null;
		while(fecha==null) {
			try { LocalDate localDate = LocalDate.parse(Entrada.cadena(),FORMATO_FECHA);fecha=localDate;}
			catch(Exception e) {System.out.println("algo ha salido mal;");e.getMessage();}
		}
		return fecha;
	}
	
	public Opcion elegirOpcion() throws OperationNotSupportedException{
		
		try{Opcion opcionR = null;

			while(opcionR==null) {int ordinal = leerEntero("Introduzca el numero de la opción a ejecutar");opcionR.get(ordinal);}
			return opcionR;
				
			}catch(Exception e) {System.out.println("algo ha salido mal;");e.getMessage();}
		return null;
	}
	
	
	public Cliente leerCliente(){
		 Cliente cliente = null;
		 String nombre ="Andrés García Gaertan";
		 String telefono = "622099498";
		 String dni;

		 do {
			 	dni = leerCadena("Introduzca el dni, en mayusculas, sin espacios ni simbolos");
				nombre = leerNombre();
				telefono = leerTelefono();
				try{Cliente clienteR = new Cliente(nombre,dni,telefono);cliente = clienteR;return clienteR;}
				catch(Exception e) {System.out.println("algo ha salido mal;");e.getMessage();}
		 }while(cliente == null);
		return cliente;
	}
	
	
	public Cliente leerClienteDni(){
		 Cliente cliente = null;
		 String nombre ="Andrés García Gaertan";
		 String telefono = "622099498";
		 String dni;
		 do {
			 	dni = leerCadena("Introduzca el dni, en mayusculas, sin espacios ni simbolos");
				
				try{Cliente clienteR = new Cliente(nombre,dni,telefono);cliente = clienteR;return clienteR;}
				catch(Exception e) {System.out.println("algo ha salido mal;");e.getMessage();}
		 }while(cliente == null);

		
		return cliente;

	
	}
	
	
	public String leerNombre(){
			String nombre;
		do {System.out.print("Introduzca el nombre ; ");
			nombre = Entrada.cadena();} 
		while (nombre.equals(""));
	return nombre;
	}
	
	public String leerTelefono(){
		String telefono;
	do {System.out.print("Introduzca el telefono ; ");
	telefono = Entrada.cadena();} 
	while (telefono.equals(""));
	return telefono;
	}
	
	
	public Turismo leerTurismo(){
		Turismo turismo = null;
		 String marca;
		 String modelo;
		 int cilindrada = -1;
		 String matricula;
		do {
			do {System.out.print("Introduzca el nombre de la marca ; ");
			marca = Entrada.cadena();} 
			while (marca.equals(""));
		
			do {System.out.print("Introduzca el nombre del modelo; ");
			modelo = Entrada.cadena();} 
			while (modelo.equals(""));
		
			do {System.out.print("Introduzca la cilindrada ; ");
			cilindrada = Entrada.entero();} 
			while (cilindrada<=0);
			
			do {System.out.print("Introduzca la matricula ; ");
			matricula = Entrada.cadena();} 
			while (matricula.equals(""));
			
			try{Turismo turismoR = new Turismo(marca,modelo,cilindrada,matricula);turismo = turismoR;return turismo;}
			catch(Exception e) {System.out.println("algo ha salido mal;");e.getMessage();}}while(turismo == null);

			
			return turismo;
			
			
	}
	
	
	public Turismo leerTurismoMatricula(){
		
		Turismo turismo = null;
		 String marca = "Seat";
		 String modelo = "Leon";
		 int cilindrada = 1000;
		 String matricula;
		
		do { do {System.out.print("Introduzca la matricula ; ");
			matricula = Entrada.cadena();} 
			while (matricula.equals(""));
		 
			try{Turismo turismoR = new Turismo(marca,modelo,cilindrada,matricula);turismo = turismoR;return turismo;}
			catch(Exception e) {System.out.println("algo ha salido mal;");e.getMessage();}
		}
		while(turismo == null);

		 
		 
		return turismo;
		 
		
	}
	
	
	public Alquiler leerAlquiler(){
		Cliente cliente;
		Turismo turismo;
		LocalDate fechaDate;
		Alquiler alquiler = null;
		
		do {
				cliente = leerCliente();
				turismo = leerTurismo();
				fechaDate = leerFecha("A continuacion se le pide la fecha de alquiler");

				
				try {Alquiler alquilerR = new Alquiler(cliente,turismo,fechaDate);alquiler=alquilerR;}
				catch(Exception e) {System.out.println("algo ha salido mal;");e.getMessage();}
			
		}
		while(alquiler == null);
		return alquiler;
		
	}
	
	
	public LocalDate leerFechaDevolucion(){
		String fecha;
		boolean status = false;
		do {
			System.out.print("Introduzca la fecha en formato dd/mm/aaaa: ");
			fecha = Entrada.cadena();
			try {LocalDate.parse(fecha, FORMATO_FECHA);status = true;} 
			catch (DateTimeParseException e) {status = false;}
		} while (!status);
		return LocalDate.parse(fecha, FORMATO_FECHA);}


	
	
	
	
	
	
	
	
}