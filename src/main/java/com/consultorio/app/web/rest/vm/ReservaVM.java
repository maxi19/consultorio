package com.consultorio.app.web.rest.vm;

import com.consultorio.app.helpers.serializer.LocalDateDeserializer;
import com.consultorio.app.helpers.serializer.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ReservaVM {

    private Long id;

    @Size(max = 50)
    @NotBlank
    private String nombre;

    @Size(max = 50)
    @NotBlank
    private String apellido;

    @Size(max = 15)
    @NotBlank
    private String documento;

    private int sucursal;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate fechaTurno;

    @NotBlank
    private String codigoHora;

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

    public int getSucursal() { return sucursal; }


    public LocalDate getFechaTurno() {
        return fechaTurno;
    }


    public ReservaVM(String nombre, String apellido, String documento, int sucursal, LocalDate fechaTurno, String codigoHora) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.sucursal = sucursal;
        this.fechaTurno = fechaTurno;
        this.codigoHora = codigoHora;
    }

    public String getCodigoHora() {
        return codigoHora;
    }

    public Long getId() {
        return id;
    }

    public void setSucursal(int sucursal) { this.sucursal = sucursal; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public void setCodigoHora(String codigoHora) {
        this.codigoHora = codigoHora;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReservaVM{" +
            "nombre='" + nombre + '\'' +
            ", apellido='" + apellido + '\'' +
            ", documento='" + documento + '\'' +
            ", sucursal=" + sucursal +
            ", fechaTurno=" + fechaTurno +
            ", codigoHora='" + codigoHora + '\'' +
            '}';
    }
}
