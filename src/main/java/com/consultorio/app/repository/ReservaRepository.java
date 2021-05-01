package com.consultorio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.app.domain.Reserva;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
