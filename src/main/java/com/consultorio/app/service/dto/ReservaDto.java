package com.consultorio.app.service.dto;

import com.consultorio.app.domain.Reserva;
import com.consultorio.app.service.mapper.EntityMapper;
import com.consultorio.app.service.mapper.ReservaMapper;

import java.util.List;

public class ReservaDto  {

    private String nombre;

    private String apellido;

    private String documento;

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

}
