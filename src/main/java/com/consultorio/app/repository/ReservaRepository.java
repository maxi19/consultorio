package com.consultorio.app.repository;

import com.consultorio.app.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.app.domain.Reserva;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

    List<Reserva> findByDocumento(String documento);

    List<Reserva> findByCodigo(String codigo);

    List<Reserva> findByHorarioAndFechaTurno ( String horario, Calendar fechaTurno );

    List<Reserva> findByFechaTurno(Calendar fechaTurno);

    Page<Reserva> findAll(Pageable pageable);

    @Query(value = "SELECT max(id) FROM Reserva")
    public Long max();

    @Transactional
    @Modifying
    @Query("DELETE FROM Reserva m WHERE m.fechaTurno < :date")
    public int removeOlderThan(@Param("date") Calendar date);

}
