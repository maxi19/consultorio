package com.consultorio.app.calendario;

public class Horario {

    private String descripcion;
    private String id;
    private boolean estado;

    public String getDescripcion() {
        return descripcion;
    }

    public String getId() {
        return id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
