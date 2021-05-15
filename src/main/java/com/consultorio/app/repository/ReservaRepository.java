package com.consultorio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.app.domain.Reserva;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

    List<Reserva> findByDocumento(String documento);

    List<Reserva> findByCodigo(String codigo);

    List<Reserva>  findByHorarioAndFechaTurno ( String horario, Calendar fechaTurno );

    List<Reserva> findByFechaTurno(Calendar fechaTurno);

}
