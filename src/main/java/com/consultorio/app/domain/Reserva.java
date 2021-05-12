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

    @Column(name = "fecha_reservacion", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_turno;

    @Column(name = "codigo")
    private String codigo;

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

    public Calendar getFecha_turno() {
        return fecha_turno;
    }

    public String getCodigo() {
        return codigo;
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

    public void setFecha_turno(Calendar fecha_turno) {
        this.fecha_turno = fecha_turno;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
