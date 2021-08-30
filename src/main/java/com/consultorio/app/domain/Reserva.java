package com.consultorio.app.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
