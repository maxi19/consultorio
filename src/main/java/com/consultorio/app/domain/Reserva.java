package com.consultorio.app.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "reserva")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Reserva implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "nombre")
	private String nombre;

    @Column(name = "apellido")
	private String apellido;

    @Column(name = "documento")
    private String documento;

    @Column(name = "fecha", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha;

    @Column(name = "sucursal")
    private int sucursal;

    public Long getId() {
        return id;
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

    public Calendar getFecha() {
        return fecha;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

}
