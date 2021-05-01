package com.consultorio.app.web.rest.vm;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ReservaVM {

    @Size(max = 50)
    @NotBlank
    private String nombre;

    @Size(max = 50)
    @NotBlank
    private String apellido;

    @Size(max = 15)
    @NotBlank
    private String documento;

    public ReservaVM(){
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "ReservaVM{" +
            "nombre='" + nombre + '\'' +
            ", apellido='" + apellido + '\'' +
            ", documento='" + documento + '\'' +
            '}';
    }

}
