package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IAlquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IVehiculos;


public class Modelo {

	protected IAlquileres alquileres;
	protected IClientes clientes;
	protected IVehiculos vehiculos;
	protected IFuenteDatos fuenteDatos;

	protected void setFuenteDatos(IFuenteDatos fuentedatos) {
		//if(fuenteDatos==null) {throw new NullPointerException("la fuente de datos no puede ser nula");}
		this.fuenteDatos=fuentedatos;}

	public Modelo() {
		super();
	}

	public void comenzar() {
		alquileres = fuenteDatos.crearAlquileres();
		clientes = fuenteDatos.crearClientes();
		vehiculos = fuenteDatos.crearVehiculos() ;
	}

	public void terminar() {System.out.println("la ejecucion del modelo ha terminado");}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
	/*	if(cliente==null) {throw new NullPointerException("ERROR: No existe el cliente del alquiler.");}
		if(buscar(cliente)!=null) {

			try {Cliente cliente2	=	 new Cliente(cliente);
				clientes.insertar(cliente2);
			} catch (OperationNotSupportedException e) {e.getMessage();}

		}*/
		Cliente cliente2	=	 new Cliente(cliente);
		clientes.insertar(cliente2);


	}

	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
	/*	if(vehiculo==null) {throw new NullPointerException("ERROR: No existe el vehiculo del alquiler.");}
		Vehiculo vehiculo2 = new Vehiculo(vehiculo);
		try {
			vehiculos.insertar(vehiculo2);
		} catch (OperationNotSupportedException e) {e.getMessage();}*/


		vehiculos.insertar(vehiculo);
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {/*
			if(alquiler==null) {throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");}
			Alquiler alquiler2 = new Alquiler(alquileres.buscar(alquiler));
			try{alquileres.insertar(alquiler2);}catch(Exception e)	{e.getMessage();}*/

			//busca que existan clientes o vehiculos ya insertados(metodos buscar) y crea un nuevo alquiler a partir de estos y la fecha del alquiler dado

	//		Alquiler alquiler2 = new Alquiler(buscar(alquiler.getCliente()),buscar(alquiler.getVehiculo()),alquiler.getFechaAlquiler());
			if(clientes.buscar(alquiler.getCliente())==null||vehiculos.buscar(alquiler.getVehiculo())==null) {throw new OperationNotSupportedException("ERROR: No se encuentra el cliente o vehiculo");}
			else {
				Alquiler alquilerI = new Alquiler(clientes.buscar(alquiler.getCliente()),vehiculos.buscar(alquiler.getVehiculo()),alquiler.getFechaAlquiler());


				alquileres.insertar(alquilerI);



			}


		}

	public Cliente buscar(Cliente cliente) {Cliente clienteR = new Cliente(clientes.buscar(cliente));return clienteR;}

	public Vehiculo buscar(Vehiculo vehiculo) {Vehiculo vehiculoR =(vehiculos.buscar(vehiculo));return vehiculoR;}

	public Alquiler buscar(Alquiler alquiler) {Alquiler alquilerR = new Alquiler(alquileres.buscar(alquiler));return alquilerR;}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {clientes.modificar(cliente, nombre, telefono);}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws NullPointerException, OperationNotSupportedException {
			if(alquileres.buscar(alquiler)==null) {throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");}
			alquileres.devolver(alquiler, fechaDevolucion);
			/*try {
			alquileres.devolver(alquiler, fechaDevolucion);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		//borramos todos los alquileres pertenecientes al cliente
		for(Alquiler alq:getAlquileres(cliente)) {
			if(alq.getCliente().equals(cliente)) {alquileres.borrar(alq);}

		}
		for(Cliente clie:getClientes()) {
			if(clie.equals(cliente)) {clientes.borrar(clie);}

		}
	}

	public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {		//borramos todos los alquileres pertenecientes al cliente
	for(Alquiler alq:getAlquileres(vehiculo)) {
		if(alq.getVehiculo().equals(vehiculo)) {alquileres.borrar(alq);}

	}
	for(Vehiculo turi:getVehiculos()) {
		if(turi.equals(vehiculo)) {vehiculos.borrar(vehiculo);}

	}}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {alquileres.borrar(alquiler);}

	public List<Cliente> getClientes() {

		List<Cliente> clientesR = new ArrayList<>();
		for (Cliente cliente : clientes.get()) {
			if (cliente != null ) {
				clientesR.add	(new Cliente	(cliente));
			}
			}
		return clientesR;

	}

	public List<Vehiculo> getVehiculos() {

	List<Vehiculo> vehiculosR = new ArrayList<>();
	for (Vehiculo vehiculo : vehiculos.get()) {
		if (vehiculo != null ) {
			try {
				vehiculosR.add	(vehiculo.copiar(vehiculo));
			} catch (OperationNotSupportedException e) {
				e.printStackTrace();
			}
		}
		}
	return vehiculosR;}

	public List<Alquiler> getAlquileres() {
			List<Alquiler> alquilerR = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get()) {
			if (alquiler != null ) {
				alquilerR.add	(new Alquiler	(alquiler));
		}
			}
		return alquilerR;
	}

	public List<Alquiler> getAlquileres(Cliente cliente) {
		List<Alquiler> alquilerR = new ArrayList<>();
	for (Alquiler alquiler : alquileres.get(cliente)) {
		if (alquiler != null ) {
			alquilerR.add	(new Alquiler	(alquiler));
		}
	}
	return alquilerR;


	}

	public List<Alquiler> getAlquileres(Vehiculo vehiculo) {
		List<Alquiler> alquilerR = new ArrayList<>();
	for (Alquiler alquiler : alquileres.get(vehiculo)) {
		if (alquiler != null ) {
			alquilerR.add	(new Alquiler	(alquiler));
		}
	}
	return alquilerR;

		}

}