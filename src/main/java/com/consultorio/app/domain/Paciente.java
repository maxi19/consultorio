package com.consultorio.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.util.Calendar;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reserva")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Paciente {

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

    @Column(name = "domicilio")
    private String domicilio;

    @Column(name = "localidad")
    private String localidad;

    @Column(name = "fecha_nacimiento", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @Column(name = "tiene_obrasocial")
    private boolean tieneObraSocial;

    @Column(name = "obrasocial")
    private String pbrasocial;

    @Column(name = "numero_afiliado")
    private String afiliado;

}
