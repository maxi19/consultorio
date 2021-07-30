package com.consultorio.app.service.dto;

import javax.persistence.Column;

public class HorarioDto {

    private Long id;

    private String codigo;

    private String descripcion;

    public HorarioDto(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public HorarioDto(long id, String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.id = id;
    }

    public void setId(Long id) { this.id = id; }

    public Long getId() { return id; }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
