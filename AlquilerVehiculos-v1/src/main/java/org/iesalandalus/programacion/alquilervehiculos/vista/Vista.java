package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

public abstract class Vista {

	protected Controlador controlador;

	public Vista() {
		super();
	}

	public void setControlador(Controlador controlador) {
		if (controlador == null) {throw new NullPointerException("ERROR: El controlador no puede ser nulo.");}
		this.controlador = controlador;
	}

	 public abstract void comenzar();

	public void terminar() {System.out.println("Hasta aqui la ejecucion del programa");}

}