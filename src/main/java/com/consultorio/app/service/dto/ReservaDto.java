package com.consultorio.app.service.dto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class ReservaDto {

    private String nombre;

    private String apellido;

    private String documento;

    private int sucursal;

    @NotBlank
    private LocalDate fechaTurno;

    @NotBlank
    private String codigoHora;

    private String horario;

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

    public String getHorario() {
        return horario;
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

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
