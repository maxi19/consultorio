package com.consultorio.app.domain;

import javax.persistence.*;

@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "descripcion")
    private String descripcion;

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
