package org.iesalandalus.programacion.alquilervehiculos.controlador;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class Controlador {

	private Vista vista;
	private Modelo modelo;
	public Controlador(Modelo modelo, Vista vista){
		if(modelo!=null&&vista!=null) {this.modelo=modelo;this.vista=vista;}vista.setControlador(this);}





	public void  comenzar(){modelo.comenzar();vista.comenzar();}

	public void  terminar(){modelo.terminar();vista.terminar();}

	public void  insertar(Cliente cliente) throws OperationNotSupportedException{modelo.insertar(cliente);}

	public void insertar(Turismo turismo) throws OperationNotSupportedException{modelo.insertar(turismo);}

	public void  insertar(Alquiler alquiler) throws OperationNotSupportedException{modelo.insertar(alquiler);}

	public Cliente buscar(Cliente cliente) throws OperationNotSupportedException{return modelo.buscar(cliente);}

	public Turismo buscar(Turismo turismo) throws OperationNotSupportedException{return modelo.buscar(turismo);}

	public Alquiler buscar(Alquiler alquiler) throws OperationNotSupportedException{return modelo.buscar(alquiler);}

	public void  modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException{modelo.modificar(cliente, nombre, telefono);}

	public void  devolver(Alquiler alquiler, LocalDate fechaDevolucion){try {
		modelo.devolver(alquiler, fechaDevolucion);
	} catch (NullPointerException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	} catch (OperationNotSupportedException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}}

	public void  borrar(Cliente cliente) throws OperationNotSupportedException{modelo.borrar(cliente);}

	public void  borrar(Turismo turismo) throws OperationNotSupportedException{modelo.borrar(turismo);}

	public void  borrar(Alquiler alquiler) throws OperationNotSupportedException{modelo.borrar(alquiler);}

	public List<Cliente> getClientes(){return modelo.getClientes();}

	public List<Turismo> getTurismos(){return modelo.getTurismos();}

	public List<Alquiler> getAlquileres(){return modelo.getAlquileres();}

	public List<Alquiler> getAlquileres(Cliente cliente){return modelo.getAlquileres(cliente);}

	public List<Alquiler> getAlquileres(Turismo turismo){return modelo.getAlquileres(turismo);}





















}
