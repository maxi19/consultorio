package com.consultorio.app.domain;

import java.io.Serializable;
import java.util.Calendar;

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

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha;

    @Column(name = "sucursal")
    private int sucursal;

    @Column(name = "fecha_reservacion", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaTurno;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "horario")
    private String horario;

    @Column(name = "origen")
    private boolean editado;

    @Column(name = "usuario")
    private String usuario;

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

    public Calendar getFechaTurno() {
        return fechaTurno;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getHorario() {
        return horario;
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

    public void setFechaTurno(Calendar fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
