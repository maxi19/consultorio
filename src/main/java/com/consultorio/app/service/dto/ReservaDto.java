package com.consultorio.app.service.dto;

import com.consultorio.app.domain.Reserva;
import com.consultorio.app.service.mapper.EntityMapper;
import com.consultorio.app.service.mapper.ReservaMapper;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

public class ReservaDto  {

    private String nombre;

    private String apellido;

    private String documento;

    private int sucursal;

    @NotBlank
    private LocalDate fechaTurno;

    @NotBlank
    private String codigoHora;

    public int getSucursal() {
        return sucursal;
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

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public String getCodigoHora() {
        return codigoHora;
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

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public void setCodigoHora(String codigoHora) {
        this.codigoHora = codigoHora;
    }
}
