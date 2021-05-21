package com.consultorio.app.web.rest.vm;

public class HorarioVm {

    private String codigo;

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
}
