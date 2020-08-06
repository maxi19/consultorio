package com.consultorio.app.service;

import com.consultorio.app.service.dto.RangoDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.consultorio.app.domain.Rango}.
 */
public interface RangoService {

    /**
     * Save a rango.
     *
     * @param rangoDTO the entity to save.
     * @return the persisted entity.
     */
    RangoDTO save(RangoDTO rangoDTO);

    /**
     * Get all the rangos.
     *
     * @return the list of entities.
     */
    List<RangoDTO> findAll();


    /**
     * Get the "id" rango.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<RangoDTO> findOne(Long id);

    /**
     * Delete the "id" rango.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
