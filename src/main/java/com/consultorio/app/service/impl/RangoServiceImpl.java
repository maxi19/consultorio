package com.consultorio.app.service.impl;

import com.consultorio.app.service.RangoService;
import com.consultorio.app.domain.Rango;
import com.consultorio.app.repository.RangoRepository;
import com.consultorio.app.service.dto.RangoDTO;
import com.consultorio.app.service.mapper.RangoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Rango}.
 */
@Service
@Transactional
public class RangoServiceImpl implements RangoService {

    private final Logger log = LoggerFactory.getLogger(RangoServiceImpl.class);

    @Autowired
    private final RangoRepository rangoRepository;

    @Autowired
    private final RangoMapper rangoMapper;

    public RangoServiceImpl(RangoRepository rangoRepository, RangoMapper rangoMapper) {
        this.rangoRepository = rangoRepository;
        this.rangoMapper = rangoMapper;
    }

    /**
     * Save a rango.
     *
     * @param rangoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public RangoDTO save(RangoDTO rangoDTO) {
        log.debug("Request to save Rango : {}", rangoDTO);
        Rango rango = rangoMapper.toEntity(rangoDTO);
        rango = rangoRepository.save(rango);
        return rangoMapper.toDto(rango);
    }

    /**
     * Get all the rangos.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<RangoDTO> findAll() {
        log.debug("Request to get all Rangos");
        return rangoRepository.findAll().stream()
            .map(rangoMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one rango by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<RangoDTO> findOne(Long id) {
        log.debug("Request to get Rango : {}", id);
        return rangoRepository.findById(id)
            .map(rangoMapper::toDto);
    }

    /**
     * Delete the rango by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Rango : {}", id);
        rangoRepository.deleteById(id);
    }
}
