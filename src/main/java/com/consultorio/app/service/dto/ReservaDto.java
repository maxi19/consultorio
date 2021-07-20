package com.consultorio.app.service.dto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class ReservaDto {

    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String documento;

    @NotBlank
    private String telefono;

    private int sucursal;

    @NotBlank
    private LocalDate fechaTurno;

    @NotBlank
    private String codigoHora;

    @NotBlank
    private String horario;

    public Long getId() { return id; }

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

    public String getTelefono() {  return telefono; }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTelefono(String telefono) { this.telefono = telefono; }
}
