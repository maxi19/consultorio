package com.consultorio.app.web.rest.vm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HorarioVm {

    private Long id ;

    @NotNull
    @Size(min = 1, max = 3)
    private String codigo;

    @NotNull
    @Size(min = 1, max = 15)
    private String descripcion;

    private boolean estado;


    public HorarioVm(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = true;
    }

    public HorarioVm(String codigo, String descripcion, boolean estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public HorarioVm(Long id, String codigo, String descripcion) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = false;
    }

    public Long getId() { return id; }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setId(Long id) { this.id = id; }
}
