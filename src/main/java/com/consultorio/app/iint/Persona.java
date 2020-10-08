package com.consultorio.app.iint;

public class Persona implements IPersona{

	private String nombre;
	private String apellido;
	
	@Override
	public IPersona devolver() {
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
