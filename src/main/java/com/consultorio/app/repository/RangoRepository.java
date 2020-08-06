package com.consultorio.app.repository;

import com.consultorio.app.domain.Rango;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Rango entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RangoRepository extends JpaRepository<Rango, Long> {
}
